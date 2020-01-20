package com.galaxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.galaxy.model.Image;
import com.galaxy.service.ImageService;

@RestController
public class ImageController {

	@Autowired
	private ImageService imageService;

	@RequestMapping(method = RequestMethod.GET, value = "/messages/{messageId}/images")
	public List<Image> getImages(@PathVariable String messageId) {
		return imageService.getAllImages(messageId);
	}

	@RequestMapping(method=RequestMethod.GET, value="/messages/{messageId}/images/{imageId}")
	public Image getImage(@PathVariable String id) {
		return imageService.getImage(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/messages/{messageId}/images/")
	public Image addImage(@RequestBody Image image, @PathVariable String messageId) {
		return imageService.addImage(messageId, image);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/messages/{messageId}/images/{imageId}")
	public Image updateImage(@RequestBody Image image, @PathVariable String messageId, @PathVariable String imageId) {
		return imageService.updateImage(messageId, image, imageId);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/images/{id}")
	public void deleteImage(@PathVariable String id) {
		imageService.removeImage(id);
	}

}
