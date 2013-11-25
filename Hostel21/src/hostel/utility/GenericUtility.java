package hostel.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.w3c.dom.DOMException;

public class GenericUtility
{
  public static boolean isNumber(String input)
  {
    try {
      Integer.parseInt(input);
      return true;
    }
    catch (NumberFormatException ex) {
      return false;
    }
  }
    
  public static boolean isValidEmailAddress(String input)
  {
    return true;
  }
  
  public static boolean isValidPhoneNumber(String input)
  {
    return true;
  }
  
  public static boolean isValidMobileNumber(String input)
  {
    return true;
  }
  
  public static Date getDate(String dateAsString)
  {
    if (dateAsString == null) {
      return null;
    }
    String dateFormat = "yyyyMMdd";
    SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
    Date date;
    try {
      date = formatter.parse(dateAsString);
      return date;
    }
    catch (DOMException | java.text.ParseException e) {
      System.err.println("Incorrect format of date. Correct format is yyyyMMdd.");
      return null;
    }
  }
  
  public static long getDiffDays(Date date1, Date date2)
  {
    long diff = date1.getTime() - date2.getTime();
    long diffDays = diff / (24 * 60 * 60 * 1000);
    return diffDays;
  }
  
  public static long getDiffHours(Date date1, Date date2)
  {
    long diff = date1.getTime() - date2.getTime();
    long diffDays = diff / (60 * 60 * 1000);
    return diffDays;
  }
  
  
  public static Date addDaysToDate(Date date, Integer days)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, days);
    return cal.getTime();
  }
  
  
  public static Date getCurrentDateWithoutTime()
  {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");      
    Date dateWithoutTime = null;
    try {
      dateWithoutTime = sdf.parse(sdf.format(new Date()));
    }
    catch (ParseException e1) {
    }
    return dateWithoutTime;
  }
}
