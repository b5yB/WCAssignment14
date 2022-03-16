package com.WCAssignment14.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.WCAssignment14.domain.Channel;
import com.WCAssignment14.service.ChannelService;

@Controller
public class WelcomeController {
	
	@Autowired
	private ChannelService cServ;
	
	@GetMapping("/welcome")
	public String welcome (ModelMap mm) {
		List<Channel> channels = cServ.getAllChannels();
		mm.put("channels", channels);
		return "welcome";
	}
	
	
}
