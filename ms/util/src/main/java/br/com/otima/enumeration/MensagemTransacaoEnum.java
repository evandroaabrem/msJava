package br.com.otima.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MensagemTransacaoEnum {
	
	ERRO(3,"Erro ao salvar os dados");
	
	private Integer value;
	private String description;

}
