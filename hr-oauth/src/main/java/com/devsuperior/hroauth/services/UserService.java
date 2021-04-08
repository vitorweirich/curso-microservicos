package com.devsuperior.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		if (user == null) {
			System.out.println("Chegou no null ---------------------------------------------------" + username);
			throw new UsernameNotFoundException("Email não encontrado");
		}
		System.out.println("Chegou ---------------------------------------------------");
		return user;
	}
}
