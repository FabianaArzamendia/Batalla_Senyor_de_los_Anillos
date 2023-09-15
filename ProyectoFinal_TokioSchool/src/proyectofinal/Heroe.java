package proyectofinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class  Heroe extends SenorAnillos{

	
	public Heroe(String nombre, int puntosvida, int nivelarmadura) {
		super(nombre, puntosvida, nivelarmadura);
		
	}
	
	
	@Override
	public  int LanzarAtaque() {
		int dado1, dado2;
		Random ran = new Random();
		dado1 = ran.nextInt(101);
		//System.out.println("DADO1 = " + dado1);
		dado2 = ran.nextInt(101);
		//System.out.println("DADO2 = " + dado2);
		if(dado1 > dado2) {
			return dado1;
			
		}
		return dado2;
		
	}
	
	
		
}


	

	
	
	
	

