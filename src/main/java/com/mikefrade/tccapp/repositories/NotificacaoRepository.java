package com.mikefrade.tccapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mikefrade.tccapp.domain.Notificacao;
import com.mikefrade.tccapp.domain.Usuario;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer> {
	
	@Transactional(readOnly=true)
	public List<Notificacao> findByUsuario(Usuario user) ;

}
