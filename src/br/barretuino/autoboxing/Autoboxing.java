package br.barretuino.autoboxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Autoboxing e unboxing
 * Possui rela��o com wrapper de objetos
 * Introduzida na J2SE 5.0
 * @autor: Paulo C. Barreto
 */

public class Autoboxing {
//	public static void main(String[] args) {
//		List<Integer> intList = new ArrayList<Integer>();
//		for(int i=0; i < 2_000_000; i++) {
//			intList.add((int)Math.random());
//		}
//		
//		somarNumerosInteiros(intList);
//	}
	
	/**
	 * Autoboxing e unboxing em Java s�o basicamente recursos para converter tipos de dados primitivos para objetos e reverter.
	 * Todo o processo � feito automaticamente em tempo de execu��o Java. "Cuidados devem ser tomados durante a implementa��o desse 
	 * recurso caso contr�rio, ter� efeito negativo sobre o desempenho do aplicativo" (Kaushik Pal).
	 * 
	 * o m�todo somarNumerosInteiros implementa um tipico exemplo de Autoboxing.
	 * Considerando que este m�todo receber� 1_000_000 valores que representam o n�mero de volumes comportados em cada endere�o log�stico
	 * de um Centro de Distribui��o de mercadorias de uma rede de supermercados, e que este devolver� a capacidade total em n�mero de posi��es
	 * do Centro de Distribui��o. 
	 * 
	 * Face a essas informa��es, melhore a perform�nce desse m�todo. Voc� tem liberdade para modificar o retorno, mantendo a compatibilidade do tipo.
	 */
	/**public static int somarNumerosInteiros(List<Integer> intList) {
		long inicio = System.currentTimeMillis();
		int soma = 0; 
		for (int i: intList) { 			
			soma += i; 			
		}
		long fim = System.currentTimeMillis();
		System.out.println("Tempo " + (fim - inicio) + " ms");
		return soma; 
	}*/
	
	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<Integer>();
		int listaA[] = new int[10_000_000];
		for(int i=0; i<10_000_000; i++) {
			listaA[i] = (int) (Math.random() * 100);
			lista.add(listaA[i]);
		}
		System.out.println("Soma com Autoboxing " + somarNumerosInteiros(lista));
		System.out.println("Soma simples " + somarNumerosInteiros(listaA));	
	}
	
	public static int somarNumerosInteiros(List<Integer> intList) {
		long inicio = System.currentTimeMillis();
		int sum = 0; 
		for (Integer i: intList) { 
			if ( i % 2 == 0 ) { 
				sum += i; 
			}
		}
		long fim = System.currentTimeMillis();
		System.out.println("Tempo " + (fim - inicio) + " ms");
		return sum; 
	}
	
	public static int somarNumerosInteiros(int intList[]) {
		long inicio = System.currentTimeMillis();
		int sum = 0; 
		for (int i: intList) { 
			if ( i % 2 == 0 ) { 
				sum += i; 
			}
		}
		long fim = System.currentTimeMillis();
		System.out.println("Tempo " + (fim - inicio) + " ms");
		return sum; 
	}
}