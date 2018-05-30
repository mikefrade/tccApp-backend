package com.mikefrade.tccapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikefrade.tccapp.domain.Usuario;
import com.mikefrade.tccapp.domain.enums.TipoUsuario;
import com.mikefrade.tccapp.repositories.UsuarioRepository;


@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;

	public Usuario find(String email) {
		Usuario obj = repo.findByEmail(email);
		return 	obj;
	}
		
	public Usuario update(Usuario obj) {
		
		if(usuarioCadastrado(obj.getEmail())) {
			Usuario newObj =  find(obj.getEmail()); 
			updateData(newObj, obj);
		    System.out.println("Passei no if do update");
			return repo.save(newObj);
		} else {
		    System.out.println("Passei no else do update");
			obj.setTipo(TipoUsuario.USUARIOCIDADAO);
			return repo.save(obj);
		}	

	}
		
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setNome(obj.getNome());
	}
	
	public boolean usuarioCadastrado(String email) {
		
		Usuario obj = repo.findByEmail(email);
		if ( obj != null ) {
			 return true;
		} else {
			return false;
		}
   }
}
