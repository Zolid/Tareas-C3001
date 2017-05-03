import java.util.Scanner;
public class main {
	
	public static void main(String[] args){ // traduccio interactivo :D
		while (true){
		Scanner scn = new Scanner(System.in);
		String expresion;
		System.out.println("Ingrese expresión matemática en notación postfija: ");
		System.out.println("Recuerde: Solo puede ingresar variables (letras) [a - z].");
		System.out.println("Y las operaciones permitidas son +, -, *, / y _ (menos unario). Para terminar presione Enter sin parametros.");
		expresion = scn.nextLine();
		Expresion e = new Expresion(expresion);
		System.out.println(e.toSimpleString()+" = "+e.toString());
			
		}
		
		
		
	}

}
	

