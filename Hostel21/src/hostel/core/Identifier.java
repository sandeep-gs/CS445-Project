package hostel.core;

import hostel.utility.GenericUtility;

public class Identifier implements InformationObject{
  private static final long serialVersionUID = 1L;
  private String Key; // Actual unique thing.


  public Identifier(Identifier identifier) 
  {
      this.Key = identifier.Key;
  }

  public Identifier(String key) {
		this.Key = key;
	}
	
	public Integer getIntegerKey()
	{
	  if (GenericUtility.isNumber(Key)) {
	    return new Integer(Key);
	  }
	  else {
	    return Key.hashCode();
	  }
	}
	
	public String getKey() {return Key;}

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((Key == null) ? 0 : Key.hashCode());
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
    Identifier other = (Identifier) obj;
    if (Key == null) {
      if (other.Key != null)
        return false;
    }
    else if (!Key.equals(other.Key))
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return Key;
  }
  
  @Override
  public boolean match(InformationObject obj)
  {
    return equals(obj);
  }
}
