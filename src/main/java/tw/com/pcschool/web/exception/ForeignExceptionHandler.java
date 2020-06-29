package tw.com.pcschool.web.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ForeignExceptionHandler {
	@ExceptionHandler(value = {ForeignRequestException.class})
	public ResponseEntity<Object> handleForeignException(ForeignRequestException e){
		HttpStatus badRequest=HttpStatus.BAD_REQUEST;
		ForeignException foreignException= new ForeignException(e.getMessage(),e, 
				badRequest, ZonedDateTime.now(ZoneId.of("Z")));
		
		return new ResponseEntity<Object>(foreignException,badRequest);
	}
}
