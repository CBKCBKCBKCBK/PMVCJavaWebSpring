package tw.com.pcschool.web.exception;

public class ForeignRequestException extends Exception{
	public ForeignRequestException(String message) {
		super(message);
	}
	public ForeignRequestException(String message,Throwable cause) {
		super(message, cause);
	}
}
