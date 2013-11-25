package hostel.unittest;

import org.junit.*;
import hostel.exception.GenericException;
import static org.junit.Assert.*;

/**
 * The class <code>GenericExceptionUnitTest</code> contains tests for the class <code>{@link GenericException}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:41 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class GenericExceptionUnitTest
{
  /**
   * Run the GenericException() constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGenericException_1()
    throws Exception {

    GenericException result = new GenericException();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getCause());
    assertEquals("hostel.exception.GenericException", result.toString());
    assertEquals(null, result.getMessage());
    assertEquals(null, result.getLocalizedMessage());
  }

  /**
   * Run the GenericException(String) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGenericException_2()
    throws Exception {
    String message = "";

    GenericException result = new GenericException(message);

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getCause());
    assertEquals("hostel.exception.GenericException: ", result.toString());
    assertEquals("", result.getMessage());
    assertEquals("", result.getLocalizedMessage());
  }

  /**
   * Run the GenericException(Throwable) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGenericException_3()
    throws Exception {
    Throwable cause = new Throwable();

    GenericException result = new GenericException(cause);

    // add additional test code here
    assertNotNull(result);
    assertEquals("hostel.exception.GenericException: java.lang.Throwable", result.toString());
    assertEquals("java.lang.Throwable", result.getMessage());
    assertEquals("java.lang.Throwable", result.getLocalizedMessage());
  }

  /**
   * Run the GenericException(String,Throwable) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGenericException_4()
    throws Exception {
    String message = "";
    Throwable cause = new Throwable();

    GenericException result = new GenericException(message, cause);

    // add additional test code here
    assertNotNull(result);
    assertEquals("hostel.exception.GenericException: ", result.toString());
    assertEquals("", result.getMessage());
    assertEquals("", result.getLocalizedMessage());
  }

  /**
   * Run the GenericException(String,Throwable,boolean,boolean) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGenericException_5()
    throws Exception {
    String message = "";
    Throwable cause = new Throwable();
    boolean enableSuppression = true;
    boolean writableStackTrace = true;

    GenericException result = new GenericException(message, cause, enableSuppression, writableStackTrace);

    // add additional test code here
    assertNotNull(result);
    assertEquals("hostel.exception.GenericException: ", result.toString());
    assertEquals("", result.getMessage());
    assertEquals("", result.getLocalizedMessage());
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
    new org.junit.runner.JUnitCore().run(GenericExceptionUnitTest.class);
  }
}