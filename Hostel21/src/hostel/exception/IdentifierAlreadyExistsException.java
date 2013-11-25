package hostel.exception;

public class IdentifierAlreadyExistsException extends GenericException
{

  private static final long serialVersionUID = 1L;

  public IdentifierAlreadyExistsException()
  {
  }

  public IdentifierAlreadyExistsException(String message)
  {
    super(message);
  }

  public IdentifierAlreadyExistsException(Throwable cause)
  {
    super(cause);
  }

  public IdentifierAlreadyExistsException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public IdentifierAlreadyExistsException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
