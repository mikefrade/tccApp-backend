package com.mikefrade.tccapp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mikefrade.tccapp.domain.Notificacao;
import com.mikefrade.tccapp.dto.NotificacaoDTO;
import com.mikefrade.tccapp.services.NotificacaoService;

@RestController
@RequestMapping(value="/notificacoes")
public class NotificacaoResource {
	@Autowired
	private NotificacaoService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Notificacao> find(@PathVariable Integer id) {
		Notificacao obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<NotificacaoDTO>> findAllUser(@PathVariable Integer id) {
		List<Notificacao> list = service.findAllUser(id);
		List<NotificacaoDTO> listDto = list.stream().map(obj -> new NotificacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);				
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Notificacao obj){
		obj = service.insert(obj);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Notificacao obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();		
	}
	
	@RequestMapping( method = RequestMethod.GET)
	public ResponseEntity<List<NotificacaoDTO>> findAll() {
		List<Notificacao> list = service.findAll();
		List<NotificacaoDTO> listDto = list.stream().map(obj -> new NotificacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);		
	}
	
	@RequestMapping(value="/picture//{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> uploadNotificacaoPicture(@RequestParam(name="file") MultipartFile file, @PathVariable Integer id){
		URI uri = service.UploadNotificacaoPicture(file, id);
		return ResponseEntity.created(uri).build();
	}
	
}
