package br.barretuino.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Filter {

	public static void main(String[] args) {
		geraLista("[Java, Delphi, C++, Java Script, Python, Adobe Flex, Fox Pro, Logo, Adabas, Ruby]");
	}
	
	/**
	 * Dada a String abaixo:
	 * 		"[Java, Delphi, C++, Java Script, Python, Adobe Flex, Fox Pro, Logo, Adabas, Ruby]"
	 * - Crie uma cole��o contendo cada uma das linguagens de programa��o
	 * - Exiba a lista em ordem alfab�tica
	 * - Remova as linguagens que cont�m a letra 'y' na descri��o
	 * - Imprima a nova lista no console
	 * @param texto
	 */	
	public static void geraLista(String texto) {
		//Crie uma cole��o contendo cada uma das linguagens de programa��o
		List<String> lista = new ArrayList<String>();
		for(String t : texto.replace("[", "").replaceAll("]", "").split(",")) {
			lista.add(t);
		}
		
		//Exiba a lista em ordem alfab�tica
		Collections.sort(lista, (a, b) -> a.compareTo(b));		
		imprimirLista(lista);
		
		//Remova as linguagens que cont�m a letra 'y' na descri��o
		lista.removeIf(i->i.contains("y"));
		
		//Imprima a nova lista no console
		imprimirLista(lista);		
	}
	
	private static void imprimirLista(List<String> lista) {
		System.out.println("Impress�o da Lista");
		for (String l : lista) {
			System.out.println(l);			
		}
	}
}
