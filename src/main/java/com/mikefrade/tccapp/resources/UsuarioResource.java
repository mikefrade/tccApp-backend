package com.mikefrade.tccapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mikefrade.tccapp.domain.Usuario;
import com.mikefrade.tccapp.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/{email}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable String email) {
		Usuario obj = service.find(email);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{email}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Usuario obj, @PathVariable String email){
	//	obj.setEmail(email);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);		
	}
}
