package hostel.unittest;

import org.junit.*;
import hostel.exception.IdentifierAlreadyExistsException;
import static org.junit.Assert.*;

/**
 * The class <code>IdentifierAlreadyExistsExceptionUnitTest</code> contains tests for the class <code>{@link IdentifierAlreadyExistsException}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:41 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class IdentifierAlreadyExistsExceptionUnitTest
{
  /**
   * Run the IdentifierAlreadyExistsException() constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIdentifierAlreadyExistsException_1()
    throws Exception {

    IdentifierAlreadyExistsException result = new IdentifierAlreadyExistsException();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getCause());
    assertEquals("hostel.exception.IdentifierAlreadyExistsException", result.toString());
    assertEquals(null, result.getMessage());
    assertEquals(null, result.getLocalizedMessage());
  }

  /**
   * Run the IdentifierAlreadyExistsException(String) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIdentifierAlreadyExistsException_2()
    throws Exception {
    String message = "";

    IdentifierAlreadyExistsException result = new IdentifierAlreadyExistsException(message);

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getCause());
    assertEquals("hostel.exception.IdentifierAlreadyExistsException: ", result.toString());
    assertEquals("", result.getMessage());
    assertEquals("", result.getLocalizedMessage());
  }

  /**
   * Run the IdentifierAlreadyExistsException(Throwable) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIdentifierAlreadyExistsException_3()
    throws Exception {
    Throwable cause = new Throwable();

    IdentifierAlreadyExistsException result = new IdentifierAlreadyExistsException(cause);

    // add additional test code here
    assertNotNull(result);
    assertEquals("hostel.exception.IdentifierAlreadyExistsException: java.lang.Throwable", result.toString());
    assertEquals("java.lang.Throwable", result.getMessage());
    assertEquals("java.lang.Throwable", result.getLocalizedMessage());
  }

  /**
   * Run the IdentifierAlreadyExistsException(String,Throwable) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIdentifierAlreadyExistsException_4()
    throws Exception {
    String message = "";
    Throwable cause = new Throwable();

    IdentifierAlreadyExistsException result = new IdentifierAlreadyExistsException(message, cause);

    // add additional test code here
    assertNotNull(result);
    assertEquals("hostel.exception.IdentifierAlreadyExistsException: ", result.toString());
    assertEquals("", result.getMessage());
    assertEquals("", result.getLocalizedMessage());
  }

  /**
   * Run the IdentifierAlreadyExistsException(String,Throwable,boolean,boolean) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testIdentifierAlreadyExistsException_5()
    throws Exception {
    String message = "";
    Throwable cause = new Throwable();
    boolean enableSuppression = true;
    boolean writableStackTrace = true;

    IdentifierAlreadyExistsException result = new IdentifierAlreadyExistsException(message, cause, enableSuppression, writableStackTrace);

    // add additional test code here
    assertNotNull(result);
    assertEquals("hostel.exception.IdentifierAlreadyExistsException: ", result.toString());
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
    new org.junit.runner.JUnitCore().run(IdentifierAlreadyExistsExceptionUnitTest.class);
  }
}