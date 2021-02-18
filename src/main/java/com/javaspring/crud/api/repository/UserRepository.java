package com.javaspring.crud.api.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.crud.api.entity.Randevular;
import com.javaspring.crud.api.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Long> {
	User findByEmail(String email);
	User findByToken(String token);
	
	
}
