package hostel.app;

import hostel.core.*;
import hostel.core.Booking.BookingStatus;
import hostel.demo.HostelXmlParser;
import hostel.exception.*;
import hostel.utility.GenericUtility;

import java.io.IOException;
import java.util.ArrayList;

import hostel.app.Result;
import hostel.app.Result.DataType;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;

public class Command
{
  private Options HostelOptions = new Options();
  private String Input[];
  
  public Command(String args[])
  {
    Input = convertToPosix(args);
    setOptions();
  }
  
  
  private void setOptions()
  {
    // set options based on the command
    if (Input[0].equals("--search")) {
      setSearchOptions();
    }
    else if (Input[0].equals("--book")) {
      setBookOptions();
    }
    else if (Input[0].equals("--user")) {
      setUserOptions();
    }
    else if (Input[0].equals("--admin")) {
      setAdminOptions();
    }
    else if (Input[0].equals("--hostel")) {
      setHostelOptions();
    }
    else if (Input[0].equals("--bed")) {
      setBedOptions();
    }
  }
  
  private void setSearchOptions()
  {
    //search related
    HostelOptions.addOption("search", true, "-- search [free/hostel/user/bed/booking/all] or just search as described in project");
    HostelOptions.addOption("beds", true, "beds");
    HostelOptions.addOption("start_date", true, "start_date");
    HostelOptions.addOption("end_date", true, "end_date");
    
    // bed search related
    HostelOptions.addOption("hostel_id", true, "hostel id");
    HostelOptions.addOption("bed_number", true, "bed number");
    HostelOptions.addOption("room_number", true, "room number");
    
    // Address related. common to user and hostel
    HostelOptions.addOption("city", true, "city");
    HostelOptions.addOption("pin", true, "pin");
    HostelOptions.addOption("street", true, "street");
    HostelOptions.addOption("state", true, "state");
    HostelOptions.addOption("country", true, "country");
    
    // contact related. common to user and hostel
    HostelOptions.addOption("email", true, "email");
    HostelOptions.addOption("facebook", true, "facebook");
    HostelOptions.addOption("phone", true, "phone");
    HostelOptions.addOption("web", true, "weburl");
    
    // policy related.
    HostelOptions.addOption("checkin", true, "checkin");
    HostelOptions.addOption("checkout", true, "checkout");
    HostelOptions.addOption("alchohol", true, "alchohol");
    HostelOptions.addOption("smoke", true, "smoke");
    HostelOptions.addOption("cancellation_penalty", true, "cancellation_penalty");
    HostelOptions.addOption("cancellation_deadline", true, "cancellation_deadline");
    
    // hostel related
    HostelOptions.addOption("hostel_name", true, "hostel_name");
    
    // booking related
    HostelOptions.addOption("booking_date", true, "booking_date");
    HostelOptions.addOption("booking_status", true, "booking_status");
    
    //user related
    HostelOptions.addOption("user_id", true, "user_id");
    HostelOptions.addOption("first_name", true, "first_name");
    HostelOptions.addOption("last_name", true, "last_name");
    HostelOptions.addOption("cc_number", true, "cc_number");
    HostelOptions.addOption("expiration_date", true, "expiration_date");
    HostelOptions.addOption("security_code", true, "security_code");
  }
  
  
  private void setBookOptions()
  {         
    // booking related
    HostelOptions.addOption("book", true, "book");  
    HostelOptions.addOption("search_id", true, "search_id");
    HostelOptions.addOption("booking_id", true, "booking_id");
    HostelOptions.addOption("user_id", true, "user_id");
  }
  
  private void setAdminOptions()
  {
    //admin related
    HostelOptions.addOption("admin", true, "--admin [load/clear/revenue/occupancy]");
    HostelOptions.addOption("file", true, "--file [filename]");
    HostelOptions.addOption("start_date", true, "start_date");
    HostelOptions.addOption("end_date", true, "end_date");
    
    // following are used for revenue and occupancy
    // Address related. common to user and hostel
    HostelOptions.addOption("city", true, "city");
    HostelOptions.addOption("pin", true, "pin");
    HostelOptions.addOption("street", true, "street");
    HostelOptions.addOption("state", true, "state");
    HostelOptions.addOption("country", true, "country");
    
    // contact related. common to user and hostel
    HostelOptions.addOption("email", true, "email");
    HostelOptions.addOption("facebook", true, "facebook");
    HostelOptions.addOption("phone", true, "phone");
    HostelOptions.addOption("web", true, "weburl");
    
    // policy related.
    HostelOptions.addOption("checkin", true, "checkin");
    HostelOptions.addOption("checkout", true, "checkout");
    HostelOptions.addOption("alchohol", true, "alchohol");
    HostelOptions.addOption("smoke", true, "smoke");
    
    // hostel related
    HostelOptions.addOption("hostel_name", true, "hostel_name");
  }
  
