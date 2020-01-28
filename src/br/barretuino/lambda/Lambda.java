package br.barretuino.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lambda {
	
	public static void main(String[] args) {
		List<Tarefa> lista = new ArrayList<Tarefa>();
		
		for(int i=0; i<100; i++) {
			int tempo = (int) (Math.random() * 100);
			lista.add(new Lambda().new Tarefa("Tarefa " + i, tempo));
		}
		
		System.out.println("Inicio dos Testes");
		
		long inicio = System.currentTimeMillis();
		imprimirItensB(lista);
		System.out.println("Resolução Típica - Execução levou " + (System.currentTimeMillis() - inicio) + " ms");
		
		inicio = System.currentTimeMillis();
		imprimirItens(lista);
		System.out.println("Sugestão Otimizada - Execução levou " + (System.currentTimeMillis() - inicio) + " ms");
		
		
	}
	
	/**
	 * Situação Problema
	 * Baseado na classe Tarefa, utilizando Tarefa::getTempo, imprima em ordem crescente, 
	 * posteriormente em ordem decrescente a lista de tarefas informada no método imprimirItens
	 */
	class Tarefa {
		private String titulo;
		private int tempo;
		
		public Tarefa(String titulo, int tempo) {
			this.titulo = titulo;
			this.tempo = tempo;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public int getTempo() {
			return tempo;
		}

		public void setTempo(int tempo) {
			this.tempo = tempo;
		}
		
		@Override
		public String toString() {
			return "[" + getTitulo() + ", " + getTempo() + "]";
		}
	}
	
	//Sugestão de Solução Otimizada
	public static void imprimirItens(List<Tarefa> lista) {		
		//Imprimir na Ordem Crescente		
		lista.stream().sorted((a,b)->a.getTempo()>b.getTempo() ? 1 : -1).forEach(System.out::println);		
				
		//Imprimir na Ordem Decrescente
		lista.stream().sorted((a,b)->a.getTempo()>b.getTempo() ? -1 : 1).forEach(System.out::println);		
	}
	
	//Solução apresentada por um desenvolvedor
	public static void imprimirItensB(List<Tarefa> lista) {

		//crescente
		Collections.sort(lista, new Comparator<Tarefa>() {
			@Override
			public int compare(Tarefa t1, Tarefa t2) {
				if(t1.getTempo() < t2.getTempo()) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		lista.stream().forEach(l -> System.out.println(l.titulo));
		
		//decrescente
		System.out.println("\n");
		Collections.sort(lista, new Comparator<Tarefa>() {
			@Override
			public int compare(Tarefa t1, Tarefa t2) {
				if(t1.getTempo() > t2.getTempo()) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		lista.stream().forEach(l -> System.out.println(l.titulo));		
	}
}
