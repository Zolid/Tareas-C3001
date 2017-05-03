
public class MAX_HEAP {
	
	double[] arreglo;
	int numElem;
	int cap = 100;
	
	public MAX_HEAP(){
		arreglo = new double[cap];
		numElem = 0;
	}
	
	public MAX_HEAP(int cap){
		arreglo = new double[cap];
		numElem = 0;
	}
	
	public int largo(){
		return numElem;
	}
	
	public boolean estaVacia(){
		return (numElem == 0);
	}
	
	public double getMax(){
		if (estaVacia()){
			return 0;
		}
		return arreglo[1];
	}
	
	public double extraerMax(){
		double m=arreglo[1];
		arreglo[1] = arreglo[numElem--];
		int j = 1;
		while (2*j <= numElem){
			int k = 2*j;
			if(k+1<=numElem && arreglo[k+1]>arreglo[k]){
				k++;
			}
			if (arreglo[j]>arreglo[k]){
				break;
			}
			double t = arreglo[j];
			arreglo[j] = arreglo[k];
			arreglo[k] = t;
			j = k;
		}
		return m;
	}
	
	public void insertarElemento(double x){
		if (largo()+1==arreglo.length){
			System.out.println("Max-Heap lleno");
			System.exit(-1);
		}
		else{
			if (estaVacia()){
				arreglo[++numElem] = x;
			}
			else{
				arreglo[++numElem] = x;
				for (int j = numElem ; j>1 && arreglo[j]>arreglo[j/2]; j/=2){
					double t = arreglo[j];
					arreglo[j] = arreglo[j/2];
					arreglo[j/2] = t;
				}
			}
		}
	}
}
