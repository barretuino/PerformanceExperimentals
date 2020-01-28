package br.barretuino.autoboxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Autoboxing e unboxing
 * Possui relação com wrapper de objetos
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
	 * Autoboxing e unboxing em Java são basicamente recursos para converter tipos de dados primitivos para objetos e reverter.
	 * Todo o processo é feito automaticamente em tempo de execução Java. "Cuidados devem ser tomados durante a implementação desse 
	 * recurso caso contrário, terá efeito negativo sobre o desempenho do aplicativo" (Kaushik Pal).
	 * 
	 * o método somarNumerosInteiros implementa um tipico exemplo de Autoboxing.
	 * Considerando que este método receberá 1_000_000 valores que representam o número de volumes comportados em cada endereço logístico
	 * de um Centro de Distribuição de mercadorias de uma rede de supermercados, e que este devolverá a capacidade total em número de posições
	 * do Centro de Distribuição. 
	 * 
	 * Face a essas informações, melhore a performânce desse método. Você tem liberdade para modificar o retorno, mantendo a compatibilidade do tipo.
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