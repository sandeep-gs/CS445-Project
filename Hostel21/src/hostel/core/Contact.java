package hostel.core;

public class Contact implements InformationObject
{
  private static final long serialVersionUID = 1L;
  private String Phone;
  private String Email;
  private String FaceBook;
  private String WebUrl;
  
  
  public Contact(Contact contactInfo) 
  {
      this.Phone = contactInfo.Phone;
      this.Email = contactInfo.Email;
      this.FaceBook = contactInfo.FaceBook;
      this.WebUrl = contactInfo.WebUrl;
  }

  public Contact() {}
  
  public Contact(String phone, String email, String faceBook, String webUrl)
  {
    super();
    Phone = phone;
    Email = email;
    FaceBook = faceBook;
    WebUrl = webUrl;
  }

  public String getPhone()
  {
    return Phone;
  }

  public void setPhone(String phone)
  {
    Phone = phone;
  }

  public String getEmail()
  {
    return Email;
  }

  public void setEmail(String email)
  {
    Email = email;
  }

  public String getFaceBook()
  {
    return FaceBook;
  }

  public void setFaceBook(String faceBook)
  {
    FaceBook = faceBook;
  }

  public String getWebUrl()
  {
    return WebUrl;
  }

  public void setWebUrl(String webUrl)
  {
    WebUrl = webUrl;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((Email == null) ? 0 : Email.hashCode());
    result = prime * result + ((FaceBook == null) ? 0 : FaceBook.hashCode());
    result = prime * result + ((Phone == null) ? 0 : Phone.hashCode());
    result = prime * result + ((WebUrl == null) ? 0 : WebUrl.hashCode());
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
    Contact other = (Contact) obj;
    if (Email == null) {
      if (other.Email != null)
        return false;
    }
    else if (!Email.equals(other.Email))
      return false;
    if (FaceBook == null) {
      if (other.FaceBook != null)
        return false;
    }
    else if (!FaceBook.equals(other.FaceBook))
      return false;
    if (Phone == null) {
      if (other.Phone != null)
        return false;
    }
    else if (!Phone.equals(other.Phone))
      return false;
    if (WebUrl == null) {
      if (other.WebUrl != null)
        return false;
    }
    else if (!WebUrl.equals(other.WebUrl))
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
    Contact other = (Contact) objectInfo;
    if (Email == null) {
      if (other.Email != null)
        return false;
    }
    else if (other.Email != null && !Email.equals(other.Email))
      return false;
    if (FaceBook == null) {
      if (other.FaceBook != null)
        return false;
    }
    else if (other.FaceBook != null && !FaceBook.equals(other.FaceBook))
      return false;
    if (Phone == null) {
      if (other.Phone != null)
        return false;
    }
    else if (other.Phone != null && !Phone.equals(other.Phone))
      return false;
    if (WebUrl == null) {
      if (other.WebUrl != null)
        return false;
    }
    else if (other.WebUrl != null && !WebUrl.equals(other.WebUrl))
      return false;
    return true;
  }

  public String toString()
  {
    final String EOL = System.getProperty( "line.separator" );
      
    String retValue = "";
    
    retValue = "Contact : " + EOL
        + "Phone = " + this.Phone + EOL
        + "Email = " + this.Email + EOL
        + "FaceBook = " + this.FaceBook + EOL
        + "WebUrl = " + this.WebUrl + EOL;

    return retValue;
  }
  
  
  
}
