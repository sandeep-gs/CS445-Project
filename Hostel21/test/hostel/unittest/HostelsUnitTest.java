package hostel.unittest;

import java.util.ArrayList;
import java.util.Date;

import hostel.core.Bed;
import hostel.core.Booking;
import hostel.core.Contact;
import hostel.core.DataBaseFactory;
import hostel.core.Hostel;
import hostel.core.Policy;
import hostel.core.Tariff;
import hostel.core.User;
import hostel.collection.Beds;
import hostel.collection.Bookings;
import hostel.collection.Hostels;
import hostel.collection.Users;
import hostel.core.Identifier;
import hostel.exception.IdentifierNotFoundException;
import hostel.exception.InvalidIdentifierException;
import hostel.exception.InvalidParameterException;
import hostel.exception.DataBaseReadWriteException;
import hostel.utility.GenericUtility;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>HostelsUnitTest</code> contains tests for the class <code>{@link Hostels}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:41 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class HostelsUnitTest
{
  /**
   * Run the void addBed(Identifier,Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testAddBed_1()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Identifier bedId = new Identifier("");

    fixture.addBed(hostelId, bedId);

    // add additional test code here
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
    Hostels fixture = Hostels.getInstance();
    Identifier id = new Identifier("");

    fixture.delete(id);

    // add additional test code here
  }

  /**
   * Run the void delete(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testDelete_2()
    throws Exception {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);
    hostelInfo.setContact(new Contact());
    Hostels.getInstance().delete(hostelId);
    Hostels.getInstance().get(hostelId);
  }

  @Test(expected = hostel.exception.InvalidParameterException.class)
  public void testDelete_3()
    throws Exception {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    hostelInfo.setContact(new Contact());
    ArrayList<Identifier> beds  = new ArrayList<Identifier>();
    beds.add(new Identifier("bed1"));
    hostelInfo.setBeds(beds);
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);

    
    Hostels.getInstance().delete(hostelId);
  }
  
  /**
   * Run the Hostel get(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testGet_1()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier id = new Identifier("");

    Hostel result = fixture.get(id);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Hostels getInstance() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetInstance_1()
    throws Exception {

    Hostels result = Hostels.getInstance();

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Double getOccupancy(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testGetOccupancy_1()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("aaa");
    Date from = new Date();
    Date to = new Date();

    Double result = fixture.getOccupancy(hostelId, from, to);

    // add additional test code here
    assertNotNull(result);
  }

  @Test
  public void testGetOccupancy_2()
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
    
    
    
    Double occupancy = Hostels.getInstance().getOccupancy(hostelId,
                         GenericUtility.addDaysToDate(date, 1),
                         GenericUtility.addDaysToDate(date, 5));
    assertEquals(occupancy, new Double(37.5));
    
    occupancy = Hostels.getInstance().getOccupancy(hostelId,
        GenericUtility.addDaysToDate(date, -15),
        GenericUtility.addDaysToDate(date, -10));
    assertEquals(occupancy, new Double(0));
    
    occupancy = Hostels.getInstance().getOccupancy(hostelId,
        GenericUtility.addDaysToDate(date, 10),
        GenericUtility.addDaysToDate(date, 15));
    assertEquals(occupancy, new Double(0));
    
    occupancy = Hostels.getInstance().getOccupancy(hostelId,
        GenericUtility.addDaysToDate(date, 2),
        GenericUtility.addDaysToDate(date, 4));
    assertEquals(occupancy, new Double(50.0));
    
    
    // null hostel Id
    occupancy = Hostels.getInstance().getOccupancy(null,
            GenericUtility.addDaysToDate(date, 1),
            GenericUtility.addDaysToDate(date, 5));
    assertEquals(occupancy, new Double(37.5));
  }
  
   /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_1()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_2()
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

   
    Booking info = new Booking();
    info.setHostelId(hostelId);
    info.setStatus(Booking.BookingStatus.RESERVED);
    info.setBookingDate(date);
    info.setUserId(userId);
    ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
    bedReservations.add(new Tariff(20, GenericUtility.addDaysToDate(date, 1), GenericUtility.addDaysToDate(date, 3)));
    info.setBedReservations(bedReservations);
    ArrayList<Identifier> bedIds = new ArrayList<Identifier>();
    bedIds.add(bedId1);
    info.setBedIds(bedIds);
    
    Identifier bookingId = Bookings.getInstance().create(info);
    
    Integer revenue = Hostels.getInstance().getRevenue(hostelId, 
                                     GenericUtility.addDaysToDate(date, 1),
                                     GenericUtility.addDaysToDate(date, 3));
    
    assertEquals(new Integer(20), revenue);
    
    Bookings.getInstance().cancel(bookingId);
    revenue = Hostels.getInstance().getRevenue(hostelId, 
        GenericUtility.addDaysToDate(date, 1),
        GenericUtility.addDaysToDate(date, 3));

    assertEquals(new Integer(10), revenue);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_3()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_4()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_5()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_6()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_7()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_8()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_9()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_10()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_11()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_12()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_13()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRevenue(Identifier,Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRevenue_14()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date start = new Date();
    Date end = new Date();

    Integer result = fixture.getRevenue(hostelId, start, end);

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the void removeBed(Identifier,Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testRemoveBed_1()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Identifier bedId = new Identifier("");

    fixture.removeBed(hostelId, bedId);

    // add additional test code here
  }

  /**
   * Run the void update(Identifier,Hostel) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testUpdate_1()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier id = new Identifier("");
    Hostel info = new Hostel();

    fixture.update(id, info);

    // add additional test code here
  }

  @Test
  public void testUpdate_2()
    throws Exception {
    Hostel hostelInfo = new Hostel();
    hostelInfo.setName("test");
    Identifier hostelId = Hostels.getInstance().create(hostelInfo);
    hostelInfo.setContact(new Contact());
    Hostels.getInstance().update(hostelId, hostelInfo);
    assertTrue(true);
  }
  
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testGetFreeBeds_1()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = new Identifier("");
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.getFreeBeds(hostelId, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
  }

 
  @Test(expected = hostel.exception.InvalidIdentifierException.class)
  public void testGetFreeBeds_2()
    throws Exception {
    Hostels fixture = Hostels.getInstance();
    Identifier hostelId = null;
    Date checkIn = new Date();
    Date checkOut = new Date();

    ArrayList<Identifier> result = fixture.getFreeBeds(hostelId, checkIn, checkOut);

    // add additional test code here
    assertNotNull(result);
  }

  @Test
  public void testGetFreeBeds_3()
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
    
    ArrayList<Identifier> bedIds = Hostels.getInstance().getFreeBeds(hostelId,
                          GenericUtility.addDaysToDate(new Date(), 1),
                          GenericUtility.addDaysToDate(new Date(), 2));
    assertEquals(2, bedIds.size());
    
    bedIds = Hostels.getInstance().getFreeBeds(hostelId,
        GenericUtility.addDaysToDate(new Date(), -4),
        GenericUtility.addDaysToDate(new Date(), -2));
    assertEquals(0, bedIds.size());
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
    new org.junit.runner.JUnitCore().run(HostelsUnitTest.class);
  }
}