import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Diff {
	
	public static void leer(String archivo1, String archivo2) throws FileNotFoundException, IOException{
		File a1 = null; //Para abrir los archivos y leer los archivos
	    File a2 = null;
	    FileReader f1 = null;
	    FileReader f2 = null;
	    BufferedReader b1 = null;
	    BufferedReader b2 = null;
	    ArrayList<String> array1 = new ArrayList<String>();// Objeto de la clase Arraylist que guarda
	    ArrayList<String> array2 = new ArrayList<String>();// las lineas en diferentes indices
	    try{
	    	a1 = new File (archivo1);
	        a2 = new File (archivo2);
	        f1 = new FileReader (a1);
	        b1 = new BufferedReader(f1);
	        f2 = new FileReader (a2);
	        b2 = new BufferedReader(f2);
	        
		    String linea;
		    while(((linea=b1.readLine())!=null)){// Para guardar cada linea dentro del Arraylist
		    	array1.add(linea);}
		    
		    while(((linea=b2.readLine())!=null)){//idem
		    	array2.add(linea);}}
	    
	    catch(Exception e){//Excepciones en caso de algún error dentro de la apertura y lectura 
	         e.printStackTrace();}// de archivos
	    finally{
	         try{                    
	            if( null != f1 && null != f2){   
	               f1.close();
	               f2.close();}}
	         catch (Exception e2){ 
	            e2.printStackTrace();}}
	    
	    int[][] matriz = new int[array1.size()+1][array2.size()+1]; 
		for (int i = 0; i<=array1.size();++i){ // Implementación de la Función de Levenshtein
			matriz[i][0] = i;}
		for (int j = 0; j<=array2.size();++j){
			matriz[0][j] = j;}
		for (int i = 1; i<=array1.size();++i){
			for (int j = 1; j<=array2.size();++j){
		
				matriz[i][j] = Min(matriz[i-1][j]+1,matriz[i][j-1]+1,matriz[i-1][j-1]+((array1.get(i-1).equals(array2.get(j-1)))?0:1));
				//System.out.print(matriz[i][j]);
	}}
		
		ArrayList<String> array3 = new ArrayList<String>(); //En este arreglo vamos guardando las modificaciones a cada string
		int i = array1.size(), j = array2.size();  
		while (i>0 && j>0){ // Este while sirve para recorrer el camino minimo de la matriz,
							// desde el último elemento de la matriz ubicado en la esquina inferior derecha
			
			 if (matriz[i][j]==Min(matriz[i-1][j],matriz[i][j-1],matriz[i-1][j-1])){
				 if (matriz[i-1][j-1]!=matriz[i-1][j] && matriz[i-1][j-1]!=matriz[i][j-1]){
					 i--;
					 j--;}
				 else if (matriz[i-1][j-1]==matriz[i][j-1]){
					 j--;}
				 else if (matriz[i-1][j-1]==matriz[i-1][j]){
					 i--;}
				 }
				 
			 else if (matriz[i][j]!=Min(matriz[i-1][j],matriz[i][j-1],matriz[i-1][j-1])){
				 if (matriz[i][j]==matriz[i-1][j]+1){
					 array3.add(array1.indexOf(array1.get(i-1))+1+". "+array1.get(i-1)+" -> "+" ");
					 i--;
					 }
				 else if (matriz[i][j]==matriz[i][j-1]+1){	
					 array3.add(array2.indexOf(array2.get(j-1))+1+". "+" "+" -> "+array2.get(j-1));
					 j--;
					 }
				 else if (matriz[i][j]==matriz[i-1][j-1]+1){
					 array3.add(array2.indexOf(array2.get(j-1))+1+". "+array1.get(i-1)+" -> "+array2.get(j-1));
					 i--;
					 j--;
					 }
			 }}
		
		//System.out.println("java Diff A.txt B.txt");
		for (int k = 0; k<=array3.size()-1;++k){// Se recorre el arreglo para imprimir la modificaciones en el orden pedido
			System.out.print(array3.get((array3.size()-1)-k)+"\n");}
		System.out.println("Distance = "+matriz[array1.size()][array2.size()]);
			
		
	}
	
	private static int Min(int n1, int n2, int n3){// Función mínimo de 3 elementos 
		if (n1 <= n2 && n1 <=n3){return n1;}
		if (n2 <= n1 && n2 <= n3){return n2;}
		return n3;}
	
	public static void main(String[] args) throws IOException{
		leer("A.txt","B.txt");}
	
	

}
