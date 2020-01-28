package br.barretuino.advanced;

/**
 * Chamada de Argumentos Multivalorados
 * Introduzida na J2SE 5.0
 * @autor: Paulo C. Barreto
 */

public class ArgumentosMultivalorados {
	
	public static void main(String[] args) {		
		chamadaMultiParametro();
	}
		
	//Antes do Java 1.5	
	public static int somar(int[] nums) {
	    int total = 0;
	 
	    for (int i=0 ; i < nums.length ; i++) {
	        total += nums[i];
	    }
	 
	    return total;
	}
	public static int somar(int a, int b) {
	    return (a + b);
	}
	 
	public static int somar(int a, int b, int c) {
	    return (a + b + c);
	}
	 
	public static int somar(int a, int b, int c, int d) {
	    return (a + b + c + d);
	}
	 
	public static int somar(int a, int b, int c, int d, int e) {
	    return (a + b + c + d + e);
	}
	
	//A partir do Java 1.5
	/*public static int somar(int... nums) {
	    int total = 0;
	 
	    for (int i=0 ; i < nums.length ; i++) {
	        total += nums[i];
	    }
	 
	     return total;
	}*/
	
	/**
	 * Um único método que seja capaz de executar as duas invocações para executaAlgo 
	 */
	public static void chamadaMultiParametro() {
		executaAlgo(1);
		executaAlgo(1,2,7);
	}
	public static void executaAlgo(int...argumentos) {
		int soma = 0;
		for(int i : argumentos) {
			soma += i;
		}
		System.out.println(soma);
	}
}