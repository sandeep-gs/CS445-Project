package hostel.exception;

public class InvalidIdentifierException extends GenericException
{

  private static final long serialVersionUID = 1L;

  public InvalidIdentifierException()
  {
    super();
  }

  public InvalidIdentifierException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public InvalidIdentifierException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public InvalidIdentifierException(String message)
  {
    super(message);
  }

  public InvalidIdentifierException(Throwable cause)
  {
    super(cause);
  }

}
