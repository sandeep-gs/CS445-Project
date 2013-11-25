package hostel.core;

import hostel.utility.GenericUtility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class Bed implements InformationObject {
  private static final long serialVersionUID = 1L;
  private Integer Number;
  private Integer RoomNo;
  private Identifier HostelId;
  private ArrayList<Tariff> BedTariff;
  
  public Bed(Bed bedInfo) 
  {
      this.Number = bedInfo.Number;
      this.HostelId = bedInfo.HostelId;
      this.RoomNo = bedInfo.RoomNo;
      this.BedTariff = bedInfo.BedTariff;
  }


  public Bed() { }
   
  public Bed(Integer number, Integer roomNo, Identifier hostelId, ArrayList<Tariff> bedTariff)
  {
    super();
    Number = number;
    RoomNo = roomNo;
    HostelId = hostelId;
    BedTariff = bedTariff;
  }


  public Integer getRoomNo()
  {
    return RoomNo;
  }


  public void setRoomNo(Integer roomNo)
  {
    RoomNo = roomNo;
  }


  public Identifier getHostelId()
  {
    return HostelId;
  }


  public void setHostelId(Identifier hostelId)
  {
    HostelId = hostelId;
  }


  public ArrayList<Tariff> getTariff()
  {
    return BedTariff;
  }

  public void setTariff(ArrayList<Tariff> bedTariff)
  {
    BedTariff = bedTariff;
  }
  
  public Tariff getTariffForDate(Date date)
  {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, 1);
    return getTariffForDate(date, cal.getTime());
  }
  
  public Tariff getTariffForDate(Date start, Date end)
  {
    int price = 0;
    if (BedTariff.size() > 0 && (start.after(BedTariff.get(0).getStartDate())
        || start.equals(BedTariff.get(0).getStartDate()))) {
      for (Tariff tr : BedTariff) {
        if (tr.getEndDate() != null && start.after(tr.getEndDate())) {
          continue;
        }
        if (tr.getEndDate() == null || end.before(tr.getEndDate()) || end.equals(tr.getEndDate())) {
          if (start.after(tr.getStartDate()) || start.equals(tr.getStartDate())) {
            price += (tr.getPrice()*GenericUtility.getDiffDays(end, start));
          }
          else {
            price += (tr.getPrice()*GenericUtility.getDiffDays(end, tr.getStartDate()));
          }
          return new Tariff(new Integer(price), start, end);
        }
        else {
          if (start.after(tr.getStartDate())) {
            price += ((GenericUtility.getDiffDays(tr.getEndDate(), start) + 1)*tr.getPrice());
          }
          else {
            price += ((GenericUtility.getDiffDays(tr.getEndDate(), tr.getStartDate()) + 1)*tr.getPrice());
          }
          
        }
      }
    }
    return null;
  }

  public Integer getNumber()
  {
    return Number;
  }

  public void setNumber(Integer number)
  {
    Number = number;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((BedTariff == null) ? 0 : BedTariff.hashCode());
    result = prime * result + ((HostelId == null) ? 0 : HostelId.hashCode());
    result = prime * result + ((Number == null) ? 0 : Number.hashCode());
    result = prime * result + ((RoomNo == null) ? 0 : RoomNo.hashCode());
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
    Bed other = (Bed) obj;
    if (BedTariff == null) {
      if (other.BedTariff != null)
        return false;
    }
    else if (!BedTariff.equals(other.BedTariff))
      return false;
    if (HostelId == null) {
      if (other.HostelId != null)
        return false;
    }
    else if (!HostelId.equals(other.HostelId))
      return false;
    if (Number == null) {
      if (other.Number != null)
        return false;
    }
    else if (!Number.equals(other.Number))
      return false;
    if (RoomNo == null) {
      if (other.RoomNo != null)
        return false;
    }
    else if (!RoomNo.equals(other.RoomNo))
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
    Bed other = (Bed) objectInfo;
    
    
    if (BedTariff == null && other.BedTariff != null) {
      return false;
    }
    else if (other.BedTariff != null) {
      for (Tariff tr1 : other.BedTariff) {
        boolean missMatchFound = true;
        for (Tariff tr2 : BedTariff) {
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
    
    if (Number == null) {
      if (other.Number != null)
        return false;
    }
    else if (other.Number != null && !Number.equals(other.Number))
      return false;
    if (RoomNo == null) {
      if (other.RoomNo != null)
        return false;
    }
    else if (other.RoomNo!= null && !RoomNo.equals(other.RoomNo))
      return false;
    if (HostelId == null) {
      if (other.HostelId != null)
        return false;
    }
    else if (other.HostelId!= null && !HostelId.equals(other.HostelId))
      return false;
    return true;
  }

  public String toString()
  {
    final String EOL = System.getProperty( "line.separator" );
      
    String retValue = "";
    
    retValue = "Bed Details : " + EOL
        + "Number = " + this.Number + EOL
        + "Room No = " + this.RoomNo + EOL
        + "Hostel Id = " + this.HostelId + EOL
        + "Bed Tariffs = " + this.BedTariff + EOL;

    return retValue;
  }



  
  
}
