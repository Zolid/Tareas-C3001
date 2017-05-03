
public class ArbolAVL implements ArbolBinario{
	
	public class Nodo {
		int info, altura;
		Nodo izq, der;
		
		public Nodo(){
			info = 0;
			altura = 0;
			izq = null;
			der = null;
		}
	}
	
	Nodo raiz;
	
	public ArbolAVL(){
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
	
	private int altura(Nodo nodo){
		if (nodo == null){
			return 0;
		}
		else{
			return nodo.altura;
		}
	}
	
	private Nodo rotacionSimpleIzq(Nodo padre){
		Nodo hijo = padre.izq;
		padre.izq = hijo.der;
		hijo.der = padre;
		padre.altura = Math.max(altura(padre.izq), altura(padre.der)) + 1;
		hijo.altura = Math.max(altura(hijo.izq), altura(hijo.der)) + 1;
		return hijo;
	}
	
	private Nodo rotacionDobleIzq(Nodo nodo){
		nodo.izq = rotacionSimpleDer(nodo.izq);
		return rotacionSimpleIzq(nodo);
	}
	
	private Nodo rotacionSimpleDer(Nodo padre){
		Nodo hijo = padre.der;
		padre.der = hijo.izq;
		hijo.izq = padre;
		padre.altura = Math.max(altura(padre.izq), altura(padre.der)) + 1;
		hijo.altura = Math.max(altura(hijo.izq), altura(hijo.der)) + 1;
		return hijo;
	}
	
	private Nodo rotacionDobleDer(Nodo nodo){
		nodo.der = rotacionSimpleIzq(nodo.der);
		return rotacionSimpleDer(nodo);
	}
	
	public void insertar(int x){
		this.raiz = insertar(x, this.raiz);
	}
	
	private Nodo insertar(int x, Nodo nodo){
		Nodo nuevo = new Nodo();
		if (nodo == null){
			nuevo.info = x;
			nuevo.altura = nuevo.altura + 1;
			return nuevo;
		}
		nuevo = nodo;
		if (nodo.info > x){
			nuevo.izq = insertar(x, nuevo.izq);
			nuevo.altura = nuevo.izq.altura + 1;
			if (altura(nuevo.izq) - altura(nuevo.der) == 2){ 
				if (nuevo.izq.info > x){
					nuevo = rotacionSimpleIzq(nuevo);
				}
				else{
					nuevo = rotacionDobleIzq(nuevo);
				}
			}
		}
		else if (nodo.info < x){
			nuevo.der = insertar(x, nuevo.der);
			nuevo.altura = nuevo.der.altura + 1;
			if (altura(nuevo.der) - altura(nuevo.izq) == 2){ 
				if (nuevo.der.info < x){
					nuevo = rotacionSimpleDer(nuevo);
				}
				else{
					nuevo = rotacionDobleDer(nuevo);
				}
			}
		}
		return nuevo;
	}
	
	public static int alture(Nodo raiz){
		if(raiz == null) return 0;
		return 1 + Math.max(alture(raiz.izq), alture(raiz.der));
	}

}
