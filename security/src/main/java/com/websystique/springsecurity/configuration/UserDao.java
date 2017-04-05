package com.websystique.springsecurity.configuration;

public interface UserDao {

	User findByUserName(String username);

}