public class ArbolRN implements ArbolBinario{
	
	static boolean rojo = true;
	static boolean negro = false;
	
	public class Nodo {
		int info;
		boolean color;
		Nodo padre, izq, der;
		
		public Nodo(int x){
			this.info = x;
			color = rojo;
		}
	}
	
	Nodo raiz;
	
	public ArbolRN(){
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
	
	private Nodo rotacionIzq(Nodo padre){
		Nodo hijo = padre.der;
		padre.der = hijo.izq;
		if (hijo.izq != null){
			hijo.izq.padre = padre;
		}
		if (hijo != null){
			hijo.padre = padre.padre;
		}
		if (padre.padre == null){
			raiz = hijo;
		}
		else if (padre == padre.padre.izq){
			padre.padre.izq = hijo;
		}
		else if (padre == padre.padre.der){
			padre.padre.der = hijo;
		}
		hijo.izq = padre;
		if (padre != null){
			padre.padre = hijo;
		}
		return hijo;
	}
	
	private Nodo rotacionDer(Nodo padre){
		Nodo hijo = padre.izq;
		padre.izq = hijo.der;
		if (hijo.der != null){
			hijo.der.padre = padre;
		}
		if (hijo != null){
			hijo.padre = padre.padre;
		}
		if (padre.padre == null){
			raiz = hijo;
		}
		else if (padre == padre.padre.der){
			padre.padre.der = hijo;
		}
		else if (padre == padre.padre.izq){
			padre.padre.izq = hijo;
		}
		hijo.der = padre;
		if (padre != null){
			padre.padre = hijo;
		}
		return hijo;
	}
	
	
	
	public void insertar(int x){
        Nodo nodo = new Nodo(x);
        if (raiz == null){
            raiz = nodo;
            raiz.color = negro;
            return;
        }
        Nodo padre = null;
        Nodo hijo = raiz;
        while (hijo != null){
        	padre = hijo;
            if (nodo.info < hijo.info){
                hijo = hijo.izq;
            }
            else{
                hijo = hijo.der;
            }
        }
        nodo.padre = padre;
        if (padre == null){
            raiz = nodo;
        }
        else if (nodo.info < padre.info){
            padre.izq = nodo;
        }
        else{
            padre.der = nodo;
        }
        //nodo.izq = null;
        //nodo.der = null;
        nodo.color = rojo;
        recuperarCondiciones(nodo);
    }
	
	private void recuperarCondiciones(Nodo nodo){
        while (nodo != raiz && nodo.padre.color == rojo){
            if (nodo.padre == nodo.padre.padre.izq){
                Nodo tio = nodo.padre.padre.der;
                if (tio != null && tio.color == rojo){
                    nodo.padre.color = negro;
                    tio.color = negro;
                    nodo.padre.padre.color = rojo;
                    nodo = nodo.padre.padre;
                }
               
                else {
                	if (nodo == nodo.padre.der){
                        nodo = nodo.padre;
                        rotacionIzq(nodo);
                    }
                nodo.padre.color = negro;
                nodo.padre.padre.color = rojo;
                rotacionDer(nodo.padre.padre);
                }
            }
            else{
                Nodo tio = nodo.padre.padre.izq;
                if (tio != null && tio.color == rojo){
                	nodo.padre.color = negro;
                    tio.color = negro;
                    nodo.padre.padre.color = rojo;
                    nodo = nodo.padre.padre;
                }
                else{
                    if (nodo == nodo.padre.izq){
                        nodo = nodo.padre;
                        rotacionDer(nodo);
                    }
                nodo.padre.color = negro;
                nodo.padre.padre.color = rojo;
                rotacionIzq(nodo.padre.padre);

                }

            }
            raiz.color = negro;
        }
    }
	
	public static int altura(Nodo raiz){
		if(raiz == null) return 0;
		return 1 + Math.max(altura(raiz.izq), altura(raiz.der));
	}
}
