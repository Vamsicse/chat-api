package com.galaxy.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Image {
	
	@Id
	private String id;
	private String content;
	
	public Image() {}
	
	public Image(String id, String content) {
		this.id = id;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
