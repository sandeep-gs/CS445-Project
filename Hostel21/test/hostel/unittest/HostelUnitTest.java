package hostel.unittest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import hostel.core.Contact;
import hostel.core.InformationObject;
import hostel.core.Address;
import hostel.core.Policy;
import hostel.core.Hostel;
import hostel.core.Identifier;
import hostel.core.User;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>HostelUnitTest</code> contains tests for the class <code>{@link Hostel}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:40 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class HostelUnitTest
{
  /**
   * Run the Hostel() constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testHostel_1()
    throws Exception {

    Hostel result = new Hostel();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getBeds());
    assertEquals(null, result.getContact());
    assertEquals("Hostel Details: \nName = null\nAddress = null\nContact = null\nHostelPoliy = null\nBeds = null\n", result.toString());
    assertEquals(null, result.getAddress());
    assertEquals(null, result.getName());
    assertEquals(null, result.getPolicy());
  }

  /**
   * Run the Hostel(Hostel) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testHostel_2()
    throws Exception {
    Hostel hostelInfo = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

    Hostel result = new Hostel(hostelInfo);

    // add additional test code here
    assertNotNull(result);
    assertEquals("Hostel Details: \nName = \nAddress = Address :\nStreetAddress = null\nCity = null\nState = null\nCountry = null\nPIN = null\n\nContact = Contact : \nPhone = null\nEmail = null\nFaceBook = null\nWebUrl = null\n\nHostelPoliy = Policy :\nCheckIn Time = null\nCheckOut Time = null\nAlcohol Policy = null\nSmoking Policy = null\nCancellation DeadLine = null\nCancellation Penalty = null\n\nBeds = []\n", result.toString());
    assertEquals("", result.getName());
  }

  /**
   * Run the Hostel(String,Address,Contact,Policy,ArrayList<Identifier>) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testHostel_3()
    throws Exception {
    String name = "";
    Address address = new Address();
    Contact contact = new Contact();
    Policy policy = new Policy();
    ArrayList<Identifier> beds = new ArrayList();

    Hostel result = new Hostel(name, address, contact, policy, beds);

    // add additional test code here
    assertNotNull(result);
    assertEquals("Hostel Details: \nName = \nAddress = Address :\nStreetAddress = null\nCity = null\nState = null\nCountry = null\nPIN = null\n\nContact = Contact : \nPhone = null\nEmail = null\nFaceBook = null\nWebUrl = null\n\nHostelPoliy = Policy :\nCheckIn Time = null\nCheckOut Time = null\nAlcohol Policy = null\nSmoking Policy = null\nCancellation DeadLine = null\nCancellation Penalty = null\n\nBeds = []\n", result.toString());
    assertEquals("", result.getName());
  }

  /**
   * Run the boolean equals(Object) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testEquals_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    Object obj = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

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
  public void testEquals_2()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
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
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
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
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    Object obj = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

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
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    Object obj = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

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
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    Object obj = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

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
  public void testEquals_7()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    Object obj = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

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
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    Object obj = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

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
  public void testEquals_9()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    Object obj = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

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
  public void testEquals_10()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), (Policy) null, new ArrayList());
    Object obj = new Hostel("", new Address(), new Contact(), (Policy) null, new ArrayList());

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the Address getAddress() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetAddress_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

    Address result = fixture.getAddress();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getStreetAddress());
    assertEquals(null, result.getPIN());
    assertEquals(null, result.getCity());
    assertEquals("Address :\nStreetAddress = null\nCity = null\nState = null\nCountry = null\nPIN = null\n", result.toString());
    assertEquals(null, result.getState());
    assertEquals(null, result.getCountry());
  }

  /**
   * Run the ArrayList<Identifier> getBeds() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetBeds_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

    ArrayList<Identifier> result = fixture.getBeds();

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the Contact getContact() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetContact_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

    Contact result = fixture.getContact();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getFaceBook());
    assertEquals(null, result.getWebUrl());
    assertEquals(null, result.getPhone());
    assertEquals(null, result.getEmail());
    assertEquals("Contact : \nPhone = null\nEmail = null\nFaceBook = null\nWebUrl = null\n", result.toString());
  }

  /**
   * Run the String getName() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetName_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

    String result = fixture.getName();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the Policy getPolicy() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetPolicy_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

    Policy result = fixture.getPolicy();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getCancellationPenalty());
    assertEquals(null, result.getCheckInTime());
    assertEquals(null, result.getCheckOutTime());
    assertEquals(null, result.getCancellationDeadLine());
    assertEquals(null, result.getSmokingPolicy());
    assertEquals(null, result.getAlcoholPolicy());
    assertEquals("Policy :\nCheckIn Time = null\nCheckOut Time = null\nAlcohol Policy = null\nSmoking Policy = null\nCancellation DeadLine = null\nCancellation Penalty = null\n", result.toString());
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
    Hostel fixture = new Hostel("", (Address) null, new Contact(), new Policy(), (ArrayList<Identifier>) null);

    int result = fixture.hashCode();

    // add additional test code here
    assertEquals(1803636513, result);
  }

  /**
   * Run the int hashCode() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testHashCode_2()
    throws Exception {
    Hostel fixture = new Hostel((String) null, new Address(), (Contact) null, (Policy) null, new ArrayList());

    int result = fixture.hashCode();

    // add additional test code here
    assertEquals(-167854563, result);
  }

  /**
   * Run the void setAddress(Address) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetAddress_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    Address address = new Address();

    fixture.setAddress(address);

    // add additional test code here
  }

  /**
   * Run the void setBeds(ArrayList<Identifier>) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetBeds_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    ArrayList<Identifier> beds = new ArrayList();

    fixture.setBeds(beds);

    // add additional test code here
  }

  /**
   * Run the void setContact(Contact) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetContact_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    Contact contact = new Contact();

    fixture.setContact(contact);

    // add additional test code here
  }

  /**
   * Run the void setName(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetName_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    String name = "";

    fixture.setName(name);

    // add additional test code here
  }

  /**
   * Run the void setPolicy(Policy) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetPolicy_1()
    throws Exception {
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());
    Policy policy = new Policy();

    fixture.setPolicy(policy);

    // add additional test code here
  }
  
  
  @Test
  public void testMatch_1()
      throws Exception {

    Hostel fixture1 = new Hostel();
    Hostel fixture2 = new Hostel();
    Date date = new Date();
    Address address = new Address();
    Contact contact = new Contact();
    Policy policy1 = new Policy();
    Policy policy2 = new Policy();
    
    policy1.setAlcoholPolicy("Y");
    policy2.setAlcoholPolicy("N");
    
    String string = new String("abc");
    
    Address address1 = new Address();
    address1.setCity("xyz");
    Contact contact1 = new Contact();
    contact1.setEmail("xyz");
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, 1);
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
    
    fixture1.setPolicy(policy1);
    assertTrue(fixture1.match(fixture2));
    assertFalse(fixture2.match(fixture1));
    fixture2.setPolicy(policy2);
    assertFalse(fixture1.match(fixture2));
    fixture2.setPolicy(policy1);
    assertTrue(fixture1.match(fixture2));
    assertTrue(fixture2.match(fixture1));
    
    fixture1.setName(string);
    assertTrue(fixture1.match(fixture2));
    assertFalse(fixture2.match(fixture1));
    fixture2.setName(string1);
    assertFalse(fixture1.match(fixture2));
    fixture2.setName(string);
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
    
    ArrayList<Identifier> beds1 = new ArrayList<Identifier>();
    beds1.add(new Identifier("abc"));
    ArrayList<Identifier> beds2 = new ArrayList<Identifier>();
    beds2.add(new Identifier("xyz"));
    fixture1.setBeds(beds1);
    assertTrue(fixture1.match(fixture2));
    fixture2.setBeds(beds2);
    assertFalse(fixture1.match(fixture2)); 
    assertFalse(fixture2.match(fixture1));
    fixture2.setBeds(beds1);
    assertTrue(fixture1.match(fixture2));
    assertTrue(fixture2.match(fixture1)); 
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
    Hostel fixture = new Hostel("", new Address(), new Contact(), new Policy(), new ArrayList());

    String result = fixture.toString();

    // add additional test code here
    assertEquals("Hostel Details: \nName = \nAddress = Address :\nStreetAddress = null\nCity = null\nState = null\nCountry = null\nPIN = null\n\nContact = Contact : \nPhone = null\nEmail = null\nFaceBook = null\nWebUrl = null\n\nHostelPoliy = Policy :\nCheckIn Time = null\nCheckOut Time = null\nAlcohol Policy = null\nSmoking Policy = null\nCancellation DeadLine = null\nCancellation Penalty = null\n\nBeds = []\n", result);
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
    new org.junit.runner.JUnitCore().run(HostelUnitTest.class);
  }
}