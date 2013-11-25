package hostel.exception;

public class IdentifierNotFoundException extends GenericException
{
  private static final long serialVersionUID = 1L;

  public IdentifierNotFoundException()
  {
  }

  public IdentifierNotFoundException(String message)
  {
    super(message);
  }

  public IdentifierNotFoundException(Throwable cause)
  {
    super(cause);
  }

  public IdentifierNotFoundException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public IdentifierNotFoundException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
