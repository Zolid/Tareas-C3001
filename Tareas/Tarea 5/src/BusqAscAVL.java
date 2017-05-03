import java.util.Random;

public class BusqAscAVL {
	
		static public void main(String[] agrs){
		
			ArbolAVL avl = new ArbolAVL();
	
			int n1=1500;  //Rango de busqueda de numeros al azar 0 entre n1 
			int k1=n1;  
			int[] numeros1=new int[n1];
			int[] resultado1=new int[n1]; //matriz de numeros aleatorios
			Random rnd1=new Random();
			int res1;
	  
			for(int i=0;i<n1;i++){
	        numeros1[i]=i+1;
			}
	        
			for(int i=0;i<n1;i++){
				res1=rnd1.nextInt(k1);            
				resultado1[i]=numeros1[res1];
				numeros1[res1]=numeros1[k1-1];
				k1--;
			}
	   
			for(int i=0;i<=1000;i++){
				avl.insertar(i); // insercion de elementos dentro del arbol
			}
	       
			long start = System.currentTimeMillis();
			for(int i=0;i<=100;i++){//se buscan 100 elementos aleatorios dentro del arbol
				avl.buscar(resultado1[i]);
			}
			long finish = System.currentTimeMillis() - start;
			System.out.println("La busqueda para un AVL con llaves ascendentes demora "+finish+" ms");
		}

}
