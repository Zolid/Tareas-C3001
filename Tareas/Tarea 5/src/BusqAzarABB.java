import java.util.Random;

public class BusqAzarABB {
	
	static public void main(String[] agrs){
		ArbolABB abb = new ArbolABB();
	
		int n1=1500; //rango de elementos al azar para insertar  
	    int k1=n1;  
	    int[] numeros1=new int[n1];
	    int[] resultado1=new int[n1];
	    Random rnd1=new Random();
	    int res1;
	    
	    int n2=1500; //rango de elementos al azar para buscar
	    int k2=n2;  
	    int[] numeros2=new int[n2];
	    int[] resultado2=new int[n2];
	    Random rnd2=new Random();
	    int res2;
	       
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
	        	abb.insertar(resultado1[i]); //insercion de elementos al azar
	        }
	       
			
	        for(int i=0;i<n2;i++){
		        numeros2[i]=i+1;
		    }
		        
		        for(int i=0;i<n2;i++){
		            res2=rnd2.nextInt(k2);            
		            resultado2[i]=numeros2[res2];
		            numeros2[res2]=numeros2[k2-1];
		            k2--;
		            
		        }
		     System.out.println();
		     long start = System.currentTimeMillis();
		     for(int i=0;i<100;i++){
			   abb.buscar(resultado2[i]); //busqueda de elementos al azar
			 }
		     long finish = System.currentTimeMillis() - start;
			 System.out.println("La busqueda para un ABB con llaves escogidas al azar demora "+finish+" ms");
			
	}

}
