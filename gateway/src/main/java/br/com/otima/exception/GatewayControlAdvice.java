package br.com.otima.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.security.core.AuthenticationException;

import br.com.otima.payload.response.JwtResponse;

@ControllerAdvice
public class GatewayControlAdvice  extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<JwtResponse> productNotFound(AuthenticationException productNotFoundException)
	{
		JwtResponse error = JwtResponse.builder()
				.status(HttpStatus.UNAUTHORIZED.value())
				.build();
		
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
		
	}
	

}
