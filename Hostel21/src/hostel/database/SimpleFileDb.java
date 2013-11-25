package hostel.database;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import hostel.core.Address;
import hostel.core.Bed;
import hostel.core.Booking;
import hostel.core.Contact;
import hostel.core.DataBase;
import hostel.core.Hostel;
import hostel.core.Identifier;
import hostel.core.User;
import hostel.exception.DataBaseReadWriteException;
import hostel.exception.IdentifierAlreadyExistsException;
import hostel.exception.IdentifierNotFoundException;
import hostel.exception.InvalidIdentifierException;
import hostel.exception.InvalidParameterException;

public class SimpleFileDb implements DataBase
{

  public static final int USERS = 0;
  public static final int HOSTELS = 1;
  public static final int BEDS = 2;
  public static final int BOOKINGS = 3;
  
  String DbFiles[] = new String[4];
  
  private HashMap<Identifier, User> Users;
  private HashMap<Identifier, Hostel> Hostels;
  private HashMap<Identifier, Bed> Beds;
  private HashMap<Identifier, Booking> Bookings;
  private Integer BookingIdCount = new Integer(0);
  private HashMap<Integer, Identifier> UniqueUserIds;

  public SimpleFileDb()
  {
    DbFiles[USERS] = ".H21_Users.sfdb";
    DbFiles[HOSTELS] = ".H21_Hostels.sfdb";
    DbFiles[BEDS] = ".H21_Beds.sfdb";
    DbFiles[BOOKINGS] = ".H21_Bookings.sfdb";
    
    restore();
  }
  
  public void clear()
  {
    Users = new HashMap<Identifier, User>();
    Hostels = new HashMap<Identifier, Hostel>();
    Beds = new HashMap<Identifier, Bed>();
    Bookings = new HashMap<Identifier, Booking>();
    UniqueUserIds = new HashMap<Integer, Identifier>();
    BookingIdCount = new Integer(0);
    
    write(USERS);
    write(HOSTELS);
    write(BEDS);
    write(BOOKINGS);
  }
  
  public void restore()
  {
    Users = new HashMap<Identifier, User>();
    Hostels = new HashMap<Identifier, Hostel>();
    Beds = new HashMap<Identifier, Bed>();
    Bookings = new HashMap<Identifier, Booking>();
    UniqueUserIds = new HashMap<Integer, Identifier>();
    
    read(USERS);
    read(HOSTELS);
    read(BEDS);
    read(BOOKINGS);
  }

  private void write(int type)
  {
    
    try (
        OutputStream file = new FileOutputStream(DbFiles[type]);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
      ){
        if (type == USERS) {
          output.writeObject(Users);
          try ( OutputStream idFile = new FileOutputStream(DbFiles[USERS]+".id");
                OutputStream idBuffer = new BufferedOutputStream(idFile);
                ObjectOutput idOutput = new ObjectOutputStream(idBuffer);){
            idOutput.writeObject(UniqueUserIds);
          }
          catch(IOException ex){
            ex.printStackTrace();
          }
        }
        else if (type == HOSTELS) {
          output.writeObject(Hostels);
        }
        else if (type == BEDS) {
          output.writeObject(Beds);
        }
        else if (type == BOOKINGS) {
          output.writeObject(Bookings);
          try ( OutputStream idFile = new FileOutputStream(DbFiles[BOOKINGS]+".id");
              OutputStream idBuffer = new BufferedOutputStream(idFile);
              ObjectOutput idOutput = new ObjectOutputStream(idBuffer);){
            idOutput.writeObject(BookingIdCount);
          }
          catch(IOException ex){
            ex.printStackTrace();
          }
        }
      }  
      catch(IOException ex){
        ex.printStackTrace();
      }
  }
  
