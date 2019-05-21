package dt062g.dawe1103.assignment4;

import java.lang.Exception;


public class NoEndPointException extends Exception{

	private static final long serialVersionUID = 1L;

	public NoEndPointException(){}

	public NoEndPointException(String message){ super(message); }

	public NoEndPointException(Throwable cause){ super(cause); }

  public NoEndPointException(String string, Throwable cause){ super(string, cause); }

}
