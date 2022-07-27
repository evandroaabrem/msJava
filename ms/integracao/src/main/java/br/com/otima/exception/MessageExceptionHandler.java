package br.com.otima.exception;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageExceptionHandler {
	
	private Date timesStamp;
	private Integer status;
	private String message;

}
