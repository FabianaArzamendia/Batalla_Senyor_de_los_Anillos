package proyectofinal;

import java.util.List;
import java.util.Random;

public class Bestia extends SenorAnillos {

	public Bestia(String nombre, int puntosvida, int nivelarmadura) {
		super(nombre, puntosvida, nivelarmadura);

	}

	@Override
	public int LanzarAtaque() {
		int dado;
		Random ran = new Random();
		dado = ran.nextInt(91);
		// System.out.println("1-DADO = " + dado);

		return dado;

	}

	
		
		


}
