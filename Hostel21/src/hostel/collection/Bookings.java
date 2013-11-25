package hostel.collection;

import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import hostel.core.*;
import hostel.exception.*;
import hostel.utility.GenericUtility;

public class Bookings
{
  private static Bookings Instance = new Bookings();

  private Bookings() {}
  
  public static Bookings getInstance()
  {
    return Instance;
  }
  
  public Identifier create(Booking info)
    throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidIdentifierException,
           InvalidParameterException, ConflictException, IdentifierNotFoundException
  {
    DataBase db = DataBaseFactory.getDataBase();
    Identifier id = null;
    if (info == null || info.getBedIds() == null || info.getBedReservations() == null
        || info.getBedIds().size() != info.getBedReservations().size()) {
      throw new InvalidParameterException(); 
    }
    try {
      int i = 0;
      for (Identifier bedId : info.getBedIds()) {
        if (!Beds.getInstance().isBedAvailable(bedId,
                                               info.getBedReservations().get(i).getStartDate(),
                                               info.getBedReservations().get(i).getEndDate(), false)) {
          throw new ConflictException();
        }
        ++i;
      }

      id = db.addBooking(info);
    }
    catch(DataBaseReadWriteException | IdentifierAlreadyExistsException
          | InvalidParameterException | ConflictException | IdentifierNotFoundException 
          | InvalidIdentifierException ex) {
      throw ex;
    }
    return id;
  }
  
  public Booking get(Identifier id)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException
  {
    DataBase db = DataBaseFactory.getDataBase();
    return db.getBooking(id);
  }
  
  public void update(Identifier id, Booking info)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException
  {
    DataBase db = DataBaseFactory.getDataBase();
    db.updateBooking(id, info);
  }

  public void delete(Identifier id)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException
  {
    DataBase db = DataBaseFactory.getDataBase();
    db.removeBooking(id);
  }
  
  public ArrayList<Identifier> search(Booking info) throws DataBaseReadWriteException
  {
    DataBase db = DataBaseFactory.getDataBase();
    return db.searchBooking(info);
  }
    
  public void cancel(Identifier bookingId) 
      throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException
  {
    Booking bookingInfo = get(bookingId);
    if (bookingInfo.getStatus() != Booking.BookingStatus.RESERVED) {
      throw new InvalidParameterException("Booking not in reserved state");
    }
    else {
      Hostel hostelInfo = Hostels.getInstance().get(bookingInfo.getHostelId());
      Policy policyInfo = hostelInfo.getPolicy();

      Date cancellationTime = new Date();
      String checkInTimePolicy[] = policyInfo.getCheckInTime().split(":");
      Integer checkInTimeInMs = (Integer.parseInt(checkInTimePolicy[0])*60*60+ Integer.parseInt(checkInTimePolicy[1])*60) * 1000;
           
      ArrayList<Tariff> reservations = bookingInfo.getBedReservations();
      int i = 0;
      for (Tariff tr : reservations) {
         Date startDate = new Date(tr.getStartDate().getTime() + checkInTimeInMs);
         Long hoursBeforeCheckIn = GenericUtility.getDiffHours(startDate, cancellationTime);
         if (hoursBeforeCheckIn < policyInfo.getCancellationDeadLine()) {
           System.out.println("Applying cancellation charges. Hours before checkIn = "
                               + hoursBeforeCheckIn.toString() + ". Cancellation deadline = "
                               + policyInfo.getCancellationDeadLine());       
           Integer pricePaid = tr.getPrice();
           Integer priceDeducted = (pricePaid * policyInfo.getCancellationPenalty())/100;
           tr.setPrice(priceDeducted);
           System.out.println("Deducted " + priceDeducted.toString() + " from total " +  pricePaid.toString());
           reservations.set(i, tr);
           bookingInfo.setBedReservations(reservations);
           i++;
         }
         else {
           tr.setPrice(0);
           System.out.println("No penalty applied for cancellation");
           reservations.set(i, tr);
           bookingInfo.setBedReservations(reservations);
           i++;
         }
      }
    } 
    bookingInfo.setStatus(Booking.BookingStatus.CANCELLED);
    update(bookingId, bookingInfo);
  }
  
  // It is somewhat stupid to specify multiple beds and reservations.
  // But in any case the API supports it!!! 
  // Includes the start date and excludes the end date. [)
  public ArrayList<Identifier> searchInDateRange(Booking info)
      throws DataBaseReadWriteException, InvalidParameterException
  {
    Booking infoWithOutDate = new Booking(info);

    ArrayList<Identifier> filteredIds = new ArrayList<Identifier>();
    
    if (info.getBedReservations() != null && info.getBedIds() != null
        && info.getBedReservations().size() != info.getBedIds().size()) {
      throw new InvalidParameterException("size of reservation and bed does not match"); 
    }
    
    // We should first get bookings with all the other matching parameters.
    // Later we will include the dates.
    if (infoWithOutDate.getBedReservations() != null) {
      ListIterator<Tariff> resItr = infoWithOutDate.getBedReservations().listIterator();
      while(resItr.hasNext()) {
        Tariff tariff = resItr.next();
        tariff.setStartDate(null);
        tariff.setEndDate(null);
        resItr.set(tariff);
      }
    }

    try {
      ArrayList<Identifier> ids = search(infoWithOutDate);
      Iterator<Identifier> it = ids.iterator();
      while (it.hasNext()) {
        Identifier id = it.next();
        Booking candidateBooking;
        candidateBooking = get(id);
        
        ArrayList<Identifier> candidateBeds = candidateBooking.getBedIds();
        ArrayList<Identifier> inputBeds = info.getBedIds();
        ArrayList<Tariff> inputReservations = info.getBedReservations();
        ArrayList<Tariff> candidateReservations = candidateBooking.getBedReservations();
        int i = 0;
        boolean missMatchFound = false;
        if (inputBeds == null) {
          // we still have to figure out which beds are in the range.
          // so use the beds of booking.
          inputBeds = candidateBeds;
        }
        for (Identifier id1 : inputBeds) {
          int j = 0;
          for (Identifier id2 : candidateBeds) {
            if (id1.equals(id2)) {             
              // true if start or end date of a candidate booking falls under the range.
              if (((inputReservations.get(i).getStartDate() == null)
                       || (candidateReservations.get(j).getStartDate().before(inputReservations.get(i).getEndDate())))
                  && (inputReservations.get(i).getEndDate() == null
                       || candidateReservations.get(j).getEndDate().after(inputReservations.get(i).getStartDate()))
              ) {
                  // Found a bed!
                 break;                
              }
              else {
                missMatchFound = true;
                // Inner for
                break;
              }
            }
            j++;
          }
          
          // Outer for
          if (missMatchFound) {
            break;
          }
          i++;
        }
        
        // Outer most while
        if (missMatchFound) {
          continue;
        }
        filteredIds.add(id);
      }
    }
    catch (IdentifierNotFoundException | InvalidIdentifierException e) {
      System.err.println(e.getMessage());
      throw new DataBaseReadWriteException(e.getMessage());
    }
    return filteredIds;
  }

}
