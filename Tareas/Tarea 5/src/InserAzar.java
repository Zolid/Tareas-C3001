import java.util.Random;
// Para el calculo más certero de los datos de cada arbol, mejor ejecutar el código con un arbol, y dejar el resto en comentarios
public class InserAzar {
	
	static public void main(String[] args){
		
		//ABB
		ArbolABB abb = new ArbolABB();
		
		int n1 = 1500;  //numeros aleatorios
	    int k1 = n1;  //auxiliar;
	    int[] numeros1 = new int[n1];
	    int[] resultado1 = new int[n1];
	    Random rnd1 = new Random();
	    int res1;
	    
	    for(int i = 0; i < n1; i++){
	        numeros1[i] = i + 1;
	    }
	        
	        for(int i = 0; i < n1 ; i++){
	            res1 = rnd1.nextInt(k1);            
	            resultado1[i] = numeros1[res1]; //matriz donde se almacenan los numeros aleatorios
	            numeros1[res1] = numeros1[k1-1];
	            k1--;
	        }
	        
	        long start = System.currentTimeMillis();
	        for(int i=0;i<=1000;i++){
	        	abb.insertar(resultado1[i]);
	        }
	        long finish = System.currentTimeMillis() - start;
	        System.out.println("La inserción para un ABB demora "+finish+" ms.");
			System.out.println("La altura del árbol ABB es "+abb.altura(abb.raiz)+".");
			
			
			//AVL
			ArbolAVL avl = new ArbolAVL();
			
			int n2 = 1500;  //numeros aleatorios
		    int k2 = n2;  //auxiliar;
		    int[] numeros2 = new int[n2];
		    int[] resultado2 = new int[n2];
		    Random rnd2 = new Random();
		    int res2;
		    
		    for(int i = 0; i < n1; i++){
		        numeros2[i] = i + 1;
		    }
		        
		        for(int i = 0; i < n1 ; i++){
		            res2 = rnd2.nextInt(k2);            
		            resultado2[i] = numeros2[res2]; //matriz donde se almacenan los numeros aleatorios
		            numeros2[res2] = numeros2[k2-1];
		            k2--;
		        }
		        
		        long start2 = System.currentTimeMillis();
		        for(int i=0;i<=1000;i++){
		        	avl.insertar(resultado2[i]);
		        }
		        long finish2 = System.currentTimeMillis() - start2;
		        System.out.println("La inserción para un AVL demora "+finish2+" ms.");
				System.out.println("La altura del árbol AVL es "+avl.alture(avl.raiz)+".");
				
		//ARN
		ArbolRN arn = new ArbolRN();
				
		int n3 = 1500;  //numeros aleatorios
		int k3 = n3;  //auxiliar;
		int[] numeros3 = new int[n3];
		int[] resultado3 = new int[n3];
		Random rnd3 = new Random();
		int res3;
			    
		for(int i = 0; i < n1; i++){
			numeros3[i] = i + 1;
		}
			        
		for(int i = 0; i < n1 ; i++){
			 res3 = rnd3.nextInt(k3);            
			 resultado3[i] = numeros3[res3]; //matriz donde se almacenan los numeros aleatorios
			 numeros3[res3] = numeros3[k3-1];
			 k3--;
		}
			        
		long start3 = System.currentTimeMillis();
		for(int i=0;i<=1000;i++){
			  arn.insertar(resultado3[i]);
		}
		long finish3 = System.currentTimeMillis() - start3;
		System.out.println("La inserción para un ARN demora "+finish3+" ms.");
		System.out.println("La altura del árbol ARN es "+arn.altura(arn.raiz)+".");		
		
	}
	
	

}
