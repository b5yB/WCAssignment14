package com.WCAssignment14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WCAssignment14.domain.Channel;
import com.WCAssignment14.repository.ChannelRepo;
import com.WCAssignment14.repository.MessageRepo;

@Service
public class ChannelService {
	
	@Autowired
	ChannelRepo cRepo;
	@Autowired
	MessageRepo mRepo;
	
	public List<Channel> getAllChannels (){
		return cRepo.getAllChannels();
	}
	
	public Channel findById(Long id) {
		Channel c = cRepo.findById(id);
		return c;
	}

}
