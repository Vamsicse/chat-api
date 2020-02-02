package com.galaxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.model.Message;
import com.galaxy.service.MessageService;

/**
* author: Vamsi Krishna Myalapalli
*/
@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(method = RequestMethod.GET, value = "/messages")
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}

	@RequestMapping(method=RequestMethod.GET, value="/messages/{id}")
	public Message getMessage(@PathVariable String id) {
		return messageService.getMessage(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/messages")
	public Message addMessage(@RequestBody Message message) {
		return messageService.addMessage(message);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/messages/{id}")
	public Message updateMessage(@RequestBody Message message, @PathVariable String id) {
		message.setId(id);
		return messageService.updateMessage(id, message);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/messages/{id}")
	public void deleteMessage(@PathVariable String id) {
		messageService.removeMessage(id);
	}

}
