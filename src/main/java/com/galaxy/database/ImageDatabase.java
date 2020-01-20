package com.galaxy.database;

import org.springframework.data.repository.CrudRepository;

import com.galaxy.model.Image;


public interface ImageDatabase extends CrudRepository<Image, String> {

	
	
}
