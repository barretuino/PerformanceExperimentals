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
	 * - Crie uma coleção contendo cada uma das linguagens de programação
	 * - Exiba a lista em ordem alfabética
	 * - Remova as linguagens que contém a letra 'y' na descrição
	 * - Imprima a nova lista no console
	 * @param texto
	 */	
	public static void geraLista(String texto) {
		//Crie uma coleção contendo cada uma das linguagens de programação
		List<String> lista = new ArrayList<String>();
		for(String t : texto.replace("[", "").replaceAll("]", "").split(",")) {
			lista.add(t);
		}
		
		//Exiba a lista em ordem alfabética
		Collections.sort(lista, (a, b) -> a.compareTo(b));		
		imprimirLista(lista);
		
		//Remova as linguagens que contém a letra 'y' na descrição
		lista.removeIf(i->i.contains("y"));
		
		//Imprima a nova lista no console
		imprimirLista(lista);		
	}
	
	private static void imprimirLista(List<String> lista) {
		System.out.println("Impressão da Lista");
		for (String l : lista) {
			System.out.println(l);			
		}
	}
}
