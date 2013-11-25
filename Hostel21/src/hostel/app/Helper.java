package hostel.app;

import hostel.collection.Beds;
import hostel.collection.Bookings;
import hostel.collection.Hostels;
import hostel.collection.Users;
import hostel.core.*;
import hostel.core.Booking.BookingStatus;
import hostel.exception.*;
import hostel.utility.GenericUtility;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Helper
{
  private static final String SEARCH_RESULE_FILE = ".h21_search.temp";
  private static Integer searchId = 0;
  private static Helper Instance = new Helper();
  
  public static Helper getInstance() {return Instance;}
  
  private static Identifier getNextSearchId()
  {
    ++searchId;
    return new Identifier(searchId.toString());
  }
  
  private <T extends InformationObject> void write(ArrayList<SearchBean<T>> result)
  {
    
    try (
        OutputStream file = new FileOutputStream(SEARCH_RESULE_FILE);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);
      ){
        output.writeObject(result);
      }  
      catch(IOException ex){
        ex.printStackTrace();
      }
  }
  
  private <T extends InformationObject> ArrayList<SearchBean<T>> read()
  {
    try(
        InputStream file = new FileInputStream(SEARCH_RESULE_FILE);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream (buffer);
      ){
        @SuppressWarnings("unchecked")
        ArrayList<SearchBean<T>> result =  (ArrayList<SearchBean<T>>) input.readObject();
        return result;
      }
      catch(ClassNotFoundException ex){
        ex.printStackTrace();
      }
      catch(IOException ex){
        ex.printStackTrace();
      }
    return null;
  }
  
  public ArrayList<Identifier> search(Bed info)
  {
    try {
      return Beds.getInstance().search(info);
    }
    catch (DataBaseReadWriteException e) {
      System.err.println(e.getMessage());
    }
    return new ArrayList<Identifier> ();
  }
  
  public ArrayList<Identifier> search(Hostel info)
  {
    try {
      return Hostels.getInstance().search(info);
    }
    catch (DataBaseReadWriteException e) {
      System.err.println(e.getMessage());
    }
    return new ArrayList<Identifier> ();
  }
  
  public ArrayList<Identifier> search(User info)
  {
    try {
      return Users.getInstance().search(info);
    }
    catch (DataBaseReadWriteException e) {
      System.err.println(e.getMessage());
    }
    return new ArrayList<Identifier> ();
  }
  
  public ArrayList<Identifier> search(Booking info)
  {
    try {
      return Bookings.getInstance().search(info);
    }
    catch (DataBaseReadWriteException e) {
      System.err.println(e.getMessage());
    }
    return new ArrayList<Identifier> ();
  }
  
  public ArrayList<SearchBean<Booking>> searchInDateRange(Booking info)
  {
    ArrayList<SearchBean<Booking>> result = new ArrayList<SearchBean<Booking>>();
    try {
      ArrayList<Identifier> bookingIds = Bookings.getInstance().searchInDateRange(info);
      for (Identifier bookingId : bookingIds) {
        SearchBean<Booking> bean = new SearchBean<Booking>(getNextSearchId(),
                                                           bookingId,
                                                           Bookings.getInstance().get(bookingId));
        result.add(bean);
      }
    }
    catch (DataBaseReadWriteException | IdentifierNotFoundException
           | InvalidIdentifierException | InvalidParameterException e) {
      e.printStackTrace();
    }
    //write(result);
    return result;
  }
  
  
  
  
  public ArrayList<SearchBean<FreeBedDetailBean>> searchForFreeBeds(Hostel info,
                                                                    Date checkIn,
                                                                    Date checkOut,
                                                                    int numberOfBeds)
  {
    
    ArrayList<SearchBean<FreeBedDetailBean>> result = new ArrayList<SearchBean<FreeBedDetailBean>>();
    // first clear the old result
    write(result);
    if(info == null) {
      return null;
    }
    try {
      ArrayList<Identifier> hostelIds = Hostels.getInstance().search(info);
      if (hostelIds.size() == 0) {
        return null;
      }
      for (Identifier hostelId : hostelIds) {
        ArrayList<Identifier> bedIds = Hostels.getInstance().getFreeBeds(hostelId, checkIn, checkOut);
        //bedIds = Beds.getInstance().sortBasedOnPrice(bedIds, checkIn, checkOut);
        if (bedIds.size() < numberOfBeds) {
          continue;
        }
        
        if (numberOfBeds == 1) {
          for (int i = 0; i < bedIds.size(); i++) {
            Bed bedInfo = Beds.getInstance().get(bedIds.get(i));
            FreeBedDetailBean bedDetail = new FreeBedDetailBean();
            bedDetail.setCheckIn(checkIn);
            bedDetail.setCheckOut(checkOut);
            bedDetail.setTotalPrice(bedInfo.getTariffForDate(checkIn, checkOut).getPrice());
            ArrayList<Identifier> topBedIds = new ArrayList<Identifier>();
            ArrayList<Integer> price = new ArrayList<Integer>();
            topBedIds.add(bedIds.get(i));
            price.add(bedInfo.getTariffForDate(checkIn, checkOut).getPrice());
            bedDetail.setBedIds(topBedIds);
            bedDetail.setPrice(price);
            SearchBean<FreeBedDetailBean> bean = new SearchBean<FreeBedDetailBean>(getNextSearchId(),
                hostelId, bedDetail);
            result.add(bean);
          }
        }
        else {
          FreeBedDetailBean bedDetail = new FreeBedDetailBean();
          bedDetail.setTotalPrice(0);
          ArrayList<Identifier> topBedIds = new ArrayList<Identifier>();
          ArrayList<Integer> price = new ArrayList<Integer>();
          // Show only the top 1 combination only.
          for (int i = 0; i < numberOfBeds; i++) {
            Bed bedInfo = Beds.getInstance().get(bedIds.get(i));
            bedDetail.setCheckIn(checkIn);
            bedDetail.setCheckOut(checkOut);
            bedDetail.setTotalPrice(bedDetail.getTotalPrice() + bedInfo.getTariffForDate(checkIn, checkOut).getPrice());
            topBedIds.add(bedIds.get(i));
            price.add(bedInfo.getTariffForDate(checkIn, checkOut).getPrice());
          }
          bedDetail.setBedIds(topBedIds);
          bedDetail.setPrice(price);
          SearchBean<FreeBedDetailBean> bean = new SearchBean<FreeBedDetailBean>(getNextSearchId(),
              hostelId, bedDetail);
          result.add(bean);
        }
      }
    }
    catch (DataBaseReadWriteException | IdentifierNotFoundException | InvalidIdentifierException | InvalidParameterException e) {
      e.printStackTrace();
    }
    
    write(result);
    return result;
  }
  
  
  
  public ArrayList<SearchBean<FreeBedSummaryBean>> getFreeBedSummary(Hostel info,
      Date start,
      Date end)
  {
    ArrayList<SearchBean<FreeBedSummaryBean>> result = new ArrayList<SearchBean<FreeBedSummaryBean>>();
     
    if(info == null) {
      return null;
    }
    
    try {
      ArrayList<Identifier> hostelIds = Hostels.getInstance().search(info);
      if (hostelIds.size() == 0) {
        return null;
      }
      for (Identifier hostelId : hostelIds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        for (int days = 1; days <= GenericUtility.getDiffDays(end, start); days++) {
          Date checkIn = cal.getTime();
          cal.add(Calendar.DATE, 1);
          Date checkOut = cal.getTime();
          
          ArrayList<Identifier> bedIds
            = Hostels.getInstance().getFreeBeds(hostelId, checkIn, checkOut);
          int maxPrice = 0;
          int minPrice = Integer.MAX_VALUE;
          for (Identifier bedId : bedIds) {
            Bed bedInfo = Beds.getInstance().get(bedId);
            Tariff tariff = bedInfo.getTariffForDate(checkIn, checkOut);
            if (tariff.getPrice() > maxPrice) maxPrice = tariff.getPrice();
            if (tariff.getPrice() < minPrice) minPrice = tariff.getPrice();
          }
          FreeBedSummaryBean fbsBean =  new FreeBedSummaryBean();
          fbsBean.setMaxPrice(maxPrice);
          fbsBean.setMinPrice(minPrice);
          fbsBean.setNoOfBeds(bedIds.size());
          fbsBean.setStartDate(checkIn);
          fbsBean.setEndDate(checkOut);
          SearchBean<FreeBedSummaryBean> bean
            = new SearchBean<FreeBedSummaryBean>(getNextSearchId(), hostelId, fbsBean);
          result.add(bean);
        }

      }
    }
    catch (DataBaseReadWriteException | IdentifierNotFoundException | InvalidIdentifierException | InvalidParameterException e) {
      e.printStackTrace();
    }
    write(result);
    return result;
  }
  
  public <T extends InformationObject> ArrayList<SearchBean<T>> getLastSearchResult()
  {
    return read();
  }
  
  public Identifier AddUser(User info)
  {
    try {
      if (info.getContact() == null || info.getContact().getEmail() == null || info.getFirstName() == null ||
          info.getLastName() == null) {
        return null;
      }
      return Users.getInstance().create(info);
    } catch (DataBaseReadWriteException | IdentifierAlreadyExistsException
        | InvalidParameterException e) {
      System.err.println("Failed to Add user. " + e.getMessage());
      return null;
    }
  }
  
  public boolean ChangeUser(Identifier id, User info)
  {
    try {
      Users.getInstance().update(id, info);
      return true;
    } catch (DataBaseReadWriteException | InvalidParameterException
             | IdentifierNotFoundException | InvalidIdentifierException e) {
      System.err.println("Failed to change user. " + e.getMessage());
      return false;
    }
  }
    
  public Identifier BookBed(Identifier userId, Identifier searchId)
  {
    ArrayList<SearchBean<FreeBedDetailBean>> results = getLastSearchResult();
    for (SearchBean<FreeBedDetailBean> search : results) {
      if (search.getSearchId().equals(searchId)) {
        FreeBedDetailBean bedDetail = search.getObjectInfo();
        Identifier hostelId = search.getObjectId();
        Booking booking = new Booking();
        booking.setBedIds(bedDetail.getBedIds());
        ArrayList<Tariff> bedReservations = new ArrayList<Tariff>();
        for (int i = 0; i < booking.getBedIds().size(); i++) {
          Tariff tariff = new Tariff(bedDetail.getPrice().get(i), bedDetail.getCheckIn(), bedDetail.getCheckOut());
          bedReservations.add(tariff);
        }
        booking.setBedReservations(bedReservations);
        booking.setBookingDate(GenericUtility.getCurrentDateWithoutTime());
        booking.setHostelId(hostelId);
        booking.setStatus(BookingStatus.RESERVED);
        booking.setUserId(userId);
        
        try {
          return Bookings.getInstance().create(booking);
        } catch (DataBaseReadWriteException | IdentifierAlreadyExistsException
            | InvalidIdentifierException | InvalidParameterException
            | ConflictException | IdentifierNotFoundException e) {
        }
      }
    }
    return null;
  }
  
  public boolean CancelBooking(Identifier bookingId)
  {
    try {
      Bookings.getInstance().cancel(bookingId);
      return true;
    } catch (DataBaseReadWriteException | IdentifierNotFoundException
        | InvalidIdentifierException | InvalidParameterException e) {
      System.err.println(e.getMessage());
      return false;
    }
  }
  
  public Double getOccupancy(Hostel hostel, Date from, Date to)
  {
    Identifier hostelId = null;
    try {
      if (hostel != null) {
        ArrayList<Identifier> list = Hostels.getInstance().search(hostel);
        hostelId = list.get(0);
      }
      return Hostels.getInstance().getOccupancy(hostelId, from, to);
    }
    catch (DataBaseReadWriteException | InvalidParameterException | IdentifierNotFoundException | InvalidIdentifierException e)
    {
      return null;
    }
  }
  
  public Integer getRevenue(Hostel hostel, Date from, Date to)
  {
    Identifier hostelId = null;
    try {
      if (hostel != null) {
        ArrayList<Identifier> list = Hostels.getInstance().search(hostel);
        hostelId = list.get(0);
      }
      return Hostels.getInstance().getRevenue(hostelId, from, to);
    }
    catch (DataBaseReadWriteException | InvalidParameterException | IdentifierNotFoundException | InvalidIdentifierException e)
    {
      return null;
    }
  }
  
  public void dump()
  {
    // retrieve all hostels in the system
    try {
      ArrayList<Identifier> hostelIds = Hostels.getInstance().search(new Hostel());
      System.out.println("----- ALL HOSTELS IN THE SYSTEM -----");
      if (hostelIds.size() > 0) {
        for (Identifier hostelId : hostelIds) {
          Hostel hostelInfo = Hostels.getInstance().get(hostelId);
          System.out.println(hostelInfo.toString());
          // now dump all beds in this hostel
          System.out.println("----- ALL BEDS IN HOSTEL " +  hostelInfo.getName()  + "-----");
          Bed searchBed = new Bed();
          searchBed.setHostelId(hostelId);
          ArrayList<Identifier> bedIds = Beds.getInstance().search(searchBed);
          if (bedIds.size() > 0) {
            for (Identifier bedId : bedIds) {
              Bed bedInfo = Beds.getInstance().get(bedId);
              System.out.println(bedInfo.toString());
            }
          }
          else {
            System.out.println("no beds found.");
            System.out.println();
          }
          
          // now dump all the bookings in this hostel
          System.out.println("----- ALL BOOKINGS IN HOSTEL " +  hostelInfo.getName()  + "-----");
          Booking searchBooking = new Booking();
          searchBooking.setHostelId(hostelId);
          ArrayList<Identifier> bookingIds = Bookings.getInstance().search(searchBooking);
          if (bookingIds.size() > 0) {
            for (Identifier bookingId : bookingIds) {
              Booking bookingInfo = Bookings.getInstance().get(bookingId);
              System.out.println(bookingInfo.toString());
            }
          }
          else {
            System.out.println("no bookings found.");
            System.out.println();
          }
        }
      }
      else {
        System.out.println("No hostels found in the system.");
        System.out.println();
      }
      
      System.out.println("----- ALL USERS IN THE SYSTEM -----");
      ArrayList<Identifier> userIds = Users.getInstance().search(new User());
      if (userIds.size() > 0) {
        for (Identifier userId : userIds) {
          User userInfo = Users.getInstance().get(userId);
          System.out.println(userInfo.toString());
        }
      }
      else {
        System.out.println("No users found in the system.");
        System.out.println();
      }
      
    }
    catch (DataBaseReadWriteException | IdentifierNotFoundException | InvalidIdentifierException e) {
      // No hostels
      System.out.println("something wrong in the system.");
      return;
    }
  }
  
}
