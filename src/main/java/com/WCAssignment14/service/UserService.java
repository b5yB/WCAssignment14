package com.WCAssignment14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WCAssignment14.domain.User;
import com.WCAssignment14.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo uRepo;
	
	public User save (String name) {
		User u = new User();
		u.setName(name);
		uRepo.save(u);
		return u;
	}
	
}
