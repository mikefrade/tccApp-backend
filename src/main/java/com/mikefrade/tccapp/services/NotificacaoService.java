package com.mikefrade.tccapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikefrade.tccapp.domain.Notificacao;
import com.mikefrade.tccapp.repositories.NotificacaoRepository;
import com.mikefrade.tccapp.services.exceptions.ObjectNotFountException;

@Service
public class NotificacaoService {
	@Autowired
	private NotificacaoRepository repo;

	public Notificacao find(Integer id) {
		Optional<Notificacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  Notificacao.class.getName()));
		}
	
}
