package dt062g.dawe1103.assignment6;

import java.lang.Exception;


public class NoEndPointException extends Exception{

	private static final long serialVersionUID = 1L;

	public NoEndPointException(){ super("End point is missing"); }
		
	public NoEndPointException(String string){ super(string); }

	public NoEndPointException(Throwable cause){ super(cause); }

    public NoEndPointException(String string, Throwable cause){ super(string, cause); }
    
}