  private void setHostelOptions()
  {
    //admin related
    HostelOptions.addOption("hostel", true, "--hostel [view]");
    HostelOptions.addOption("hostel_id", true, "hostel_id");
  }
  
  private void setBedOptions()
  {
    //admin related
    HostelOptions.addOption("bed", true, "--bed [view]");
    HostelOptions.addOption("bed_id", true, "bed_id");
  }
  
  private void setUserOptions()
  {
    //user related
    HostelOptions.addOption("user", true, "user");
    HostelOptions.addOption("user_id", true, "user_id");
    HostelOptions.addOption("first_name", true, "first_name");
    HostelOptions.addOption("last_name", true, "last_name");
    HostelOptions.addOption("cc_number", true, "cc_number");
    HostelOptions.addOption("expiration_date", true, "expiration_date");
    HostelOptions.addOption("security_code", true, "security_code");
    
    // Address of user
    HostelOptions.addOption("city", true, "city");
    HostelOptions.addOption("pin", true, "pin");
    HostelOptions.addOption("street", true, "street");
    HostelOptions.addOption("state", true, "state");
    HostelOptions.addOption("country", true, "country");
    
    // Contact details of users
    HostelOptions.addOption("email", true, "email");
    HostelOptions.addOption("facebook", true, "facebook");
    HostelOptions.addOption("phone", true, "phone");
    HostelOptions.addOption("web", true, "weburl");
  }
      
  private String[] convertToPosix(String args[])
  {
    if (args[0].equals("search")) {
      String posix[] = new String[args.length + 1];
      posix[0] = "--search";
      posix[1] = "free";
      for (int i = 1; i < args.length; i++) {
        posix[i+1] = args[i];
      }
      return posix;
    }
    else if (!args[0].startsWith("--")) {
      args[0] = "--" + args[0];
    }
    return args;
  }
  
  public void printHelp()
  {
	  
  }
  
