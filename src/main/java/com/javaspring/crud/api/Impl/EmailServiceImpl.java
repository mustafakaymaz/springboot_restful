package com.javaspring.crud.api.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.javaspring.crud.api.service.EmailService;
@Service("emailService")
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired 
	public EmailServiceImpl(JavaMailSender javaMailSender){
	  this.mailSender = javaMailSender;
	}
	
	@Async
	public void sendEmail(SimpleMailMessage email) {
		mailSender.send(email);

	}

}
