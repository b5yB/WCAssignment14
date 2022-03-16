package com.WCAssignment14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.WCAssignment14.domain.Channel;
import com.WCAssignment14.domain.Message;
import com.WCAssignment14.domain.User;

@Component
public class MessageRepo {

	private Map<Long, List<Message>> messages = new HashMap<>();
	
	public List<Message> save (Long channelId, List<Message> channelMessages) {
		List<Message> m = messages.put(channelId, channelMessages);
		
		System.out.println(messages);
		
		return m;
	}

	public List<Message> findByChannelId(Long channelId) {
		if (messages.isEmpty()) {
			List<Message> general = new ArrayList<>();
			messages.put(channelId, general);
		}
		List<Message> m = messages.get(channelId);
		return m;
	}
	
}
