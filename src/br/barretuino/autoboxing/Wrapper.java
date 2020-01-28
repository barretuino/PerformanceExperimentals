package br.barretuino.autoboxing;

/**
 * Exemplo de Wrapper
 * @author Paulo Barreto
 */
public class Wrapper {
	public static void main(String[] args) {
		System.out.println(new Double(100.1));
		System.out.println((double)100.1);
		
		//Passa um Double, retorna um double
		long inicio = System.currentTimeMillis();
		System.out.println(recebe(new Double(1.167)));
		System.out.println("Passa um Double, retorna um double --> " + (System.currentTimeMillis() - inicio) + " ms");
		
		//Passa um double, retorna um Double
		inicio = System.currentTimeMillis();
		System.out.println(recebe((double) 1.167));
		System.out.println("Passa um double, retorna um Double --> " + (System.currentTimeMillis() - inicio) + " ms");
		
		//Passa um Double, retorna um Double
		inicio = System.currentTimeMillis();
		System.out.println(recebeD(new Double(1.167)));
		System.out.println("Passa um Double, retorna um Double --> " + (System.currentTimeMillis() - inicio) + " ms");
		
		//Passa um double, retorna um double
		inicio = System.currentTimeMillis();
		System.out.println(recebed((double) 1.167));
		System.out.println("Passa um double, retorna um double --> " + (System.currentTimeMillis() - inicio) + " ms");
		
		
		//Exemplo contendo a típica atualização em massa de valores
		//20 Lojas x 60_000 itens a serem atualizados x 130 resultados (vnd_vi_vendas_diarias por exemplo)
		double valores[] = new double[130];		
		for(int i=0; i<130; i++) {
			valores[i] = Math.random();
		}
		
		inicio = System.currentTimeMillis();
		System.out.println(recebe(1_200_000, (double)0.10, valores));
		System.out.println("Passa um double, retorna um double --> " + (System.currentTimeMillis() - inicio) + " ms");
		
		
	}
	
	public static Double recebe(double valor) {
		for(int i=0; i<1_000_000; i++) {
			valor += 1;
		}
		return valor;
	}
	public static double recebe(Double valor) {
		for(int i=0; i<1_000_000; i++) {
			valor += 1;
		}
		return valor;
	}
	public static Double recebeD(Double valor) {
		for(int i=0; i<1_000_000; i++) {
			valor += 1;
		}
		return valor;
	}
	public static double recebed(double valor) {
		for(int i=0; i<1_000_000; i++) {
			valor += 1;
		}
		return valor;
	}
	
	public static double recebe(int passos, double valor, double...valores) {
		double retorno = 0D;		
		for(int i=0; i <= passos; i++) {
			for(int c=0; c<valores.length; c++) {
				retorno += valores[c]*valor;				
			}
		}		
		return retorno;
	}
}