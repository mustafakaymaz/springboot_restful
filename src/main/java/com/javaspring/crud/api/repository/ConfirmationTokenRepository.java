package com.javaspring.crud.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaspring.crud.api.entity.ConfirmationToken;
@Repository("confirmationTokenRepository")
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, String>{
	ConfirmationToken findByConfirmationToken(String confirmationToken);
}
