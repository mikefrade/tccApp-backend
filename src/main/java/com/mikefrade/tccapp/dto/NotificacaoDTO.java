package com.mikefrade.tccapp.dto;

import java.io.Serializable;
import java.util.Date;

import com.mikefrade.tccapp.domain.Notificacao;
import com.mikefrade.tccapp.domain.Usuario;

public class NotificacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomeuser;
	private Date logHora;
	private String latitude;
	private String longitude;
	private String endereco;
	private String categoria;
	private String descricao;

	public NotificacaoDTO() {
		
	}
	
	public NotificacaoDTO(Notificacao obj) {
		setId(obj.getId());
		nomeuser = obj.getUsuario().getNome();
		logHora = obj.getLogHora();
		latitude = obj.getLatitude();
		longitude = obj.getLongitude();
		endereco =  obj.getEndereco();
		categoria = obj.getCategoria();
		descricao = obj.getDescricao();
		
	}

	public String getNomeuser() {
		return nomeuser;
	}

	public void setNomeuser(String nomeuser) {
		this.nomeuser = nomeuser;
	}

	public Date getLogHora() {
		return logHora;
	}

	public void setLogHora(Date logHora) {
		this.logHora = logHora;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
