package Managers;

import data.Letters;

public class EditLetters {
	
	private static EditLetters editor;

	private EditLetters() {
		
	}
	
	public static EditLetters get() {
		if(editor == null)
			editor = new EditLetters();
		
		return editor;
	}
	
	public boolean edit(Letters letter, String description) {
		
		if(letter == null || description == null || description.isBlank())
			return false;
		
		letter.setDescp(description);
		return true;
	}
}
