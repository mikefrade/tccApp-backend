package com.mikefrade.tccapp.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mikefrade.tccapp.domain.Notificacao;
import com.mikefrade.tccapp.repositories.NotificacaoRepository;
import com.mikefrade.tccapp.services.exceptions.DataIntegrityViolationExpetion;
import com.mikefrade.tccapp.services.exceptions.ObjectNotFountException;

@Service
public class NotificacaoService {
	@Autowired
	private NotificacaoRepository repo;
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ImageService imageService;
	
	@Value("${img.prefix.notificacao.picture}")
	private String prefix;

	public Notificacao find(Integer id) {
		Optional<Notificacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFountException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " +  Notificacao.class.getName()));
		}
	public Notificacao insert(Notificacao obj) {
		obj.setId(null);
		Date date = new Date();
		date = Calendar.getInstance(TimeZone.getTimeZone("GMT-03:00")).getTime();
		obj.setLogHora(date);
		obj.setAtivo(true);
		return repo.save(obj);
	}
	
	
	public Notificacao update(Notificacao obj) {
		Notificacao newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void  delete (Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		} catch(DataIntegrityViolationExpetion e ){
			throw new DataIntegrityViolationExpetion("Não é possível excluir esta notificação!" );
		}
	}
	
	public List<Notificacao> findAll(){
		return repo.findAll();
	}
	private void updateData(Notificacao newObj, Notificacao obj) {
		
		newObj.setLatitude(obj.getLatitude());
		newObj.setLongitude(obj.getLongitude());
		newObj.setEndereco(obj.getEndereco());
		newObj.setCategoria(obj.getCategoria());
		newObj.setDescricao(obj.getDescricao());
	}
	
	public URI UploadNotificacaoPicture(MultipartFile multipartFile, Integer id) {
	
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		String fileName = prefix + id + ".jpg";
		
		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
	}
}
