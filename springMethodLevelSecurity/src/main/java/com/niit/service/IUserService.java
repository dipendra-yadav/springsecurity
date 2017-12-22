package com.niit.service;

import org.springframework.security.access.annotation.Secured;

public interface IUserService {

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void addUser(String name, String pwd);

	@Secured("ROLE_ADMIN")
	public void deleteUser(String name);

}
