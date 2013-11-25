package hostel.collection;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import hostel.core.*;
import hostel.exception.*;

public class Beds
{ 
  private static Beds Instance = new Beds();
  
  private Beds() {}
  
  public static Beds getInstance()
  {
    return Instance;
  }
  
  public Identifier create(Bed info)
    throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException, IdentifierNotFoundException, InvalidIdentifierException
  {
    DataBase db = DataBaseFactory.getDataBase();
    Identifier bedId =  db.addBed(info);
    Hostels.getInstance().addBed(info.getHostelId(), bedId);
    return bedId;
  }
  
  public Bed get(Identifier id)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException
  {
    DataBase db = DataBaseFactory.getDataBase();
    return db.getBed(id);
  }
  
  public void delete(Identifier id)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException
  {
    DataBase db = DataBaseFactory.getDataBase();
    Hostels.getInstance().addBed(get(id).getHostelId(), id);
    db.removeBed(id);
  }
  
  public void update(Identifier id, Bed info)
    throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException, InvalidParameterException
  {
    DataBase db = DataBaseFactory.getDataBase();
    try {
      db.updateBed(id, info);
    }
    catch(GenericException ex) {
      throw ex;
    }
  }
  
  public boolean isBedAvailable(Identifier bedId, Date from, Date to, boolean ignorePricingAvailability)
      throws DataBaseReadWriteException, InvalidParameterException, IdentifierNotFoundException, InvalidIdentifierException
  {
    Booking info = new Booking();
    ArrayList<Identifier> beds = new ArrayList<Identifier>();
    beds.add(bedId);
    info.setBedIds(beds);
    ArrayList<Tariff> tariffs = new ArrayList<Tariff>();
    tariffs.add(new Tariff(null, from, to));
    info.setBedReservations(tariffs);
    info.setStatus(Booking.BookingStatus.RESERVED);
    ArrayList<Identifier> result;
    result = Bookings.getInstance().searchInDateRange(info);
    
    // There is a chance of bed being available as there are no bookings.
    // But price details should also be available for the date
    if (result.isEmpty()) {
      Bed bedInfo = get(bedId);
      if (ignorePricingAvailability || bedInfo.getTariffForDate(from, to) != null) {
        return true;
      }
      else {
        System.err.println("Ooops! bed no " + bedInfo.getNumber().toString()
            + " is free but no price detail available from " + from.toString()
            + " to " + to.toString());
      }
    }
    
    return false;
  }
  
  
  public ArrayList<Identifier> sortBasedOnPrice(ArrayList<Identifier> unsortedBeds, Date checkIn, Date checkOut)
      throws DataBaseReadWriteException, IdentifierNotFoundException, InvalidIdentifierException 
  {
    ArrayList<Identifier> sortedBeds = new ArrayList<Identifier>(unsortedBeds);
        
    for (int i = 0; i < sortedBeds.size(); i++) {
      for (int j = 0; j < sortedBeds.size() - i - 1; j++) {
        
        Integer priceJ = get(sortedBeds.get(j)).getTariffForDate(checkIn, checkOut).getPrice();
        Integer priceJp1 = get(sortedBeds.get(j+1)).getTariffForDate(checkIn, checkOut).getPrice();
        if (priceJ > priceJp1) /* For descending order use < */
        {
          Identifier swap       = sortedBeds.get(j);
          sortedBeds.set(j, sortedBeds.get(j+1));
          sortedBeds.set(j+1, swap);
        }
      }
    }
    return sortedBeds;
  }
      
  public ArrayList<Identifier> search(Bed info) throws DataBaseReadWriteException
  {
    DataBase db = DataBaseFactory.getDataBase();
    ArrayList<Identifier> result = new ArrayList<Identifier>();
    try {
      result = db.searchBed(info);
    }
    catch (DataBaseReadWriteException ex) {
      ex.printStackTrace();
      throw ex;
    }
    return result;
  }
}
