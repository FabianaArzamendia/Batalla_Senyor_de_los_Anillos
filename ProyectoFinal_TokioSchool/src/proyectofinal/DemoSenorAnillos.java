package proyectofinal;

import java.util.ArrayList;
import java.util.List;

public class DemoSenorAnillos {

	public static void main(String[] args) throws InterruptedException {

		List<Heroe> ejercitoheroes = new ArrayList<Heroe>();
		List<Bestia> ejercitobestias = new ArrayList<Bestia>();

		ejercitoheroes.add(new Elfo("Legolas", 150, 30));
		ejercitoheroes.add(new Humano("Aragorn", 150, 50));
		ejercitoheroes.add(new Humano("Boromir", 100, 60));
		ejercitoheroes.add(new Humano("Gandalf", 300, 30));
		ejercitoheroes.add(new Hobbit("Frodo", 20, 10));

		ejercitobestias.add(new Orco("Lurtz", 200, 60));
		ejercitobestias.add(new Orco("Shagrat", 220, 50));
		ejercitobestias.add(new Trasgo("Ugluk", 120, 30));
		ejercitobestias.add(new Trasgo("Mauhur", 100, 30));

		comienzaElJuego(ejercitoheroes, ejercitobestias);

	}

	public static void comienzaElJuego(List<Heroe> ejercitoheroes, List<Bestia> ejercitobestias)
			/*throws InterruptedException*/ {
		int turno = 1;
		// while (true) {
		while (hayaVidaEnLosEjercitos(ejercitoheroes, ejercitobestias)) {

			System.out.println("Turno: " + turno++);

			for (int luchador = 0; luchador < cuantosLuchanALaVez(ejercitoheroes, ejercitobestias); luchador++) {

				// cojo el luchador de heroes y lo pongo a combatir con el luchador de bestias
				pelean(ejercitoheroes.get(luchador), ejercitobestias.get(luchador));
				//Thread.sleep(3000);

			}

			// Eliminar los muertos si hay alguno (en bestia y heroes)
			ejercitobestias = eliminarBestiasMuertas(ejercitobestias);
			ejercitoheroes = eliminarHeroesMuertos(ejercitoheroes);

		}
		imprimirGanador(ejercitoheroes, ejercitobestias);

		/* } */

	}

	private static void pelean(Heroe heroe, Bestia bestia) {
		System.out.println("Luchan: " + heroe + " y " + bestia);
		int ataqueHeroe = heroe.LanzarAtaque();

		// si es elfo contra orco, suma 10 a su ataque
		if (esElfoContraOrco(heroe, bestia)) {

			ataqueHeroe += 10;
		}

		// si es hobit contra trasgo, resta 5 a ataque
		if (esHobbitContraTrasgo(heroe, bestia)) {
			System.out.println("Hobbit contra trasgo");
			ataqueHeroe -= 5;
		}

		int porcentaje = 0;
		// si es orco contra heroe, la armadura del heroe disminuira 10%
		if (bestia instanceof Orco) {
			porcentaje = heroe.getNivelarmadura() / 10;
		}

		if (ataqueHeroe > bestia.getNivelarmadura()) {
			// heroe ataca a bestia
			int vidaquelequita = ataqueHeroe - bestia.getNivelarmadura();
			System.out.println("\t" + heroe.getNombre() + " saca " + ataqueHeroe + " y le quita " + vidaquelequita
					+ " de vida a " + bestia.getNombre());
			bestia.setPuntosvida(bestia.getPuntosvida() - vidaquelequita);
		} else {
			System.out.println("\t" + heroe.getNombre() + " saca " + ataqueHeroe + " y le quita 0 de vida a "
					+ bestia.getNombre());
		}

		int ataqueBestia = bestia.LanzarAtaque();
		if (ataqueBestia > heroe.getNivelarmadura()) {
			// bestia ataca a heroe
			int vidaquelequita = ataqueBestia - (heroe.getNivelarmadura() - porcentaje);
			System.out.println("\t" + bestia.getNombre() + " saca " + ataqueBestia + " y le quita " + vidaquelequita
					+ " de vida a " + heroe.getNombre());
			heroe.setPuntosvida(heroe.getPuntosvida() - vidaquelequita);
		} else {
			System.out.println("\t" + bestia.getNombre() + " saca " + ataqueBestia + " y le quita 0 de vida a "
					+ heroe.getNombre());
		}
	}

	private static boolean esHobbitContraTrasgo(Heroe heroe, Bestia bestia) {
		return heroe instanceof Hobbit && bestia instanceof Trasgo;
	}

	private static boolean esElfoContraOrco(Heroe heroe, Bestia bestia) {
		return heroe instanceof Elfo && bestia instanceof Orco;
	}

	private static List<Bestia> eliminarBestiasMuertas(List<Bestia> ejercito) {
		// creo lista temporal
		List<Bestia> temporal = new ArrayList();
		for (int i = 0; i < ejercito.size(); i++) {
			if (ejercito.get(i).getPuntosvida() > 0) {
				temporal.add(ejercito.get(i));
			} else {

				System.out.println("\t¡Muere " + ejercito.get(i).getClass().getSimpleName() + " "
						+ ejercito.get(i).getNombre() + "!");
			}
		}

		return temporal;
	}

	private static List<Heroe> eliminarHeroesMuertos(List<Heroe> ejercito) {
		// creo lista temporal
		List<Heroe> temporal = new ArrayList();
		for (int i = 0; i < ejercito.size(); i++) {
			if (ejercito.get(i).getPuntosvida() > 0) {
				temporal.add(ejercito.get(i));
			} else {

				System.out.println("\t¡Muere " + ejercito.get(i).getClass().getSimpleName() + " "
						+ ejercito.get(i).getNombre() + "!");
			}
		}

		return temporal;
	}

	private static boolean hayaVidaEnLosEjercitos(List<Heroe> ejercitoheroes, List<Bestia> ejercitobestias) {
		return !ejercitoheroes.isEmpty() && !ejercitobestias.isEmpty();
	}

	private static void imprimirGanador(List<Heroe> ejercitoheroes, List<Bestia> ejercitobestias) {
		if (!ejercitoheroes.isEmpty()) {

			System.out.println(" Heroes han ganado !!!");

		} else if (!ejercitobestias.isEmpty()) {
			System.out.println(" Bestias han ganado !!!");
		}
	}

	private static int cuantosLuchanALaVez(List<Heroe> ejercitoheroes, List<Bestia> ejercitobestias) {

		if (ejercitoheroes.size() < ejercitobestias.size()) {
			return ejercitoheroes.size();
		}
		return ejercitobestias.size();

	}

}
