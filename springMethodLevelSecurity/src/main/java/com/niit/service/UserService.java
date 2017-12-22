package com.niit.service;

import org.springframework.stereotype.Repository;

@Repository
public class UserService implements IUserService {

	
	
	public void addUser(String name, String pwd) {
		System.out.println("user added");
	}

	public void deleteUser(String name) {
		System.out.println("user deleted");
	}
}
