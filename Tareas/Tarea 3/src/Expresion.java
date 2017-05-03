import java.util.Stack;
public class Expresion{
	
	NodoArbol arbol;
	
	public Expresion(String Formula){ // contructor que transforma el string en arbol :D
		if (Formula.equals(" ") || Formula.equals("")){
			System.out.println("Traducci贸n realizada, gracias.");
			System.exit(-1);
		}
		Stack<Object> pila = new Stack<Object>();
		String[] s = Formula.split(" ");
		for (int i = 0; i<s.length; ++i){
			NodoArbol arbol = new NodoArbol();
			String str = s[i];
			if (str.equals("+")){
				if (pila.size()==1 || pila.isEmpty()){
					System.out.println("Error: La notaci贸n ingresada es err贸nea !!!!!");
					System.out.println("Verifique que la notaci贸n ingresa es la correcta, y recuerde que "+str+" es un operador binario.");
					System.exit(-1);
				}
				arbol.info = str;
				Object obj2 = pila.pop();
				if (obj2 instanceof NodoArbol){
					arbol.der = (NodoArbol) obj2;
				}
				else{
					NodoArbol h2 = new NodoArbol(obj2,null,null);
					arbol.der = h2;
				}
				Object obj1 = pila.pop();
				if (obj1 instanceof NodoArbol){
					arbol.izq = (NodoArbol) obj1;
				}
				else{
					NodoArbol h1 = new NodoArbol(obj1,null,null);
					arbol.izq = h1;
				}
				pila.push(arbol);
			}
			else if (str.equals("_")){
				arbol.info = "-";
				Object obj2 = pila.pop();
				if (obj2 instanceof NodoArbol){
					arbol.der = (NodoArbol) obj2;
				}
				else{
					NodoArbol h2 = new NodoArbol(obj2,null,null);
					arbol.der = h2;
				}
				pila.push(arbol);
			}
			else if (str.equals("-")){
				if (pila.size()==1 || pila.isEmpty()){
					System.out.println("Error: La notaci贸n ingresada es err贸nea !!!!!");
					System.out.println("Verifique que la notaci贸n ingresa es la correcta, y recuerde que "+str+" es un operador binario.");
					System.exit(-1);
				}
				arbol.info = str;
				Object obj2 = pila.pop();
				if (obj2 instanceof NodoArbol){
					arbol.der = (NodoArbol) obj2;
				}
				else{
					NodoArbol h2 = new NodoArbol(obj2,null,null);
					arbol.der = h2;
				}
				Object obj1 = pila.pop();
				if (obj1 instanceof NodoArbol){
					arbol.izq = (NodoArbol) obj1;
				}
				else{
					NodoArbol h1 = new NodoArbol(obj1,null,null);
					arbol.izq = h1;
				}
				pila.push(arbol);
				
			}
			else if (str.equals("*")){
				if (pila.size()==1 || pila.isEmpty()){
					System.out.println("Error: La notaci贸n ingresada es err贸nea !!!!!");
					System.out.println("Verifique que la notaci贸n ingresa es la correcta, y recuerde que "+str+" es un operador binario.");
					System.exit(-1);
				}
				arbol.info = str;
				Object obj2 = pila.pop();
				if (obj2 instanceof NodoArbol){
					arbol.der = (NodoArbol) obj2;
				}
				else{
					NodoArbol h2 = new NodoArbol(obj2,null,null);
					arbol.der = h2;
				}
				Object obj1 = pila.pop();
				if (obj1 instanceof NodoArbol){
					arbol.izq = (NodoArbol) obj1;
				}
				else{
					NodoArbol h1 = new NodoArbol(obj1,null,null);
					arbol.izq = h1;
				}
				pila.push(arbol);
			
			}
			else if (str.equals("/")){
				if (pila.size()==1 || pila.isEmpty()){
					System.out.println("Error: La notaci贸n ingresada es err贸nea !!!!!");
					System.out.println("Verifique que la notaci贸n ingresa es la correcta, y recuerde que "+str+" es un operador binario.");
					System.exit(-1);
				}
				arbol.info = str;
				Object obj2 = pila.pop();
				if (obj2 instanceof NodoArbol){
					arbol.der = (NodoArbol) obj2;
				}
				else{
					NodoArbol h2 = new NodoArbol(obj2,null,null);
					arbol.der = h2;
				}
				Object obj1 = pila.pop();
				if (obj1 instanceof NodoArbol){
					arbol.izq = (NodoArbol) obj1;
				}
				else{
					NodoArbol h1 = new NodoArbol(obj1,null,null);
					arbol.izq = h1;
				}
				pila.push(arbol);
			}
			else if (str.equals("a") || str.equals("b") || str.equals("c") || str.equals("d") || str.equals("e") || str.equals("f")||
					str.equals("g") || str.equals("h") || str.equals("i") || str.equals("j") || str.equals("k") || str.equals("l") ||
					str.equals("m") || str.equals("n") || str.equals("帽") || str.equals("o") || str.equals("p") || str.equals("q") ||
					str.equals("r") || str.equals("s") || str.equals("t") || str.equals("u") || str.equals("v") || str.equals("w") ||
					str.equals("x") || str.equals("y") || str.equals("z")){
				pila.push(str);
			}
			else if (str.equals(" ")){
				System.out.println("Por ejemplo: a b +." );
				System.exit(-1);
			}
			else{
				System.out.println("Error: Formato err贸neo!!!!!!!!!!!!!!!");
				System.out.println("Recuerde: El String solo puede estar en notacion Polaca Inversa y separados por espacios.");
				System.out.println("Por ejemplo: a b +." );
				System.exit(-1);
			}
		}
		if (pila.peek() instanceof String){
			System.out.println("Error: Formato err贸neo!!!!!!!!!!!!!!!");
			System.out.println("No ha ingresado operadores.");
			System.exit(-1);
		}
		this.arbol = (NodoArbol) pila.pop();
	
		if (!pila.empty()){
			System.out.println("Error: Formato err贸neo!!!!!!!!!!!!!!!");
			System.out.println("Una variable ha quedado sin su ser operada :(");
			System.exit(-1);
		}
	}
	
