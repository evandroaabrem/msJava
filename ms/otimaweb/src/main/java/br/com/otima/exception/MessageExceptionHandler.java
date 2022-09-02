package br.com.otima.exception;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageExceptionHandler {
	
	private Date timesStamp;
	private Integer status;

	private List<String> lstError;

}
