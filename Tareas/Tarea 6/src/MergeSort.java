import java.util.*;

public class MergeSort implements Ordenacion{
	
	int[] arreglo;
	
	public MergeSort(){
		this.arreglo = null;
	}
	
	public void ordenar(int[] a){
		this.arreglo = a;
		sort(this.arreglo, 0, a.length - 1);
	}
	
	public String print(){
		return Arrays.toString(this.arreglo);
	}
	
	public static void merge(int[] arreglo, int inicio, int centro, int termino){
		int largo1 = centro - inicio + 1;
		int largo2 = termino - centro;
		
		int[] arregloIzq = new int[largo1];
		int[] arregloDer = new int[largo2];
		
		for (int i = 0; i < largo1; ++i){
			arregloIzq[i] = arreglo[inicio + i];
		}
		for (int j = 0; j < largo2; ++j){
			arregloDer[j] = arreglo[centro + 1 + j];
		}
		
		int i = 0, j = 0;
		
		int k = inicio;
		while (i < largo1 && j < largo2){
			if (arregloIzq[i] <= arregloDer[j]){
				arreglo[k] = arregloIzq[i];
				++i;
			}
			else{
				arreglo[k] = arregloDer[j];
				++j;
			}
			++k;
		}
		while (i < largo1){
			arreglo[k] = arregloIzq[i];
			++i;
			++k;
		}
		while(j < largo2){
			arreglo[k] = arregloDer[j];
			++j;
			++k;
		}
	}
	
	public static void sort(int[] arreglo, int inicio, int termino){
		if (inicio < termino){
			int medio = (inicio + termino)/2;
			sort(arreglo, inicio, medio);
			sort(arreglo, medio + 1, termino);
			
			merge(arreglo, inicio, medio, termino);
		}
	}
	
	static public int[] permutacion(int n){
		int[] a = new int[n];
		for (int i = 0; i < n; i++){
			a[i] = i + 1;
		}
		Random rnd = new Random();
		for (int i = 0; i < n; i++){
			int r = i + rnd.nextInt(n - i);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
		return a;
	}
	
	static public void main(String[] args){
		int[] a = permutacion((int) Math.pow(10, 8));
		Ordenacion m = new MergeSort();
		long start = System.currentTimeMillis();
		m.ordenar(a);
		long finish = System.currentTimeMillis() - start;
		System.out.println("El algoritmo demora "+finish+" milisegundos");
		//System.out.println(m.print());
	}

}
