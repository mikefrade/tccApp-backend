package com.mikefrade.tccapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikefrade.tccapp.domain.Usuario;
import com.mikefrade.tccapp.repositories.UsuarioRepository;
import com.mikefrade.tccapp.services.exceptions.ObjectNotFountException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  Usuario.class.getName()));
		}
	
}
