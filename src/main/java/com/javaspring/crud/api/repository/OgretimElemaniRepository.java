package com.javaspring.crud.api.repository;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.crud.api.entity.OgretimElemani;
import com.javaspring.crud.api.entity.User;

@Repository("ogretimElemaniRepository")
public interface OgretimElemaniRepository extends CrudRepository<OgretimElemani, String> {
	OgretimElemani findByEmail(String email);
	OgretimElemani findByToken(String token);
}
