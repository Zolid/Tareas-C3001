
public class ArbolABB implements ArbolBinario{
	
	public class Nodo {
		int info;
		Nodo izq, der;
		
		public Nodo(int x){
			this.info = x;
		}
	}
	
	Nodo raiz;
	
	public ArbolABB(){
		raiz = null;
	}
	
	public boolean buscar(int x){
		return buscar(x, this.raiz);
	}
	
	private boolean buscar(int x, Nodo nodo){
		if (nodo.info == x){
			return true;
		}
		else if (nodo.info > x){
			if (nodo.izq != null){
				return buscar(x, nodo.izq);
			}
			else{
				return false;
			}
		}
		else if (nodo.info < x){
			if (nodo.der != null){
				return buscar(x, nodo.der);
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	
	public void insertar(int x){
		this.raiz = insertar(x, this.raiz);
	}
	
	private Nodo insertar(int x, Nodo nodo){
		Nodo nuevo = new Nodo(x);
		if (nodo == null){
			nodo = nuevo;
		}
		else if (nodo.info > x){
			if (nodo.izq == null){
				nodo.izq = nuevo;
			}
			else{
				nodo.izq = insertar(x, nodo.izq);
			}
		}
		else if (nodo.info < x){
			if (nodo.der == null){
				nodo.der = nuevo;
			}
			else{
				nodo.der = insertar(x, nodo.der);
			}
		}
		return nodo;
	}
	
	public static int altura(Nodo raiz){
		if(raiz == null) return 0;
		return 1 + Math.max(altura(raiz.izq), altura(raiz.der));
	}
	
	static public void main(String[] args){
		ArbolABB abb = new ArbolABB();
		for (int i = 1; i<=1000; i++){
			abb.insertar(i);
			
		}
		System.out.println(abb.buscar(500));
	}
}
