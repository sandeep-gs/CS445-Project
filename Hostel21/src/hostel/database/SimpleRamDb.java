package hostel.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import hostel.core.Bed;
import hostel.core.Booking;
import hostel.core.DataBase;
import hostel.core.Hostel;
import hostel.core.Identifier;
import hostel.core.User;
import hostel.exception.DataBaseReadWriteException;
import hostel.exception.IdentifierAlreadyExistsException;
import hostel.exception.IdentifierNotFoundException;
import hostel.exception.InvalidIdentifierException;
import hostel.exception.InvalidParameterException;

public class SimpleRamDb implements DataBase
{
  private HashMap<Identifier, User> Users;
  private HashMap<Identifier, Hostel> Hostels;
  private HashMap<Identifier, Bed> Beds;
  private HashMap<Identifier, Booking> Bookings;
  private Integer BookingIdCount = new Integer(1);

  public SimpleRamDb()
  {
    Users = new HashMap<Identifier, User>();
    Hostels = new HashMap<Identifier, Hostel>();
    Beds = new HashMap<Identifier, Bed>();
    Bookings = new HashMap<Identifier, Booking>();
  }

  public void clear()
  {
    Users = new HashMap<Identifier, User>();
    Hostels = new HashMap<Identifier, Hostel>();
    Beds = new HashMap<Identifier, Bed>();
    Bookings = new HashMap<Identifier, Booking>();
    
    BookingIdCount = new Integer(1);
  }
  
  public void restore()
  {

  }

  private Integer getUniqueIdForUser(User info)
  {
    if (info.getContact() != null && info.getContact().getEmail() != null) {
      return info.getContact().getEmail().hashCode();
    }
    return null;
  }
  
  @Override
  public Identifier addUser(User info) throws DataBaseReadWriteException,
      IdentifierAlreadyExistsException, InvalidParameterException
  {
    Identifier id;
    
    if (info != null) {
      Integer userId = getUniqueIdForUser(info);
      if (userId == null) {
        throw new InvalidParameterException("Invalid Email Address");
      }
      id = new Identifier(userId.toString());
    }
    else {
      throw new InvalidParameterException("Invalid user details");
    }
    if (Users.containsKey(id) == false) {
      Users.put(id, new User(info));
      return id;
    }
    else {
      throw new IdentifierAlreadyExistsException("User Already Exists");
    }
  }

