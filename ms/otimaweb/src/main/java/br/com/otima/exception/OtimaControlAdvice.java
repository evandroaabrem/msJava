package br.com.otima.exception;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class OtimaControlAdvice {
	
	@ExceptionHandler(PosteException.class)
	public ResponseEntity<MessageExceptionHandler> exceptionDefault(PosteException posteException)
	{
		MessageExceptionHandler error = MessageExceptionHandler.builder()
				.timesStamp(new Date())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.lstError(Arrays.asList(posteException.getMessage()))
				.build();
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<MessageExceptionHandler> validDto(MethodArgumentNotValidException exception)
	{
		MessageExceptionHandler error = MessageExceptionHandler.builder()
				.timesStamp(new Date())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.lstError(buildDto(exception))
				.build();
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}


	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ResponseEntity<MessageExceptionHandler> validObj(ConstraintViolationException exception)
	{
		MessageExceptionHandler error = MessageExceptionHandler.builder()
				.timesStamp(new Date())
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.lstError(buildObj(exception))
				.build();

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}


	private List<String> buildDto(MethodArgumentNotValidException exception) {
		Stream<String> stream = exception.getBindingResult().getFieldErrors().stream().map(this::buildFieldDto);
		return stream.collect(Collectors.toList());
	}

	private List<String> buildObj(ConstraintViolationException exception) {
		Stream<String> stream = exception.getConstraintViolations().stream().map(this::buildFieldObj);
		return  stream.collect(Collectors.toList());
	}

	private String buildFieldObj(ConstraintViolation<?> violation) {
		return "[ ".concat(violation.getPropertyPath().toString().concat(" ] : ".concat(violation.getMessage())));
	}

	private String buildFieldDto(FieldError fieldError) {
		return "[ ".concat(fieldError.getField().concat(" ] : ".concat(fieldError.getDefaultMessage())));
	}


}
