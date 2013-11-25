package hostel.core;

import java.util.ArrayList;
import java.util.Date;

public class Booking implements InformationObject {
  private static final long serialVersionUID = 1L;

  public enum BookingStatus {
    RESERVED,
    CANCELLED,
    CLOSED,
    UNKNOWN
  };
  private Identifier UserId;
  private Identifier HostelId;
  private ArrayList<Identifier> BedIds;
  private ArrayList<Tariff> BedReservations;
  private Date BookingDate;
  private BookingStatus Status;

  public Booking(Booking bookingInfo)
  {
      this.UserId = bookingInfo.UserId;
      this.HostelId = bookingInfo.HostelId;
      this.BedIds = bookingInfo.BedIds;
      this.BookingDate = bookingInfo.BookingDate;
      if (bookingInfo.BedReservations != null) {
        this.BedReservations = new ArrayList<Tariff>();
        for (Tariff tr : bookingInfo.BedReservations)
          this.BedReservations.add(new Tariff(tr));
      }
      this.Status = bookingInfo.Status;
  }

  public Booking()
  {
    Status = BookingStatus.UNKNOWN;
  }

  public Booking(Identifier userId, Identifier hostelId,
      ArrayList<Identifier> bedIds, ArrayList<Tariff> bedReservations,
      Date bookingDate, BookingStatus status)
  {
    super();
    UserId = userId;
    HostelId = hostelId;
    BedIds = bedIds;
    BedReservations = bedReservations;
    BookingDate = bookingDate;
    Status = status;
  }
  
  public Identifier getUserId()
  {
    return UserId;
  }

  public void setUserId(Identifier userId)
  {
    UserId = userId;
  }

  public Identifier getHostelId()
  {
    return HostelId;
  }

  public void setHostelId(Identifier hostelId)
  {
    HostelId = hostelId;
  }

  public ArrayList<Identifier> getBedIds()
  {
    return BedIds;
  }

  public void setBedIds(ArrayList<Identifier> bedIds)
  {
    BedIds = bedIds;
  }

  public ArrayList<Tariff> getBedReservations()
  {
    return BedReservations;
  }

  public void setBedReservations(ArrayList<Tariff> bedReservations)
  {
    BedReservations = bedReservations;
  }

  public Date getBookingDate()
  {
    return BookingDate;
  }

  public void setBookingDate(Date bookingDate)
  {
    BookingDate = bookingDate;
  }

  public BookingStatus getStatus()
  {
    return Status;
  }

  public void setStatus(BookingStatus status)
  {
    Status = status;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((BedIds == null) ? 0 : BedIds.hashCode());
    result = prime * result
        + ((BedReservations == null) ? 0 : BedReservations.hashCode());
    result = prime * result
        + ((BookingDate == null) ? 0 : BookingDate.hashCode());
    result = prime * result + ((HostelId == null) ? 0 : HostelId.hashCode());
    result = prime * result + ((Status == null) ? 0 : Status.hashCode());
    result = prime * result + ((UserId == null) ? 0 : UserId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Booking other = (Booking) obj;
    if (BedIds == null) {
      if (other.BedIds != null)
        return false;
    }
    else if (!BedIds.equals(other.BedIds))
      return false;
    if (BedReservations == null) {
      if (other.BedReservations != null)
        return false;
    }
    else if (!BedReservations.equals(other.BedReservations))
      return false;
    if (BookingDate == null) {
      if (other.BookingDate != null)
        return false;
    }
    else if (!BookingDate.equals(other.BookingDate))
      return false;
    if (HostelId == null) {
      if (other.HostelId != null)
        return false;
    }
    else if (!HostelId.equals(other.HostelId))
      return false;
    if (Status != other.Status)
      return false;
    if (UserId == null) {
      if (other.UserId != null)
        return false;
    }
    else if (!UserId.equals(other.UserId))
      return false;
    return true;
  }
  
  @Override
  public boolean match(InformationObject objectInfo)
  {
    if (this == objectInfo)
      return true;
    if (objectInfo == null)
      return false;
    if (getClass() != objectInfo.getClass())
      return false;
    Booking other = (Booking) objectInfo;
    
    if (BedIds == null && other.BedIds != null) {
      return false;
    }
    else if (other.BedIds != null) {
      for (Identifier id1 : other.BedIds) {
        boolean missMatchFound = true;
        for (Identifier id2 : BedIds) {
          if (id2.match(id1)) {
            missMatchFound = false;
            break;
          }
        }
        if (missMatchFound) {
          return false;
        }
      }
    }
    
    if (other.BedReservations != null && BedReservations == null) {
      return false;
    }
    else if (other.BedReservations != null) {
      for (Tariff tr1 : other.BedReservations) {
        boolean missMatchFound = true;
        for (Tariff tr2 : BedReservations) {
          if (tr2.match(tr1)) {
            missMatchFound = false;
            break;
          }
        }
        if (missMatchFound) {
          return false;
        }
      }
    }
    if (BookingDate == null && other.BookingDate != null) {
      return false;
    }
    else if (other.BookingDate != null && !BookingDate.equals(other.BookingDate))
      return false;
    if (HostelId == null && other.HostelId != null) {
      return false;
    }
    else if (other.HostelId != null && !HostelId.equals(other.HostelId))
      return false;
    if (Status == BookingStatus.UNKNOWN && other.Status != BookingStatus.UNKNOWN)
      return false;
    if (other.Status != BookingStatus.UNKNOWN && !(other.Status == Status)) {
      return false;
    }
    if (UserId == null && other.UserId != null) {
      return false;
    }
    else if (other.UserId != null && !UserId.equals(other.UserId))
      return false;
        
    return true;
  }

  public String toString()
  {
    final String EOL = System.getProperty( "line.separator" );
      
    String retValue = "";
    
    retValue = "Booking Details : " + EOL
        + "User Id = " + this.UserId + EOL
        + "Hostel Id = " + this.HostelId + EOL
        + "Booked Bed Ids = " + this.BedIds + EOL
        + "Tariff for the beds = " + this.BedReservations + EOL
        + "Booking Date = " + this.BookingDate + EOL
        + "Status = " + this.Status + EOL;

    return retValue;
  }
  
  
}