  @Override
  public void removeUser(Identifier id) throws DataBaseReadWriteException,
      IdentifierNotFoundException, InvalidIdentifierException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is invalid");
    }
    if (Users.remove(id) == null) {
      throw  new IdentifierNotFoundException("Id not found");
    }
  }

  @Override
  public User getUser(Identifier id) throws DataBaseReadWriteException,
      IdentifierNotFoundException, InvalidIdentifierException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is invalid");
    }
    User info = Users.get(id);
    if (info == null) {
      throw  new IdentifierNotFoundException("Id not found");
    }
    return new User(info);
  }

  @Override
  public ArrayList<Identifier> searchUser(User info)
      throws DataBaseReadWriteException
  {
    ArrayList<Identifier> ids = new ArrayList<Identifier>();
    for (Map.Entry<Identifier, User> entry : Users.entrySet()) {
      if (entry.getValue().match(info)) {
        Identifier id = entry.getKey();
        ids.add(id);
      }
    }
    return ids;
  }

  @Override
  public void updateUser(Identifier id, User info)
      throws DataBaseReadWriteException, IdentifierNotFoundException,
      InvalidIdentifierException, InvalidParameterException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is null");
    }
    
    if (info == null) {
      throw  new InvalidParameterException("info is null");
    }
       
    if (Users.containsKey(id) == false) {
      throw  new IdentifierNotFoundException("Id not found");
    }
       
    Users.put(id, new User(info));
  }

  
  private Integer getUniqueIdForHostel(Hostel info)
  {
    if (info.getName() != null) {
      return info.getName().hashCode();
    }
    return null;
  }
  
  @Override
  public Identifier addHostel(Hostel info)
      throws DataBaseReadWriteException, IdentifierAlreadyExistsException,
      InvalidParameterException
  {
    Identifier id;
    
    if (info != null) {
      Integer hostelId = getUniqueIdForHostel(info);
      id = new Identifier(hostelId.toString());
    }
    else {
      throw new InvalidParameterException("Invalid Parameters");
    }
    if (Hostels.containsKey(id) == false) {
      Hostels.put(id, new Hostel(info));
      return id;
    }
    else {
      throw new IdentifierAlreadyExistsException("User Already Exists");
    }
  }

  @Override
  public void removeHostel(Identifier id) throws DataBaseReadWriteException,
      IdentifierNotFoundException, InvalidIdentifierException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is invalid");
    }
    if (Hostels.remove(id) == null) {
      throw  new IdentifierNotFoundException("Id not found");
    }
  }

  @Override
  public Hostel getHostel(Identifier id) throws DataBaseReadWriteException,
      IdentifierNotFoundException, InvalidIdentifierException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is invalid");
    }
    Hostel info = Hostels.get(id);
    if (info == null) {
      throw  new IdentifierNotFoundException("Id not found");
    }
    return new Hostel(info);
  }

  @Override
  public ArrayList<Identifier> searchHostel(Hostel info)
      throws DataBaseReadWriteException
  {   
    ArrayList<Identifier> ids = new ArrayList<Identifier>();
    for (Map.Entry<Identifier, Hostel> entry : Hostels.entrySet()) {
      if (entry.getValue().match(info)) {
        Identifier id = entry.getKey();
        ids.add(id);
      }
    }
    return ids;
  }

  @Override
  public void updateHostel(Identifier id, Hostel info)
      throws DataBaseReadWriteException, IdentifierNotFoundException,
      InvalidIdentifierException, InvalidParameterException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is null");
    }
    
    if (info == null) {
      throw  new InvalidParameterException("info is null");
    }
       
    if (Hostels.containsKey(id) == false) {
      throw  new IdentifierNotFoundException("Id not found");
    }
    Hostels.put(id, new Hostel(info));
  }

  private Integer getUniqueIdForBed(Bed info)
  {
    if (info.getHostelId() == null || info.getNumber() == null || info.getRoomNo() == null
        || !Hostels.containsKey(info.getHostelId())) {
      return null;
    }
    String key = Hostels.get(info.getHostelId()).getName() + "-" + info.getRoomNo() + "-" + info.getNumber().toString();
    return key.hashCode();
  }
  
  @Override
  public Identifier addBed(Bed info) throws DataBaseReadWriteException,
      IdentifierAlreadyExistsException, InvalidParameterException
  {
    Identifier id;
    
    if (info == null) {
      throw new InvalidParameterException("input is null");
    }
    Integer bedId = getUniqueIdForBed(info);
    if (bedId == null) {
      throw new InvalidParameterException("Invalid Hostel Id or Bed number");
    }
    id = new Identifier(bedId.toString());

    if (Beds.containsKey(id) == false) {
      Beds.put(id, new Bed(info));
      return id;
    }
    else {
      throw new IdentifierAlreadyExistsException("Bed Already Exists");
    }
  }

  @Override
  public void removeBed(Identifier id) throws DataBaseReadWriteException,
      IdentifierNotFoundException, InvalidIdentifierException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is invalid");
    }
    if (Beds.remove(id) == null) {
      throw  new IdentifierNotFoundException("Id not found");
    }
  }

  @Override
  public Bed getBed(Identifier id) throws DataBaseReadWriteException,
      IdentifierNotFoundException, InvalidIdentifierException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is invalid");
    }
    Bed info = Beds.get(id);
    if (info == null) {
      throw  new IdentifierNotFoundException("Id not found");
    }
    return new Bed(info);
  }

  @Override
  public ArrayList<Identifier> searchBed(Bed info)
      throws DataBaseReadWriteException
  {
    ArrayList<Identifier> ids = new ArrayList<Identifier>();
    Iterator<Entry<Identifier, Bed>> it = Beds.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<Identifier, Bed> pairs = (Map.Entry<Identifier, Bed>)it.next();
      if (pairs.getValue().match(info)) {
        ids.add(pairs.getKey());
      }
    }
    return ids;
  }

  @Override
  public void updateBed(Identifier id, Bed info)
      throws DataBaseReadWriteException, IdentifierNotFoundException,
      InvalidIdentifierException, InvalidParameterException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is null");
    }
    if (info == null) {
      throw  new InvalidParameterException("info is null");
    }
       
    if (Beds.containsKey(id) == false) {
      throw  new IdentifierNotFoundException("Id not found");
    }
        
    Bed currentInfo = Beds.get(id);
    if (info.getNumber() != null && info.getNumber() != currentInfo.getNumber()
        || info.getHostelId() != null && info.getHostelId() != currentInfo.getHostelId()) {
      throw  new InvalidParameterException("Modifiation of hostel and bed number not allowed in this version");
    }
    Beds.put(id, new Bed(info));
  }

  @Override
  public Identifier addBooking(Booking info)
      throws DataBaseReadWriteException,
      InvalidParameterException
  {
    Identifier id;  
    if (info == null
        || info.getHostelId() == null
        || !Hostels.containsKey(info.getHostelId())
        || info.getBedIds() == null
        || info.getBedReservations() == null
        || info.getBedReservations().isEmpty()
        || info.getUserId() == null
        || !Users.containsKey(info.getUserId())) {
      throw new InvalidParameterException("Invalid Booking details");
    }
    
    // second level of sanity test
    for (Identifier key : info.getBedIds()) {
      if (!Beds.containsKey(key)) {
        throw new InvalidParameterException("Invalid Bed Ids");
      }
    }
    
    id = new Identifier((BookingIdCount++).toString());
    Bookings.put(id, new Booking(info));
    return id;
  }
  
  @Override
  public void removeBooking(Identifier id) throws DataBaseReadWriteException,
      IdentifierNotFoundException, InvalidIdentifierException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is invalid");
    }
    if (Bookings.remove(id) == null) {
      throw  new IdentifierNotFoundException("Id not found");
    }
  }

  @Override
  public Booking getBooking(Identifier id)
      throws DataBaseReadWriteException, IdentifierNotFoundException,
      InvalidIdentifierException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is invalid");
    }
    Booking info = Bookings.get(id);
    if (info == null) {
      throw  new IdentifierNotFoundException("Id not found");
    }
    return new Booking(info);
  }

  @Override
  public ArrayList<Identifier> searchBooking(Booking info)
      throws DataBaseReadWriteException
  {
    ArrayList<Identifier> ids = new ArrayList<Identifier>();
    Iterator<Entry<Identifier, Booking>> it = Bookings.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<Identifier, Booking> pairs = (Map.Entry<Identifier, Booking>)it.next();
      if (pairs.getValue().match(info)) {
        ids.add(pairs.getKey());
      }
    }
    return ids;
  }

  @Override
  public void updateBooking(Identifier id, Booking info)
      throws DataBaseReadWriteException, IdentifierNotFoundException,
      InvalidIdentifierException, InvalidParameterException
  {
    if (id == null) {
      throw  new InvalidIdentifierException("Id is null");
    }
    if (info == null) {
      throw  new InvalidParameterException("info is null");
    }
    if (Bookings.containsKey(id) == false) {
      throw  new IdentifierNotFoundException("Id not found");
    }
    
    Booking currentInfo = Bookings.get(id);
    if (info.getHostelId() != null && info.getHostelId().equals(currentInfo.getHostelId())
        || info.getBedIds() != null && info.getBedIds().equals(currentInfo.getBedIds())
        || info.getBedReservations() != null || info.getBedIds() != null) {
      
      throw  new InvalidParameterException("Modifiation of hostel and schedule not allowed in this version");
    }
    
    Bookings.put(id, new Booking(info));
  }
}
