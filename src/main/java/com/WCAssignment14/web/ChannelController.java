package com.WCAssignment14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.WCAssignment14.domain.Channel;
import com.WCAssignment14.domain.Message;
import com.WCAssignment14.service.ChannelService;
import com.WCAssignment14.service.MessageService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService cServ;
	
	@Autowired
	private MessageService mServ;
	
	@GetMapping("/channel/{channelId}")
	public String getChannel (ModelMap mm, @PathVariable Long channelId) {
		Channel c = cServ.findById(channelId);
		List<Message> m = mServ.findByChannelId(channelId);
		mm.put("messages", m);
		mm.put("channel", c);
		return "channel";
	}
}
