package com.javaspring.crud.api.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.crud.api.entity.Randevular;
import com.javaspring.crud.api.entity.User;
import com.javaspring.crud.api.repository.RandevularRepository;
import com.javaspring.crud.api.repository.UserRepository;
import com.javaspring.crud.api.repository.UserResetPaswordRepository;
import com.javaspring.crud.api.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserResetPaswordRepository userResetPaswordRepository;
	
	@Autowired
	RandevularRepository randevularRepository;
	
	@Override
	public Optional<User> findUserByEmail(String email) {
		
		return userResetPaswordRepository.findByEmail(email);
	}

	@Override
	public Optional<User> findUserByToken(String token) {
		return userResetPaswordRepository.findByToken(token);
	}

	@Override
	public void save(User user) {
		userResetPaswordRepository.save(user);
	}

	@Override
	public Optional<Randevular> findRandevularByEmail(String email) {
		return randevularRepository.findRandevularByEmail(email) ;
	}

	@Override
	public void save(Randevular randevular) {
		randevularRepository.save(randevular);
		
	}

	@Override
	public Optional<Randevular> findRandevularBySaat(String saat) {
		
		return randevularRepository.findRandevularBySaat(saat);
	}

	@Override
	public Optional<Randevular> findRandevularByTarih(String tarih) {
		// TODO Auto-generated method stub
		return null;
	}

	



}
