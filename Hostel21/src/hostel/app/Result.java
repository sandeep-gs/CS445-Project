package hostel.app;

import hostel.collection.Beds;
import hostel.collection.Bookings;
import hostel.collection.Hostels;
import hostel.collection.Users;
import hostel.core.*;
import hostel.exception.DataBaseReadWriteException;
import hostel.exception.IdentifierNotFoundException;
import hostel.exception.InvalidIdentifierException;
import hostel.utility.GenericUtility;

import java.util.ArrayList;

public class Result<T>
{
  public enum DataType{
    FREE_BED_SUMMARY,
    FREE_BED_DETAILS,
    USER,
    BED,
    HOSTEL,
    BOOKING,
  }
  
  private ArrayList<T> Data;
  private DataType Type;
  
  public Result(ArrayList<T> data, DataType type) {
    Data = data;
    Type = type;
  }
  
  public void display()
  {
    if (Data == null) {
      return;
    }
    
    switch(Type) {
    case FREE_BED_SUMMARY:
      displayFreeBedSummary();
      break;
    case FREE_BED_DETAILS:
      displayFreeBedDetails();
      break;
    case BED:
      displayBed();
      break;
    case BOOKING:
      displayBooking();
      break;
    case HOSTEL:
      displayHostel();
      break;
    case USER:
      displayUser();
      break;
    default:
      break;

    }
  }
  
  
  private void displayHostel()
  {
    if (Data.size() == 0) {
      System.err.println("No results found for the input criteria");
      return;
    }
    
    try {
      @SuppressWarnings("unchecked")
      ArrayList<Identifier> hostels = (ArrayList<Identifier>) Data;
      for(Identifier id : hostels) {
          Hostel info = Hostels.getInstance().get(id);
          System.out.println();
          System.out.println("Hostel Id = "+ id.toString());
          System.out.println(info.toString());
      }
    }
    catch (DataBaseReadWriteException | IdentifierNotFoundException
        | InvalidIdentifierException e) {
      System.err.println("failed to display hostel details");
    }
    
  }
  
  private void displayBed()
  {
    if (Data.size() == 0) {
      System.err.println("No results found for the input criteria");
      return;
    }
    
    try {
      @SuppressWarnings("unchecked")
      ArrayList<Identifier> beds = (ArrayList<Identifier>) Data;
      for(Identifier id : beds) {
          Bed info = Beds.getInstance().get(id);
          System.out.println();
          System.out.println("Bed Id = "+ id.toString());
          System.out.println(info.toString());
      }
    }
    catch (DataBaseReadWriteException | IdentifierNotFoundException
        | InvalidIdentifierException e) {
      System.err.println("Invalid Id or Id not found.");
    }
    
  }
  
  private void displayBooking()
  {
    
    if (Data.size() == 0) {
      System.err.println("No results found for the input criteria");
      return;
    }
    try {
      @SuppressWarnings("unchecked")
      ArrayList<Identifier> bookings = (ArrayList<Identifier>) Data;
      for(Identifier id : bookings) {
          Booking info = Bookings.getInstance().get(id);
          /*System.out.println();
          System.out.println("Booking Id = "+ id.toString());
          System.out.println("Hostel = "+ Hostels.getInstance().get(info.getHostelId()).getName());
          System.out.println("No of beds = " + info.getBedIds().size());
          System.out.println("Bed Details: ");
          String bedNos = new String();
          for (Identifier bedId : info.getBedIds()) {
            Bed bedInfo = Beds.getInstance().get(bedId);
            bedNos += ("bed no " + bedInfo.getNumber().toString() + " in room no " + bedInfo.getRoomNo().toString() + "   ");
          }
          System.out.println(bedNos);
          System.out.println("Status = " + info.getStatus().toString());
          System.out.println("User Id = " + info.getUserId().toString());*/
          System.out.println("Booking Id : " + id.toString());
          System.out.println(info.toString());
      }
    }
    catch (DataBaseReadWriteException | IdentifierNotFoundException
        | InvalidIdentifierException e) {
      System.err.println("Invalid Id or Id not found.");
    }   
  }
   
  private void displayUser()
  {
    if (Data.size() == 0) {
      System.err.println("No results found for the input criteria");
      return;
    }
    try {
      @SuppressWarnings("unchecked")
      ArrayList<Identifier> users = (ArrayList<Identifier>) Data;
      for(Identifier id : users) {
          User info = Users.getInstance().get(id);
          System.out.println();
          System.out.println("User Id = "+ id.toString());
          System.out.println(info.toString());
      }
    }
    catch (DataBaseReadWriteException | IdentifierNotFoundException
        | InvalidIdentifierException e) {
      System.err.println("Invalid Id or Id not found.");
    }    
  }
  
  
  private void displayFreeBedSummary()
  {
    try {
      if (Data.size() == 0) {
        System.err.println("No results found for the input criteria");
        return;
      }
      
      for (T data : Data) {
        @SuppressWarnings("rawtypes")
        SearchBean bean = (SearchBean)data;
        FreeBedSummaryBean summary = (FreeBedSummaryBean)bean.getObjectInfo();
        String hostelName = Hostels.getInstance().get(bean.getObjectId()).getName();
        System.out.println("Hostel : " + hostelName + ", From " + summary.getStartDate().toString()
            + " to " + summary.getEndDate().toString() + ": " + summary.getNoOfBeds() + " beds available between $"
            + summary.getMinPrice().toString() + " to $" + summary.getMaxPrice().toString());
      }
    }
      catch (DataBaseReadWriteException | IdentifierNotFoundException
        | InvalidIdentifierException e) {
      e.printStackTrace();
    }
  }

  private void displayFreeBedDetails()
  {
    try {
      if (Data.size() == 0) {
        System.err.println("No results found for the input criteria");
        return;
      }
      
      for (T data : Data) {
        @SuppressWarnings("unchecked")
        SearchBean<FreeBedDetailBean> bean = (SearchBean<FreeBedDetailBean>) data;
        FreeBedDetailBean detail = (FreeBedDetailBean)bean.getObjectInfo();
        String hostelName = Hostels.getInstance().get(bean.getObjectId()).getName();
        System.out.println("Search Id: " + bean.getSearchId().toString() + ", Hostel : " + hostelName + ", "
            + "Total Price " + detail.getTotalPrice());
        ArrayList<Identifier> bedIds = detail.getBedIds();
        for (int i = 0; i < bedIds.size(); i++) {
          Bed bedInfo = Beds.getInstance().get(bedIds.get(i));
          System.out.println("\tBed number = " + bedInfo.getNumber().toString() + " Room No =" + bedInfo.getRoomNo()
           + " price per day = " + detail.getTotalPrice() / GenericUtility.getDiffDays(detail.getCheckOut(), detail.getCheckIn())+ ".");
        }
        System.out.println();
        System.out.println();
      }
    }
      catch (DataBaseReadWriteException | IdentifierNotFoundException
        | InvalidIdentifierException e) {
      e.printStackTrace();
    }
  }


}

