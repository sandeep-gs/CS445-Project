package hostel.core;
import java.io.Serializable;

public interface InformationObject extends Serializable
{
  public boolean match(InformationObject objectInfo);
}
