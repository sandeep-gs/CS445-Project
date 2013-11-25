package hostel.unittest;

import java.util.ArrayList;
import java.util.Date;

import hostel.core.Identifier;
import hostel.collection.Beds;
import hostel.collection.Bookings;
import hostel.collection.Hostels;
import hostel.collection.Users;
import hostel.exception.IdentifierNotFoundException;
import hostel.core.Bed;
import hostel.core.Booking;
import hostel.core.Booking.BookingStatus;
import hostel.core.Contact;
import hostel.core.DataBaseFactory;
import hostel.core.Hostel;
import hostel.core.Policy;
import hostel.core.Tariff;
import hostel.core.User;
import hostel.exception.InvalidParameterException;
import hostel.utility.GenericUtility;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>BookingsUnitTest</code> contains tests for the class <code>{@link Bookings}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:40 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class BookingsUnitTest
{
  /**
   * Run the void cancel(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testCancel_1()
    throws Exception {
    Bookings fixture = Bookings.getInstance();
    Identifier bookingId = new Identifier("");

    fixture.cancel(bookingId);

    // add additional test code here
  }

  /**
   * Run the void cancel(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testCancel_2()
    throws Exception {
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = Users.getInstance().create(userInfo);
    
    Policy policy = new Policy();
    policy.setAlcoholPolicy("N");
    policy.setSmokingPolicy("N");
    policy.setCancellationDeadLine(48);
    policy.setCancellationPenalty(50);
    policy.setCheckInTime("12:00");
    policy.setCheckOutTime("12:00");
    
    Beds beds = Beds.getInstance();
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    hostelInfo.setPolicy(policy);
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);
        
    Bed bedInfo1 = new Bed();
    bedInfo1.setNumber(1);
    bedInfo1.setRoomNo(1);
    ArrayList<Tariff> bedTariff1 = new ArrayList<Tariff> ();
    bedTariff1.add(new Tariff(10, new Date(), null));
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

   
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId1);
    info.setBedIds(bedIds);
    
    Identifier bookingId = Bookings.getInstance().create(info);
    
    Bookings.getInstance().cancel(bookingId);
    Booking cancelledBooking = Bookings.getInstance().get(bookingId);
    assertEquals(cancelledBooking.getStatus(), BookingStatus.CANCELLED);
    assertEquals(cancelledBooking.getBedReservations().get(0).getPrice(), new Integer(5));

    // add additional test code here
  }

  /**
   * Run the Identifier create(Booking) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testCreate_1()
    throws Exception {
    Bookings fixture = Bookings.getInstance();
    Booking info = null;

    Identifier result = fixture.create(info);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Identifier create(Booking) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testCreate_2()
    throws Exception {
    Bookings fixture = Bookings.getInstance();
    Booking info = new Booking(new Identifier(""), new Identifier(""), (ArrayList<Identifier>) null, new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    Identifier result = fixture.create(info);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the void delete(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testDelete_1()
    throws Exception {
    Bookings fixture = Bookings.getInstance();
    Identifier id = new Identifier("");

    fixture.delete(id);

    // add additional test code here
  }

  /**
   * Run the Booking get(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testGet_1()
    throws Exception {
    Bookings fixture = Bookings.getInstance();
    Identifier id = new Identifier("");

    Booking result = fixture.get(id);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Bookings getInstance() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetInstance_1()
    throws Exception {

    Bookings result = Bookings.getInstance();

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the ArrayList<Identifier> search(Booking) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSearch_1()
    throws Exception {
    Bookings fixture = Bookings.getInstance();
    Booking info = new Booking();

    ArrayList<Identifier> result = fixture.search(info);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Identifier> searchInDateRange(Booking) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSearchInDateRange_1()
    throws Exception {
    Bookings fixture = Bookings.getInstance();
    Booking info = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    ArrayList<Identifier> result = fixture.searchInDateRange(info);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Identifier> searchInDateRange(Booking) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSearchInDateRange_2()
    throws Exception {
    Date date = new Date();
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = Users.getInstance().create(userInfo);
    
    Policy policy = new Policy();
    policy.setAlcoholPolicy("N");
    policy.setSmokingPolicy("N");
    policy.setCancellationDeadLine(48);
    policy.setCancellationPenalty(50);
    policy.setCheckInTime("12:00");
    policy.setCheckOutTime("12:00");
    
    Beds beds = Beds.getInstance();
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    hostelInfo.setPolicy(policy);
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);
        
    Bed bedInfo1 = new Bed();
    bedInfo1.setNumber(1);
    bedInfo1.setRoomNo(1);
    ArrayList<Tariff> bedTariff1 = new ArrayList<Tariff> ();
    bedTariff1.add(new Tariff(10, date, null));
    bedInfo1.setTariff(bedTariff1);
    bedInfo1.setHostelId(hostelId);
    Identifier bedId1 = Beds.getInstance().create(bedInfo1);
    
    Bed bedInfo2 = new Bed();
    bedInfo2.setNumber(1);
    bedInfo2.setRoomNo(2);
    ArrayList<Tariff> bedTariff2 = new ArrayList<Tariff> ();
    bedTariff2.add(new Tariff(10, GenericUtility.addDaysToDate(date, 1), null));
    bedInfo2.setTariff(bedTariff2);
    bedInfo2.setHostelId(hostelId);
    Identifier bedId2 = Beds.getInstance().create(bedInfo2);

   
    Booking info1 = new Booking();
    info1.setHostelId(hostelId);
    info1.setStatus(Booking.BookingStatus.RESERVED);
    info1.setBookingDate(date);
    info1.setUserId(userId);
    ArrayList<Tariff> bedReservations1 = new ArrayList<Tariff>();
    bedReservations1.add(new Tariff(10, date, GenericUtility.addDaysToDate(date, 2)));
    info1.setBedReservations(bedReservations1);
    ArrayList<Identifier> bedIds1 = new ArrayList<Identifier>();
    bedIds1.add(bedId1);
    info1.setBedIds(bedIds1);
    
    Identifier bookingId1 = Bookings.getInstance().create(info1);
    
    
    Booking info2 = new Booking();
    info2.setHostelId(hostelId);
    info2.setStatus(Booking.BookingStatus.RESERVED);
    info2.setBookingDate(date);
    info2.setUserId(userId);
    ArrayList<Tariff> bedReservations2 = new ArrayList<Tariff>();
    bedReservations2.add(new Tariff(10, GenericUtility.addDaysToDate(date, 2),
                                        GenericUtility.addDaysToDate(date, 4)));
    info2.setBedReservations(bedReservations2);
    ArrayList<Identifier> bedIds2 = new ArrayList<Identifier>();
    bedIds2.add(bedId2);
    info2.setBedIds(bedIds2);
    
    Identifier bookingId2 = Bookings.getInstance().create(info2);
    
    Booking info3 = new Booking();
    ArrayList<Tariff> bedReservations3 = new ArrayList<Tariff>();
    bedReservations3.add(new Tariff(10, GenericUtility.addDaysToDate(date, -1),
                                        GenericUtility.addDaysToDate(date, 5)));
    info3.setBedReservations(bedReservations3);
    ArrayList<Identifier> ids = Bookings.getInstance().searchInDateRange(info3);
    assertEquals(2, ids.size());
    
    bedReservations3.remove(0);
    bedReservations3.add(new Tariff(10, GenericUtility.addDaysToDate(date, -15),
        GenericUtility.addDaysToDate(date, -10)));
    info3.setBedReservations(bedReservations3);
    ids = Bookings.getInstance().searchInDateRange(info3);
    assertEquals(0, ids.size());
    
    bedReservations3.remove(0);
    bedReservations3.add(new Tariff(10, GenericUtility.addDaysToDate(date, 10),
        GenericUtility.addDaysToDate(date, 15)));
    info3.setBedReservations(bedReservations3);
    ids = Bookings.getInstance().searchInDateRange(info3);
    assertEquals(0, ids.size());
    
    bedReservations3.remove(0);
    bedReservations3.add(new Tariff(10, GenericUtility.addDaysToDate(date, 1),
        GenericUtility.addDaysToDate(date, 3)));
    info3.setBedReservations(bedReservations3);
    ids = Bookings.getInstance().searchInDateRange(info3);
    assertEquals(2, ids.size());
    
    bedReservations3.remove(0);
    bedReservations3.add(new Tariff(10, GenericUtility.addDaysToDate(date, 1),
        GenericUtility.addDaysToDate(date, 2)));
    info3.setBedReservations(bedReservations3);
    ids = Bookings.getInstance().searchInDateRange(info3);
    assertEquals(1, ids.size());
    
    bedReservations3.remove(0);
    bedReservations3.add(new Tariff(10, GenericUtility.addDaysToDate(date, 2),
        GenericUtility.addDaysToDate(date, 3)));
    info3.setBedReservations(bedReservations3);
    ids = Bookings.getInstance().searchInDateRange(info3);
    assertEquals(1, ids.size());
    
    bedReservations3.remove(0);
    bedReservations3.add(new Tariff(10, GenericUtility.addDaysToDate(date, 3),
        GenericUtility.addDaysToDate(date, 4)));
    info3.setBedReservations(bedReservations3);
    ids = Bookings.getInstance().searchInDateRange(info3);
    assertEquals(1, ids.size());
    
  }

  /**
   * Run the void update(Identifier,Booking) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testUpdate_1()
    throws Exception {
    Bookings fixture = Bookings.getInstance();
    Identifier id = new Identifier("");
    Booking info = new Booking();

    fixture.update(id, info);

    // add additional test code here
  }

  @Test
  public void testUpdate_2()
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
    bedTariff1.add(new Tariff(10, new Date(), null));
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

   
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId1);
    info.setBedIds(bedIds);
    
    Identifier bookingId = Bookings.getInstance().create(info);
    info.setStatus(Booking.BookingStatus.CLOSED);
    
    Bookings.getInstance().update(bookingId, info);
    assertTrue(true);
  }
  
  @Test
  public void testDelete_2()
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
    bedTariff1.add(new Tariff(10, new Date(), null));
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

   
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(new Date());
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(10, new Date(), GenericUtility.addDaysToDate(new Date(), 1)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId1);
    info.setBedIds(bedIds);
    
    Identifier bookingId = Bookings.getInstance().create(info);
    info.setStatus(Booking.BookingStatus.CLOSED);
    
    Bookings.getInstance().delete(bookingId);
    assertTrue(true);
  }
  
  
  /**
   * Perform pre-test initialization.
   *
   * @throws Exception
   *         if the initialization fails for some reason
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Before
  public void setUp()
    throws Exception {
    // add additional set up code here
    DataBaseFactory.getDataBase().clear();
  }

  /**
   * Perform post-test clean-up.
   *
   * @throws Exception
   *         if the clean-up fails for some reason
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @After
  public void tearDown()
    throws Exception {
    // Add additional tear down code here
    DataBaseFactory.getDataBase().clear();
  }

  /**
   * Launch the test.
   *
   * @param args the command line arguments
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(BookingsUnitTest.class);
  }
}