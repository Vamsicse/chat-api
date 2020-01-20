/**
 * 
 */
package com.galaxy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author VAMSI KRISHNA MYALAPALLI (vamsikrishna.vasu@gmail.com)
 *
 */

@RestController
public class HomePageController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String guestUser() {
		return "<h1>Welcome Guest</h1>";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public String regularUser() {
		return "<h1>Welcome User</h1>";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/admin")
	public String adminUser() {
		return "<h1>Welcome Admin</h1>";
	}
	
}
