package com.javaspring.crud.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.crud.api.entity.ConfirmationToken;
import com.javaspring.crud.api.entity.OgretimElemani;

import com.javaspring.crud.api.entity.User;
import com.javaspring.crud.api.repository.ConfirmationTokenRepository;
import com.javaspring.crud.api.repository.OgretimElemaniRepository;

import com.javaspring.crud.api.service.EmailService;
import com.javaspring.crud.api.service.OgretimElemaniService;

@RestController
@RequestMapping("/api/ogretimelemani")
public class OgretimElemaniController {
 
	@Autowired
	private OgretimElemaniRepository ogretimElemaniRepository;
	
	@Autowired 
	private ConfirmationTokenRepository confirmationTokenRepository;
	
	@Autowired
	EmailService emailService;
	
	@Autowired 
	private OgretimElemaniService ogretimElemaniService;
	
	@GetMapping
	public List<OgretimElemani> getAllOgretimElemanis(){
		return (List<OgretimElemani>) this.ogretimElemaniRepository.findAll();
		
	}
	@PostMapping
	public OgretimElemani createOgretimElemanis(@RequestBody OgretimElemani ogretimElemani) {
	Optional<OgretimElemani> ogr = ogretimElemaniService.findOgretimElemaniByEmail(ogretimElemani.getEmail());
		if(!ogr.isPresent()) {
			return this.ogretimElemaniRepository.save(ogretimElemani);
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/login")
	public OgretimElemani login(@RequestBody OgretimElemani ogretimElemani) {
	 OgretimElemani ogr = ogretimElemaniRepository.findByEmail(ogretimElemani.getEmail());
		if(ogr==null) {
			return null;
		}
		else {
			if(ogr. getSifre().equals(ogretimElemani.getSifre())) {
				return ogretimElemani;
			}
			else
				return null;
		}
		//return this.userRepository.save(user);
	}
	@PostMapping("/dogrulama")
	public OgretimElemani kullaniciKaydi(@RequestParam("email") String email,HttpServletRequest request, OgretimElemani ogretimElemani) {
		
		OgretimElemani ogr = ogretimElemaniRepository.findByEmail(ogretimElemani.getEmail());
		
		if(ogr != null) {
			return null;
		}
		else {
			ogretimElemaniRepository.save(ogretimElemani);
			
			ConfirmationToken confirmationToken = new ConfirmationToken(ogretimElemani);
			
			confirmationTokenRepository.save(confirmationToken);
		
			
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			
			mailMessage.setTo(ogretimElemani.getEmail());
			mailMessage.setSubject("Kayıt Onay Kodu");
			mailMessage.setText("http://localhost:8080/kodDogrula?token=" + confirmationToken.getConfirmationToken());
			
			emailService.sendEmail(mailMessage);
		}
		
		return null;
	}
	
	@PostMapping("/kodDogrula")
	public OgretimElemani kayitKontrol(@RequestParam("token") String confirmationToken) {
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
		if(token!=null) {
			OgretimElemani ogretimElemani = ogretimElemaniRepository.findByEmail(token.getOgretimElemani().getEmail());
			ogretimElemani.setIsEnabled(true);
			ogretimElemaniRepository.save(ogretimElemani);
		}else
		{
			return null;
		}
		return kayitKontrol(confirmationToken);
	}

	
}
