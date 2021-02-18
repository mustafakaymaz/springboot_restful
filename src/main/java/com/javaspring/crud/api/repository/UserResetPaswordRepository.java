package com.javaspring.crud.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.crud.api.entity.Randevular;
import com.javaspring.crud.api.entity.User;

@Repository("userResetPaswordRepository")
public interface UserResetPaswordRepository extends JpaRepository<User, Long>{
	Optional<User>  findByEmail(String email);
	Optional<User> findByToken(String token);
	
		
}
