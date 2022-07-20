package br.com.otima.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class OtimaControlAdvice  extends ResponseEntityExceptionHandler{
	

	
	
	
	@ExceptionHandler(PosteException.class)
	public ResponseEntity<MessageExceptionHandler> posteNaoEncontrado(PosteException posteException)
	{
		MessageExceptionHandler error = MessageExceptionHandler.builder()
				.timesStamp(new Date())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(posteException.getMessage())
				.build();
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MessageExceptionHandler> posteNaoEncontrado(Exception exception)
	{
		MessageExceptionHandler error = MessageExceptionHandler.builder()
				.timesStamp(new Date())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(exception.getMessage())
				.build();
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
}
