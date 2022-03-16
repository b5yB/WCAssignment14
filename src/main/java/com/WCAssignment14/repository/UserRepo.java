package com.WCAssignment14.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.WCAssignment14.domain.User;

@Component
public class UserRepo {
	
	public Map<Long, User> users = new HashMap<>();
		
	public User save (User u) {
		
		if (users.isEmpty()) {
			u.setUserId(1L);
			users.put(1L, u);
		}
		else {
			u.setUserId(users.size()+1L);
			users.putIfAbsent(users.size()+1L, u);
		}
		
		System.out.println(users);
		return u;
	}

	
}
