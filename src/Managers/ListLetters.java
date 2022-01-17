package Managers;

import java.util.*;
import data.Letters;

public class ListLetters {
	private Stack<Letters> letters;
	
	public ListLetters(Stack<Letters> let) {
		letters = let;
	}
	
	public void add(Letters letter) {
		letters.add(letter);
	}
	
	public boolean contains(Letters letter) {
		return letters.contains(letter);
	}
	
	public Iterator<Letters> getIterator() {
		return letters.iterator();
	}
	
	public Letters get(String subj) {
		if(!letters.isEmpty()) {
			return (Letters) letters.stream().filter(d -> d.getSUBJECT().equals(subj)).findFirst().get().clone();
		}
		
		return null;
	}
	
}
