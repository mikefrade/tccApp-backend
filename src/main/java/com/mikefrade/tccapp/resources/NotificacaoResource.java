package com.mikefrade.tccapp.resources;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mikefrade.tccapp.domain.Notificacao;

@RestController
@RequestMapping(value="/notificacoes")
public class NotificacaoResource {
	@RequestMapping(method = RequestMethod.GET)
	public List<Notificacao> listar() {
		Date date = new Date();
		date = Calendar.getInstance(TimeZone.getTimeZone("GMT-03:00")).getTime();
		Notificacao not1 = new Notificacao (1, date, "latitude", "longitude", "Rua Açucena, 48. Sol Nascente", "Iluminação Pública", "Lâmpada queimada", true);
		Notificacao not2 = new Notificacao (2, date, "latitude", "longitude", "Rua Açucena, 48. Sol Nascente", "Iluminação Pública", "Lâmpada queimada", true);
		List<Notificacao> lista = new ArrayList<>();
		lista.add(not1);
		lista.add(not2);
		return lista;
	}
}
