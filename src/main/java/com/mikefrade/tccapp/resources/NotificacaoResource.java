package com.mikefrade.tccapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mikefrade.tccapp.domain.Notificacao;
import com.mikefrade.tccapp.services.NotificacaoService;

@RestController
@RequestMapping(value="/notificacoes")
public class NotificacaoResource {
	@Autowired
	private NotificacaoService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Notificacao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
		
		
	}
}
