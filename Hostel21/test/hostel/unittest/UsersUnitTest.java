package hostel.unittest;

import java.util.ArrayList;

import hostel.collection.Users;
import hostel.core.Contact;
import hostel.core.DataBaseFactory;
import hostel.core.User;
import hostel.exception.IdentifierAlreadyExistsException;
import hostel.core.Identifier;
import hostel.exception.IdentifierNotFoundException;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * The class <code>UsersUnitTest</code> contains tests for the class <code>{@link Users}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:41 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class UsersUnitTest
{
  /**
   * Run the Identifier create(User) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierAlreadyExistsException.class)
  public void testCreate_1()
    throws Exception {
    Users fixture = Users.getInstance();
    User info = new User();

    Identifier result = fixture.create(info);

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the void delete(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testDelete_1()
    throws Exception {
    Users fixture = Users.getInstance();
    Identifier id = new Identifier("");

    fixture.delete(id);

    // add additional test code here
  }

  /**
   * Run the void delete(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testDelete_2()
    throws Exception {
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = Users.getInstance().create(userInfo);
    Users.getInstance().delete(userId);
    Users.getInstance().get(userId);
  }

  /**
   * Run the User get(Identifier) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testGet_1()
    throws Exception {
    Users fixture = Users.getInstance();
    Identifier id = new Identifier("");

    User result = fixture.get(id);

    // add additional test code here
    assertNotNull(result);
  }

  @Test
  public void testGet_2()
    throws Exception {
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = Users.getInstance().create(userInfo);
    assertTrue(Users.getInstance().get(userId)!=null);
  }
  
  /**
   * Run the Users getInstance() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testGetInstance_1()
    throws Exception {

    Users result = Users.getInstance();

    // add additional test code here
    assertNotNull(result);
  }

  /**
   * Run the ArrayList<Identifier> search(User) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test
  public void testSearch_1()
    throws Exception {
    Users fixture = Users.getInstance();
    User info = new User();

    ArrayList<Identifier> result = fixture.search(info);

    // add additional test code here
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  /**
   * Run the void update(Identifier,User) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  @Test(expected = hostel.exception.IdentifierNotFoundException.class)
  public void testUpdate_1()
    throws Exception {
    Users fixture = Users.getInstance();
    Identifier id = new Identifier("");
    User info = new User();

    fixture.update(id, info);

    // add additional test code here
  }

  @Test
  public void testUpdate_2()
    throws Exception {
    User userInfo = new User();
    Contact contact1 = new Contact();
    contact1.setEmail("test1@test1.com");
    userInfo.setContact(contact1);
    Identifier userId = Users.getInstance().create(userInfo);
    Users.getInstance().update(userId, userInfo);
    assertTrue(true);
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
    DataBaseFactory.ClearDataBase();
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
    DataBaseFactory.ClearDataBase();
  }

  /**
   * Launch the test.
   *
   * @param args the command line arguments
   *
   * @generatedBy CodePro at 11/22/13 12:41 PM
   */
  public static void main(String[] args) {
    new org.junit.runner.JUnitCore().run(UsersUnitTest.class);
  }
}