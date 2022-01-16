package main;

import java.util.Iterator;
import java.util.Scanner;

import Managers.ManageLetters;
import data.Letters;

public class Program {
	public static void main(String[] args) {
		
		boolean state = true;
		Scanner sc = new Scanner(System.in);

		print("Hola");
		print("Ingrese su nombre: ");
		String name = sc.next();
		
		ManageLetters manager = new ManageLetters(name);
		
		do {
			menu();
			int ch = sc.nextInt();

			switch (ch) {
			//Agregar
			case 1:
				print("Ingrese el titulo:");
				String sb = sc.next();
				print("Ingrese la descripcion:");
				String desc = sc.next();

				manager.createLetter(sb, desc);
				print("Archivo creado");
				break;

				//Mostrar
			case 2:
				print(manager.getList());
				break;
				
			//Salir
			case 3:
				state = false;
				break;
			}

		} while (state);
		
		manager.CreateDocument(name);
		sc.close();
	}

	private static void menu() {
		System.out.println("Menu\n" + "1. Agregar recordatorio.\n" + "2. Mostrar recordatorio.\n" + "3.Salir.");
	}

	private static void print(String data) {
		System.out.println(data);
	}

	private static void print(Iterator<Letters> data) {
		String divide = "-".repeat(12);

		print("Listado\n");
		
		while (data.hasNext()) {
			Letters info = data.next();
			print(info.getSUBJECT());
			print(info.getDescp());
			print(divide);
		}
	}
}