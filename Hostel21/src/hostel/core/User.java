package hostel.core;

import java.util.Date;

public class User implements InformationObject{

  private static final long serialVersionUID = 1L;
  private String FirstName;
  private String LastName;
  private Date CreationDate;
  private Address Address;
  private Contact Contact;
  private Date ExpirationDate;
  private String CcCode;
  private String SecurityCode;
  
  /**
   * Copy Constructor
   *
   * @param userInfo a <code>UserInfo</code> object
   */
  public User(User userInfo) 
  {
      this.FirstName = userInfo.FirstName;
      this.LastName = userInfo.LastName;
      this.CreationDate = userInfo.CreationDate;
      this.Address = userInfo.Address;
      this.Contact = userInfo.Contact;
      this.ExpirationDate = userInfo.ExpirationDate;
      this.CcCode = userInfo.CcCode;
      this.SecurityCode = userInfo.SecurityCode;
  }

  public User()
  {
  }
 
  
  public User(String email, String firstName, String lastName, Date creationDate,
      Address address, Contact contact, Date expirationDate,
      String ccCode, String securityCode)
  {
    super();
    FirstName = firstName;
    LastName = lastName;
    CreationDate = creationDate;
    Address = address;
    Contact = contact;
    ExpirationDate = expirationDate;
    CcCode = ccCode;
    SecurityCode = securityCode;
  }
 

  public String getFirstName() {
    return FirstName;
  }

  public void setFirstName(String firstName) {
    FirstName = firstName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String lastName) {
    LastName = lastName;
  }

  public Date getCreationDate()
  {
    return CreationDate;
  }

  public void setCreationDate(Date creationDate)
  {
    CreationDate = creationDate;
  }

  public Address getAddress()
  {
    return Address;
  }

  public void setAddress(Address address)
  {
    Address = address;
  }

  public Contact getContact()
  {
    return Contact;
  }

  public void setContact(Contact contact)
  {
    Contact = contact;
  }

  public Date getExpirationDate()
  {
    return ExpirationDate;
  }

  public void setExpirationDate(Date expirationDate)
  {
    ExpirationDate = expirationDate;
  }

  public String getCcCode()
  {
    return CcCode;
  }

  public void setCcCode(String ccCode)
  {
    CcCode = ccCode;
  }

  public String getSecurityCode()
  {
    return SecurityCode;
  }

  public void setSecurityCode(String securityCode)
  {
    SecurityCode = securityCode;
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
    User other = (User) objectInfo;
    if (Address == null && other.Address != null) {
      return false;
    }
    else if (other.Address != null && !Address.match(other.Address))
      return false;
    if (CcCode == null && other.CcCode != null) {
      return false;
    }
    else if (other.CcCode != null && !CcCode.equals(other.CcCode))
      return false;
    
    if (Contact == null && other.Contact != null) {
        return false;
    }
    else if (other.Contact != null && !Contact.match(other.Contact))
      return false;
    
    if (CreationDate == null && other.CreationDate != null) {
      return false;
    }
    else if (other.CreationDate != null && !CreationDate.equals(other.CreationDate))
      return false;

    if (ExpirationDate == null && other.ExpirationDate != null) {
        return false;
    }
    else if (other.ExpirationDate != null && !ExpirationDate.equals(other.ExpirationDate))
      return false;
    if (FirstName == null && other.FirstName != null) {
      return false;
    }
    else if (other.FirstName != null && !FirstName.equals(other.FirstName))
      return false;
    
    if (LastName == null && other.LastName != null) {
      return false;
    }
    else if (other.LastName != null && !LastName.equals(other.LastName))
      return false;
    
    if (SecurityCode == null && other.SecurityCode != null) {
      return false;
    }
    else if (other.SecurityCode != null && !SecurityCode.equals(other.SecurityCode))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((Address == null) ? 0 : Address.hashCode());
    result = prime * result + ((CcCode == null) ? 0 : CcCode.hashCode());
    result = prime * result + ((Contact == null) ? 0 : Contact.hashCode());
    result = prime * result
        + ((CreationDate == null) ? 0 : CreationDate.hashCode());
    result = prime * result
        + ((ExpirationDate == null) ? 0 : ExpirationDate.hashCode());
    result = prime * result + ((FirstName == null) ? 0 : FirstName.hashCode());
    result = prime * result + ((LastName == null) ? 0 : LastName.hashCode());
    result = prime * result
        + ((SecurityCode == null) ? 0 : SecurityCode.hashCode());
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
    User other = (User) obj;
    if (Address == null) {
      if (other.Address != null)
        return false;
    } else if (!Address.equals(other.Address))
      return false;
    if (CcCode == null) {
      if (other.CcCode != null)
        return false;
    } else if (!CcCode.equals(other.CcCode))
      return false;
    if (Contact == null) {
      if (other.Contact != null)
        return false;
    } else if (!Contact.equals(other.Contact))
      return false;
    if (CreationDate == null) {
      if (other.CreationDate != null)
        return false;
    } else if (!CreationDate.equals(other.CreationDate))
      return false;
    if (ExpirationDate == null) {
      if (other.ExpirationDate != null)
        return false;
    } else if (!ExpirationDate.equals(other.ExpirationDate))
      return false;
    if (FirstName == null) {
      if (other.FirstName != null)
        return false;
    } else if (!FirstName.equals(other.FirstName))
      return false;
    if (LastName == null) {
      if (other.LastName != null)
        return false;
    } else if (!LastName.equals(other.LastName))
      return false;
    if (SecurityCode == null) {
      if (other.SecurityCode != null)
        return false;
    } else if (!SecurityCode.equals(other.SecurityCode))
      return false;
    return true;
  }

  public String toString()
  {
    final String EOL = System.getProperty( "line.separator" );
      
    String retValue = "";
    
    retValue = "User Details : " + EOL
        + "FirstName = " + this.FirstName + EOL
        + "LastName = " + this.LastName + EOL
        + "CreationDate = " + this.CreationDate + EOL
        + "Address = " + this.Address + EOL
        + "Contact = " + this.Contact + EOL
        + "ExpirationDate = " + this.ExpirationDate + EOL
        + "CcCode = " + this.CcCode + EOL
        + "SecurityCode = " + this.SecurityCode + EOL;

    return retValue;
  }
   
  
}
