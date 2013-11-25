package hostel.app;

import java.util.ArrayList;
import java.util.Date;

import hostel.core.Identifier;
import hostel.core.InformationObject;

public class FreeBedDetailBean implements InformationObject
{
  private static final long serialVersionUID = 1L;
  
  private Date CheckIn;
  private Date CheckOut;
  private Integer TotalPrice;
  private ArrayList<Identifier> BedIds;
  private ArrayList<Integer> Price;
    
  public Date getCheckIn() {
    return CheckIn;
  }

  public void setCheckIn(Date checkIn) {
    CheckIn = checkIn;
  }

  public Date getCheckOut() {
    return CheckOut;
  }

  public void setCheckOut(Date checkOut) {
    CheckOut = checkOut;
  }

  public Integer getTotalPrice() {
    return TotalPrice;
  }

  public void setTotalPrice(Integer totalPrice) {
    TotalPrice = totalPrice;
  }

  public ArrayList<Identifier> getBedIds() {
    return BedIds;
  }

  public void setBedIds(ArrayList<Identifier> bedIds) {
    BedIds = bedIds;
  }

  public ArrayList<Integer> getPrice() {
    return Price;
  }

  public void setPrice(ArrayList<Integer> price) {
    Price = price;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((BedIds == null) ? 0 : BedIds.hashCode());
    result = prime * result + ((CheckIn == null) ? 0 : CheckIn.hashCode());
    result = prime * result + ((CheckOut == null) ? 0 : CheckOut.hashCode());
    result = prime * result + ((Price == null) ? 0 : Price.hashCode());
    result = prime * result
        + ((TotalPrice == null) ? 0 : TotalPrice.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    FreeBedDetailBean other = (FreeBedDetailBean) obj;
    if (BedIds == null) {
      if (other.BedIds != null)
        return false;
    } else if (!BedIds.equals(other.BedIds))
      return false;
    if (CheckIn == null) {
      if (other.CheckIn != null)
        return false;
    } else if (!CheckIn.equals(other.CheckIn))
      return false;
    if (CheckOut == null) {
      if (other.CheckOut != null)
        return false;
    } else if (!CheckOut.equals(other.CheckOut))
      return false;
    if (Price == null) {
      if (other.Price != null)
        return false;
    } else if (!Price.equals(other.Price))
      return false;
    if (TotalPrice == null) {
      if (other.TotalPrice != null)
        return false;
    } else if (!TotalPrice.equals(other.TotalPrice))
      return false;
    return true;
  }

  @Override
  public boolean match(InformationObject obj) {
    return equals(obj);
  }
}
