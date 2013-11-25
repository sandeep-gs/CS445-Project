package hostel.collection;

import hostel.core.*;
import hostel.core.Booking.BookingStatus;
import hostel.exception.*;
import hostel.utility.GenericUtility;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Hostels
{
  private static Hostels Instance = new Hostels();
  
  private Hostels() {}
  
  public static Hostels getInstance()
  {
    return Instance;
  }
  
  public Hostel get(Identifier id)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException
  {
    DataBase db = DataBaseFactory.getDataBase();
    return db.getHostel(id);
  }
  
  public Identifier create(Hostel info)
      throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException 
  {
    DataBase db = DataBaseFactory.getDataBase();
    return db.addHostel(info);
  }

  public void update(Identifier id, Hostel info)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException
  {
    DataBase db = DataBaseFactory.getDataBase();
    db.updateHostel(id, info);
  }

  public void delete(Identifier id)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException
  {
    DataBase db = DataBaseFactory.getDataBase();
    // Before deleting the hostel make sure hostel is empty
    try {
      Hostel info = get(id);
      if (info.getBeds() != null && info.getBeds().size() != 0) {
        throw new InvalidParameterException();
      }
      db.removeHostel(id);
    }
    catch(GenericException ex) {
      throw ex;
    }
  }
  
  public void addBed(Identifier hostelId, Identifier bedId)
      throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException
  {
    DataBase db = DataBaseFactory.getDataBase();
    try {
      Bed bedInfo = Beds.getInstance().get(bedId);
      if (bedInfo.getHostelId() != hostelId) {
        throw new InvalidParameterException("hostel ID of the bed and hostelId does not match");
      }
      Hostel hostelInfo = get(hostelId);
      ArrayList<Identifier> beds = hostelInfo.getBeds();
      if (beds == null) {
        beds = new ArrayList<Identifier>();
      }
      beds.add(bedId);
      hostelInfo.setBeds(beds);
      db.updateHostel(hostelId, hostelInfo);
    }
    catch (GenericException ex) {
      System.err.println(ex.getMessage());
      throw ex;
    }
  }
    
  public void removeBed(Identifier hostelId, Identifier bedId)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException
  {
    DataBase db = DataBaseFactory.getDataBase();
    try {
      Bed bedInfo = Beds.getInstance().get(bedId);
      if (bedInfo.getHostelId() != hostelId) {
        throw new InvalidParameterException("Hostel ID of the bed and hostelId does not match");
      }
      Hostel hostelInfo = get(hostelId);
      ArrayList<Identifier> beds = hostelInfo.getBeds();
      beds.remove(bedId);
      hostelInfo.setBeds(beds);
      db.updateHostel(hostelId, hostelInfo);
    }
    catch (GenericException ex) {
      System.err.println(ex.getMessage());
      throw ex;
    }
  } 
  
  public ArrayList<Identifier> search(Hostel info) throws DataBaseReadWriteException
  {
    DataBase db = DataBaseFactory.getDataBase();
    return db.searchHostel(info);
  }
  
  public Double getOccupancy(Identifier hostelId, Date from, Date to)
      throws DataBaseReadWriteException, InvalidParameterException, IdentifierNotFoundException, InvalidIdentifierException
  {
     double occupiedBeds = 0;
     double totalBeds = 0;
     ArrayList<Identifier> hostelIds = new ArrayList<Identifier> ();
     if (hostelId != null) {
       hostelIds.add(hostelId);
     }
     else {
       hostelIds = search(new Hostel());
     }
     
     for (Identifier id : hostelIds) {
       for (Identifier bedId : get(id).getBeds()) {
         Date start = from;
         Date end = to;
 
         while (!start.equals(end)) {
           Date temp = GenericUtility.addDaysToDate(start, 1);
           // System.out.println("start = " + start.toString() + " temp = " + temp.toString() + " end = " + end.toString());
           if (!Beds.getInstance().isBedAvailable(bedId, start, temp, true)) {
             occupiedBeds++;
           }
           start = GenericUtility.addDaysToDate(start, 1);
           totalBeds++;
         }
       }
     }
     return ((occupiedBeds*100)/totalBeds);
  }
  
  public Integer getRevenue(Identifier hostelId, Date start, Date end)
      throws DataBaseReadWriteException, InvalidParameterException, IdentifierNotFoundException, InvalidIdentifierException
  {
    Integer price = 0;
    Booking booking = new Booking();
    ArrayList<Tariff> tariffList = new ArrayList<Tariff>();
    tariffList.add(new Tariff(null, start, end));
    
    booking.setBedReservations(tariffList);
    booking.setHostelId(hostelId);
    booking.setStatus(BookingStatus.RESERVED);
    ArrayList<Identifier> bookingIds = Bookings.getInstance().searchInDateRange(booking);
    for (Identifier id : bookingIds) {
      Booking info = Bookings.getInstance().get(id);
      for (Tariff tr : info.getBedReservations()) {      
        Long perDayPrice = (tr.getPrice()/GenericUtility.getDiffDays(tr.getEndDate(), tr.getStartDate()));
        Long spanPrice;
        if (tr.getEndDate().after(end)) {
          spanPrice =  perDayPrice * GenericUtility.getDiffDays(end, tr.getStartDate());
        }
        else {
          spanPrice =  perDayPrice * GenericUtility.getDiffDays(tr.getEndDate(), tr.getStartDate());
        }
        
        price += spanPrice.intValue();
      }
    }
    
    booking.setStatus(BookingStatus.CANCELLED);
    bookingIds = Bookings.getInstance().searchInDateRange(booking);
    for (Identifier id : bookingIds) {
      Booking info = Bookings.getInstance().get(id);
      for (Tariff tr : info.getBedReservations()) {
        Long perDayPrice = (tr.getPrice()/GenericUtility.getDiffDays(tr.getEndDate(), tr.getStartDate()));
        Long spanPrice;
        if (tr.getEndDate().after(end)) {
          spanPrice =  perDayPrice * GenericUtility.getDiffDays(end, tr.getStartDate());
        }
        else {
          spanPrice =  perDayPrice * GenericUtility.getDiffDays(tr.getEndDate(), tr.getStartDate());
        }
        
        price += spanPrice.intValue();
      }
    }

    return price;
  }
  
  public ArrayList<Identifier> getFreeBeds(Identifier hostelId, Date checkIn, Date checkOut)
      throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException
  {
    ArrayList<Identifier> freeBedIds = new ArrayList<Identifier>();
      Hostel hostelInfo = Hostels.getInstance().get(hostelId);
      Iterator<Identifier> bedItr = hostelInfo.getBeds().iterator();
      while (bedItr.hasNext()) {
        Identifier bedId = bedItr.next();
        if (Beds.getInstance().isBedAvailable(bedId, checkIn, checkOut, false)) {
          freeBedIds.add(bedId);
        }
      }
      return freeBedIds;
  }
}