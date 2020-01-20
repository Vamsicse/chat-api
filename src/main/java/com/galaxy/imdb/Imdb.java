/**
 * 
 */
package com.galaxy.imdb;

import java.util.HashMap;
import java.util.Map;

import com.galaxy.model.Message;

/**
 * @author VAMSI KRISHNA MYALAPALLI (vamsikrishna.vasu@gmail.com)
 *
 */

// This class serves as In Memory database (IMDB)
public class Imdb {

	private static Map<Integer, Message> messages = new HashMap<>();

	public static Map<Integer, Message> getMessages() {
		return messages;
	}
	
}
