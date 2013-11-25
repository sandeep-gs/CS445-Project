package hostel.core;

public class Address implements InformationObject {
  private static final long serialVersionUID = 1L;
  private String StreetAddress;
	private String City;
	private String State;
	private String Country;
	private String PIN;
	
	public Address() {}
	
  public Address(Address addressInfo) 
  {
      if (addressInfo == null) return;
      this.StreetAddress = addressInfo.StreetAddress;
      this.City = addressInfo.City;
      this.State = addressInfo.State;
      this.Country = addressInfo.Country;
      this.PIN = addressInfo.PIN;
  }

  public Address(String streetAddress,
              			 String city,
              			 String state,
              			 String country,
              			 String pin)
	{
	  this.StreetAddress = streetAddress;
	  this.City = city;
	  this.State = state;
	  this.Country = country;
	  this.PIN = pin;
	};
	
	
  public String getStreetAddress()
  {
    return StreetAddress;
  }

  public String getCity()
  {
    return City;
  }

  public void setStreetAddress(String streetAddress)
  {
    StreetAddress = streetAddress;
  }

  public void setCity(String city)
  {
    City = city;
  }

  public void setState(String state)
  {
    State = state;
  }

  public void setCountry(String country)
  {
    Country = country;
  }

  public void setPIN(String pIN)
  {
    PIN = pIN;
  }

  public String getState()
  {
    return State;
  }

  public String getCountry()
  {
    return Country;
  }

  public String getPIN()
  {
    return PIN;
  }

  @Override
  public boolean match(InformationObject info)
  {
    if (this == info)
      return true;
    if (info == null)
      return false;
    if (getClass() != info.getClass())
      return false;
    Address other = (Address) info;
    if (City == null) {
      if (other.City != null)
        return false;
    }
    else if (other.City != null && !City.equals(other.City))
      return false;
    if (Country == null) {
      if (other.Country != null)
        return false;
    }
    else if (other.Country != null && !Country.equals(other.Country))
      return false;
    if (PIN == null) {
      if (other.PIN != null)
        return false;
    }
    else if (other.PIN != null && !PIN.equals(other.PIN))
      return false;
    if (State == null) {
      if (other.State != null)
        return false;
    }
    else if (other.State != null && !State.equals(other.State))
      return false;
    if (StreetAddress == null) {
      if (other.StreetAddress != null)
        return false;
    }
    else if (other.StreetAddress != null && !StreetAddress.equals(other.StreetAddress))
      return false;
    return true;
  }
  
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((City == null) ? 0 : City.hashCode());
    result = prime * result + ((Country == null) ? 0 : Country.hashCode());
    result = prime * result + ((PIN == null) ? 0 : PIN.hashCode());
    result = prime * result + ((State == null) ? 0 : State.hashCode());
    result = prime * result
        + ((StreetAddress == null) ? 0 : StreetAddress.hashCode());
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
    Address other = (Address) obj;
    if (City == null) {
      if (other.City != null)
        return false;
    }
    else if (!City.equals(other.City))
      return false;
    if (Country == null) {
      if (other.Country != null)
        return false;
    }
    else if (!Country.equals(other.Country))
      return false;
    if (PIN == null) {
      if (other.PIN != null)
        return false;
    }
    else if (!PIN.equals(other.PIN))
      return false;
    if (State == null) {
      if (other.State != null)
        return false;
    }
    else if (!State.equals(other.State))
      return false;
    if (StreetAddress == null) {
      if (other.StreetAddress != null)
        return false;
    }
    else if (!StreetAddress.equals(other.StreetAddress))
      return false;
    return true;
  }

  public String toString()
  {
      final String EOL = System.getProperty( "line.separator" );
      
      String retValue = "";
      
      retValue = "Address :" + EOL
          + "StreetAddress = " + this.StreetAddress + EOL
          + "City = " + this.City + EOL
          + "State = " + this.State + EOL
          + "Country = " + this.Country + EOL
          + "PIN = " + this.PIN + EOL;
  
      return retValue;
  }
  
  
  
  
  
}

