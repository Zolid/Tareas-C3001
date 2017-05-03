import java.util.*;

public class MetodoClasico implements Ordenacion{
	
	int[] arreglo;
	
	public MetodoClasico(){
		this.arreglo = null;
	}
	
	public void ordenar(int[] a){
		this.arreglo = a;
		QuicksortMC(this.arreglo, 0, a.length - 1);
	}
	
	public String print(){
		return Arrays.toString(this.arreglo);
	}
		
	 static void QuicksortMC(int[] a, int lo, int hi) {
	        if (hi <= lo) return;
	        int k = particionar(a, lo, hi);
	        QuicksortMC(a, lo, k-1);
	        QuicksortMC(a, k+1, hi);
	    }
	
	static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int particionar(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        //Eleccion del pivote
        int ip = new Random().nextInt(hi-lo+1) + lo;
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
	
	static public void main(String[] args){
		int[] a = permutacion((int) Math.pow(10, 8));
		Ordenacion  m = new MetodoClasico();
		long start = System.currentTimeMillis();
		m.ordenar(a);
		long finish = System.currentTimeMillis() - start;
		System.out.println("El algoritmo demora "+finish+" milisegundos");
		//System.out.println(m.print());
	}

}
