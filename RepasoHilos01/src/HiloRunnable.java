import java.util.ArrayList;

public class HiloRunnable implements Runnable {

	int segundosEspera;
	ArrayList lista;
	public HiloRunnable(int segundosEspera, ArrayList lista) {
		super();
		this.segundosEspera = segundosEspera;
		this.lista = lista;
	}
	@Override
	public void run() {
		System.out.println("Hola soy el HiloRunnable"+
							"\n ID: "+Thread.currentThread().getId()+
							"\n Name: "+Thread.currentThread().getName());

		for (int i = 0; i<100; i++) {
			lista.remove(0);
		}
		
		try {
			Thread.sleep(segundosEspera*1000);
		} catch (InterruptedException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
