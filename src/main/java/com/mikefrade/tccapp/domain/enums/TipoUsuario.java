package com.mikefrade.tccapp.domain.enums;

public enum TipoUsuario {
	
	USUARIOCIDADAO(1, "Usuário/Cidadão"),
	AGENTEPUBLICO(2, "Agente Público");
	
	private int cod;
	private String descricacao;
	private TipoUsuario(int cod, String descricacao) {
		this.cod = cod;
		this.descricacao = descricacao;
	}
	public int getCod() {
		return cod;
	}
	public String getDescricacao() {
		return descricacao;
	}
	
	public static TipoUsuario toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoUsuario x: TipoUsuario.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
