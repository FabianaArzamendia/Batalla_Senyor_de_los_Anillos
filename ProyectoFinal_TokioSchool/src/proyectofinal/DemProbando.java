package proyectofinal;

public class DemProbando {

	public static void main(String[] args) {
			
	Runnable runnable = new Runnable() {
		  @Override
		  public void run() {
		    // Esto se ejecuta en segundo plano una �nica vez
		    while (true) {
		      // Pero usamos un truco y hacemos un ciclo infinito
		      try {
		        // En �l, hacemos que el hilo duerma
		        Thread.sleep(1000);
		        // Y despu�s realizamos las operaciones
		        System.out.println("Me imprimo cada segundo");
		        // As�, se da la impresi�n de que se ejecuta cada cierto tiempo
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
		  }
		};
		
		Thread hilo = new Thread(runnable);
		hilo.start();
	}
}
