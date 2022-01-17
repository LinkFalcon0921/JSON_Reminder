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

		if (subj == null) {
			return null;
		}
		
		return new Letters(subj,description);
	}
}
