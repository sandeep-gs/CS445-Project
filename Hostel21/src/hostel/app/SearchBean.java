package hostel.app;

import java.io.Serializable;

import hostel.core.Identifier;
import hostel.core.InformationObject;

public class SearchBean<T extends InformationObject> implements Serializable
{
  private static final long serialVersionUID = 1L;

  private Identifier searchId;
  private Identifier objectId;
  private T objectInfo;
  
  
  
  public SearchBean() {}
  
  public SearchBean(Identifier searchId, Identifier objectId, T objectInfo)
  {
    super();
    this.searchId = searchId;
    this.objectId = objectId;
    this.objectInfo = objectInfo;
  }
  
  public SearchBean(SearchBean<T> searchBean) 
  {
      this.searchId = searchBean.searchId;
      this.objectId = searchBean.objectId;
      this.objectInfo = searchBean.objectInfo;
  }
  public Identifier getSearchId()
  {
    return searchId;
  }
  public void setSearchId(Identifier searchId)
  {
    this.searchId = searchId;
  }
  public Identifier getObjectId()
  {
    return objectId;
  }
  public void setObjectId(Identifier objectId)
  {
    this.objectId = objectId;
  }
  public T getObjectInfo()
  {
    return objectInfo;
  }
  public void setObjectInfo(T objectInfo)
  {
    this.objectInfo = objectInfo;
  }
  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((objectId == null) ? 0 : objectId.hashCode());
    result = prime * result
        + ((objectInfo == null) ? 0 : objectInfo.hashCode());
    result = prime * result + ((searchId == null) ? 0 : searchId.hashCode());
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
    @SuppressWarnings("unchecked")
    SearchBean<T> other = (SearchBean<T>) obj;
    if (objectId == null) {
      if (other.objectId != null)
        return false;
    }
    else if (!objectId.equals(other.objectId))
      return false;
    if (objectInfo == null) {
      if (other.objectInfo != null)
        return false;
    }
    else if (!objectInfo.equals(other.objectInfo))
      return false;
    if (searchId == null) {
      if (other.searchId != null)
        return false;
    }
    else if (!searchId.equals(other.searchId))
      return false;
    return true;
  }
}
