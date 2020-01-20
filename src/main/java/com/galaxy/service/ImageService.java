package com.galaxy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galaxy.database.ImageDatabase;
import com.galaxy.database.MessageDatabase;
import com.galaxy.model.Image;

/**
 * @author VAMSI KRISHNA MYALAPALLI (vamsikrishna.vasu@gmail.com)
 */

@Service
public class ImageService {

	@Autowired
	ImageDatabase imageDB;
	
	@Autowired 
	MessageDatabase messageDB;
	
	public List<Image> getAllImages(String id) {
		List<Image> images = new ArrayList<>();
		imageDB.findAll().forEach(images::add);
		return images;
	}

	public Image getImage(String id) {
		Optional<Image> optionalImage =	imageDB.findById(String.valueOf(id));
		return optionalImage.get();
	}

	public Image addImage(String messageId, Image image) {
		
		imageDB.save(image);
		return image;
	}

	public Image updateImage(String id, Image image, String imageId) {
		imageDB.save(image);
		return getImage(id);
	}

	public void removeImage(String id) {
		imageDB.deleteById(id);
	}

}
