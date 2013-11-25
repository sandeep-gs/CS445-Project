package hostel.unittest;

import java.text.DateFormat;
import java.util.Date;
import org.junit.*;
import hostel.core.Tariff;
import hostel.core.InformationObject;
import hostel.core.Address;
import static org.junit.Assert.*;

/**
 * The class <code>TariffUnitTest</code> contains tests for the class <code>{@link Tariff}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:40 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class TariffUnitTest
{
  /**
   * Run the Tariff() constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testTariff_1()
    throws Exception {

    Tariff result = new Tariff();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getPrice());
    assertEquals("Tariff : \nPrice = null\nStart Date = null\nEnd Date = null\n", result.toString());
    assertEquals(null, result.getEndDate());
    assertEquals(null, result.getStartDate());
  }

  /**
   * Run the Tariff(Tariff) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testTariff_2()
    throws Exception {
    Tariff tariff = new Tariff(new Integer(1), new Date(), new Date());

    Tariff result = new Tariff(tariff);

    // add additional test code here
    assertNotNull(result);
    assertEquals(new Integer(1), result.getPrice());
    assertEquals(tariff.toString(), result.toString());
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testEquals_2()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), new Date(), new Date());
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
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testEquals_3()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), new Date(), new Date());
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
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testEquals_4()
    throws Exception {
    Date date = new Date();
    Tariff fixture = new Tariff(new Integer(1), date, date);
    Object obj = new Tariff(new Integer(1), date, date);

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testEquals_5()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), new Date(), new Date());
    Object obj = new Tariff(new Integer(1), new Date(), new Date());

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testEquals_6()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), new Date(), new Date());
    Object obj = new Tariff(new Integer(1), new Date(), new Date());

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testEquals_8()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), (Date) null, new Date());
    Object obj = new Tariff(new Integer(1), (Date) null, new Date());

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the Date getEndDate() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetEndDate_1()
    throws Exception {
    Date date = new Date();
    Tariff fixture = new Tariff(new Integer(1), date, date);

    Date result = fixture.getEndDate();

    // add additional test code here
    assertNotNull(result);
    assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
    assertEquals(date.getTime(), result.getTime());
  }

  /**
   * Run the Integer getPrice() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetPrice_1()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), new Date(), new Date());

    Integer result = fixture.getPrice();

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
   * Run the Date getStartDate() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetStartDate_1()
    throws Exception {
    Date date = new Date();
    Tariff fixture = new Tariff(new Integer(1), date, date);

    Date result = fixture.getStartDate();

    // add additional test code here
    assertNotNull(result);
    assertEquals(DateFormat.getInstance().format(date), DateFormat.getInstance().format(result));
    assertEquals(date.getTime(), result.getTime());
  }

  /**
   * Run the int hashCode() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testHashCode_1()
    throws Exception {
    Date date = new Date();
    Tariff fixture1 = new Tariff(new Integer(1), date, (Date) null);
    Tariff fixture2 = new Tariff(new Integer(1), date, (Date) null);

    // add additional test code here
    assertEquals(fixture1.hashCode(), fixture2.hashCode());
  }


  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testMatch_2()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), new Date(), new Date());
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
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testMatch_3()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), new Date(), new Date());
    InformationObject objectInfo = new Address();

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(false, result);
  }

  /**
   * Run the void setEndDate(Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetEndDate_1()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), new Date(), new Date());
    Date endDate = new Date();

    fixture.setEndDate(endDate);

    // add additional test code here
  }

  /**
   * Run the void setPrice(Integer) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetPrice_1()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), new Date(), new Date());
    Integer price = new Integer(1);

    fixture.setPrice(price);

    // add additional test code here
  }

  /**
   * Run the void setStartDate(Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetStartDate_1()
    throws Exception {
    Tariff fixture = new Tariff(new Integer(1), new Date(), new Date());
    Date startDate = new Date();

    fixture.setStartDate(startDate);

    // add additional test code here
  }

  /**
   * Run the String toString() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testToString_1()
    throws Exception {
    Date date = new Date();
    Tariff fixture1 = new Tariff(new Integer(1), date, date);
    Tariff fixture2 = new Tariff(new Integer(1), date, date);

    // add additional test code here
    assertEquals(fixture1.toString(), fixture2.toString());
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
  }

  /**
   * Launch the test.
   *
   * @param args the command line arguments
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(TariffUnitTest.class);
  }
}