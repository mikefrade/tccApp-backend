package com.mikefrade.tccapp.services;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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
		
		usuarioRepository.save(user1);
		
		Date date = new Date();
		date = Calendar.getInstance(TimeZone.getTimeZone("GMT-03:00")).getTime();
		
	
		Notificacao not1 = new Notificacao (null, date, user1, "-19.8157", "-43.9545", "Rua Açucena, 48. Sol Nascente", "Iluminação Pública", "Lâmpada queimada", true);
		Notificacao not2 = new Notificacao (null, date, user1, "-19.8157", "-43.9542", "Rua Açucena, 48. Sol Nascente", "Iluminação Pública", "Lâmpada queimada", true);
	
		notificacaoRepository.saveAll(Arrays.asList(not1, not2));

		
	}

}
