package com.galaxy.database;

import org.springframework.data.repository.CrudRepository;

import com.galaxy.model.Message;


public interface MessageDatabase extends CrudRepository<Message, String> {

	
	
}
