package com.javaspring.crud.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.crud.api.entity.Randevular;


	@Repository("randevularRepository")
	public interface RandevularRepository extends JpaRepository<Randevular,Long> {
		
		Optional<Randevular>findRandevularByEmail(String email);
		
		Optional<Randevular>findRandevularBySaat(String saat);
		
}
