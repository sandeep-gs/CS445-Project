package hostel.core;

public class Policy implements InformationObject
{
  private static final long serialVersionUID = 1L;
  private String CheckInTime;
  private String CheckOutTime;
  private String AlcoholPolicy;
  private String SmokingPolicy;
  private Integer CancellationDeadLine;
  private Integer CancellationPenalty;
  
  
  public Policy(Policy contactInfo) 
  {
      this.CheckInTime = contactInfo.CheckInTime;
      this.CheckOutTime = contactInfo.CheckOutTime;
      this.AlcoholPolicy = contactInfo.AlcoholPolicy;
      this.SmokingPolicy = contactInfo.SmokingPolicy;
      this.CancellationDeadLine = contactInfo.CancellationDeadLine;
      this.CancellationPenalty = contactInfo.CancellationPenalty;
  }

  public Policy() {}
  
  public Policy(String checkInTime, String checkOutTime, String alcoholPolicy, String smokingPolicy,
      Integer cancellationDeadLine, Integer cancellationPenalty)
  {
    super();
    CheckInTime = checkInTime;
    CheckOutTime = checkOutTime;
    AlcoholPolicy = alcoholPolicy;
    SmokingPolicy = smokingPolicy;
    CancellationDeadLine = cancellationDeadLine;
    CancellationPenalty = cancellationPenalty;
  }

  public String getCheckInTime()
  {
    return CheckInTime;
  }

  public void setCheckInTime(String checkInTime)
  {
    CheckInTime = checkInTime;
  }

  public String getCheckOutTime()
  {
    return CheckOutTime;
  }

  public void setCheckOutTime(String checkOutTime)
  {
    CheckOutTime = checkOutTime;
  }

  public String getAlcoholPolicy()
  {
    return AlcoholPolicy;
  }

  public void setAlcoholPolicy(String alcoholPolicy)
  {
    AlcoholPolicy = alcoholPolicy;
  }

  public String getSmokingPolicy()
  {
    return SmokingPolicy;
  }

  public void setSmokingPolicy(String smokingPolicy)
  {
    SmokingPolicy = smokingPolicy;
  }
 
  public Integer getCancellationDeadLine() {
    return CancellationDeadLine;
  }

  public void setCancellationDeadLine(Integer cancellationDeadLine) {
    CancellationDeadLine = cancellationDeadLine;
  }

  public Integer getCancellationPenalty() {
    return CancellationPenalty;
  }

  public void setCancellationPenalty(Integer cancellationPenalty) {
    CancellationPenalty = cancellationPenalty;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((AlcoholPolicy == null) ? 0 : AlcoholPolicy.hashCode());
    result = prime
        * result
        + ((CancellationDeadLine == null) ? 0 : CancellationDeadLine.hashCode());
    result = prime * result
        + ((CancellationPenalty == null) ? 0 : CancellationPenalty.hashCode());
    result = prime * result
        + ((CheckInTime == null) ? 0 : CheckInTime.hashCode());
    result = prime * result
        + ((CheckOutTime == null) ? 0 : CheckOutTime.hashCode());
    result = prime * result
        + ((SmokingPolicy == null) ? 0 : SmokingPolicy.hashCode());
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
    Policy other = (Policy) obj;
    if (AlcoholPolicy == null) {
      if (other.AlcoholPolicy != null)
        return false;
    } else if (!AlcoholPolicy.equals(other.AlcoholPolicy))
      return false;
    if (CancellationDeadLine == null) {
      if (other.CancellationDeadLine != null)
        return false;
    } else if (!CancellationDeadLine.equals(other.CancellationDeadLine))
      return false;
    if (CancellationPenalty == null) {
      if (other.CancellationPenalty != null)
        return false;
    } else if (!CancellationPenalty.equals(other.CancellationPenalty))
      return false;
    if (CheckInTime == null) {
      if (other.CheckInTime != null)
        return false;
    } else if (!CheckInTime.equals(other.CheckInTime))
      return false;
    if (CheckOutTime == null) {
      if (other.CheckOutTime != null)
        return false;
    } else if (!CheckOutTime.equals(other.CheckOutTime))
      return false;
    if (SmokingPolicy == null) {
      if (other.SmokingPolicy != null)
        return false;
    } else if (!SmokingPolicy.equals(other.SmokingPolicy))
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
    Policy other = (Policy) objectInfo;
    if (AlcoholPolicy == null) {
      if (other.AlcoholPolicy != null)
        return false;
    }
    else if (other.AlcoholPolicy != null && !AlcoholPolicy.equals(other.AlcoholPolicy))
      return false;
    if (CheckInTime == null) {
      if (other.CheckInTime != null)
        return false;
    }
    else if (other.CheckInTime != null && !CheckInTime.equals(other.CheckInTime))
      return false;
    if (CheckOutTime == null) {
      if (other.CheckOutTime != null)
        return false;
    }
    else if (other.CheckOutTime != null && !CheckOutTime.equals(other.CheckOutTime))
      return false;
    if (SmokingPolicy == null) {
      if (other.SmokingPolicy != null)
        return false;
    }
    else if (other.SmokingPolicy != null && !SmokingPolicy.equals(other.SmokingPolicy))
      return false;
    
    if (CancellationDeadLine == null) {
      if (other.CancellationDeadLine != null)
        return false;
    } else if (other.CancellationDeadLine != null && !CancellationDeadLine.equals(other.CancellationDeadLine))
      return false;
    
    if (CancellationPenalty == null) {
      if (other.CancellationPenalty != null)
        return false;
    } else if (other.CancellationPenalty != null && !CancellationPenalty.equals(other.CancellationPenalty))
      return false;
    
    return true;
  }

  public String toString()
  {
    final String EOL = System.getProperty( "line.separator" );
      
    String retValue = "";
    
    retValue = "Policy :"  + EOL
        + "CheckIn Time = " + this.CheckInTime + EOL
        + "CheckOut Time = " + this.CheckOutTime + EOL
        + "Alcohol Policy = " + this.AlcoholPolicy + EOL
        + "Smoking Policy = " + this.SmokingPolicy + EOL
        + "Cancellation DeadLine = " + this.CancellationDeadLine + EOL
        + "Cancellation Penalty = " + this.CancellationPenalty + EOL;

    return retValue;
  }
 
}
