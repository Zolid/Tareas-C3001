import java.util.Scanner;

public class ColaPrioridadMediana {
	
	MAX_HEAP max_heap;
	MIN_HEAP min_heap;
	
	public ColaPrioridadMediana(){
		
		max_heap = new MAX_HEAP();
		min_heap = new MIN_HEAP();
	}
	
public ColaPrioridadMediana(int cap){
		
		max_heap = new MAX_HEAP(cap/2);
		min_heap = new MIN_HEAP(cap/2);
	}
	
	public void insertar(double x){
		if ( min_heap.largo() == 0 || x>=min_heap.getMin() ){
			min_heap.insertarElemento(x);;
		}
		else{
			max_heap.insertarElemento(x);
		}
		if ( min_heap.largo() - max_heap.largo() > 1){
			max_heap.insertarElemento(min_heap.extraerMin());
		}
		else if ( max_heap.largo() - min_heap.largo() > 1 ){
			min_heap.insertarElemento(max_heap.extraerMax());
		}
	}
	
	public double getMediana(){
		double mediana = 0;
		if ( max_heap.largo() == min_heap.largo() ){
			mediana = (min_heap.getMin() + max_heap.getMax())/2.0;
		}
		else{
			mediana = (min_heap.largo() > max_heap.largo())? min_heap.getMin() : max_heap.getMax();
		}
		return mediana;
	}
	
	static public void main(String[] agrs){
		
		ColaPrioridadMediana m = new ColaPrioridadMediana(202);
		Scanner scn = new Scanner(System.in);
		System.out.print("Recuerde ingresar solo valores positivos, y calcular el intervalo de subsidios pulse Enter.\n");
		String s;
		double subsidio;
		do {
			System.out.println(">>");
			s = scn.nextLine();
			if (s.equals("")==false){
				subsidio=Double.parseDouble(s);
				if (subsidio<0){
					System.out.print("Solo puede ingresar valores positivos.");
					System.exit(-1);
				}
				m.insertar(subsidio);
			}
		}
		
		while(s.equals("")==false);
		scn.close();
		System.out.println("El subsidio aplica hasta $"+m.getMediana()+" de ingreso familiar.");
		}
}
