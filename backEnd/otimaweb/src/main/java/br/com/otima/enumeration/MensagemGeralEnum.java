package br.com.otima.enumeration;

public enum MensagemGeralEnum {
	OBJNAOENCONTRADO("Object not found"),
	BAIRRONULLOOUEMBRANCO("Bairro is null or blank"),
	IDENTIFNULLOOUEMBRANCO("Identificacao  is null or blank")
	;
	
	private String valueStatus;

	MensagemGeralEnum(String valor) {
		valueStatus = valor;
	}

	public String getValueStatus() {
		return valueStatus;
	}
	
}