	public String toSimpleString(){
		return arbol.toSS();
	}
	
	public String toString(){
		return arbol.toS();
	}
	
	
	
	static public class NodoArbol{ // clase Nodo
		
		Object info;
		NodoArbol izq;
		NodoArbol der;
		
		public NodoArbol(){
			info = null;
			izq = null;
			der = null;
		}
		
		public NodoArbol(Object informacion, NodoArbol izquierdo, NodoArbol derecho){
			this.info = informacion;
			this.izq = izquierdo;
			this.der = derecho;
		}
		
		
		
		public String toSS(){ // m閠odo que calcula parentesis por operacion
			String i = "(";
			String d = "";
			if (izq != null){
				i += izq.toSS();
			}
			else if (izq == null && der !=null){
				i = "(";
			}
			else {
				i = "";
			}
			if (der != null){
				d += der.toSS()+")";
			}
			else{
				d = "";
			}
			return i + info + d ;
		}
		
		public String toS(){ // m閠odo para el minimo de parentesis
			String i = "";
			String d = "";
			if (izq != null){
				if (info.equals("*") && izq.info.equals("-")){
					i = "(";
					//info = ")"+info+"(";
					i += izq.toS()+")";
				}
				else if (info.equals("*") && izq.info.equals("+")){
					i = "(";
					i += izq.toS()+")";
				}
				else if (info.equals("/") && izq.info.equals("-")){
					i = "(";
					i += izq.toS()+")";
				}
				else if (info.equals("/") && izq.info.equals("+")){
						i = "(";
						i += izq.toS()+")";
				}
				
				
				else{
					i += izq.toS();
				}
			}
			else {
				i = "";
			}
			if (der != null){
				if (info.equals("*") && der.info.equals("-")){
					d = "(";
					d += der.toS()+")";
				}
				else if (info.equals("*") && der.info.equals("+")){
					d = "(";
					d += der.toS()+")";
				}
				else if (info.equals("/") && der.info.equals("-")){
					d = "(";
					d += der.toS()+")";
				}
				else if (info.equals("/") && der.info.equals("+")){
					d = "(";
					d += der.toS()+")";
				}
				else if (info.equals("-") && der.info.equals("+")){
					d = "(";
					d += der.toS()+")";
				}
				else if (info.equals("-") && der.info.equals("-")){
					d = "(";
					d += der.toS()+")";
				}
				else{
					d += der.toS();
				}
			}
			else{
				d = "";
			}
			return i + info + d ;
		}
		
	}
	
}
