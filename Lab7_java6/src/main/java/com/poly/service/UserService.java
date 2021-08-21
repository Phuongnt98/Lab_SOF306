package com.poly.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;

import jdk.jshell.spi.ExecutionControl.UserException;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	AccountDAO accountDao;
	
	@Autowired
	BCryptPasswordEncoder pe;
	
	@Override
	public UserDetails loadUserByUsername(String username){
		try {
			Account account = accountDao.findById(username).get();
			//tao userDetails tu Account
			String password = account.getPassword();
			String[] roles = account.getAuthorities().stream()
//					.map(au > au.getRole().getId())
					.collect(Collectors.toList()).toArray(new String[0]);
			return User.withUsername(username)
					.password(pe.encode(password))
					.roles(roles).build();
		} catch (Exception e) {
			throw new UsernameNotFoundException(username + "not found!");
		}
	}
}
