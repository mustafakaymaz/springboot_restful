package com.javaspring.crud.api.service;



import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaspring.crud.api.entity.Randevular;
import com.javaspring.crud.api.entity.User;


public interface UserService {
	
	public Optional<User>  findUserByEmail(String email);
	    public Optional<User> findUserByToken(String token);
	    public Optional<Randevular>  findRandevularByEmail(String email);
	    public Optional<Randevular>  findRandevularBySaat(String saat);
	    public Optional<Randevular>  findRandevularByTarih(String tarih);
	    //public Optional<Randevular>  findRandevularByOgretimElemani(String adSoyad);
	    public void save(Randevular randevular);
	    public void save(User user);
}
