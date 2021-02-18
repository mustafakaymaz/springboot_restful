package com.javaspring.crud.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.crud.api.entity.Randevular;
import com.javaspring.crud.api.repository.RandevularRepository;

@RestController
@RequestMapping("/api/rands")
public class RandevularimController {

	@Autowired
	private RandevularRepository randevularRepository;
	
	@GetMapping
	public List<Randevular> getAllRandelars(){
		return this.randevularRepository.findAll();
		}
}
