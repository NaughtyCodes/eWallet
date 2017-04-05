package com.websystique.springsecurity.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	public User findByUserName(String username) {
		
		System.out.println("--------------------------------------------");
		User user = new User();
		Set<String> role = new HashSet<String>();
		role.add("ROLE_ADMIN");
		user.setUsername("mohan");
		user.setPassword("1234");
		user.setEnabled(true);
		user.setUserRole(role);
		
		return user;
	}
}