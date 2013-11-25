package hostel.core;
import java.util.Date;

public class Tariff implements InformationObject {
  private static final long serialVersionUID = 1L;
  private Integer Price;
  private Date StartDate;
  private Date EndDate;
  
  
  public Tariff() {}

  public Tariff(Integer price, Date startDate, Date endDate)
  {
    super();
    Price = price;
    StartDate = startDate;
    EndDate = endDate;
  }

  public Tariff(Tariff tariff) 
  {
      this.Price = tariff.Price;
      this.StartDate = (Date)tariff.StartDate.clone();
      this.EndDate = (Date)tariff.EndDate.clone();
  }

  public Integer getPrice()
  {
    return Price;
  }

  public void setPrice(Integer price)
  {
    Price = price;
  }

  public Date getStartDate()
  {
    return StartDate;
  }

  public void setStartDate(Date startDate)
  {
    StartDate = startDate;
  }

  public Date getEndDate()
  {
    return EndDate;
  }

  public void setEndDate(Date endDate)
  {
    EndDate = endDate;
  }

  public boolean match(InformationObject objectInfo)
  {
    if (this == objectInfo)
      return true;
    if (objectInfo == null)
      return false;
    if (getClass() != objectInfo.getClass())
      return false;
    Tariff other = (Tariff) objectInfo;
    
    if (EndDate == null && other.EndDate != null) {
        return false;
    }
    else if (other.EndDate != null && !EndDate.equals(other.EndDate))
      return false;

    if (Price == null && other.Price != null) {
        return false;
    }
    else if (other.Price != null && !Price.equals(other.Price))
      return false;
    
    if (StartDate == null && other.StartDate != null) {
      return false;
    }
    else if (other.StartDate != null && !StartDate.equals(other.StartDate))
      return false;
    
    return true;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((EndDate == null) ? 0 : EndDate.hashCode());
    result = prime * result + ((Price == null) ? 0 : Price.hashCode());
    result = prime * result
        + ((StartDate == null) ? 0 : StartDate.hashCode());
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
    Tariff other = (Tariff) obj;
    if (EndDate == null) {
      if (other.EndDate != null)
        return false;
    }
    else if (!EndDate.equals(other.EndDate))
      return false;
    if (Price == null) {
      if (other.Price != null)
        return false;
    }
    else if (!Price.equals(other.Price))
      return false;
    if (StartDate == null) {
      if (other.StartDate != null)
        return false;
    }
    else if (!StartDate.equals(other.StartDate))
      return false;
    return true;
  }

  /**
   * Constructs a <code>String</code> with all attributes
   * in name = value format.
   *
   * @return a <code>String</code> representation 
   * of this object.
   */
  public String toString()
  {
    final String EOL = System.getProperty( "line.separator" );
      
    String retValue = "";
    
    retValue = "Tariff : " + EOL
        + "Price = " + this.Price + EOL
        + "Start Date = " + this.StartDate + EOL
        + "End Date = " + this.EndDate + EOL;

    return retValue;
  }

}