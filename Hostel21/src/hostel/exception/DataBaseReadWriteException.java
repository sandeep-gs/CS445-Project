package hostel.exception;

public class DataBaseReadWriteException extends GenericException
{
  private static final long serialVersionUID = 1L;

  public DataBaseReadWriteException()
  {
  }

  public DataBaseReadWriteException(String message)
  {
    super(message);
  }

  public DataBaseReadWriteException(Throwable cause)
  {
    super(cause);
  }

  public DataBaseReadWriteException(String message, Throwable cause)
  {
    super(message, cause);
  }

  public DataBaseReadWriteException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace)
  {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
