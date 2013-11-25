package hostel.unittest;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import hostel.core.User;

import org.junit.*;

import hostel.core.Contact;
import hostel.core.InformationObject;
import hostel.core.Address;
import static org.junit.Assert.*;

/**
 * The class <code>UserUnitTest</code> contains tests for the class <code>{@link User}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:41 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class UserUnitTest
{
  /**
   * Run the User() constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testUser_1()
    throws Exception {

    User result = new User();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getSecurityCode());
    assertEquals(null, result.getFirstName());
    assertEquals(null, result.getExpirationDate());
    assertEquals(null, result.getContact());
    assertEquals(null, result.getCcCode());
    assertEquals(null, result.getLastName());
    assertEquals("User Details : \nFirstName = null\nLastName = null\nCreationDate = null\nAddress = null\nContact = null\nExpirationDate = null\nCcCode = null\nSecurityCode = null\n", result.toString());
    assertEquals(null, result.getAddress());
    assertEquals(null, result.getCreationDate());
  }

  /**
   * Run the User(User) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testUser_2()
    throws Exception {
    User userInfo = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");

    User result = new User(userInfo);

    // add additional test code here
    assertNotNull(result);
    assertEquals("", result.getSecurityCode());
    assertEquals("", result.getFirstName());
    assertEquals("", result.getCcCode());
    assertEquals("", result.getLastName());
    assertEquals(userInfo.toString(), result.toString());
  }

  /**
   * Run the User(String,String,String,Date,Address,Contact,Date,String,String) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testUser_3()
    throws Exception {
    String email = "";
    String firstName = "";
    String lastName = "";
    Date creationDate = new Date();
    Address address = new Address();
    Contact contact = new Contact();
    Date expirationDate = new Date();
    String ccCode = "";
    String securityCode = "";

    User result = new User(email, firstName, lastName, creationDate, address, contact, expirationDate, ccCode, securityCode);

    User copy = new User(result);
    
    // add additional test code here
    assertNotNull(result);
    assertEquals("", result.getSecurityCode());
    assertEquals("", result.getFirstName());
    assertEquals("", result.getCcCode());
    assertEquals("", result.getLastName());
    assertEquals(copy.toString(), result.toString());
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
    Date now = new Date();
    User fixture = new User("", "", "", now, new Address(), new Contact(), now, "", "");
    Object obj = new User("", "", "", now, new Address(), new Contact(), now, "", "");

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * 
   */
  @Test
  public void testEquals_2()
    throws Exception {
    User fixture1 = new User();
    User fixture2 = new User();
    Address address = new Address();
    Contact contact = new Contact();
    Date date = new Date();
    String string = new String("abc");

    
    assertFalse(fixture1.equals(null));
    assertFalse(fixture1.equals(new String()));
    assertTrue(fixture1.equals(fixture1));
    assertTrue(fixture2.equals(fixture1));
    
    fixture1.setAddress(address);
    assertFalse(fixture1.equals(fixture2));
    assertFalse(fixture2.equals(fixture1));
    fixture2.setAddress(address);
    assertTrue(fixture1.equals(fixture2));
    assertTrue(fixture2.equals(fixture1));
    
    fixture1.setCcCode(string);
    assertFalse(fixture1.equals(fixture2));
    assertFalse(fixture2.equals(fixture1));
    fixture2.setCcCode(string);
    assertTrue(fixture1.equals(fixture2));
    assertTrue(fixture2.equals(fixture1));
    
    fixture1.setContact(contact);
    assertFalse(fixture1.equals(fixture2));
    assertFalse(fixture2.equals(fixture1));
    fixture2.setContact(contact);
    assertTrue(fixture1.equals(fixture2));
    assertTrue(fixture2.equals(fixture1));
    
    fixture1.setCreationDate(date);
    assertFalse(fixture1.equals(fixture2));
    assertFalse(fixture2.equals(fixture1));
    fixture2.setCreationDate(date);
    assertTrue(fixture1.equals(fixture2));
    assertTrue(fixture2.equals(fixture1));

    fixture1.setExpirationDate(date);
    assertFalse(fixture1.equals(fixture2));
    assertFalse(fixture2.equals(fixture1));
    fixture2.setExpirationDate(date);
    assertTrue(fixture1.equals(fixture2));
    assertTrue(fixture2.equals(fixture1));
    
    fixture1.setFirstName(string);
    assertFalse(fixture1.equals(fixture2));
    assertFalse(fixture2.equals(fixture1));
    fixture2.setFirstName(string);
    assertTrue(fixture1.equals(fixture2));
    assertTrue(fixture2.equals(fixture1));
    
    fixture1.setLastName(string);
    assertFalse(fixture1.equals(fixture2));
    assertFalse(fixture2.equals(fixture1));
    fixture2.setLastName(string);
    assertTrue(fixture1.equals(fixture2));
    assertTrue(fixture2.equals(fixture1));
    
    fixture1.setSecurityCode(string);
    assertFalse(fixture1.equals(fixture2));
    assertFalse(fixture2.equals(fixture1));
    fixture2.setSecurityCode(string);
    assertTrue(fixture1.equals(fixture2));    
    assertTrue(fixture2.equals(fixture1));   
  }
  
  @Test
  public void testMatch_1()
      throws Exception {

    User fixture1 = new User();
    User fixture2 = new User();
    Date date = new Date();
    Address address = new Address();
    Contact contact = new Contact();
    String string = new String("abc");
    
    Address address1 = new Address();
    address1.setCity("xyz");
    Contact contact1 = new Contact();
    contact1.setEmail("xyz");
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, 1);
    Date date1 = cal.getTime();
    String string1 = new String("xyz");

    
    assertFalse(fixture1.match(null));
    assertFalse(fixture1.match(address));
    assertTrue(fixture1.match(fixture1));
    assertTrue(fixture2.match(fixture1));
    
    fixture1.setAddress(address);
    assertTrue(fixture1.match(fixture2));
    assertFalse(fixture2.match(fixture1));
    fixture2.setAddress(address1);
    assertFalse(fixture1.match(fixture2));
    fixture2.setAddress(address);
    assertTrue(fixture1.match(fixture2));
    assertTrue(fixture2.match(fixture1));
    
    fixture1.setCcCode(string);
    assertTrue(fixture1.match(fixture2));
    assertFalse(fixture2.match(fixture1));
    fixture2.setCcCode(string1);
    assertFalse(fixture1.match(fixture2));
    fixture2.setCcCode(string);
    assertTrue(fixture1.match(fixture2));
    assertTrue(fixture2.match(fixture1));
    
    fixture1.setContact(contact);
    assertTrue(fixture1.match(fixture2));
    assertFalse(fixture2.match(fixture1));
    fixture2.setContact(contact1);
    assertFalse(fixture1.match(fixture2));
    fixture2.setContact(contact);
    assertTrue(fixture1.match(fixture2));
    assertTrue(fixture2.match(fixture1));
    
    fixture1.setCreationDate(date);
    assertTrue(fixture1.match(fixture2));
    fixture2.setCreationDate(date1);
    assertFalse(fixture1.match(fixture2)); 
    assertFalse(fixture2.match(fixture1));
    fixture2.setCreationDate(date);
    assertTrue(fixture1.match(fixture2));
    assertTrue(fixture2.match(fixture1));

    fixture1.setExpirationDate(date);
    assertTrue(fixture1.match(fixture2));
    assertFalse(fixture2.match(fixture1));
    fixture2.setExpirationDate(date1);
    assertFalse(fixture1.match(fixture2));
    fixture2.setExpirationDate(date);
    assertTrue(fixture1.match(fixture2));
    assertTrue(fixture2.match(fixture1));
    
    fixture1.setFirstName(string);
    assertTrue(fixture1.match(fixture2));
    assertFalse(fixture2.match(fixture1));
    fixture2.setFirstName(string1);
    assertFalse(fixture1.match(fixture2));
    fixture2.setFirstName(string);
    assertTrue(fixture1.match(fixture2));
    assertTrue(fixture2.match(fixture1));
    
    fixture1.setLastName(string);
    assertTrue(fixture1.match(fixture2));
    assertFalse(fixture2.match(fixture1));
    fixture2.setLastName(string1);
    assertFalse(fixture1.match(fixture2));
    fixture2.setLastName(string);
    assertTrue(fixture1.match(fixture2));
    assertTrue(fixture2.match(fixture1));
    
    fixture1.setSecurityCode(string);
    assertTrue(fixture1.match(fixture2));
    assertFalse(fixture2.match(fixture1));
    fixture2.setSecurityCode(string1);
    assertFalse(fixture1.match(fixture2)); 
    fixture2.setSecurityCode(string);
    assertTrue(fixture1.match(fixture2));    
    assertTrue(fixture2.match(fixture1));  
 
  }


  /**
   * Run the Address getAddress() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetAddress_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");

    Address result = fixture.getAddress();

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
   * Run the String getCcCode() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetCcCode_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");

    String result = fixture.getCcCode();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the Contact getContact() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetContact_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");

    Contact result = fixture.getContact();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getWebUrl());
    assertEquals(null, result.getFaceBook());
    assertEquals(null, result.getPhone());
    assertEquals(null, result.getEmail());
    assertEquals("Contact : \nPhone = null\nEmail = null\nFaceBook = null\nWebUrl = null\n", result.toString());
  }

  /**
   * Run the Date getCreationDate() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetCreationDate_1()
    throws Exception {
    Date now = new Date();
    User fixture = new User("", "", "", now, new Address(), new Contact(), new Date(), "", "");

    Date result = fixture.getCreationDate();

    // add additional test code here
    assertNotNull(result);
    assertEquals(DateFormat.getInstance().format(now), DateFormat.getInstance().format(result));
    assertEquals(now.getTime(), result.getTime());
  }

  /**
   * Run the Date getExpirationDate() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetExpirationDate_1()
    throws Exception {
    Date joinDate = new Date();
    Date expDate = new Date();
    User fixture = new User("", "", "", joinDate, new Address(), new Contact(), expDate, "", "");

    Date result = fixture.getExpirationDate();

    // add additional test code here
    assertNotNull(result);
    assertEquals(DateFormat.getInstance().format(joinDate), DateFormat.getInstance().format(result));
    assertEquals(joinDate.getTime(), result.getTime());
  }

  /**
   * Run the String getFirstName() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetFirstName_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");

    String result = fixture.getFirstName();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the String getLastName() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetLastName_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");

    String result = fixture.getLastName();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the String getSecurityCode() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetSecurityCode_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");

    String result = fixture.getSecurityCode();

    // add additional test code here
    assertEquals("", result);
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
    User fixture1 = new User("", "", "", (Date) null, (Address) null, (Contact) null, new Date(), (String) null, "");

    User fixture2 = new User("", "", "", (Date) null, (Address) null, (Contact) null, new Date(), (String) null, "");
    int result1 = fixture1.hashCode();
    int result2 = fixture2.hashCode();

    // add additional test code here
    assertEquals(result1, result2);
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
    User fixture1 = new User("", (String) null, (String) null, new Date(), new Address(), new Contact(), (Date) null, "", (String) null);
    User fixture2 = new User("", (String) null, (String) null, new Date(), new Address(), new Contact(), (Date) null, "", (String) null);
    int result1 = fixture1.hashCode();
    int result2 = fixture2.hashCode();

    // add additional test code here
    assertEquals(result1, result2);
  }

  /**
   * Run the void setAddress(Address) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetAddress_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");
    Address address = new Address();

    fixture.setAddress(address);

    // add additional test code here
  }

  /**
   * Run the void setCcCode(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetCcCode_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");
    String ccCode = "";

    fixture.setCcCode(ccCode);

    // add additional test code here
  }

  /**
   * Run the void setContact(Contact) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetContact_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");
    Contact contact = new Contact();

    fixture.setContact(contact);

    // add additional test code here
  }

  /**
   * Run the void setCreationDate(Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetCreationDate_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");
    Date creationDate = new Date();

    fixture.setCreationDate(creationDate);

    // add additional test code here
  }

  /**
   * Run the void setExpirationDate(Date) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetExpirationDate_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");
    Date expirationDate = new Date();

    fixture.setExpirationDate(expirationDate);

    // add additional test code here
  }

  /**
   * Run the void setFirstName(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetFirstName_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");
    String firstName = "";

    fixture.setFirstName(firstName);

    // add additional test code here
  }

  /**
   * Run the void setLastName(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetLastName_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");
    String lastName = "";

    fixture.setLastName(lastName);

    // add additional test code here
  }

  /**
   * Run the void setSecurityCode(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSetSecurityCode_1()
    throws Exception {
    User fixture = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");
    String securityCode = "";

    fixture.setSecurityCode(securityCode);

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
    User fixture1 = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");

    User fixture2 = new User("", "", "", new Date(), new Address(), new Contact(), new Date(), "", "");

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
    new org.junit.runner.JUnitCore().run(UserUnitTest.class);
  }
}