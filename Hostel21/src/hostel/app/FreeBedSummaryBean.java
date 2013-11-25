package hostel.app;

import java.util.Date;

import hostel.core.InformationObject;

public class FreeBedSummaryBean implements InformationObject
{
  private static final long serialVersionUID = 1L;
  
  private Date StartDate;
  private Date EndDate;
  private Integer NoOfBeds;
  private Integer MinPrice;
  private Integer MaxPrice;
   
  public Date getStartDate() {
    return StartDate;
  }

  public void setStartDate(Date startDate) {
    StartDate = startDate;
  }

  public Date getEndDate() {
    return EndDate;
  }

  public void setEndDate(Date endDate) {
    EndDate = endDate;
  }

  public Integer getNoOfBeds() {
    return NoOfBeds;
  }

  public void setNoOfBeds(Integer noOfBeds) {
    NoOfBeds = noOfBeds;
  }

  public Integer getMinPrice() {
    return MinPrice;
  }

  public void setMinPrice(Integer minPrice) {
    MinPrice = minPrice;
  }

  public Integer getMaxPrice() {
    return MaxPrice;
  }

  public void setMaxPrice(Integer maxPrice) {
    MaxPrice = maxPrice;
  }

    
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((EndDate == null) ? 0 : EndDate.hashCode());
    result = prime * result + ((MaxPrice == null) ? 0 : MaxPrice.hashCode());
    result = prime * result + ((MinPrice == null) ? 0 : MinPrice.hashCode());
    result = prime * result + ((NoOfBeds == null) ? 0 : NoOfBeds.hashCode());
    result = prime * result + ((StartDate == null) ? 0 : StartDate.hashCode());
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
    FreeBedSummaryBean other = (FreeBedSummaryBean) obj;
    if (EndDate == null) {
      if (other.EndDate != null)
        return false;
    } else if (!EndDate.equals(other.EndDate))
      return false;
    if (MaxPrice == null) {
      if (other.MaxPrice != null)
        return false;
    } else if (!MaxPrice.equals(other.MaxPrice))
      return false;
    if (MinPrice == null) {
      if (other.MinPrice != null)
        return false;
    } else if (!MinPrice.equals(other.MinPrice))
      return false;
    if (NoOfBeds == null) {
      if (other.NoOfBeds != null)
        return false;
    } else if (!NoOfBeds.equals(other.NoOfBeds))
      return false;
    if (StartDate == null) {
      if (other.StartDate != null)
        return false;
    } else if (!StartDate.equals(other.StartDate))
      return false;
    return true;
  }

  public boolean match(InformationObject obj)
  {
    return equals(obj);
  }

}
