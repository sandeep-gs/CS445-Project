package hostel.unittest;

import java.util.ArrayList;
import java.util.Date;

import hostel.core.Address;
import hostel.core.Contact;
import hostel.core.Identifier;
import hostel.core.Booking;
import hostel.core.Bed;
import hostel.core.User;
import hostel.exception.DataBaseReadWriteException;
import hostel.exception.IdentifierAlreadyExistsException;
import hostel.exception.IdentifierNotFoundException;
import hostel.core.Tariff;
import hostel.exception.InvalidIdentifierException;
import hostel.database.SimpleFileDb;
import hostel.exception.InvalidParameterException;
import hostel.utility.GenericUtility;
import hostel.core.Hostel;

import org.junit.*;

import static org.junit.Assert.*;


public class SimpleFileDbUnitTest
{
  SimpleFileDb db = new SimpleFileDb();
  
  @BeforeClass
  public static void setUpBeforeClass() throws Exception
  {
    
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception
  {
 
  }

  @Before
  public void setUp() throws Exception
  {
    db.clear();
  }

  @After
  public void tearDown() throws Exception
  {
    db.clear();
  }

  @Test
  public void testSimpleRamDb()
  {
    SimpleFileDb tempdb = new SimpleFileDb();
    assertFalse(tempdb == null);
  }

  @Test(expected = InvalidParameterException.class)
  public void testAddUserNullInfo() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
      db.addUser(null);
  }

