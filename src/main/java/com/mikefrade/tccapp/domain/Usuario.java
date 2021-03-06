package com.mikefrade.tccapp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mikefrade.tccapp.domain.enums.TipoUsuario;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@Column(unique=true)
	private String email;
	private Integer tipo;
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	transient private Set<Notificacao> notificacao = new HashSet<>();	

	public Usuario () {
		
	}

public Usuario(Integer id, String nome, String email, TipoUsuario tipo) {
	super();
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.tipo = (tipo==null) ? null: tipo.getCod();
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public TipoUsuario getTipo() {
	return TipoUsuario.toEnum(tipo);
}

public void setTipo(TipoUsuario tipo) {
	this.tipo = tipo.getCod();
}

@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}



}