  @SuppressWarnings("unchecked")
  private void read(int type)
  {
    try(
        InputStream file = new FileInputStream(DbFiles[type]);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream (buffer);
      ){
        if (type == USERS) {
          try ( InputStream idFile = new FileInputStream(DbFiles[USERS]+".id");
                InputStream idBuffer = new BufferedInputStream(idFile);
                ObjectInput idInput = new ObjectInputStream (idBuffer);) {
            UniqueUserIds = (HashMap<Integer, Identifier>) idInput.readObject();
          }
          catch(IOException ex){
            //System.out.println("Nothing to read : (user ids)" + ex.getMessage());
            return;
          }
          Users = (HashMap<Identifier, User>) input.readObject();
        }
        else if (type == HOSTELS) {
          Hostels = (HashMap<Identifier, Hostel>) input.readObject();
        }
        else if (type == BEDS) {
          Beds = (HashMap<Identifier, Bed>) input.readObject();
        }
        else if (type == BOOKINGS) {
          try ( InputStream idFile = new FileInputStream(DbFiles[BOOKINGS]+".id");
              InputStream idBuffer = new BufferedInputStream(idFile);
              ObjectInput idInput = new ObjectInputStream (idBuffer);) {
            BookingIdCount = (Integer) idInput.readObject();
          }
          catch(IOException ex){
            //System.out.println("Nothing to read (booking ID): " + ex.getMessage());
            return;
          }
          Bookings = (HashMap<Identifier, Booking>) input.readObject();
        }
      }
      catch(ClassNotFoundException ex){
        System.out.println("Class not found : " + ex.getMessage());
      }
      catch(IOException ex){
        //System.out.println("Nothing to read : " + ex.getMessage());
      }
  }
  
  private Integer getUniqueIdForUser(User info)
  {
    Integer userId;
    if (info.getContact() != null && info.getContact().getEmail() != null) {
      if (UniqueUserIds.containsKey(info.getContact().getEmail().hashCode())) {
        return null;
      }
      userId = UniqueUserIds.size() + 1;
      UniqueUserIds.put(info.getContact().getEmail().hashCode(), new Identifier(userId.toString()));
      return userId;
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
        throw new IdentifierAlreadyExistsException("Invalid Email Address/ User Already Exists");
      }
      id = new Identifier(userId.toString());
    }
    else {
      throw new InvalidParameterException("Invalid user details");
    }
    Users.put(id, new User(info));
    // Save to DB
    write(USERS);
    return id;
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
    Users.remove(id);
    // Save to DB
    write(USERS);
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
    
    User curInfo = Users.get(id);
    if (info.getFirstName() != null) {
      curInfo.setFirstName(info.getFirstName());
    }
    if (info.getLastName() != null) {
      curInfo.setLastName(info.getLastName());
    }
    if (info.getCcCode() != null) {
      curInfo.setCcCode(info.getCcCode());
    }
    if (info.getSecurityCode() != null) {
      curInfo.setSecurityCode(info.getSecurityCode());
    }
    if (info.getExpirationDate() != null) {
      curInfo.setExpirationDate(info.getExpirationDate());
    }
    if (info.getCreationDate() != null) {
      curInfo.setCreationDate(info.getCreationDate());
    }
    
