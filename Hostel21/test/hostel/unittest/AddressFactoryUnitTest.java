package hostel.unittest;

import org.junit.*;
import hostel.core.Address;
import static org.junit.Assert.*;

/**
 * The class <code>AddressFactoryUnitTest</code> contains tests for the class <code>{@link AddressFactory}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:41 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class AddressFactoryUnitTest
{
  /**
   * Run the Address createAddress() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testCreateAddress_1()
    throws Exception {

    Address result = AddressFactory.createAddress();

    // add additional test code here
    assertNotNull(result);
    assertEquals("", result.getPIN());
    assertEquals("", result.getStreetAddress());
    assertEquals("", result.getCity());
    assertEquals("Address :\nStreetAddress = \nCity = \nState = \nCountry = \nPIN = \n", result.toString());
    assertEquals("", result.getState());
    assertEquals("", result.getCountry());
  }

  /**
   * Run the Address createAddress2() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testCreateAddress2_1()
    throws Exception {

    Address result = AddressFactory.createAddress2();

    // add additional test code here
    assertNotNull(result);
    assertEquals("", result.getPIN());
    assertEquals("0123456789", result.getStreetAddress());
    assertEquals("0123456789", result.getCity());
    assertEquals("Address :\nStreetAddress = 0123456789\nCity = 0123456789\nState = 0123456789\nCountry = 0123456789\nPIN = \n", result.toString());
    assertEquals("0123456789", result.getState());
    assertEquals("0123456789", result.getCountry());
  }

  /**
   * Run the Address createAddress3() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testCreateAddress3_1()
    throws Exception {

    Address result = AddressFactory.createAddress3();

    // add additional test code here
    assertNotNull(result);
    assertEquals("0123456789", result.getPIN());
    assertEquals("0123456789", result.getStreetAddress());
    assertEquals("0123456789", result.getCity());
    assertEquals("Address :\nStreetAddress = 0123456789\nCity = 0123456789\nState = 0123456789\nCountry = 0123456789\nPIN = 0123456789\n", result.toString());
    assertEquals("0123456789", result.getState());
    assertEquals("0123456789", result.getCountry());
  }

  /**
   * Run the Address createAddress4() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testCreateAddress4_1()
    throws Exception {

    Address result = AddressFactory.createAddress4();

    // add additional test code here
    assertNotNull(result);
    assertEquals("An��t-1.0.txt", result.getPIN());
    assertEquals("An��t-1.0.txt", result.getStreetAddress());
    assertEquals("An��t-1.0.txt", result.getCity());
    assertEquals("Address :\nStreetAddress = An��t-1.0.txt\nCity = An��t-1.0.txt\nState = An��t-1.0.txt\nCountry = An��t-1.0.txt\nPIN = An��t-1.0.txt\n", result.toString());
    assertEquals("An��t-1.0.txt", result.getState());
    assertEquals("An��t-1.0.txt", result.getCountry());
  }

  /**
   * Run the Address createAddress5() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testCreateAddress5_1()
    throws Exception {

    Address result = AddressFactory.createAddress5();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getPIN());
    assertEquals(null, result.getStreetAddress());
    assertEquals(null, result.getCity());
    assertEquals("Address :\nStreetAddress = null\nCity = null\nState = null\nCountry = null\nPIN = null\n", result.toString());
    assertEquals(null, result.getState());
    assertEquals(null, result.getCountry());
  }

  /**
   * Run the Address createAddress6() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testCreateAddress6_1()
    throws Exception {

    Address result = AddressFactory.createAddress6();

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the Address createAddress7() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testCreateAddress7_1()
    throws Exception {

    Address result = AddressFactory.createAddress7();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getPIN());
    assertEquals(null, result.getStreetAddress());
    assertEquals(null, result.getCity());
    assertEquals("Address :\nStreetAddress = null\nCity = null\nState = null\nCountry = null\nPIN = null\n", result.toString());
    assertEquals(null, result.getState());
    assertEquals(null, result.getCountry());
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
    new org.junit.runner.JUnitCore().run(AddressFactoryUnitTest.class);
  }
}