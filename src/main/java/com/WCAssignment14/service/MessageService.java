package com.WCAssignment14.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WCAssignment14.domain.Channel;
import com.WCAssignment14.domain.Message;
import com.WCAssignment14.repository.ChannelRepo;
import com.WCAssignment14.repository.MessageRepo;

@Service
public class MessageService {
	
	@Autowired
	MessageRepo mRepo;
	@Autowired
	ChannelRepo cRepo;

	public List<Message> findByChannelId(Long channelId) {
		List<Message> m = mRepo.findByChannelId(channelId);
		return m;
	}
	
	public Message save (Long channelId, Message m) {
		List<Message> ms = mRepo.findByChannelId(channelId);
		if (ms.isEmpty()) {
			m.setMessageId(1L);
		}
		else {
			m.setMessageId(ms.size()+1L);
			m.setChannelId(channelId);
		}
		ms.add(m);
		mRepo.save(channelId, ms);
		return m;
	}

}
