package hostel.unittest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.*;

import hostel.utility.GenericUtility;
import static org.junit.Assert.*;

/**
 * The class <code>GenericUtilityUnitTest</code> contains tests for the class <code>{@link GenericUtility}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:41 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class GenericUtilityUnitTest
{
  /**
   * Run the Date addDaysToDate(Date,Integer) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testAddDaysToDate_1()
    throws Exception {
    Date date = new Date();
    Integer days = new Integer(1);

    Date result = GenericUtility.addDaysToDate(date, days);

    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, days);
    Date localDate = cal.getTime();
    
    // add additional test code here
    assertNotNull(result);
    assertEquals(DateFormat.getInstance().format(localDate), DateFormat.getInstance().format(result));
    assertEquals(localDate.getTime(), result.getTime());
  }

  /**
   * Run the Date getCurrentDateWithoutTime() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetCurrentDateWithoutTime_1()
    throws Exception {

    Date result = GenericUtility.getCurrentDateWithoutTime();

    // add additional test code here
    assertNotNull(result);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");      
    Date dateWithoutTime = null;
    try {
      dateWithoutTime = sdf.parse(sdf.format(new Date()));
    }
    catch (ParseException e1) {
    }  
    assertEquals(dateWithoutTime.getTime(), result.getTime());
  }

  /**
   * Run the Date getDate(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetDate_1()
    throws Exception {
    String dateAsString = null;

    Date result = GenericUtility.getDate(dateAsString);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Date getDate(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetDate_2()
    throws Exception {
    String dateAsString = "";

    Date result = GenericUtility.getDate(dateAsString);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the Date getDate(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetDate_3()
    throws Exception {
    String dateAsString = "";

    Date result = GenericUtility.getDate(dateAsString);

    // add additional test code here
    assertEquals(null, result);
  }

  /**
   * Run the long getDiffDays(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetDiffDays_1()
    throws Exception {
    Date date1 = new Date();
    Date date2 = new Date();

    long result = GenericUtility.getDiffDays(date1, date2);

    // add additional test code here
    assertEquals(0L, result);
  }

  /**
   * Run the long getDiffHours(Date,Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetDiffHours_1()
    throws Exception {
    Date date1 = new Date();
    Date date2 = new Date();

    long result = GenericUtility.getDiffHours(date1, date2);

    // add additional test code here
    assertEquals(0L, result);
  }

  /**
   * Run the boolean isNumber(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIsNumber_1()
    throws Exception {
    String input = "0";

    boolean result = GenericUtility.isNumber(input);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean isNumber(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIsNumber_2()
    throws Exception {
    String input = "";

    boolean result = GenericUtility.isNumber(input);

    // add additional test code here
    assertEquals(false, result);
  }

  /**
   * Run the boolean isValidEmailAddress(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIsValidEmailAddress_1()
    throws Exception {
    String input = "";

    boolean result = GenericUtility.isValidEmailAddress(input);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean isValidMobileNumber(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIsValidMobileNumber_1()
    throws Exception {
    String input = "";

    boolean result = GenericUtility.isValidMobileNumber(input);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean isValidPhoneNumber(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIsValidPhoneNumber_1()
    throws Exception {
    String input = "";

    boolean result = GenericUtility.isValidPhoneNumber(input);

    // add additional test code here
    assertEquals(true, result);
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
    new org.junit.runner.JUnitCore().run(GenericUtilityUnitTest.class);
  }
}