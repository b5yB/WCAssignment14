package com.WCAssignment14.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.WCAssignment14.domain.Channel;

@Component
public class ChannelRepo {

	public List<Channel> channels = new ArrayList<Channel>();
	
	public Channel save (Channel c) {
	
		c.setChannelId(channels.size()+1L);
		channels.add(c);
		
		System.out.println(channels);
		return c;
	}
	
	public List<Channel> getAllChannels() {
		if (channels.isEmpty()) {
			Channel general = new Channel();
			general.setTitle("General");
			general.setChannelId(1L);
			channels.add(general);
		}
		System.out.println(channels);
		return channels;
	}
	
	public Channel findById(Long id) {
		int i = Math.toIntExact(id-1);
		Channel c = channels.get(i);
		return c;
	}
}
