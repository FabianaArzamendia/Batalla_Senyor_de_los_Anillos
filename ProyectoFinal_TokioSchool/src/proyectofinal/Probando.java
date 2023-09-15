package proyectofinal;

public class Probando {
	
	Runnable runnable = new Runnable() {
		  @Override
		  public void run() {
		    // Esto se ejecuta en segundo plano una única vez
		    while (true) {
		      // Pero usamos un truco y hacemos un ciclo infinito
		      try {
		        // En él, hacemos que el hilo duerma
		        Thread.sleep(1000);
		        // Y después realizamos las operaciones
		        System.out.println("Me imprimo cada segundo");
		        // Así, se da la impresión de que se ejecuta cada cierto tiempo
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
		  }
		};

}
