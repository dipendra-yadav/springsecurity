package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	public IUserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String success(ModelMap map) {
		userService.addUser("ABC", "abc");
		userService.deleteUser("ABC");
		map.addAttribute("msg", "Done Successfully");
		return "success";

	}
}