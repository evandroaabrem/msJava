package br.com.otima.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PosteDto {
	
	private Integer id;
	
	private String bairro;

	private String identificacao;
	
	private Integer status;
	

}
