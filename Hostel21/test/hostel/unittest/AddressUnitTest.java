package hostel.unittest;

import org.junit.*;
import hostel.core.InformationObject;
import hostel.core.Address;
import static org.junit.Assert.*;

/**
 * The class <code>AddressUnitTest</code> contains tests for the class <code>{@link Address}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:53 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class AddressUnitTest
{
  /**
   * Run the Address() constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testAddress_1()
    throws Exception {

    Address result = new Address();

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
   * Run the Address(Address) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testAddress_2()
    throws Exception {
    Address addressInfo = null;

    Address result = new Address(addressInfo);

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
   * Run the Address(Address) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testAddress_3()
    throws Exception {
    Address addressInfo = new Address("", "", "", "", "");

    Address result = new Address(addressInfo);

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
   * Run the Address(String,String,String,String,String) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testAddress_4()
    throws Exception {
    String streetAddress = "";
    String city = "";
    String state = "";
    String country = "";
    String pin = "";

    Address result = new Address(streetAddress, city, state, country, pin);

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
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testEquals_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    Object obj = new Address("", "", "", "", "");

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testEquals_2()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
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
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testEquals_3()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
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
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testEquals_4()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    Object obj = new Address("", "", "", "", "");

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testEquals_5()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    Object obj = new Address("", "", "", "", "");

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testEquals_6()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    Object obj = new Address("", "", "", "", "");

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testEquals_7()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    Object obj = new Address("", "", "", "", "");

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testEquals_8()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    Object obj = new Address("", "", "", "", "");

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testEquals_9()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    Object obj = new Address("", "", "", "", "");

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testEquals_10()
    throws Exception {
    Address fixture = new Address((String) null, "", "", "", "");
    Object obj = new Address((String) null, "", "", "", "");

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the String getCity() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testGetCity_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");

    String result = fixture.getCity();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the String getCountry() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testGetCountry_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");

    String result = fixture.getCountry();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the String getPIN() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testGetPIN_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");

    String result = fixture.getPIN();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the String getState() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testGetState_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");

    String result = fixture.getState();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the String getStreetAddress() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testGetStreetAddress_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");

    String result = fixture.getStreetAddress();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the int hashCode() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testHashCode_1()
    throws Exception {
    Address fixture = new Address("", (String) null, "", (String) null, "");

    int result = fixture.hashCode();

    // add additional test code here
    assertEquals(28629151, result);
  }

  /**
   * Run the int hashCode() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testHashCode_2()
    throws Exception {
    Address fixture = new Address((String) null, "", (String) null, "", (String) null);

    int result = fixture.hashCode();

    // add additional test code here
    assertEquals(28629151, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testMatch_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    InformationObject info = new Address("", "", "", "", "");

    boolean result = fixture.match(info);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testMatch_2()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    InformationObject info = null;

    boolean result = fixture.match(info);

    // add additional test code here
    assertEquals(false, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testMatch_3()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    InformationObject info = new Address();

    boolean result = fixture.match(info);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testMatch_4()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    InformationObject info = new Address("", "", "", "", "");

    boolean result = fixture.match(info);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testMatch_5()
    throws Exception {
    Address fixture = new Address("", (String) null, "", "", "");
    InformationObject info = new Address("", (String) null, "", "", "");

    boolean result = fixture.match(info);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testMatch_6()
    throws Exception {
    Address fixture = new Address("", (String) null, "", (String) null, "");
    InformationObject info = new Address("", (String) null, "", (String) null, "");

    boolean result = fixture.match(info);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testMatch_7()
    throws Exception {
    Address fixture = new Address("", (String) null, "", (String) null, (String) null);
    InformationObject info = new Address("", (String) null, "", (String) null, (String) null);

    boolean result = fixture.match(info);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testMatch_8()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    InformationObject info = new Address("", "", "", "", "");

    boolean result = fixture.match(info);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testMatch_9()
    throws Exception {
    Address fixture = new Address("", (String) null, (String) null, (String) null, (String) null);
    InformationObject info = new Address("", (String) null, (String) null, (String) null, (String) null);

    boolean result = fixture.match(info);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testMatch_10()
    throws Exception {
    Address fixture = new Address((String) null, (String) null, (String) null, (String) null, (String) null);
    InformationObject info = new Address((String) null, (String) null, (String) null, (String) null, (String) null);

    boolean result = fixture.match(info);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the void setCity(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testSetCity_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    String city = "";

    fixture.setCity(city);

    // add additional test code here
  }

  /**
   * Run the void setCountry(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testSetCountry_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    String country = "";

    fixture.setCountry(country);

    // add additional test code here
  }

  /**
   * Run the void setPIN(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testSetPIN_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    String pIN = "";

    fixture.setPIN(pIN);

    // add additional test code here
  }

  /**
   * Run the void setState(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testSetState_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    String state = "";

    fixture.setState(state);

    // add additional test code here
  }

  /**
   * Run the void setStreetAddress(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testSetStreetAddress_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");
    String streetAddress = "";

    fixture.setStreetAddress(streetAddress);

    // add additional test code here
  }

  /**
   * Run the String toString() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  @Test
  public void testToString_1()
    throws Exception {
    Address fixture = new Address("", "", "", "", "");

    String result = fixture.toString();

    // add additional test code here
    assertEquals("Address :\nStreetAddress = \nCity = \nState = \nCountry = \nPIN = \n", result);
  }

  /**
   * Perform pre-test initialization.
   *
   * @throws Exception
   *         if the initialization fails for some reason
   *
   * @generatedBy CodePro at 11/22/13 12:53 PM
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
   * @generatedBy CodePro at 11/22/13 12:53 PM
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
   * @generatedBy CodePro at 11/22/13 12:53 PM
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(AddressUnitTest.class);
  }
}