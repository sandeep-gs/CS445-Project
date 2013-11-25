package hostel.unittest;

import java.text.DateFormat;
import hostel.core.Booking;
import java.util.ArrayList;
import java.util.Date;
import hostel.core.Identifier;
import hostel.core.Tariff;
import hostel.core.InformationObject;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BookingUnitTest</code> contains tests for the class <code>{@link Booking}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:41 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class BookingUnitTest
{
  /**
   * Run the Booking() constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testBooking_1()
    throws Exception {

    Booking result = new Booking();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getBedReservations());
    assertEquals(null, result.getBookingDate());
    assertEquals(null, result.getBedIds());
    assertEquals(null, result.getHostelId());
    assertEquals("Booking Details : \nUser Id = null\nHostel Id = null\nBooked Bed Ids = null\nTariff for the beds = null\nBooking Date = null\nStatus = UNKNOWN\n", result.toString());
    assertEquals(null, result.getUserId());
  }

  /**
   * Run the Booking(Booking) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testBooking_2()
    throws Exception {
    Booking bookingInfo = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    Booking result = new Booking(bookingInfo);

    // add additional test code here
    assertNotNull(result);
    assertEquals(bookingInfo.toString(), result.toString());
  }

  /**
   * Run the Booking(Identifier,Identifier,ArrayList<Identifier>,ArrayList<Tariff>,Date,BookingStatus) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testBooking_4()
    throws Exception {
    Identifier userId = new Identifier("");
    Identifier hostelId = new Identifier("");
    ArrayList<Identifier> bedIds = new ArrayList();
    ArrayList<Tariff> bedReservations = new ArrayList();
    Date bookingDate = new Date();
    hostel.core.Booking.BookingStatus status = hostel.core.Booking.BookingStatus.CANCELLED;

    Booking result1 = new Booking(userId, hostelId, bedIds, bedReservations, bookingDate, status);
    Booking result2 = new Booking(userId, hostelId, bedIds, bedReservations, bookingDate, status);

    // add additional test code here
    assertEquals(result1.toString(), result2.toString());
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testEquals_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Object obj = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testEquals_2()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Object obj = null;

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(false, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testEquals_3()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Object obj = new Object();

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(false, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testEquals_5()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Object obj = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testEquals_6()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Object obj = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testEquals_7()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Object obj = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testEquals_8()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Object obj = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testEquals_10()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Object obj = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testEquals_11()
    throws Exception {
    Booking fixture = new Booking((Identifier) null, new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Object obj = new Booking((Identifier) null, new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the ArrayList<Identifier> getBedIds() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetBedIds_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    ArrayList<Identifier> result = fixture.getBedIds();

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the ArrayList<Tariff> getBedReservations() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetBedReservations_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    ArrayList<Tariff> result = fixture.getBedReservations();

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the Date getBookingDate() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetBookingDate_1()
    throws Exception {
    Date date = new Date();
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), date, hostel.core.Booking.BookingStatus.CANCELLED);

    Date result = fixture.getBookingDate();

    // add additional test code here
    assertNotNull(result);
    assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
    assertEquals(date.getTime(), result.getTime());
  }

  /**
   * Run the Identifier getHostelId() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetHostelId_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    Identifier result = fixture.getHostelId();

    // add additional test code here
    assertNotNull(result);
    assertEquals(new Integer(0), result.getIntegerKey());
    assertEquals("", result.toString());
    assertEquals("", result.getKey());
  }

  /**
   * Run the hostel.core.Booking.BookingStatus getStatus() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetStatus_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    hostel.core.Booking.BookingStatus result = fixture.getStatus();

    // add additional test code here
    assertNotNull(result);
    assertEquals("CANCELLED", result.name());
    assertEquals("CANCELLED", result.toString());
    assertEquals(1, result.ordinal());
  }

  /**
   * Run the Identifier getUserId() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetUserId_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    Identifier result = fixture.getUserId();

    // add additional test code here
    assertNotNull(result);
    assertEquals(new Integer(0), result.getIntegerKey());
    assertEquals("", result.toString());
    assertEquals("", result.getKey());
  }

  /**
   * Run the int hashCode() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testHashCode_1()
    throws Exception {
    Booking fixture1 = new Booking(new Identifier(""), new Identifier(""), (ArrayList<Identifier>) null, (ArrayList<Tariff>) null, (Date) null, hostel.core.Booking.BookingStatus.CANCELLED);
    Booking fixture2 = new Booking(new Identifier(""), new Identifier(""), (ArrayList<Identifier>) null, (ArrayList<Tariff>) null, (Date) null, hostel.core.Booking.BookingStatus.CANCELLED);

    // add additional test code here
    assertEquals(fixture1.hashCode(), fixture2.hashCode());
  }

  /**
   * Run the void setBedIds(ArrayList<Identifier>) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetBedIds_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    ArrayList<Identifier> bedIds = new ArrayList();

    fixture.setBedIds(bedIds);

    // add additional test code here
  }

  /**
   * Run the void setBedReservations(ArrayList<Tariff>) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetBedReservations_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    ArrayList<Tariff> bedReservations = new ArrayList();

    fixture.setBedReservations(bedReservations);

    // add additional test code here
  }

  /**
   * Run the void setBookingDate(Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetBookingDate_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Date bookingDate = new Date();

    fixture.setBookingDate(bookingDate);

    // add additional test code here
  }

  /**
   * Run the void setHostelId(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetHostelId_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Identifier hostelId = new Identifier("");

    fixture.setHostelId(hostelId);

    // add additional test code here
  }

  /**
   * Run the void setStatus(BookingStatus) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetStatus_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    hostel.core.Booking.BookingStatus status = hostel.core.Booking.BookingStatus.CANCELLED;

    fixture.setStatus(status);

    // add additional test code here
  }

  /**
   * Run the void setUserId(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetUserId_1()
    throws Exception {
    Booking fixture = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Identifier userId = new Identifier("");

    fixture.setUserId(userId);

    // add additional test code here
  }

  /**
   * Run the String toString() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testToString_1()
    throws Exception {
    Booking fixture1 = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);
    Booking fixture2 = new Booking(new Identifier(""), new Identifier(""), new ArrayList(), new ArrayList(), new Date(), hostel.core.Booking.BookingStatus.CANCELLED);

    // add additional test code here
    assertEquals(fixture1.toString(), fixture2.toString());
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
  }

  /**
   * Launch the test.
   *
   * @param args the command line arguments
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(BookingUnitTest.class);
  }
}