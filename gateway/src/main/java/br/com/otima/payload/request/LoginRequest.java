package br.com.otima.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LoginRequest {
	@NotBlank
  private String username;

	@NotBlank
	private String password;

}
