import java.util.ArrayList;

public class Programa {

	public static void main(String[] args) throws InterruptedException {
		
		ArrayList<String> lista = new ArrayList<String>();
		// crear y lanzar hilo que extiende Thread
		HiloThread h1 = new HiloThread(3, lista);
		System.out.println("Hola soy el Programa Principal"+
				"\n ID: "+Thread.currentThread().getId()+
				"\n Name: "+Thread.currentThread().getName());
		System.out.println("Voy a lanzar el hilo h1");
		HiloThread h3= new HiloThread(3, lista);
		HiloThread h4 = new HiloThread(3, lista);
		
		// crear y lanzar hilo que implementa Runnable.
		Thread h2 = new Thread(new HiloRunnable(3, lista));
		System.out.println("Voy a lanzar el hilo h2");
		h1.start();
		h3.start();
		h4.start();
		h2.start();
		h1.join();
		
		System.out.println("El hilo h1 ha finalizado");
		h2.join();
		System.out.println("El hilo h2 ha finalizado");
		System.out.println(lista);
	}

}
