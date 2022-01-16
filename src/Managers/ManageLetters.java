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
	private CreateLetters creator;
	private ListLetters list;
	//private EditLetters editor;
	private DataFiles files;
	

	public ManageLetters(String owner) {
		files = new DataFiles();
		creator = new CreateLetters();
		Stack<Letters> lt = JsonTakes.getData(files.CreateFile(owner));
		list = new ListLetters(lt);
		//editor = new EditLetters();
	}

	public void CreateDocument(final String owner) {
		if (owner == null || owner.isBlank()) {
				return;
		}

		File space = files.CreateFile(owner);

		if (JsonSaves.writeData(space, list.getIterator())) {
			JOptionPane.showMessageDialog(null, "Archivo creado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "Archivo no actualizado.");
		}
	}
	
	//Letters
	public void createLetter(String subj, String description) {
		list.add(creator.create(subj, description));
	}
	
	public Iterator<Letters> getList() {
		return list.getIterator();
	}
	

}
