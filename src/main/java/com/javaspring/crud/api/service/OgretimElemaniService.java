package com.javaspring.crud.api.service;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import com.javaspring.crud.api.entity.OgretimElemani;


public interface OgretimElemaniService{
	
	public Optional<OgretimElemani>  findOgretimElemaniByEmail(String email);
	public void save(OgretimElemani ogretimElemani);
	
}
