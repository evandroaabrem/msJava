package br.com.otima.payload.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class JwtResponse {
	  private String token;
	  private String type;
	  private Integer id;
	  private String username;
	  private String email;
	  private List<String> roles;	
	  private Integer status;
	
}