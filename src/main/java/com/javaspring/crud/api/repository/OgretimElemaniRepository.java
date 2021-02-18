package com.javaspring.crud.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.crud.api.entity.OgretimElemani;
import com.javaspring.crud.api.entity.User;

@Repository("ogretimElemaniRepository")
public interface OgretimElemaniRepository extends JpaRepository<OgretimElemani, Long> {
	User findByEmail(String adSoyad);
	User findByToken(String email);
	
	
}
