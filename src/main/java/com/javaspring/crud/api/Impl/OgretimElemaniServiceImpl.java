package com.javaspring.crud.api.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspring.crud.api.entity.OgretimElemani;
import com.javaspring.crud.api.repository.OgretimElemaniRepository;
import com.javaspring.crud.api.service.OgretimElemaniService;

@Service("ogretimElemaniService")
public class OgretimElemaniServiceImpl implements OgretimElemaniService{
	@Autowired
	private OgretimElemaniRepository ogretimElemaniRepository;

	@Override
	public Optional<OgretimElemani> findOgretimElemaniByEmail(String email) {
		return null;
	}

	@Override
	public void save(OgretimElemani ogretimElemani) {
			ogretimElemaniRepository.save(ogretimElemani);
	}
	
		
}
