package com.mikefrade.tccapp.services;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikefrade.tccapp.domain.Notificacao;
import com.mikefrade.tccapp.domain.Usuario;
import com.mikefrade.tccapp.domain.enums.TipoUsuario;
import com.mikefrade.tccapp.repositories.NotificacaoRepository;
import com.mikefrade.tccapp.repositories.UsuarioRepository;

@Service
public class DBService {
	@Autowired
	private NotificacaoRepository notificacaoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public void instantiateTestDatabase() {
		Usuario user1 = new Usuario (null, "Mike Frade", "mikefrade@hotmail.com", TipoUsuario.USUARIOCIDADAO);
		Usuario user2 = new Usuario (null, "Mike Frade 1 ", "mikefrade1@hotmail.com", TipoUsuario.USUARIOCIDADAO);
		
		usuarioRepository.save(user1);
		usuarioRepository.save(user2);
		
		//Date date = new Date();
		//date = Calendar.getInstance(TimeZone.getTimeZone("GMT-03:00")).getTime();
		LocalDateTime data = LocalDateTime.now();
		
	
		Notificacao not1 = new Notificacao (null, data, user1, "-19.92087680405777", "-43.9479585740246", "Rua dos Goitacazes, 1161 - Centro, Belo Horizonte", "Iluminação Pública", "Lâmpada queimada", true);
		Notificacao not2 = new Notificacao (null, data, user2, "-19.91930100438631", "-43.94874332844506", "Rua dos Tupis, 1265 - Barro Preto, Belo Horizonte", "Via Pública", "Buraco na rua", true);
	
		notificacaoRepository.saveAll(Arrays.asList(not1, not2));

		
	}

}
