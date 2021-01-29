package edu.sagah.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapMaximo {
	
	private int[] Heap; 
	private int tamanho; 
	private int tamanhoMaximo; 

	/**
	 * Novo método
	 */
	public HeapMaximo() {
		
	}
	
	
	
	
	public HeapMaximo(int maxsize) 
	{ 
		this.tamanhoMaximo = maxsize; 
		this.tamanho = 0; 
		Heap = new int[this.tamanhoMaximo + 1]; 
		Heap[0] = Integer.MAX_VALUE; 
	}
	
	/**
	 * 
	 */
	public void definirValores(int[] valores) {
		this.tamanhoMaximo = valores.length; 
		this.tamanho = valores.length; 
		Heap = new int[this.tamanhoMaximo + 1]; 
		Heap[0] = Integer.MAX_VALUE;
		for (int pos = 1; pos <= this.tamanhoMaximo; ++pos)
			Heap[pos] = valores[pos - 1];
	}
	
	
	public boolean ehHeapMaximo() {
		
		boolean ehHeap = true;
		int valorPai, valorFilhoEsq, valorfilhoDir;
		
		for (int i = 1; i <= this.tamanho/2; ++i) {
			valorPai = Heap[i];
			valorFilhoEsq = Heap[filhoAEsquerda(i)];
			valorfilhoDir = Heap[filhoADireita(i)];
			
			if (valorPai < valorFilhoEsq || valorPai < valorfilhoDir) {
				ehHeap = false;
				break;
			}
		}
		
		return ehHeap;
	}

	// Returns position of parent 
	private int noPai(int pos) 
	{ 
		return pos / 2; 
	} 

	// Below two functions return left and 
	// right children. 
	private int filhoAEsquerda(int pos) 
	{ 
		return (2 * pos); 
	} 
	private int filhoADireita(int pos) 
	{ 
		return 2 * pos + 1; 
	} 

	// Returns true of given node is leaf 
	private boolean ehNoFolha(int pos) 
	{ 
		if (pos >= (tamanho / 2) && pos <= tamanho) { 
			return true; 
		} 
		return false; 
	} 

	private void trocarPosicoes(int fpos, int spos) 
	{ 
		int tmp; 
		tmp = Heap[fpos]; 
		Heap[fpos] = Heap[spos]; 
		Heap[spos] = tmp; 
	} 

	// A recursive function to max heapify the given 
	// subtree. This function assumes that the left and 
	// right subtrees are already heapified, we only need 
	// to fix the root. 
	public void repararHeap(int pos) 
	{ 
		if (ehNoFolha(pos)) return;
		int esq = filhoAEsquerda(pos);
		int dir = filhoADireita(pos);
		int maior = pos;

		if (esq <= this.tamanhoMaximo && Heap[esq] > Heap[pos]) 
			maior = esq;
		
		if (dir <= this.tamanhoMaximo && Heap[dir] > Heap[maior])
			maior = dir;
		
		if (maior != pos) {
			trocarPosicoes(pos, maior);
			repararHeap(maior);
		}

	} 
	
	public void construirDeBaixoParaCima() {
		
		for (int i  = this.tamanho / 2; i >= 1; --i) {
			
			int pai = i;
			int valorPai = Heap[pai];
			boolean ehHeap = false;
			
			while (!ehHeap && 2*pai <= this.tamanho) {
				
				int filho = 2*pai;
				
				if (filho < this.tamanho) {
					if (Heap[filho] < Heap[filho + 1]) filho++;
				}
				
				if (valorPai >= Heap[filho]) {
					ehHeap = true;
				}
				else {
					Heap[pai] = Heap[filho];
					pai = filho;
				}
				Heap[pai] = valorPai;
			}
		}
	}
	
	
	public void inserir(int elemento) 
	{ 
		Heap[++tamanho] = elemento; 

		int atual = tamanho; 
		while (Heap[atual] > Heap[noPai(atual)]) { 
			trocarPosicoes(atual, noPai(atual)); 
			atual = noPai(atual); 
		} 
	} 


	public int removerMaximo() { 
		int removido = Heap[1]; 
		Heap[1] = Heap[tamanho--]; 
		repararHeap(1); 
		return removido; 
	} 
	

	
	public void imprimir() {
		
		for (int i = 1; i <= tamanho / 2; i++) { 
			System.out.print(" PAI : " + Heap[i] + 
					" FILHO ESQUERDA : " + Heap[2 * i] + 
					" FILHO DIREITA : " + Heap[2 * i + 1]); 
			System.out.println(); 
		} 
	} 

	
	public void printPriorityQueue() {
		
		PriorityQueue<String> heap = new PriorityQueue<>(Comparator.reverseOrder());
		heap.add("O");
		heap.add("R");
		heap.add("D");
		heap.add("E");
		heap.add("N");
		heap.add("A");
		heap.add("S");
		heap.forEach(System.out::print);
		System.out.println("\nRaiz: " + heap.element());
		heap.remove();
		System.out.println("\nRaiz: " + heap.element());
	}
	
	public void atualizar(int original, int atual) {
		for (int i = 1; i <= this.tamanho; ++i) {
			if (Heap[i] == original) {
				Heap[i]  = atual;
				
				int corrente = i;
				while (Heap[corrente] > Heap[noPai(corrente)]) { 
					trocarPosicoes(corrente, noPai(corrente)); 
					corrente = noPai(corrente); 
				} 
			}
		}
	}

	public static void main(String[] arg) 
	{ 
		// Construção do Heap a partir da lista: 5, 3, 17, 10, 84, 19, 6, 22, 9
		/*
		HeapMaximo maxHeap = new HeapMaximo(15); 
		maxHeap.inserir(5); 
		maxHeap.inserir(3); 
		maxHeap.inserir(17); 
		maxHeap.inserir(10); 
		maxHeap.inserir(84); 
		maxHeap.inserir(19); 
		maxHeap.inserir(6); 
		maxHeap.inserir(22); 
		maxHeap.inserir(9); 

		maxHeap.imprimir(); 
		System.out.println("O valor máximo do heap é: " + maxHeap.removerMaximo()); 
		*/
		/*
		HeapMaximo noHeap = new HeapMaximo();
		noHeap.definirValores(new int[] { 5, 3, 17, 10, 84, 19, 6, 22, 9 });
		System.out.println("Eh heap maximo: " + noHeap.ehHeapMaximo());
		*/
		
		HeapMaximo heap = new HeapMaximo();
		heap.definirValores(new int[] { 8, 5, 7, 1, 3, 6, 4 });
		System.out.println("Eh heap maximo: " + heap.ehHeapMaximo());
		heap.atualizar(3,  9);
		System.out.println("Eh heap maximo: " + heap.ehHeapMaximo());
		heap.imprimir();
			
		
	} 
} 

