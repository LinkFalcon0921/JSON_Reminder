package Managers;

import data.Letters;

public class CreateLetters {

	public Letters create(final String subj, String description) {

		if (subj == null) {
			return null;
		}
		
		return new Letters(subj,description);
	}
}
