package hostel.unittest;

import org.junit.*;
import hostel.exception.InvalidIdentifierException;
import static org.junit.Assert.*;

/**
 * The class <code>InvalidIdentifierExceptionUnitTest</code> contains tests for the class <code>{@link InvalidIdentifierException}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:40 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class InvalidIdentifierExceptionUnitTest
{
  /**
   * Run the InvalidIdentifierException() constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testInvalidIdentifierException_1()
    throws Exception {

    InvalidIdentifierException result = new InvalidIdentifierException();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getCause());
    assertEquals("hostel.exception.InvalidIdentifierException", result.toString());
    assertEquals(null, result.getMessage());
    assertEquals(null, result.getLocalizedMessage());
  }

  /**
   * Run the InvalidIdentifierException(String) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testInvalidIdentifierException_2()
    throws Exception {
    String message = "";

    InvalidIdentifierException result = new InvalidIdentifierException(message);

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getCause());
    assertEquals("hostel.exception.InvalidIdentifierException: ", result.toString());
    assertEquals("", result.getMessage());
    assertEquals("", result.getLocalizedMessage());
  }

  /**
   * Run the InvalidIdentifierException(Throwable) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testInvalidIdentifierException_3()
    throws Exception {
    Throwable cause = new Throwable();

    InvalidIdentifierException result = new InvalidIdentifierException(cause);

    // add additional test code here
    assertNotNull(result);
    assertEquals("hostel.exception.InvalidIdentifierException: java.lang.Throwable", result.toString());
    assertEquals("java.lang.Throwable", result.getMessage());
    assertEquals("java.lang.Throwable", result.getLocalizedMessage());
  }

  /**
   * Run the InvalidIdentifierException(String,Throwable) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testInvalidIdentifierException_4()
    throws Exception {
    String message = "";
    Throwable cause = new Throwable();

    InvalidIdentifierException result = new InvalidIdentifierException(message, cause);

    // add additional test code here
    assertNotNull(result);
    assertEquals("hostel.exception.InvalidIdentifierException: ", result.toString());
    assertEquals("", result.getMessage());
    assertEquals("", result.getLocalizedMessage());
  }

  /**
   * Run the InvalidIdentifierException(String,Throwable,boolean,boolean) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testInvalidIdentifierException_5()
    throws Exception {
    String message = "";
    Throwable cause = new Throwable();
    boolean enableSuppression = true;
    boolean writableStackTrace = true;

    InvalidIdentifierException result = new InvalidIdentifierException(message, cause, enableSuppression, writableStackTrace);

    // add additional test code here
    assertNotNull(result);
    assertEquals("hostel.exception.InvalidIdentifierException: ", result.toString());
    assertEquals("", result.getMessage());
    assertEquals("", result.getLocalizedMessage());
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
    new org.junit.runner.JUnitCore().run(InvalidIdentifierExceptionUnitTest.class);
  }
}