package br.com.otima.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnderecoDto {
	
	private String bairro;
	private String cidade;
	private String logradouro;
	private EstadoInfoDto estado_info;
	private CidadeInfoDto cidade_info;
	private String estado;
	
}
