package com.devsuperior.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findbyEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			//System.out.println("Email não encontrado "+ email);
			throw new IllegalArgumentException("Email não encontrado");
		}
		//System.out.println("Email encontrado "+ email);
		return user;
	}
}
