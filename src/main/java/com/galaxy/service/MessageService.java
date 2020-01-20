package com.galaxy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.database.MessageDatabase;
import com.galaxy.model.Message;

/**
 * @author VAMSI KRISHNA MYALAPALLI (vamsikrishna.vasu@gmail.com)
 */
@Service
public class MessageService {

	@Autowired
	MessageDatabase messageDB;
	
	public List<Message> getAllMessages() {
		List<Message> messages = new ArrayList<>();
		messageDB.findAll().forEach(messages::add);
		return messages;
	}

	public Message getMessage(String id) {
		Optional<Message> optionalMessage =	messageDB.findById(String.valueOf(id));
		return optionalMessage.get();
	}

	public Message addMessage(Message message) {
		messageDB.save(message);
		return message;
	}

	public Message updateMessage(String id, Message message) {
		messageDB.save(message);
		return getMessage(id);
	}

	public void removeMessage(String id) {
		messageDB.deleteById(id);
	}

}