  public CommandLine get()
  {
    final CommandLineParser cmdLinePosixParser = new PosixParser();
    CommandLine commandLine;
    try
    {
       commandLine = cmdLinePosixParser.parse(HostelOptions, Input);
       return commandLine;
    }
    catch (ParseException parseException)
    {
       System.err.println(parseException.getLocalizedMessage());
       System.err.println("For help use h21 --help.");
       return null;
    }
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public <T> Result<T> executeSearch(CommandLine cmd)  throws IOException
  {
    String search = cmd.getOptionValue("search");
    if (search.equals("free")) {
      if (!cmd.hasOption("start_date") && !cmd.hasOption("end_date") && !cmd.hasOption("beds")) {
        Helper.getInstance().dump();
        return null;
      }
      Hostel hostelInfo = getHostel(cmd);
      // for global search.
      if (hostelInfo == null) hostelInfo = new Hostel();
      
      if (cmd.getOptionValue("start_date").equals(cmd.getOptionValue("end_date"))) {
        System.err.println("Start and End date can not be same.");
        return null;
      }     
      if (cmd.hasOption("beds")) {
        if (!GenericUtility.isNumber(cmd.getOptionValue("beds"))) {
          System.err.println("Not a number. Correct option is --beds [number]");
          return null;
        }
        int numberOfBeds = Integer.parseInt(cmd.getOptionValue("beds"));
        ArrayList<SearchBean<FreeBedDetailBean>> freeBeds
          = Helper.getInstance().searchForFreeBeds(hostelInfo,
              GenericUtility.getDate(cmd.getOptionValue("start_date")),
              GenericUtility.getDate(cmd.getOptionValue("end_date")),
              numberOfBeds);
        return new Result(freeBeds, DataType.FREE_BED_DETAILS);
      }
      else {
        ArrayList<SearchBean<FreeBedSummaryBean>> freeBeds
          = Helper.getInstance().getFreeBedSummary(hostelInfo,
              GenericUtility.getDate(cmd.getOptionValue("start_date")),
              GenericUtility.getDate(cmd.getOptionValue("end_date")));
        return new Result(freeBeds, DataType.FREE_BED_SUMMARY);
      }
    }
    else if (search.equalsIgnoreCase("hostel")) {
      Hostel hostelInfo = getHostel(cmd);
      if (hostelInfo != null) {
        ArrayList<Identifier> hostels = Helper.getInstance().search(hostelInfo);
        return new Result(hostels, DataType.HOSTEL);
      }
      else {
        System.err.println("please enter appropriate option for searching hostel.");
        return null;
      }
    }
    else if (search.equalsIgnoreCase("bed")) {
      Bed bed = getBed(cmd);
      if (bed != null) {
        ArrayList<Identifier> users = Helper.getInstance().search(bed);
        return new Result(users, DataType.BED);
      }
      else {
        System.err.println("please enter appropriate option for searching beds.");
        return null;
      }
    }
    else if (search.equalsIgnoreCase("user")) {
      User userInfo = getUser(cmd);
      if (userInfo != null) {
        ArrayList<Identifier> users = Helper.getInstance().search(userInfo);
        return new Result(users, DataType.USER);
      }
      else {
        System.err.println("please enter appropriate option for searching user.");
        return null;
      }
    }
    else if (search.equalsIgnoreCase("book")) {
      Booking bookingInfo = getBooking(cmd);
      if (bookingInfo != null) {
        ArrayList<Identifier> bookings = Helper.getInstance().search(bookingInfo);
        return new Result(bookings, DataType.BOOKING);
      }
      else {
        System.err.println("please enter appropriate option for searching booking.");
        return null;
      }
    }
    return null;
  }
  
  
  public <T> Result<T> executeAdmin(CommandLine cmd)  throws IOException
  {
    String option = cmd.getOptionValue("admin");
    
    if (option.equalsIgnoreCase("load")) {
      if (cmd.hasOption("file")) {
        try {
          HostelXmlParser parser = new HostelXmlParser(cmd.getOptionValue("file"));
          parser.parse();
          System.out.println("Data loaded from DB!");
        }
        catch (InvalidParameterException e) {
          System.err.println("Load DB failed. Error: " + e.getMessage());
        }
      }
      else {
        System.err.println("Please specify the file name with --file option");
      }
    }
    else if (option.equalsIgnoreCase("clear")) {
      DataBaseFactory.getDataBase().clear();
      System.out.println("Cleared the DB!");
    }
    else if (option.equalsIgnoreCase("revenue")) {
      if (cmd.hasOption("start_date") && cmd.hasOption("end_date")) {
        Integer revenue = Helper.getInstance().getRevenue(getHostel(cmd),
                                        GenericUtility.getDate(cmd.getOptionValue("start_date")),
                                        GenericUtility.getDate(cmd.getOptionValue("end_date")));
        System.out.println("The total revenue is " + revenue.toString() + ".");
      }
      else {
        System.out.println("start_date and end_date are mandatory.");
      }
    }
    else if (option.equalsIgnoreCase("occupancy")) {
      if (cmd.hasOption("start_date") && cmd.hasOption("end_date")) {
        Double occupancy = Helper.getInstance().getOccupancy(getHostel(cmd),
                                        GenericUtility.getDate(cmd.getOptionValue("start_date")),
                                        GenericUtility.getDate(cmd.getOptionValue("end_date")));
        System.out.println("The percentage occupancy is " + occupancy.toString());
      }
      else {
        System.out.println("start_date and end_date are mandatory.");
      }
    }
    return null;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public <T> Result<T> executeBook(CommandLine cmd)  throws IOException
  {
    String option = cmd.getOptionValue("book");
    ArrayList<Identifier> booking = new ArrayList<Identifier>();
    
    if (option.equalsIgnoreCase("add")) {
      if (cmd.hasOption("user_id") && cmd.hasOption("search_id")) {
        Identifier id = Helper.getInstance().BookBed(new Identifier(cmd.getOptionValue("user_id")),
            new Identifier(cmd.getOptionValue("search_id")));
        if (id != null) {
          System.out.println("Booking Success!");
          booking.add(id);
          return new Result(booking, DataType.BOOKING);
        }
        else {
          System.out.println("Booking failed.");
          return null;
        }
      }
    }
    else if (option.equalsIgnoreCase("cancel")) {
      if (cmd.hasOption("booking_id")) {
        
        if ( Helper.getInstance().CancelBooking(new Identifier(cmd.getOptionValue("booking_id"))) ) {
          System.out.println("Booking cancelled successfully");
        }
        else {
          System.out.println("Could'nt cancel booking");
        }
      }
      else {
        System.err.println("--booking_id [booking id] required to cancel a booking.");
      }
    }
    else if (option.equalsIgnoreCase("view")) {
      ArrayList<Identifier> user = new ArrayList<Identifier>();
      user.add(new Identifier(cmd.getOptionValue("booking_id")));
      return new Result(user, DataType.BOOKING);
    }
    return null;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public <T> Result<T> executeUser(CommandLine cmd)  throws IOException
  {
    String option = cmd.getOptionValue("user");
    User info = getUser(cmd);
    if (option.equalsIgnoreCase("add")) {
      Identifier id = Helper.getInstance().AddUser(info);
      if (id == null) {
        System.err.println("Failed to create user.");
        return null;
      }
      ArrayList<Identifier> user = new ArrayList<Identifier>();
      user.add(id);
      return new Result(user, DataType.USER);
    }
    else if (option.equalsIgnoreCase("change")) {
      if (cmd.hasOption("user_id")) {
        
        if ( Helper.getInstance().ChangeUser(new Identifier(cmd.getOptionValue("user_id")), info) ) {
          System.out.println("User information changed successfully");
        }
        else {
          System.out.println("User information change failed");
        }
      }
      else {
        System.err.println("--user_id [user id] required to change a user.");
      }
    }
    else if (option.equalsIgnoreCase("view")) {
      ArrayList<Identifier> user = new ArrayList<Identifier>();
      user.add(new Identifier(cmd.getOptionValue("user_id")));
      return new Result(user, DataType.USER);
    }
    return null;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public <T> Result<T> executeHostel(CommandLine cmd)  throws IOException
  {
    String option = cmd.getOptionValue("hostel");
    if (option.equalsIgnoreCase("view")) {
      ArrayList<Identifier> hostel = new ArrayList<Identifier>();
      if (cmd.hasOption("hostel_id")) {
        hostel.add(new Identifier(cmd.getOptionValue("hostel_id")));
      }
      else {
        System.err.println("--hostel_id [id] not specified");
      }
      return new Result(hostel, DataType.HOSTEL);
    }
    return null;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public <T> Result<T> executeBed(CommandLine cmd)  throws IOException
  {
    String option = cmd.getOptionValue("bed");
    if (option.equalsIgnoreCase("view")) {
      ArrayList<Identifier> bed = new ArrayList<Identifier>();
      if (cmd.hasOption("bed_id")) {
        bed.add(new Identifier(cmd.getOptionValue("bed_id")));
      }
      else {
        System.err.println("--bed_id [id] not specified");
      }
      return new Result(bed, DataType.BED);
    }
    return null;
  }
  
  private <T> Result<T>  NotSupported(CommandLine cmd)
  {
    return null;
  }
  
  public <T> Result<T> execute(CommandLine cmd)  throws IOException
  {
    if (cmd.hasOption("search")) {
      return executeSearch(cmd);
    }
    else if (cmd.hasOption("admin")) {
      return executeAdmin(cmd);
    }
    else if (cmd.hasOption("book")) {
      return executeBook(cmd);
    }
    else if (cmd.hasOption("user")) {
      return executeUser(cmd);
    }
    else if (cmd.hasOption("hostel")) {
      return executeHostel(cmd);
    }
    else if (cmd.hasOption("bed")) {
      return executeBed(cmd);
    }
    return null;
  }

  public Address getAddress(CommandLine cmd)
  {
    Address address = null;
    if (cmd.hasOption("city") || cmd.hasOption("pin") || cmd.hasOption("street")
        || cmd.hasOption("state") || cmd.hasOption("country")) {
      address = new Address();
      address.setCity(cmd.getOptionValue("city"));
      address.setPIN(cmd.getOptionValue("pin"));
      address.setStreetAddress(cmd.getOptionValue("street"));
      address.setState(cmd.getOptionValue("state"));
      address.setCountry(cmd.getOptionValue("country"));
    }
    return address;
  }
  
  public Contact getContact(CommandLine cmd)
  {
    Contact contact = null;
    if (cmd.hasOption("email") || cmd.hasOption("facebook")
        || cmd.hasOption("phone") || cmd.hasOption("web")) {
      contact = new Contact();
      contact.setEmail(cmd.getOptionValue("email"));
      contact.setFaceBook(cmd.getOptionValue("facebook"));
      contact.setPhone(cmd.getOptionValue("phone"));
      contact.setWebUrl(cmd.getOptionValue("web"));
    }
    return contact;
  }
  
  public Policy getPolicy(CommandLine cmd)
  {

    Policy policy = null;
    if (cmd.hasOption("checkIn") || cmd.hasOption("checkOut")
        || cmd.hasOption("alchohol") || cmd.hasOption("smoke")
        || cmd.hasOption("cancellation_deadline") || cmd.hasOption("cancellation_penalty")) {
      policy = new Policy();
      policy.setCheckInTime(cmd.getOptionValue("checkIn"));
      policy.setCheckOutTime(cmd.getOptionValue("checkOut"));
      policy.setAlcoholPolicy(cmd.getOptionValue("alchohol"));
      policy.setSmokingPolicy(cmd.getOptionValue("smoke"));
      if (cmd.hasOption("cancellation_deadline")) {
        policy.setCancellationDeadLine(Integer.parseInt(cmd.getOptionValue("cancellation_deadline")));
      }
      if (cmd.hasOption("cancellation_penalty")) {
        policy.setCancellationPenalty(Integer.parseInt(cmd.getOptionValue("cancellation_penalty")));
      }      
    }
    return policy;
  }

  private Hostel getHostel(CommandLine cmd)
  {
    Hostel hostel = null;
    Policy policy = getPolicy(cmd);
    Contact contact = getContact(cmd);
    Address address = getAddress(cmd);
    if (cmd.hasOption("hostel_name") || policy != null
        || contact != null || address != null) {
      hostel = new Hostel();
      hostel.setAddress(address);
      hostel.setContact(contact);
      hostel.setPolicy(policy);
      hostel.setName(cmd.getOptionValue("hostel_name"));
    }
    return hostel;
  }
  
  private Bed getBed(CommandLine cmd)
  {
    Bed bed = null;
    if (cmd.hasOption("hostel_id")) {
      if (bed == null) bed = new Bed();
      bed.setHostelId(new Identifier(cmd.getOptionValue("hostel_id")));
    }
    if (cmd.hasOption("bed_number")) {
      if (bed == null) bed = new Bed();
      bed.setNumber(new Integer(cmd.getOptionValue("bed_number")));
    }
    
    if (cmd.hasOption("room_number")) {
      if (bed == null) bed = new Bed();
      bed.setRoomNo(new Integer(cmd.getOptionValue("room_number")));
    }
    if (bed != null) bed.setTariff(null);
    return bed;
  }
  
  private Booking getBooking(CommandLine cmd) throws IOException
  {   
    Booking booking = null;
    if (cmd.hasOption("hostel_id")
        || cmd.hasOption("booking_date") || cmd.hasOption("booking_status")
        || cmd.hasOption("user_id")) {
      booking = new Booking();
      booking.setBedIds(null);
      booking.setBedReservations(null);
      booking.setBookingDate(GenericUtility.getDate(cmd.getOptionValue("booking_date")));
      String statusAsString = cmd.getOptionValue("booking_status");
      BookingStatus status = BookingStatus.UNKNOWN;
      if (statusAsString != null) {
        if (statusAsString.equalsIgnoreCase(BookingStatus.RESERVED.toString())) {
          status = BookingStatus.RESERVED;
        }
        else if (statusAsString.equalsIgnoreCase(BookingStatus.CANCELLED.toString())) {
          status = BookingStatus.CANCELLED;
        }
        else if (statusAsString.equalsIgnoreCase(BookingStatus.CLOSED.toString())) {
          status = BookingStatus.CLOSED;
        }
      }
      booking.setStatus(status);
      if (cmd.hasOption("hostel_id")) {
        booking.setHostelId(new Identifier(cmd.getOptionValue("hostel_id")));
      }
      if (cmd.hasOption("user_id")) {
        booking.setUserId(new Identifier(cmd.getOptionValue("user_id")));
      }
    }
    return booking;
  }
  
  private User getUser(CommandLine cmd)
  {
    User user = null;
    Address address = getAddress(cmd);
    Contact contact = getContact(cmd);
    if (cmd.hasOption("first_name") || cmd.hasOption("last_name") || cmd.hasOption("cc_number")
        || cmd.hasOption("expiration_date") || cmd.hasOption("security_code") || contact != null || address != null) {
      user = new User();
      user.setAddress(address);
      user.setContact(contact);
      user.setCcCode(cmd.getOptionValue("cc_number"));
      user.setExpirationDate(GenericUtility.getDate(cmd.getOptionValue("expiration_date")));
      user.setFirstName(cmd.getOptionValue("first_name"));
      user.setLastName(cmd.getOptionValue("last_name"));
      user.setSecurityCode(cmd.getOptionValue("security_code"));

    }
    return user;
  }  
}


