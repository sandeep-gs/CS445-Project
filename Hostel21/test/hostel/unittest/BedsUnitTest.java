package hostel.unittest;

import java.util.ArrayList;
import java.util.Date;

import hostel.core.Identifier;
import hostel.exception.IdentifierNotFoundException;
import hostel.core.Booking;
import hostel.core.Contact;
import hostel.core.DataBaseFactory;
import hostel.core.Hostel;
import hostel.core.Policy;
import hostel.core.Tariff;
import hostel.core.Bed;
import hostel.core.User;
import hostel.collection.Beds;
import hostel.collection.Bookings;
import hostel.collection.Hostels;
import hostel.collection.Users;
import hostel.exception.InvalidParameterException;
import hostel.exception.DataBaseReadWriteException;
import hostel.utility.GenericUtility;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>BedsUnitTest</code> contains tests for the class <code>{@link Beds}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:41 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class BedsUnitTest
{
  /**
   * Run the Identifier create(Bed) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testCreate_1()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Bed info = new Bed();

    Identifier result = fixture.create(info);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Identifier create(Bed) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierAlreadyExistsException.class)
  public void testCreate_2()
    throws Exception {
    
    Beds beds = Beds.getInstance();
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = beds.create(bedInfo);
    bedId = beds.create(bedInfo);


    // add additional test code here
    assertNotNull(bedId);
  }

  /**
   * Run the Identifier create(Bed) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testCreate_3()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Bed info = new Bed();

    Identifier result = fixture.create(info);

    // add additional test code here
    assertNotNull(result);
  }

  
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testDeleteSuccess()
    throws Exception {
    
    Beds beds = Beds.getInstance();
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = beds.create(bedInfo);
    beds.delete(bedId);
    beds.get(bedId);
  }
  
  
  @Test
  public void testUpdateSuccess()
    throws Exception {
    
    Beds beds = Beds.getInstance();
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = beds.create(bedInfo);
    bedTariff.set(0, new Tariff(100, null, null));
    bedInfo.setTariff(bedTariff);
    beds.update(bedId, bedInfo);
    Bed updated = beds.get(bedId);
    assertTrue(updated.getTariff().get(0).getPrice() == 100);
  }
  
  /**
   * Run the Identifier create(Bed) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testCreate_4()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Bed info = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    Identifier result = fixture.create(info);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Identifier create(Bed) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testCreate_5()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Bed info = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    Identifier result = fixture.create(info);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Identifier create(Bed) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testCreate_6()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Bed info = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    Identifier result = fixture.create(info);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Identifier create(Bed) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testCreate_7()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Bed info = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    Identifier result = fixture.create(info);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Identifier create(Bed) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testCreate_8()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Bed info = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    Identifier result = fixture.create(info);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the void delete(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testDelete_1()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Identifier id = new Identifier("");

    fixture.delete(id);

    // add additional test code here
  }

  /**
   * Run the Bed get(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testGet_1()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Identifier id = new Identifier("");

    Bed result = fixture.get(id);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Bed get(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testGet_2()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Identifier id = new Identifier("");

    Bed result = fixture.get(id);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Bed get(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testGet_3()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Identifier id = new Identifier("");

    Bed result = fixture.get(id);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Bed get(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testGet_4()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Identifier id = new Identifier("");

    Bed result = fixture.get(id);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Beds getInstance() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetInstance_1()
    throws Exception {

    Beds result = Beds.getInstance();

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the boolean isBedAvailable(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testIsBedAvailable_1()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Identifier bedId = new Identifier("");
    Date from = new Date();
    Date to = new Date();

    boolean result = fixture.isBedAvailable(bedId, from, to, false);

    // add additional test code here
    assertTrue(result);
  }

  /**
   * Run the boolean isBedAvailable(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIsBedAvailable_2()
    throws Exception {
    Beds beds = Beds.getInstance();
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);
        
    Bed bedInfo = new Bed();
    bedInfo.setNumber(1);
    bedInfo.setRoomNo(1);
    ArrayList<Tariff> bedTariff = new ArrayList<Tariff> ();
    bedTariff.add(new Tariff(10, new Date(), null));
    bedInfo.setTariff(bedTariff);
    bedInfo.setHostelId(hostelId);
    Identifier bedId = Beds.getInstance().create(bedInfo);
    Hostels.getInstance().addBed(hostelId, bedId);

    boolean result = Beds.getInstance().isBedAvailable(
                  bedId, new Date(), GenericUtility.addDaysToDate(new Date(), 1), false);

    // add additional test code here
    assertTrue(result);
  }


  @Test
  public void testIsBedAvailable_3()
    throws Exception {
    
    Date date = new Date();
    
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = Users.getInstance().create(userInfo);
        
    Beds beds = Beds.getInstance();
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);
        
    Bed bedInfo1 = new Bed();
    bedInfo1.setNumber(1);
    bedInfo1.setRoomNo(1);
    ArrayList<Tariff> bedTariff1 = new ArrayList<Tariff> ();
    bedTariff1.add(new Tariff(10, date, null));
    bedInfo1.setTariff(bedTariff1);
    bedInfo1.setHostelId(hostelId);
    Identifier bedId1 = Beds.getInstance().create(bedInfo1);
    Hostels.getInstance().addBed(hostelId, bedId1);
    
    Bed bedInfo2 = new Bed();
    bedInfo2.setNumber(1);
    bedInfo2.setRoomNo(2);
    ArrayList<Tariff> bedTariff2 = new ArrayList<Tariff> ();
    bedTariff2.add(new Tariff(10, GenericUtility.addDaysToDate(date, 1), null));
    bedInfo2.setTariff(bedTariff2);
    bedInfo2.setHostelId(hostelId);
    Identifier bedId2 = Beds.getInstance().create(bedInfo2);
    Hostels.getInstance().addBed(hostelId, bedId2);

    boolean result = Beds.getInstance().isBedAvailable(
                  bedId2, date, GenericUtility.addDaysToDate(date, 1), false);

    // add additional test code here
    assertFalse(result);
    
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(date);
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, date, GenericUtility.addDaysToDate(date, 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId1);
    info.setBedIds(bedIds);
    
    Bookings.getInstance().create(info);
    
    result = Beds.getInstance().isBedAvailable(
        bedId1, date, GenericUtility.addDaysToDate(date, 1), false);

    // add additional test code here
    assertFalse(result);
  }

  /**
   * Run the boolean isBedAvailable(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testIsBedAvailable_4()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Identifier bedId = new Identifier("");
    Date from = new Date();
    Date to = new Date();

    boolean result = fixture.isBedAvailable(bedId, from, to, false);

    // add additional test code here
    assertTrue(result);
  }

  /**
   * Run the boolean isBedAvailable(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testIsBedAvailable_5()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Identifier bedId = new Identifier("");
    Date from = new Date();
    Date to = new Date();

    boolean result = fixture.isBedAvailable(bedId, from, to, false);

    // add additional test code here
    assertTrue(result);
  }

  /**
   * Run the boolean isBedAvailable(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testIsBedAvailable_6()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Identifier bedId = new Identifier("");
    Date from = new Date();
    Date to = new Date();

    boolean result = fixture.isBedAvailable(bedId, from, to, false);

    // add additional test code here
    assertTrue(result);
  }

  /**
   * Run the ArrayList<Identifier> search(Bed) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSearch_1()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Bed info = new Bed();

    ArrayList<Identifier> result = fixture.search(info);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }


  @Test
  public void testSortBasedOnPrice_1()
    throws Exception {
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = Users.getInstance().create(userInfo);
    
    Beds beds = Beds.getInstance();
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);
        
    Bed bedInfo1 = new Bed();
    bedInfo1.setNumber(1);
    bedInfo1.setRoomNo(1);
    ArrayList<Tariff> bedTariff1 = new ArrayList<Tariff> ();
    bedTariff1.add(new Tariff(20, new Date(), null));
    bedInfo1.setTariff(bedTariff1);
    bedInfo1.setHostelId(hostelId);
    Identifier bedId1 = Beds.getInstance().create(bedInfo1);
    
    Bed bedInfo2 = new Bed();
    bedInfo2.setNumber(1);
    bedInfo2.setRoomNo(2);
    ArrayList<Tariff> bedTariff2 = new ArrayList<Tariff> ();
    bedTariff2.add(new Tariff(10, GenericUtility.addDaysToDate(new Date(), 1), null));
    bedInfo2.setTariff(bedTariff2);
    bedInfo2.setHostelId(hostelId);
    Identifier bedId2 = Beds.getInstance().create(bedInfo2);
    
    Date start = GenericUtility.addDaysToDate(new Date(), 1);
    Date end = GenericUtility.addDaysToDate(new Date(), 2);
    ArrayList<Identifier> bedIds = Hostels.getInstance().getFreeBeds(hostelId,
                          start, end);
    bedIds = Beds.getInstance().sortBasedOnPrice(bedIds,
        start, end);
    assertTrue(bedIds.get(0).equals(bedId2));
  }

  /**
   * Run the ArrayList<Identifier> sortBasedOnPrice(ArrayList<Identifier>,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSortBasedOnPrice_2()
    throws Exception {
    Beds fixture = Beds.getInstance();
    ArrayList<Identifier> unsortedBeds = new ArrayList();
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.sortBasedOnPrice(unsortedBeds, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Identifier> sortBasedOnPrice(ArrayList<Identifier>,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSortBasedOnPrice_3()
    throws Exception {
    Beds fixture = Beds.getInstance();
    ArrayList<Identifier> unsortedBeds = new ArrayList();
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.sortBasedOnPrice(unsortedBeds, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Identifier> sortBasedOnPrice(ArrayList<Identifier>,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSortBasedOnPrice_4()
    throws Exception {
    Beds fixture = Beds.getInstance();
    ArrayList<Identifier> unsortedBeds = new ArrayList();
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.sortBasedOnPrice(unsortedBeds, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Identifier> sortBasedOnPrice(ArrayList<Identifier>,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSortBasedOnPrice_5()
    throws Exception {
    Beds fixture = Beds.getInstance();
    ArrayList<Identifier> unsortedBeds = new ArrayList();
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.sortBasedOnPrice(unsortedBeds, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Identifier> sortBasedOnPrice(ArrayList<Identifier>,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSortBasedOnPrice_6()
    throws Exception {
    Beds fixture = Beds.getInstance();
    ArrayList<Identifier> unsortedBeds = new ArrayList();
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.sortBasedOnPrice(unsortedBeds, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Identifier> sortBasedOnPrice(ArrayList<Identifier>,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSortBasedOnPrice_7()
    throws Exception {
    Beds fixture = Beds.getInstance();
    ArrayList<Identifier> unsortedBeds = new ArrayList();
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.sortBasedOnPrice(unsortedBeds, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Identifier> sortBasedOnPrice(ArrayList<Identifier>,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSortBasedOnPrice_8()
    throws Exception {
    Beds fixture = Beds.getInstance();
    ArrayList<Identifier> unsortedBeds = new ArrayList();
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.sortBasedOnPrice(unsortedBeds, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Identifier> sortBasedOnPrice(ArrayList<Identifier>,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSortBasedOnPrice_9()
    throws Exception {
    Beds fixture = Beds.getInstance();
    ArrayList<Identifier> unsortedBeds = new ArrayList();
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.sortBasedOnPrice(unsortedBeds, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Identifier> sortBasedOnPrice(ArrayList<Identifier>,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSortBasedOnPrice_10()
    throws Exception {
    Beds fixture = Beds.getInstance();
    ArrayList<Identifier> unsortedBeds = new ArrayList();
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.sortBasedOnPrice(unsortedBeds, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the void update(Identifier,Bed) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testUpdate_1()
    throws Exception {
    Beds fixture = Beds.getInstance();
    Identifier id = new Identifier("");
    Bed info = new Bed();

    fixture.update(id, info);

    // add additional test code here
  }

  /**
   * Perform pre-test initialization.
   *
   * @throws Exception
   *         if the initialization fails for some reason
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Before
  public void setUp()
    throws Exception {
    // add additional set up code here
    DataBaseFactory.ClearDataBase();
  }

  /**
   * Perform post-test clean-up.
   *
   * @throws Exception
   *         if the clean-up fails for some reason
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @After
  public void tearDown()
    throws Exception {
    // Add additional tear down code here
    DataBaseFactory.ClearDataBase();
  }

  /**
   * Launch the test.
   *
   * @param args the command line arguments
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(BedsUnitTest.class);
  }
}