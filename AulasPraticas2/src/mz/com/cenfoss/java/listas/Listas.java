package mz.com.cenfoss.java.listas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Listas {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<String>();
		lista.add("Demo");
		lista.add("De");
		lista.add("Uma");
		lista.add("Lista");
		
		System.out.println("Primeira Vez\n**************************************");
		for (Iterator iterator = lista.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
		System.out.println("\n\n\nSegunda Vez\n**************************************");
		for (int i = 0; i < lista.size(); i++) {
			String valor = lista.get(i);
			System.out.println(valor);
		}

	}
	
}
