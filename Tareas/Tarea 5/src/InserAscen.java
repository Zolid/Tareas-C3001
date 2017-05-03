
public class InserAscen {
	
public static void main(String[] args) {
		
		long start1 = System.currentTimeMillis();
		ArbolABB abb = new ArbolABB();
		for (int i = 1; i<=1000; ++i){// para hacer pruebas de inserciones cambiar 
			abb.insertar(i);			// los valores de i 
		}
		long finish1 = System.currentTimeMillis() - start1;
		System.out.println("La inserción para un ABB demora "+finish1+" ms.");
		System.out.println("La altura del árbol ABB es "+abb.altura(abb.raiz)+".");
		
		long start2 = System.currentTimeMillis();
		ArbolAVL avl = new ArbolAVL();
		for (int i = 1; i<=1000; ++i){ // para hacer pruebas de inserciones cambiar 
			avl.insertar(i);			// los valores de i  
		}
		long finish2 = System.currentTimeMillis() - start2;
		System.out.println("La inserción para un AVL demora "+finish2+" ms.");
		System.out.println("La altura del árbol AVL es "+avl.alture(avl.raiz)+".");
		
		long start3 = System.currentTimeMillis();
		ArbolRN arn = new ArbolRN();
		for (int i = 1; i<=1000; ++i){ // para hacer pruebas de inserciones cambiar 
			arn.insertar(i);			// los valores de i  
		}
		long finish3 = System.currentTimeMillis() - start3;
		System.out.println("La inserción para un ARN demora "+finish3+" ms.");
		System.out.println("La altura del árbol es "+arn.altura(arn.raiz)+".");
	}

}
