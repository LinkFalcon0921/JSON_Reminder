package Managers;

import data.Letters;

public class CreateLetters {
	
	private static CreateLetters creator;
	
	private CreateLetters() {
		
	}
	
	public static CreateLetters get() {
		if(creator == null)
			creator = new CreateLetters();
		
		return creator;
	}

	public Letters create(final String subj, String description) {
		Letters letter;
		if (subj == null) {
			return null;
		}
		
		letter = new Letters(subj,description);
		letter.setDate();
		
		return letter;
	}
}
