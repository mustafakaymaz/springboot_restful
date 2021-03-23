package com.javaspring.crud.api.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.mail.Message;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.ServletContextPropertyUtils;

import com.javaspring.crud.api.entity.Randevular;
import com.javaspring.crud.api.entity.User;
import com.javaspring.crud.api.exception.ResourceNotFoundException;
import com.javaspring.crud.api.repository.RandevularRepository;
import com.javaspring.crud.api.repository.UserRepository;
import com.javaspring.crud.api.repository.UserResetPaswordRepository;
import com.javaspring.crud.api.service.EmailService;
import com.javaspring.crud.api.service.UserService;
import com.sun.mail.handlers.message_rfc822;


@RestController
@RequestMapping("/api/users")
public class UserController {
	
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserResetPaswordRepository userResetPasswordRepository;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private RandevularRepository randevularRepository;
	
	@Autowired
	EmailService emailService;

	
	
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable (value = "id") long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User Not Found with id :"+ userId));
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		Optional<User> u = userService.findUserByEmail(user.getEmail());
		if(!u.isPresent()) {
			return this.userRepository.save(user);
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/randevu")
	public Randevular createRandevu(@RequestBody Randevular randevular) {
		Optional<Randevular> u =userService.findRandevularBySaat(randevular.getSaat());
		if(!u.isPresent()) {
			return this.randevularRepository.save(randevular);
		}
		else {
			return null;
	   }
    }
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
	 User u = userRepository.findByEmail(user.getEmail());
		if(u==null) {
			return null;
		}
		else {
			if(u. getSifre().equals(user.getSifre())) {
				return user;
			}
			else
				return null;
		}
		//return this.userRepository.save(user);
	}
	
	
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		User existingUser = this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User Not Found with id :"+ userId));
		existingUser.setAdSoyad(user.getAdSoyad());
		existingUser.setEmail(user.getEmail());
		existingUser.setFakulte(user.getFakulte());
		existingUser.setBolum(user.getBolum());
		existingUser.setSifre(user.getSifre());
		return this.userRepository.save(existingUser);
	}
	
	@DeleteMapping("/randevu/{id}")
	public ResponseEntity<Randevular> deleteRandevular(@PathVariable ("id") long randevuId){
		Randevular existingRandevu = this.randevularRepository.findById(randevuId)
				.orElseThrow(()-> new ResourceNotFoundException("User Not Found with id :"+ randevuId));
		this.randevularRepository.delete(existingRandevu);
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/forgot-password")
	public User forgotPassword(@RequestParam("email") String email, HttpServletRequest request) {
		Optional<User> optional = userService.findUserByEmail(email);
		Random random = new Random();
		int otp = 10000+ random.nextInt(100000);
		if (!optional.isPresent()) {
				return null;
		}else {
			User user = optional.get();
			user.setToken(String.valueOf(otp));
			userService.save(user);
			
			
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			//passwordResetEmail.setFrom("");
			passwordResetEmail.setTo(user.getEmail());
			passwordResetEmail.setSubject("Şifre Sıfırlama İsteği");
			passwordResetEmail.setText("Doğrulama Şifreniz:\n" + user.getToken());
			
			emailService.sendEmail(passwordResetEmail);
		}
		return optional.get();
		
	}
	
	@PostMapping("newPass1")
	public User dogrulama(@RequestBody User user) {
	 User u = userRepository.findByToken(user.getToken());
	 
		if(u == null) {
			return null;
		}
		else {
			if(u. getToken().equals(user.getToken())) {
				return user;
			}
			else
				return null;
		}
		//return this.userRepository.save(user);
	}
	
	@PostMapping("newPass")
	public String newPassword(@RequestParam Map<String, String> requestParams) {
	  Optional<User> user = userService.findUserByToken(requestParams.get("token"));
	  if(user.isPresent()) {
		  User resetUser = user.get();
		  resetUser.setSifre(requestParams.get("sifre"));
		  resetUser.setToken(null);
		  userService.save(resetUser);  
		  return "kayıt başarılı";
	  }else {
		  return null;
		  
	  }
	}
	
}
