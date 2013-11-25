package hostel.unittest;

import org.junit.*;
import hostel.core.InformationObject;
import hostel.core.Address;
import hostel.core.Identifier;
import static org.junit.Assert.*;

/**
 * The class <code>IdentifierUnitTest</code> contains tests for the class <code>{@link Identifier}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:40 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class IdentifierUnitTest
{
  /**
   * Run the Identifier(Identifier) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testIdentifier_1()
    throws Exception {
    Identifier identifier = new Identifier("");

    Identifier result = new Identifier(identifier);

    // add additional test code here
    assertNotNull(result);
    assertEquals(new Integer(0), result.getIntegerKey());
    assertEquals("", result.toString());
    assertEquals("", result.getKey());
  }

  /**
   * Run the Identifier(String) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testIdentifier_2()
    throws Exception {
    String key = "";

    Identifier result = new Identifier(key);

    // add additional test code here
    assertNotNull(result);
    assertEquals(new Integer(0), result.getIntegerKey());
    assertEquals("", result.toString());
    assertEquals("", result.getKey());
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
    Identifier fixture = new Identifier("");
    Object obj = new Identifier("");

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
    Identifier fixture = new Identifier("");
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
    Identifier fixture = new Identifier("");
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
    Identifier fixture = new Identifier("");
    Object obj = new Identifier("");

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
    Identifier fixture = new Identifier("");
    Object obj = new Identifier("");

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
    Identifier fixture = new Identifier((String) null);
    Object obj = new Identifier((String) null);

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the Integer getIntegerKey() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetIntegerKey_1()
    throws Exception {
    Identifier fixture = new Identifier("");

    Integer result = fixture.getIntegerKey();

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getIntegerKey() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetIntegerKey_2()
    throws Exception {
    Identifier fixture = new Identifier("");

    Integer result = fixture.getIntegerKey();

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getIntegerKey() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetIntegerKey_3()
    throws Exception {
    Identifier fixture = new Identifier("");

    Integer result = fixture.getIntegerKey();

    // add additional test code here
    assertNotNull(result);
    assertEquals("0", result.toString());
    assertEquals((byte) 0, result.byteValue());
    assertEquals((short) 0, result.shortValue());
    assertEquals(0, result.intValue());
    assertEquals(0L, result.longValue());
    assertEquals(0.0f, result.floatValue(), 1.0f);
    assertEquals(0.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the String getKey() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetKey_1()
    throws Exception {
    Identifier fixture = new Identifier("");

    String result = fixture.getKey();

    // add additional test code here
    assertEquals("", result);
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
    Identifier fixture = new Identifier("");

    int result = fixture.hashCode();

    // add additional test code here
    assertEquals(31, result);
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
    Identifier fixture = new Identifier((String) null);

    int result = fixture.hashCode();

    // add additional test code here
    assertEquals(31, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testMatch_1()
    throws Exception {
    Identifier fixture = new Identifier("");
    InformationObject obj = new Address();

    boolean result = fixture.match(obj);

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
  public void testMatch_2()
    throws Exception {
    Identifier fixture = new Identifier("");
    InformationObject obj = new Address();

    boolean result = fixture.match(obj);

    // add additional test code here
    assertEquals(false, result);
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
    Identifier fixture = new Identifier("");

    String result = fixture.toString();

    // add additional test code here
    assertEquals("", result);
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
    new org.junit.runner.JUnitCore().run(IdentifierUnitTest.class);
  }
}