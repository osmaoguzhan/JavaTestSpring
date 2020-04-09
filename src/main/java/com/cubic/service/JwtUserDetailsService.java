package com.cubic.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cubic.dao.UserDao;
import com.cubic.exceptions.ApiRequestException;


@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	

	
	public UserDetails loadUserByUsername(String username){
		com.cubic.model.User user = userDao.findUserByUsername(username);
		if(user == null) {
			throw new ApiRequestException("Username not found!");
		}
		return new User(user.getUsername(),user.getEmail(),new ArrayList<>());
	}

}