package Managers;

import data.Letters;

public class EditLetters {
	public boolean EditLetters(Letters letter, String description) {
		
		if(letter == null || description == null || description.isBlank())
			return false;
		
		letter.setDescp(description);
		return true;
	}
}
