package helpers;

import java.io.*;
import java.util.Iterator;

import data.Letters;

public class DataFiles {

	public DataFiles() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Crea el archivo de recordatorios para los clientes.
	 * 
	 * @throws IOException
	 */
	public File CreateFile(String filename) {
		filename = String.format(PathsTo.get().getLettersPath() + filename + ".txt");
		File site = new File(filename);

		// Si el archivo ya existe devuelvelo.
		if (site.exists())
			return site;

		// Consiste en crear el archivo en caso de que no exista.
		try {

			if (site.createNewFile())
				return site;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	public static void main(String[] args) {
		DataFiles file = new DataFiles();

	}
}
