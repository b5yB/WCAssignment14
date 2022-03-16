package com.WCAssignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.WCAssignment14.domain.Channel;
import com.WCAssignment14.domain.Message;
import com.WCAssignment14.service.ChannelService;
import com.WCAssignment14.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	MessageService mServ;
	
	@Autowired
	ChannelService cServ;
	
	@PostMapping("/channel/{channelId}/message")
	public Message newMessage (@PathVariable Long channelId, @RequestBody Message m){
		return mServ.save(channelId, m);
	}
	
	@GetMapping("/channel/{channelId}/message")
	public List<Message> getChannelMessages (@PathVariable Long channelId) {
		List<Message> m = mServ.findByChannelId(channelId);
		return m;
	}

}
