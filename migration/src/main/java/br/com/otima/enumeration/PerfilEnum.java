package br.com.otima.enumeration;

public enum PerfilEnum {
  ROLE_USER("ROLE_USER"),
  ROLE_MODERATOR("ROLE_MODERATOR"),
  ROLE_ADMIN("ROLE_ADMIN");
	
	private String valuePerfil;

	PerfilEnum(String valor) {
		valuePerfil = valor;
	}

	public String getValueStatus() {
		return valuePerfil;
	}
}
