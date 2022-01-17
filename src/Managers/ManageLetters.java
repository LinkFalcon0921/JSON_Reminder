package Managers;

import java.io.File;
import java.util.Iterator;
import java.util.Stack;

import javax.swing.JOptionPane;

import data.Letters;
import helpers.DataFiles;
import helpers.JsonSaves;
import helpers.JsonTakes;

public class ManageLetters {

	// Varibles to manage the IO Files
	private ListLetters list;
	private DataFiles files;

	public ManageLetters(String owner) {
		files = new DataFiles();
		Stack<Letters> lt = JsonTakes.getData(files.CreateFile(owner));
		list = new ListLetters(lt);
	}

	public void CreateDocument(final String owner) {
		if (owner == null || owner.isBlank()) {
			return;
		}

		File space = files.CreateFile(owner);

		if (JsonSaves.writeData(space, list.getIterator())) {
			System.out.println("\nArchivo creado correctamente");
		} else {
			System.out.println("\nArchivo no actualizado.");
		}
	}

	// Letters
	public void createLetter(String subj, String description) {
		if(subj.isBlank()) {
			return;
		}
		Letters letter = CreateLetters.get().create(subj, description);
		list.add(letter);
	}

	public Iterator<Letters> getList() {
		return list.getIterator();
	}

}
