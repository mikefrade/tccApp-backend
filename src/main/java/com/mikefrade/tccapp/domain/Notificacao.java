package com.mikefrade.tccapp.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Notificacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;  // id usuario;
	
	private Date logHora;
	private String latitude;
	private String longitude;
	private String endereco;
	private String categoria;
	private String descricao;
	private Boolean ativo;
	
	public Notificacao() {
	}
	


	public Notificacao(Integer id, Date logHora, Usuario usuario,  String latitude, String longitude, String endereco,
			String categoria, String descricao, Boolean ativo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.logHora = logHora;
		this.latitude = latitude;
		this.longitude = longitude;
		this.endereco = endereco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.ativo = ativo;
	}



	public Notificacao(Integer id, Usuario usuario, String latitude, String longitude, String endereco,
			String categoria, String descricao, Boolean ativo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.latitude = latitude;
		this.longitude = longitude;
		this.endereco = endereco;
		this.categoria = categoria;
		this.descricao = descricao;
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacao other = (Notificacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
