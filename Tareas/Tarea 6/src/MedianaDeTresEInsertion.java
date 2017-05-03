import java.util.*;

public class MedianaDeTresEInsertion implements Ordenacion {
	
	int[] arreglo;
	
	public MedianaDeTresEInsertion(){
		this.arreglo = null;
	}
	
	public void ordenar(int[] a){
		this.arreglo = a;
		Sort(this.arreglo, 0, a.length - 1);
	}
	
	public String print(){
		return Arrays.toString(this.arreglo);
	}
	
	 static void Sort(int[] a, int lo, int hi) {
		 	int M = 10;
		 	if (hi - lo + 1 < M){
		 		insertionSort(a, lo, hi);
		 	}
		 	else{
	        	int k = particionar(a, lo, hi);
		        Sort(a, lo, k-1);
		        Sort(a, k+1, hi);
	        }
	    }
	
	static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	 public static int medianaDe3(int[] a, int lo, int hi) {
		    int ce = (lo + hi) / 2;

		    if (a[lo] > a[ce])
		      swap(a, lo, hi);

		    if (a[lo] > a[hi])
		      swap(a, lo, hi);

		    if (a[ce] > a[hi])
		      swap(a, ce, hi);

		    swap(a, ce, hi - 1);
		    return hi - 1;
		  }
		  
	
	static int particionar(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        //Eleccion del pivote
        int ip = medianaDe3(a, lo, hi);
        swap(a,lo,ip);

        int p = a[lo];
        while (true) {
            // Avanzar i
            while (a[++i] < p)
                if (i == hi) break;

            // Avanzar j
            while (p < a[--j])
                if (j == lo) break;

            if (i >= j) break;

            swap(a,i,j);
        }
        // Poner el pivote en su posicion
        swap(a,lo,j);

        return j;
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
	
	static public boolean less(int a, int b){
		return a < b;	
	}
	
	private static void insertionSort( int[ ] a, int low, int high ) {
        for( int p = low + 1; p <= high; p++ ) {
            int tmp = a[ p ];
            int j;
             
            for( j = p; j > low && less(a[p], a[j - 1]); j-- )
                a[ j ] = a[ j - 1 ];
            a[ j ] = tmp;
        }
    }
	 
	 static public void main(String[] args){
			int[] a = permutacion((int) Math.pow(10,6));
			Ordenacion m = new MedianaDeTresEInsertion();
			long start = System.currentTimeMillis();
			m.ordenar(a);
			long finish = System.currentTimeMillis() - start;
			System.out.println("El algoritmo demora "+finish+" milisegundos");
			//System.out.println(m.print());
		}

}
