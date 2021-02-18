package com.javaspring.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.crud.api.entity.OgretimElemani;
import com.javaspring.crud.api.entity.User;
import com.javaspring.crud.api.repository.OgretimElemaniRepository;

@RestController
@RequestMapping("/api/ogretimelemani")
public class OgretimElemaniController {
 
	@Autowired
	private OgretimElemaniRepository ogretimElemaniRepository;
	
	@GetMapping
	public List<OgretimElemani> getAllOgretimElemanis(){
		return this.ogretimElemaniRepository.findAll();
		
	}
	
}
