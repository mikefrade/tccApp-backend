package com.mikefrade.tccapp;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mikefrade.tccapp.domain.Notificacao;
import com.mikefrade.tccapp.domain.Usuario;
import com.mikefrade.tccapp.domain.enums.TipoUsuario;
import com.mikefrade.tccapp.repositories.NotificacaoRepository;
import com.mikefrade.tccapp.repositories.UsuarioRepository;

@SpringBootApplication
public class TccappApplication implements CommandLineRunner {
	@Autowired
	private NotificacaoRepository notificacaoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(TccappApplication.class, args);

		
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario (null, "Mike Frade", "mikefrade@hotmail.com", TipoUsuario.USUARIOCIDADAO);
		
		usuarioRepository.save(user1);
		
		Date date = new Date();
		date = Calendar.getInstance(TimeZone.getTimeZone("GMT-03:00")).getTime();
		Notificacao not1 = new Notificacao (null, user1, date, "latitude", "longitude", "Rua Açucena, 48. Sol Nascente", "Iluminação Pública", "Lâmpada queimada", true);
		Notificacao not2 = new Notificacao (null,user1, date, "latitude", "longitude", "Rua Açucena, 48. Sol Nascente", "Iluminação Pública", "Lâmpada queimada", true);
	
		notificacaoRepository.saveAll(Arrays.asList(not1, not2));

		
	}
}
