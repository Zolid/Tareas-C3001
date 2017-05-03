import java.awt.Color;

import java.util.Scanner;

public class Koch {
	
	static int LMIN = 3;
	private static Scanner p;
	static int step = 600;
	static double radius = 280;

	static public void main(String[] args){
	
	p = new Scanner(System.in);
	int angulo;
	
	/*No supe como hacer que si el usario ingresa un valor no entero, 
	el programa le pidiera al usuario que un nuevo valor,
	pero sí que reconociera el que el dato obtenido no era entero*/
	
	System.out.print("Ingrese ángulo de inclinación: \n");	
	
	try {
		
		angulo = p.nextInt();
	
		Turtle t = new Turtle(600,350,90,1200,700);
		t.setPenColor(Color.GREEN);
		t.setPenUp();
		t.turnLeft(angulo);
		t.goForward(radius);
		t.turnRight(150);
		t.setPenDown();
		curvaDeKoch(t,step);
		t.turnRight(120);
		curvaDeKoch(t,step);
		t.turnRight(120);
		curvaDeKoch(t,step);
		
	}
	
	catch(Exception e){
		
		System.out.println("No me diste un valor entero");
}
	
	}
		
	public static void curvaDeKoch(Turtle tortuga, int largo){

		
		if(largo<=LMIN){
			
			tortuga.goForward(largo);
			
		}
		
		else{
			
			curvaDeKoch(tortuga,largo/3);
			tortuga.turnLeft(60);
			curvaDeKoch(tortuga,largo/3);
			tortuga.turnRight(120);
			curvaDeKoch(tortuga,largo/3);
			tortuga.turnLeft(60);
			curvaDeKoch(tortuga,largo/3);
			
		}
	}
}