  @Test(expected = IdentifierAlreadyExistsException.class)
  public void testAddUserNullEmail() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
      db.addUser(new User());
  }
  
  @Test
  public void testAddUserSuccess() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info = new User();
    Contact contact = new Contact();
    contact.setEmail("test@test.com");
    info.setContact(contact);
    Identifier id = db.addUser(info);
    assertFalse(id == null);
  }
  
  @Test(expected = IdentifierAlreadyExistsException.class)
  public void testAddUserDuplicateUser() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info = new User();
    Contact contact = new Contact();
    contact.setEmail("test@test.com");
    info.setContact(contact);
    db.addUser(info);
    db.addUser(info);
  }
    
  @Test(expected = InvalidIdentifierException.class)
  public void testRemoveUserNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.removeUser(null);
  }

  @Test(expected = IdentifierNotFoundException.class)
  public void testRemoveUserInvalidId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.removeUser(new Identifier("test"));
  }
  
  @Test(expected = IdentifierNotFoundException.class)
  public void testRemoveUserSuccess() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info = new User();
    Contact contact = new Contact();
    contact.setEmail("test@test.com");
    info.setContact(contact);
    Identifier id = db.addUser(info);
    db.removeUser(id);
    db.getUser(id);
  }
  
  @Test
  public void testGetUserAddAndGet() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info = new User();
    Contact contact = new Contact();
    contact.setEmail("test@test.com");
    info.setContact(contact);
    Identifier id = db.addUser(info);
    User result = db.getUser(id);
    assertTrue(result.equals(info));
  }

  @Test(expected = InvalidIdentifierException.class)
  public void testGetUserNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.getUser(null);
  }

  @Test(expected = IdentifierNotFoundException.class)
  public void testGetUserIdNotFound() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.getUser(new Identifier("test"));
  }
  
  @Test
  public void testSearchUser() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info1 = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    info1.setContact(contact1);
    db.addUser(info1);

    User info2 = new User();
    Contact contact2 = new Contact();
    contact2.setEmail("test2@test2.com");
    info2.setContact(contact2);
    db.addUser(info2);
    
    ArrayList<Identifier> result = db.searchUser(info2);
    assertTrue(result.size() == 1);
    
    User info3 = new User();
    Contact contact3 = new Contact();
    contact3.setEmail("test3@test3.com");
    info3.setContact(contact3);
    result = db.searchUser(info3);
    assertTrue(result.size() == 0);
  }
  
  @Test(expected = InvalidIdentifierException.class)
  public void testUpdateUserNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info = new User();
    db.updateUser(null, info);
  }
  
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testUpdateUserNullInfo() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    db.updateUser(new Identifier("test"), null);
  }
  
  @Test
  public void testUpdateUserSuccess() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    info.setContact(contact1);
    Identifier id = db.addUser(info);
    info.setFirstName("test1");
    db.updateUser(id, info);
    User result = db.getUser(id);
    assertTrue(result.getFirstName().equals(info.getFirstName()));
  }
  
  @Test
  public void testUpdateUserSuccessMore1() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info = new User();
    Contact contact1 = new Contact();
    Address address1 = new Address();
    contact1.setEmail("test1@test1.com");
    info.setContact(contact1);
    info.setAddress(address1);
    Identifier id = db.addUser(info);
    
    
    info.setFirstName("test1");
    info.setLastName("abc");
    info.setSecurityCode("sec");
    info.setCcCode("cc");
    info.setExpirationDate(new Date());
    info.setCreationDate(new Date());
    contact1.setFaceBook("fb");
    contact1.setPhone("111111");
    contact1.setWebUrl("web");
    address1.setCity("city");
    address1.setCountry("country");
    address1.setPIN("11111");
    address1.setState("state");
    address1.setStreetAddress("abc");
    info.setContact(contact1);
    info.setAddress(address1);
    db.updateUser(id, info);
    User result = db.getUser(id);
    assertTrue(result.getFirstName().equals(info.getFirstName()));
  }
  
  @Test
  public void testUpdateUserSuccessMore2() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info = new User();
    Contact contact1 = new Contact();
    Address address1 = new Address();
    contact1.setEmail("test1@test1.com");
    info.setContact(contact1);
    Identifier id = db.addUser(info);
    
    
    info.setFirstName("test1");
    info.setLastName("abc");
    info.setSecurityCode("sec");
    info.setCcCode("cc");
    info.setExpirationDate(new Date());
    info.setCreationDate(new Date());
    contact1.setFaceBook("fb");
    contact1.setPhone("111111");
    contact1.setWebUrl("web");
    address1.setCity("city");
    address1.setCountry("country");
    address1.setPIN("11111");
    address1.setState("state");
    address1.setStreetAddress("abc");
    info.setContact(contact1);
    info.setAddress(address1);
    db.updateUser(id, info);
    User result = db.getUser(id);
    assertTrue(result.getFirstName().equals(info.getFirstName()));
  }
  
  @Test
  public void testUpdateUserSuccessMore3() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info = new User();
    Contact contact1 = new Contact();
    Address address1 = new Address();
    contact1.setEmail("test1@test1.com");
    contact1.setFaceBook("fb");
    contact1.setPhone("111111");
    contact1.setWebUrl("web");
    address1.setCity("city");
    address1.setCountry("country");
    address1.setPIN("11111");
    address1.setState("state");
    address1.setStreetAddress("abc");
    info.setContact(contact1);
    info.setAddress(address1);
    Identifier id = db.addUser(info);
    
    
    info.setFirstName("test1");
    info.setLastName("abc");
    info.setSecurityCode("sec");
    info.setCcCode("cc");
    info.setExpirationDate(new Date());
    info.setCreationDate(new Date());
    info.setContact(new Contact());
    info.setAddress(new Address());
    db.updateUser(id, info);
    User result = db.getUser(id);
    assertTrue(result.getFirstName().equals(info.getFirstName()));
    
    info.setFirstName("test1");
    info.setLastName("abc");
    info.setSecurityCode("sec");
    info.setCcCode("cc");
    info.setExpirationDate(new Date());
    info.setCreationDate(new Date());
    info.setContact(null);
    info.setAddress(new Address());
    db.updateUser(id, info);
    result = db.getUser(id);
    assertTrue(result.getFirstName().equals(info.getFirstName()));
  }
  
  @Test(expected = IdentifierNotFoundException.class)
  public void testUpdateUserIdnotFound() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    info.setContact(contact1);
    db.addUser(info);
    info.setFirstName("test1");
    db.updateUser(new Identifier("test"), info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testUpdateUserKeyMismatch1() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info1 = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    info1.setContact(contact1);
    Identifier id1 = db.addUser(info1);
    
    User info2 = new User();
    Contact contact2 = new Contact();
    contact2.setEmail("test2@test2.com");
    info2.setContact(contact2);
    Identifier id2 = db.addUser(info2);
    
    User info3 = new User();
    Contact contact3 = new Contact();
    contact3.setEmail("test2@test2.com");
    info3.setContact(contact3);
    db.updateUser(id1, info3);
  }
  
  @Test
  public void testUpdateUserKeyMismatchAllowed() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info1 = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    info1.setContact(contact1);
    Identifier id1 = db.addUser(info1);
       
    User info3 = new User();
    Contact contact3 = new Contact();
    contact3.setEmail("test2@test2.com");
    info3.setContact(contact3);
    db.updateUser(id1, info3);
    assertTrue(true);
  }
  
  @Test
  public void testUpdateUserTricky() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    User info1 = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    info1.setContact(contact1);
    Identifier id1 = db.addUser(info1);
       
    User info3 = new User();
    Contact contact3 = new Contact();
    info3.setContact(contact3);
    db.updateUser(id1, info3);
    assertTrue(true);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddHostelNullInfo() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
      db.addHostel(null);
  }

  @Test(expected = InvalidParameterException.class)
  public void testAddHostelNullName() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
      db.addHostel(new Hostel());
  }
  
  @Test
  public void testAddHostelSuccess() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel info = new Hostel();
    info.setName("test");
    Identifier id = db.addHostel(info);
    assertFalse(id == null);
  }
  
  @Test(expected = IdentifierAlreadyExistsException.class)
  public void testAddHostelDuplicateUser() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel info = new Hostel();
    info.setName("test");
    db.addHostel(info);
    db.addHostel(info);
  }
    
  @Test(expected = InvalidIdentifierException.class)
  public void testRemoveHostelNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.removeHostel(null);
  }

  @Test(expected = IdentifierNotFoundException.class)
  public void testRemoveHostelInvalidId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.removeHostel(new Identifier("test"));
  }
  
  @Test(expected = IdentifierNotFoundException.class)
  public void testRemoveHostelSuccess() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel info = new Hostel();
    info.setName("test");
    Identifier id = db.addHostel(info);
    db.removeHostel(id);
    db.getHostel(id);
  }
  
  @Test
  public void testGetHostelAddAndGet() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel info = new Hostel();
    info.setName("test");
    Identifier id = db.addHostel(info);
    Hostel result = db.getHostel(id);
    assertTrue(result.equals(info));
  }

  @Test(expected = InvalidIdentifierException.class)
  public void testGetHostelNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.getHostel(null);
  }

  @Test(expected = IdentifierNotFoundException.class)
  public void testGetHostelIdNotFound() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.getHostel(new Identifier("test"));
  }
  
  @Test
  public void testSearchHostel() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel info = new Hostel();
    info.setName("test1");
    db.addHostel(info);
    info.setName("test2");
    db.addHostel(info);
    ArrayList<Identifier> result = db.searchHostel(info);
    assertTrue(result.size() == 1);
    info.setName("test3");
    result = db.searchHostel(info);
    assertTrue(result.size() == 0);
  }
  
  @Test(expected = InvalidIdentifierException.class)
  public void testUpdateHostelNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel info = new Hostel();
    db.updateHostel(null, info);
  }
  
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testUpdateHostelNullInfo() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    db.updateHostel(new Identifier("test"), null);
  }
  
  @Test
  public void testUpdateHostelSuccess() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel info = new Hostel();
    Contact contact = new Contact();
    contact.setEmail("abc");
    info.setContact(contact);
    info.setName("test1");
    Identifier id = db.addHostel(info);
    contact.setEmail("xyz");
    db.updateHostel(id, info);
    info.setContact(contact);
    Hostel result = db.getHostel(id);
    assertTrue(result.getContact().equals(info.getContact()));
  }
  
  @Test(expected = IdentifierNotFoundException.class)
  public void testUpdateHostelIdnotFound() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel info = new Hostel();
    info.setName("test1");
    db.addHostel(info);
    db.updateHostel(new Identifier("test"), info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBedInvalidParamExcep1() throws DataBaseReadWriteException, IdentifierAlreadyExistsException,
  InvalidParameterException
  {
    Bed info = null;
    db.addBed(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBedInvalidParamExcep2() throws DataBaseReadWriteException, IdentifierAlreadyExistsException,
  InvalidParameterException
  {
    Bed info = new Bed();
    db.addBed(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBedInvalidParamExcep3() throws DataBaseReadWriteException, IdentifierAlreadyExistsException,
  InvalidParameterException
  {
    Bed info = new Bed();
    info.setNumber(1);
    db.addBed(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBedInvalidParamExcep4() throws DataBaseReadWriteException, IdentifierAlreadyExistsException,
  InvalidParameterException
  {
    Bed info = new Bed();
    info.setHostelId(new Identifier("test"));
    info.setNumber(1);
    db.addBed(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBedInvalidParamExcep5() throws DataBaseReadWriteException, IdentifierAlreadyExistsException,
  InvalidParameterException
  {
    Bed info = new Bed();
    info.setHostelId(new Identifier("test"));
    db.addBed(info);
  }
  
  @Test
  public void testAddBedSuccss() throws DataBaseReadWriteException, IdentifierAlreadyExistsException,
  InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed info1 = new Bed();
    info1.setNumber(1);
    info1.setRoomNo(1);
    info1.setHostelId(hostelId);
    Identifier id = db.addBed(info1);
    
    assertFalse(id == null);
  }
  
  @Test(expected = IdentifierAlreadyExistsException.class)
  public void testAddBedIdAlreadyExists() throws DataBaseReadWriteException, IdentifierAlreadyExistsException,
  InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed info1 = new Bed();
    info1.setNumber(1);
    info1.setRoomNo(1);
    info1.setHostelId(hostelId);
    Identifier id = db.addBed(info1);    
    
    Bed info2 = new Bed();
    info2.setNumber(1);
    info2.setRoomNo(1);
    info2.setHostelId(hostelId);
    db.addBed(info2);
  }
    
  @Test(expected = InvalidIdentifierException.class)
  public void testRemoveBedNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.removeBed(null);
  }

  @Test(expected = IdentifierNotFoundException.class)
  public void testRemoveBedInvalidId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.removeBed(new Identifier("1"));
  }
  
  @Test(expected = IdentifierNotFoundException.class)
  public void testRemoveBedSuccess() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed info1 = new Bed();
    info1.setNumber(1);
    info1.setRoomNo(1);
    info1.setHostelId(hostelId);
    Identifier id = db.addBed(info1);    
    db.removeBed(id);
    db.getBed(id); 
  }

  @Test
  public void testGetBedAddAndGet() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed info1 = new Bed();
    info1.setNumber(1);
    info1.setRoomNo(1);
    info1.setHostelId(hostelId);
    Identifier id = db.addBed(info1);   
    
    Bed result = db.getBed(id);
    assertTrue(result.equals(info1));
  }

  @Test(expected = InvalidIdentifierException.class)
  public void testGetBedNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.getBed(null);
  }
  
  @Test(expected = IdentifierNotFoundException.class)
  public void testGetBedIdNotFound() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.getBed(new Identifier("1"));
  }
  
  @Test
  public void testSearchBed() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed info1 = new Bed();
    info1.setNumber(1);
    info1.setRoomNo(1);
    info1.setHostelId(hostelId);
    Identifier id = db.addBed(info1);   
    
    info1.setNumber(2);    
    db.addBed(info1);
    
    ArrayList<Identifier> result = db.searchBed(info1);
    assertTrue(result.size() == 1);
    
    info1.setNumber(3);
    result = db.searchBed(info1);
    assertTrue(result.size() == 0);
  }

  @Test(expected = InvalidIdentifierException.class)
  public void testUpdateBedNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Bed info = new Bed();
    db.updateBed(null, info);
  }
  
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testUpdateBedNullInfo() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    db.updateBed(new Identifier("1"), null);
  }
  
  @Test
  public void testUpdateBedSuccess() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed info1 = new Bed();
    info1.setNumber(1);
    info1.setRoomNo(1);
    info1.setHostelId(hostelId);
    Identifier id = db.addBed(info1);   
    
    ArrayList<Tariff> tariffs = new ArrayList<Tariff>();
    tariffs.add(new Tariff(100, new Date(), new Date()));
    info1.setTariff(tariffs);
    db.updateBed(id, info1);
    Bed result = db.getBed(id);
    assertTrue(result.getTariff().equals(info1.getTariff()));
  }
  
  @Test(expected = IdentifierNotFoundException.class)
  public void testUpdateBedIdnotFound() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed info1 = new Bed();
    info1.setNumber(1);
    info1.setRoomNo(1);
    info1.setHostelId(hostelId);
    Identifier id = db.addBed(info1);
    db.updateBed(new Identifier("2"), info1);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testUpdateBedKeyMismatch1() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed info1 = new Bed();
    info1.setNumber(1);
    info1.setRoomNo(1);
    info1.setHostelId(hostelId);
    Identifier id = db.addBed(info1);
    info1.setNumber(2);
    db.updateBed(id, info1);
  }

  @Test(expected = InvalidParameterException.class)
  public void testAddBookingNullInfo() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
      db.addBooking(null);
  }

  @Test(expected = InvalidParameterException.class)
  public void testAddBookingNullId() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
      db.addBooking(new Booking());
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBookingInvalidParam1() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    db.addBooking(null);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBookingInvalidParam2() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(null);
    
    db.addBooking(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBookingInvalidParam3() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(null);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    db.addBooking(info);
    
    db.addBooking(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBookingInvalidParam4() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(null);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    db.addBooking(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBookingInvalidParam5() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(null);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    db.addBooking(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBookingInvalidParam6() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    //bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    db.addBooking(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBookingInvalidParam7() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    //bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    db.addBooking(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBookingInvalidParam8() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(new Identifier("abc"));
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    db.addBooking(info);
  }
  @Test(expected = InvalidParameterException.class)
  public void testAddBookingInvalidParam9() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(new Identifier("abc"));
    info.setBedIds(bedIds);
    
    db.addBooking(info);
  }
  
  @Test(expected = InvalidParameterException.class)
  public void testAddBookingInvalidParam10() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(new Identifier("finally"));
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    db.addBooking(info);
  }
  
  @Test
  public void testAddBookingSuccess() throws DataBaseReadWriteException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    db.addBooking(info);
  }
     
  @Test(expected = InvalidIdentifierException.class)
  public void testRemoveBookingNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.removeBooking(null);
  }

  @Test(expected = IdentifierNotFoundException.class)
  public void testRemoveBookingInvalidId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.removeBooking(new Identifier("test"));
  }
  
  @Test(expected = IdentifierNotFoundException.class)
  public void testRemoveBookingSuccess() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    Identifier id = db.addBooking(info);
    db.removeBooking(id);
    db.getBooking(id);
  }
  
  @Test
  public void testGetBookingAddAndGet() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    Identifier id = db.addBooking(info);
    Booking result = db.getBooking(id);
    assertTrue(result.equals(info));
  }

  @Test(expected = InvalidIdentifierException.class)
  public void testGetBookingNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.getBooking(null);
  }

  @Test(expected = IdentifierNotFoundException.class)
  public void testGetBookingIdNotFound() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException
  {
    db.getBooking(new Identifier("test"));
  }
  
  @Test
  public void testSearchBooking() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    Identifier id = db.addBooking(info);
    ArrayList<Identifier> result = db.searchBooking(info);
    assertTrue(result.size() == 1);
    info.setStatus(Booking.BookingStatus.CLOSED);
    result = db.searchBooking(info);
    assertTrue(result.size() == 0);
  }
  
  @Test(expected = InvalidIdentifierException.class)
  public void testUpdateBookingNullId() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Booking info = new Booking();
    db.updateBooking(null, info);
  }
  
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testUpdateBookingNullInfo() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    db.updateBooking(new Identifier("test"), null);
  }
  
  @Test
  public void testUpdateBookingSuccess1() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    Identifier id = db.addBooking(info);
    info.setStatus(Booking.BookingStatus.CANCELLED);
    db.updateBooking(id, info);
    Booking result = db.getBooking(id);
    assertTrue(result.getStatus().equals(info.getStatus()));
  }
  
  @Test(expected = IdentifierNotFoundException.class)
  public void testUpdateBookingIdnotFound() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    Identifier id = db.addBooking(info);
    db.updateBooking(new Identifier("test"), info);
  }
 
  @Test(expected = InvalidParameterException.class)
  public void testUpdateBookingInvalidUpdate() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    Identifier id = db.addBooking(info);
    
    Booking info1 = new Booking();
    info1.setHostelId(new Identifier("x"));
    db.updateBooking(id, info1);
    
    Booking info2 = new Booking();
    info2.setBedIds(new ArrayList<Identifier>());
    db.updateBooking(id, info2);
    
    Booking info3 = new Booking();
    info3.setBedReservations(new ArrayList<Tariff>());
    db.updateBooking(id, info3);
  }
  
  @Test
  public void testUpdateBookingValidUpdate() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    Identifier id = db.addBooking(info);
    
    Booking info1 = db.getBooking(id);
    
    info1.setHostelId(hostelId);
    db.updateBooking(id, info1);
        
    Booking info3  = db.getBooking(id);
    db.updateBooking(id, info3);
    assertTrue(true);
  }
  
  @Test
  public void testUpdateBookingValidUpdate2() throws DataBaseReadWriteException,
  IdentifierNotFoundException, InvalidIdentifierException, IdentifierAlreadyExistsException, InvalidParameterException
  {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = db.addHostel(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = db.addBed(bedInfo);
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = db.addUser(userInfo);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId);
    info.setBedIds(bedIds);
    
    Identifier id = db.addBooking(info);
    
    Booking info1 = new Booking();
    info1.setStatus(Booking.BookingStatus.CANCELLED);
    db.updateBooking(id, info1);
    
    
    assertTrue(true);
  }
  
  
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(SimpleFileDbUnitTest.class);
  }
}