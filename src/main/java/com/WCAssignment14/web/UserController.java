package com.WCAssignment14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.WCAssignment14.domain.User;
import com.WCAssignment14.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService uServ;
	
	@PostMapping("/new")
	public User newUser (@RequestBody String name) {
		return uServ.save(name);
	}
	
}
