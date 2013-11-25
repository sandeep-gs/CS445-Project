package hostel.unittest;

import java.util.ArrayList;
import java.util.Date;
import hostel.core.Identifier;
import hostel.core.Tariff;
import hostel.core.Bed;
import hostel.core.InformationObject;
import hostel.core.Address;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BedUnitTest</code> contains tests for the class <code>{@link Bed}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:41 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class BedUnitTest
{
  /**
   * Run the Bed() constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testBed_1()
    throws Exception {

    Bed result = new Bed();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getHostelId());
    assertEquals(null, result.getTariff());
    assertEquals(null, result.getRoomNo());
    assertEquals("Bed Details : \nNumber = null\nRoom No = null\nHostel Id = null\nBed Tariffs = null\n", result.toString());
    assertEquals(null, result.getNumber());
  }

  /**
   * Run the Bed(Bed) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testBed_2()
    throws Exception {
    Bed bedInfo = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    Bed result = new Bed(bedInfo);

    // add additional test code here
    assertNotNull(result);
    assertEquals(new Integer(1), result.getRoomNo());
    assertEquals("Bed Details : \nNumber = 1\nRoom No = 1\nHostel Id = \nBed Tariffs = []\n", result.toString());
    assertEquals(new Integer(1), result.getNumber());
  }

  /**
   * Run the Bed(Integer,Integer,Identifier,ArrayList<Tariff>) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testBed_3()
    throws Exception {
    Integer number = new Integer(1);
    Integer roomNo = new Integer(1);
    Identifier hostelId = new Identifier("");
    ArrayList<Tariff> bedTariff = new ArrayList();

    Bed result = new Bed(number, roomNo, hostelId, bedTariff);

    // add additional test code here
    assertNotNull(result);
    assertEquals(new Integer(1), result.getRoomNo());
    assertEquals("Bed Details : \nNumber = 1\nRoom No = 1\nHostel Id = \nBed Tariffs = []\n", result.toString());
    assertEquals(new Integer(1), result.getNumber());
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
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Object obj = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

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
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
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
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
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
  public void testEquals_4()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Object obj = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

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
  public void testEquals_5()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Object obj = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

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
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Object obj = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

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
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Object obj = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

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
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Object obj = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

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
  public void testEquals_9()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), (Integer) null, new Identifier(""), new ArrayList());
    Object obj = new Bed(new Integer(1), (Integer) null, new Identifier(""), new ArrayList());

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
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
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    Identifier result = fixture.getHostelId();

    // add additional test code here
    assertNotNull(result);
    assertEquals(new Integer(0), result.getIntegerKey());
    assertEquals("", result.toString());
    assertEquals("", result.getKey());
  }

  /**
   * Run the Integer getNumber() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetNumber_1()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    Integer result = fixture.getNumber();

    // add additional test code here
    assertNotNull(result);
    assertEquals("1", result.toString());
    assertEquals((byte) 1, result.byteValue());
    assertEquals((short) 1, result.shortValue());
    assertEquals(1, result.intValue());
    assertEquals(1L, result.longValue());
    assertEquals(1.0f, result.floatValue(), 1.0f);
    assertEquals(1.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getRoomNo() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetRoomNo_1()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    Integer result = fixture.getRoomNo();

    // add additional test code here
    assertNotNull(result);
    assertEquals("1", result.toString());
    assertEquals((byte) 1, result.byteValue());
    assertEquals((short) 1, result.shortValue());
    assertEquals(1, result.intValue());
    assertEquals(1L, result.longValue());
    assertEquals(1.0f, result.floatValue(), 1.0f);
    assertEquals(1.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the ArrayList<Tariff> getTariff() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariff_1()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    ArrayList<Tariff> result = fixture.getTariff();

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the Tariff getTariffForDate(Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariffForDate_1()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Date date = new Date();

    Tariff result = fixture.getTariffForDate(date);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Tariff getTariffForDate(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariffForDate_2()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Date start = new Date();
    Date end = new Date();

    Tariff result = fixture.getTariffForDate(start, end);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Tariff getTariffForDate(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariffForDate_3()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Date start = new Date();
    Date end = new Date();

    Tariff result = fixture.getTariffForDate(start, end);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Tariff getTariffForDate(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariffForDate_4()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Date start = new Date();
    Date end = new Date();

    Tariff result = fixture.getTariffForDate(start, end);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Tariff getTariffForDate(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariffForDate_5()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Date start = new Date();
    Date end = new Date();

    Tariff result = fixture.getTariffForDate(start, end);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Tariff getTariffForDate(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariffForDate_6()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Date start = new Date();
    Date end = new Date();

    Tariff result = fixture.getTariffForDate(start, end);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Tariff getTariffForDate(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariffForDate_7()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Date start = new Date();
    Date end = new Date();

    Tariff result = fixture.getTariffForDate(start, end);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Tariff getTariffForDate(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariffForDate_8()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Date start = new Date();
    Date end = new Date();

    Tariff result = fixture.getTariffForDate(start, end);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Tariff getTariffForDate(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariffForDate_9()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Date start = new Date();
    Date end = new Date();

    Tariff result = fixture.getTariffForDate(start, end);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Tariff getTariffForDate(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetTariffForDate_10()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Date start = new Date();
    Date end = new Date();

    Tariff result = fixture.getTariffForDate(start, end);

    // add additional test code here
    assertEquals(null, result);
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
    Bed fixture = new Bed(new Integer(1), new Integer(1), (Identifier) null, (ArrayList<Tariff>) null);

    int result = fixture.hashCode();

    // add additional test code here
    assertEquals(923553, result);
  }

  /**
   * Run the int hashCode() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testHashCode_2()
    throws Exception {
    Bed fixture = new Bed((Integer) null, (Integer) null, new Identifier(""), new ArrayList());

    int result = fixture.hashCode();

    // add additional test code here
    assertEquals(983103, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testMatch_1()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    InformationObject objectInfo = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testMatch_2()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    InformationObject objectInfo = null;

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(false, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testMatch_3()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    InformationObject objectInfo = new Address();

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(false, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testMatch_4()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), (ArrayList<Tariff>) null);
    InformationObject objectInfo = new Bed(new Integer(1), new Integer(1), new Identifier(""), (ArrayList<Tariff>) null);

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testMatch_5()
    throws Exception {
    Bed fixture = new Bed((Integer) null, (Integer) null, new Identifier(""), (ArrayList<Tariff>) null);
    InformationObject objectInfo = new Bed((Integer) null, (Integer) null, new Identifier(""), (ArrayList<Tariff>) null);

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
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
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Identifier hostelId = new Identifier("");

    fixture.setHostelId(hostelId);

    // add additional test code here
  }

  /**
   * Run the void setNumber(Integer) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetNumber_1()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Integer number = new Integer(1);

    fixture.setNumber(number);

    // add additional test code here
  }

  /**
   * Run the void setRoomNo(Integer) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetRoomNo_1()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    Integer roomNo = new Integer(1);

    fixture.setRoomNo(roomNo);

    // add additional test code here
  }

  /**
   * Run the void setTariff(ArrayList<Tariff>) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetTariff_1()
    throws Exception {
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());
    ArrayList<Tariff> bedTariff = new ArrayList();

    fixture.setTariff(bedTariff);

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
    Bed fixture = new Bed(new Integer(1), new Integer(1), new Identifier(""), new ArrayList());

    String result = fixture.toString();

    // add additional test code here
    assertEquals("Bed Details : \nNumber = 1\nRoom No = 1\nHostel Id = \nBed Tariffs = []\n", result);
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
    new org.junit.runner.JUnitCore().run(BedUnitTest.class);
  }
}