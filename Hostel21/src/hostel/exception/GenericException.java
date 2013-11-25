package hostel.exception;

public class GenericException extends Exception
{
  private static final long serialVersionUID = 1L;

  public GenericException()
  {
  }

  public GenericException(String message)
  {
    super(message);
  }

  public GenericException(Throwable cause)
  {
    super(cause);
  }

  public GenericException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public GenericException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
