package hostel.unittest;

import org.junit.*;
import hostel.core.InformationObject;
import hostel.core.Address;
import hostel.core.Policy;
import static org.junit.Assert.*;

/**
 * The class <code>PolicyUnitTest</code> contains tests for the class <code>{@link Policy}</code>.
 * <p>
 * Copyright (c) 2013
 *
 * @generatedBy CodePro at 11/22/13 12:40 PM
 * @author sandeep
 * @version $Revision: 1.0 $
 */
public class PolicyUnitTest
{
  /**
   * Run the Policy() constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testPolicy_1()
    throws Exception {

    Policy result = new Policy();

    // add additional test code here
    assertNotNull(result);
    assertEquals(null, result.getCheckOutTime());
    assertEquals(null, result.getAlcoholPolicy());
    assertEquals(null, result.getSmokingPolicy());
    assertEquals(null, result.getCancellationDeadLine());
    assertEquals(null, result.getCancellationPenalty());
    assertEquals(null, result.getCheckInTime());
    assertEquals("Policy :\nCheckIn Time = null\nCheckOut Time = null\nAlcohol Policy = null\nSmoking Policy = null\nCancellation DeadLine = null\nCancellation Penalty = null\n", result.toString());
  }

  /**
   * Run the Policy(Policy) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testPolicy_2()
    throws Exception {
    Policy contactInfo = new Policy("", "", "", "", new Integer(1), new Integer(1));

    Policy result = new Policy(contactInfo);

    // add additional test code here
    assertNotNull(result);
    assertEquals("", result.getCheckOutTime());
    assertEquals("", result.getAlcoholPolicy());
    assertEquals("", result.getSmokingPolicy());
    assertEquals(new Integer(1), result.getCancellationDeadLine());
    assertEquals(new Integer(1), result.getCancellationPenalty());
    assertEquals("", result.getCheckInTime());
    assertEquals("Policy :\nCheckIn Time = \nCheckOut Time = \nAlcohol Policy = \nSmoking Policy = \nCancellation DeadLine = 1\nCancellation Penalty = 1\n", result.toString());
  }

  /**
   * Run the Policy(String,String,String,String,Integer,Integer) constructor test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testPolicy_3()
    throws Exception {
    String checkInTime = "";
    String checkOutTime = "";
    String alcoholPolicy = "";
    String smokingPolicy = "";
    Integer cancellationDeadLine = new Integer(1);
    Integer cancellationPenalty = new Integer(1);

    Policy result = new Policy(checkInTime, checkOutTime, alcoholPolicy, smokingPolicy, cancellationDeadLine, cancellationPenalty);

    // add additional test code here
    assertNotNull(result);
    assertEquals("", result.getCheckOutTime());
    assertEquals("", result.getAlcoholPolicy());
    assertEquals("", result.getSmokingPolicy());
    assertEquals(new Integer(1), result.getCancellationDeadLine());
    assertEquals(new Integer(1), result.getCancellationPenalty());
    assertEquals("", result.getCheckInTime());
    assertEquals("Policy :\nCheckIn Time = \nCheckOut Time = \nAlcohol Policy = \nSmoking Policy = \nCancellation DeadLine = 1\nCancellation Penalty = 1\n", result.toString());
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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    Object obj = new Policy("", "", "", "", new Integer(1), new Integer(1));

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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    Object obj = new Policy("", "", "", "", new Integer(1), new Integer(1));

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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    Object obj = new Policy("", "", "", "", new Integer(1), new Integer(1));

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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    Object obj = new Policy("", "", "", "", new Integer(1), new Integer(1));

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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    Object obj = new Policy("", "", "", "", new Integer(1), new Integer(1));

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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    Object obj = new Policy("", "", "", "", new Integer(1), new Integer(1));

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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    Object obj = new Policy("", "", "", "", new Integer(1), new Integer(1));

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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    Object obj = new Policy("", "", "", "", new Integer(1), new Integer(1));

    boolean result = fixture.equals(obj);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the String getAlcoholPolicy() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetAlcoholPolicy_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));

    String result = fixture.getAlcoholPolicy();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the Integer getCancellationDeadLine() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetCancellationDeadLine_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));

    Integer result = fixture.getCancellationDeadLine();

    // add additional test code here
    assertNotNull(result);
    assertEquals("1", result.toString());
    assertEquals((byte) 1, result.byteValue());
    assertEquals((short) 1, result.shortValue());
    assertEquals(1, result.intValue());
    assertEquals(1L, result.longValue());
    assertEquals(1.0f, result.floatValue(), 1.0f);
    assertEquals(1.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the Integer getCancellationPenalty() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetCancellationPenalty_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));

    Integer result = fixture.getCancellationPenalty();

    // add additional test code here
    assertNotNull(result);
    assertEquals("1", result.toString());
    assertEquals((byte) 1, result.byteValue());
    assertEquals((short) 1, result.shortValue());
    assertEquals(1, result.intValue());
    assertEquals(1L, result.longValue());
    assertEquals(1.0f, result.floatValue(), 1.0f);
    assertEquals(1.0, result.doubleValue(), 1.0);
  }

  /**
   * Run the String getCheckInTime() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetCheckInTime_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));

    String result = fixture.getCheckInTime();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the String getCheckOutTime() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetCheckOutTime_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));

    String result = fixture.getCheckOutTime();

    // add additional test code here
    assertEquals("", result);
  }

  /**
   * Run the String getSmokingPolicy() method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testGetSmokingPolicy_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));

    String result = fixture.getSmokingPolicy();

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
    Policy fixture = new Policy("", "", (String) null, "", (Integer) null, (Integer) null);

    int result = fixture.hashCode();

    // add additional test code here
    assertEquals(887503681, result);
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
    Policy fixture = new Policy((String) null, (String) null, "", (String) null, new Integer(1), new Integer(1));

    int result = fixture.hashCode();

    // add additional test code here
    assertEquals(888456993, result);
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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    InformationObject objectInfo = new Policy("", "", "", "", new Integer(1), new Integer(1));

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    InformationObject objectInfo = null;

    boolean result = fixture.match(objectInfo);

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
  public void testMatch_3()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    InformationObject objectInfo = new Address();

    boolean result = fixture.match(objectInfo);

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
  public void testMatch_4()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    InformationObject objectInfo = new Policy("", "", "", "", new Integer(1), new Integer(1));

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testMatch_5()
    throws Exception {
    Policy fixture = new Policy("", "", (String) null, "", new Integer(1), new Integer(1));
    InformationObject objectInfo = new Policy("", "", (String) null, "", new Integer(1), new Integer(1));

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testMatch_6()
    throws Exception {
    Policy fixture = new Policy((String) null, "", (String) null, "", new Integer(1), new Integer(1));
    InformationObject objectInfo = new Policy((String) null, "", (String) null, "", new Integer(1), new Integer(1));

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testMatch_7()
    throws Exception {
    Policy fixture = new Policy((String) null, (String) null, (String) null, "", new Integer(1), new Integer(1));
    InformationObject objectInfo = new Policy((String) null, (String) null, (String) null, "", new Integer(1), new Integer(1));

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testMatch_8()
    throws Exception {
    Policy fixture = new Policy((String) null, (String) null, (String) null, (String) null, new Integer(1), new Integer(1));
    InformationObject objectInfo = new Policy((String) null, (String) null, (String) null, (String) null, new Integer(1), new Integer(1));

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testMatch_9()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    InformationObject objectInfo = new Policy("", "", "", "", new Integer(1), new Integer(1));

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the boolean match(InformationObject) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testMatch_10()
    throws Exception {
    Policy fixture = new Policy((String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null);
    InformationObject objectInfo = new Policy((String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null);

    boolean result = fixture.match(objectInfo);

    // add additional test code here
    assertEquals(true, result);
  }

  /**
   * Run the void setAlcoholPolicy(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetAlcoholPolicy_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    String alcoholPolicy = "";

    fixture.setAlcoholPolicy(alcoholPolicy);

    // add additional test code here
  }

  /**
   * Run the void setCancellationDeadLine(Integer) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetCancellationDeadLine_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    Integer cancellationDeadLine = new Integer(1);

    fixture.setCancellationDeadLine(cancellationDeadLine);

    // add additional test code here
  }

  /**
   * Run the void setCancellationPenalty(Integer) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetCancellationPenalty_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    Integer cancellationPenalty = new Integer(1);

    fixture.setCancellationPenalty(cancellationPenalty);

    // add additional test code here
  }

  /**
   * Run the void setCheckInTime(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetCheckInTime_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    String checkInTime = "";

    fixture.setCheckInTime(checkInTime);

    // add additional test code here
  }

  /**
   * Run the void setCheckOutTime(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetCheckOutTime_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    String checkOutTime = "";

    fixture.setCheckOutTime(checkOutTime);

    // add additional test code here
  }

  /**
   * Run the void setSmokingPolicy(String) method test.
   *
   * @throws Exception
   *
   * @generatedBy CodePro at 11/22/13 12:40 PM
   */
  @Test
  public void testSetSmokingPolicy_1()
    throws Exception {
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));
    String smokingPolicy = "";

    fixture.setSmokingPolicy(smokingPolicy);

    // add additional test code here
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
    Policy fixture = new Policy("", "", "", "", new Integer(1), new Integer(1));

    String result = fixture.toString();

    // add additional test code here
    assertEquals("Policy :\nCheckIn Time = \nCheckOut Time = \nAlcohol Policy = \nSmoking Policy = \nCancellation DeadLine = 1\nCancellation Penalty = 1\n", result);
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
    new org.junit.runner.JUnitCore().run(PolicyUnitTest.class);
  }
}