    Contact curContact = curInfo.getContact();
    if (info.getContact() != null) {
      if (info.getContact().getEmail() != null && !info.getContact().getEmail().equals(curContact.getEmail())) {
        if (UniqueUserIds.containsKey(info.getContact().getEmail().hashCode())) {
          System.err.println("A user with this email already exists");
          throw new InvalidParameterException("A user with this email already exists");
        }
        else {
          UniqueUserIds.put(info.getContact().getEmail().hashCode(), id);
          UniqueUserIds.remove(curInfo.getContact().getEmail().hashCode());
        }
        curContact.setEmail(info.getContact().getEmail());
      }
      if (info.getContact().getPhone() != null) {
        curContact.setPhone(info.getContact().getPhone());
      }
      if (info.getContact().getWebUrl() != null) {
        curContact.setWebUrl(info.getContact().getWebUrl());
      }
      if (info.getContact().getFaceBook() != null) {
        curContact.setFaceBook(info.getContact().getFaceBook());
      }
      curInfo.setContact(curContact);
    }
    
    
    Address curAddress = curInfo.getAddress();
    if (info.getAddress() != null) {
      if (curAddress == null) {
        curInfo.setAddress(info.getAddress());
      }
      else {
        if (info.getAddress().getStreetAddress() != null) {
          curAddress.setStreetAddress(info.getAddress().getStreetAddress());
        }
        if (info.getAddress().getCity() != null) {
          curAddress.setCity(info.getAddress().getCity());
        }
        if (info.getAddress().getState() != null) {
          curAddress.setState(info.getAddress().getState());
        }
        if (info.getAddress().getCountry() != null) {
          curAddress.setCountry(info.getAddress().getCountry());
        }
        if (info.getAddress().getPIN() != null) {
          curAddress.setPIN(info.getAddress().getPIN());
        }
        curInfo.setAddress(curAddress);
      }
    }
    
    Users.put(id, new User(curInfo));
    // Save to DB
    write(USERS);
  }

  
  private String getUniqueIdForHostel(Hostel info)
  {
    if (info.getName() != null) {
      return info.getName();
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
      String hostelId = getUniqueIdForHostel(info);
      if (hostelId == null) {
        throw new InvalidParameterException("Hostel name must be specified");
      }
      id = new Identifier(hostelId);
    }
    else {
      throw new InvalidParameterException("Invalid Parameters");
    }
    if (Hostels.containsKey(id) == false) {
      Hostels.put(id, new Hostel(info));
      // Save to DB
      write(HOSTELS);
      return id;
    }
    else {
      throw new IdentifierAlreadyExistsException("Hostel Already Exists");
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
    Hostels.remove(id);
    // Save to DB
    write(HOSTELS);
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
    // Save to DB
    write(HOSTELS);
  }

  private String getUniqueIdForBed(Bed info)
  {
    if (info.getHostelId() == null || info.getNumber() == null || info.getRoomNo() == null
        || !Hostels.containsKey(info.getHostelId())) {
      return null;
    }
    String key = Hostels.get(info.getHostelId()).getName() + "_room_" + info.getRoomNo().toString() + "_bed_" + info.getNumber().toString();
    return key;
  }
  
  @Override
  public Identifier addBed(Bed info) throws DataBaseReadWriteException,
      IdentifierAlreadyExistsException, InvalidParameterException
  {
    Identifier id;
    
    if (info == null) {
      throw new InvalidParameterException("input is null");
    }
    String bedId = getUniqueIdForBed(info);
    if (bedId == null) {
      throw new InvalidParameterException("Invalid Hostel Id or Bed number");
    }
    id = new Identifier(bedId);

    if (Beds.containsKey(id) == false) {
      Beds.put(id, new Bed(info));
      // Save to DB
      write(BEDS);
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
    Beds.remove(id);
    // Save to DB
    write(BEDS);
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
    // Save to DB
    write(BEDS);
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
        || info.getBedIds().isEmpty()
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
    
    id = new Identifier((++BookingIdCount).toString());
    if (Bookings.containsKey(id)) {
      throw new DataBaseReadWriteException("Failed to generate a booking ID!");
    }
    Bookings.put(id, new Booking(info));
    // Save to DB
    write(BOOKINGS);
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
    Bookings.remove(id);
    // Save to DB
    write(BOOKINGS);
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
    if (info.getHostelId() != null && !info.getHostelId().equals(currentInfo.getHostelId())
        || info.getBedIds() != null && !info.getBedIds().equals(currentInfo.getBedIds())) {
      
      throw  new InvalidParameterException("Modifiation of hostel and beds not allowed in this version");
    }
    
    Bookings.put(id, new Booking(info));
    // Save to DB
    write(BOOKINGS);
  }
}
