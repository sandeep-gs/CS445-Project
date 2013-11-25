package hostel.core;

import java.util.ArrayList;

public class Hostel implements InformationObject {
  private static final long serialVersionUID = 1L;
  private String Name;
  private Address Address;
  private Contact Contact;
  private Policy HostelPoliy;
  private ArrayList<Identifier> Beds;

  public Hostel(Hostel hostelInfo) 
  {
    this.Name = hostelInfo.Name;
    this.Address = hostelInfo.Address;
    this.Contact = hostelInfo.Contact;
    this.HostelPoliy = hostelInfo.HostelPoliy;
    this.Beds = hostelInfo.Beds;
  }


  public Hostel() {}


  public Hostel(String name, Address address, Contact contact,
      Policy policy, ArrayList<Identifier> beds)
  {
    super();
    Name = name;
    Address = address;
    Contact = contact;
    HostelPoliy = policy;
    Beds = beds;
  }


  public String getName()
  {
    return Name;
  }


  public void setName(String name)
  {
    Name = name;
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


  public Policy getPolicy()
  {
    return HostelPoliy;
  }


  public void setPolicy(Policy policy)
  {
    HostelPoliy = policy;
  }


  public ArrayList<Identifier> getBeds()
  {
    return Beds;
  }


  public void setBeds(ArrayList<Identifier> beds)
  {
    Beds = beds;
  }


  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((Address == null) ? 0 : Address.hashCode());
    result = prime * result + ((Beds == null) ? 0 : Beds.hashCode());
    result = prime * result + ((Contact == null) ? 0 : Contact.hashCode());
    result = prime * result + ((Name == null) ? 0 : Name.hashCode());
    result = prime * result + ((HostelPoliy == null) ? 0 : HostelPoliy.hashCode());
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
    Hostel other = (Hostel) obj;
    if (Address == null) {
      if (other.Address != null)
        return false;
    }
    else if (!Address.equals(other.Address))
      return false;
    if (Beds == null) {
      if (other.Beds != null)
        return false;
    }
    else if (!Beds.equals(other.Beds))
      return false;
    if (Contact == null) {
      if (other.Contact != null)
        return false;
    }
    else if (!Contact.equals(other.Contact))
      return false;
    if (Name == null) {
      if (other.Name != null)
        return false;
    }
    else if (!Name.equals(other.Name))
      return false;
    if (HostelPoliy == null) {
      if (other.HostelPoliy != null)
        return false;
    }
    else if (!HostelPoliy.equals(other.HostelPoliy))
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
    Hostel other = (Hostel) objectInfo;
    if (Address == null && other.Address != null) {
      return false;
    }
    else if (other.Address != null && !Address.match(other.Address))
      return false;
    if (Beds == null && other.Beds != null) {
      return false;
    }
    else if (other.Beds != null) {
      for (Identifier bd1 : other.Beds) {
        boolean missMatchFound = true;
        for (Identifier bd2 : Beds) {
          if (bd2.match(bd1)) {
            missMatchFound = false;
            break;
          }
        }
        if (missMatchFound) {
          return false;
        }
      }
    }
    
    if (Contact == null && other.Contact != null) {
        return false;
    }
    else if (other.Contact != null && !Contact.match(other.Contact))
      return false;
    
    if (Name == null && other.Name != null) {
      return false;
    }
    else if (other.Name != null && !Name.equals(other.Name))
      return false;
    
    if (HostelPoliy == null && other.HostelPoliy != null) {
      return false;
    }
    else if (other.HostelPoliy != null && !HostelPoliy.match(other.HostelPoliy))
      return false;
    
    return true;
  }

  public String toString()
  {
    final String EOL = System.getProperty( "line.separator" );
      
    String retValue = "";
    
    retValue = "Hostel Details: "  + EOL
        + "Name = " + this.Name + EOL
        + "Address = " + this.Address + EOL
        + "Contact = " + this.Contact + EOL
        + "HostelPoliy = " + this.HostelPoliy + EOL
        + "Beds = " + this.Beds + EOL;

    return retValue;
  }
  
  
}
