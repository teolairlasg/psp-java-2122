import java.util.ArrayList;

public class HiloThread extends Thread {

	int segundosEspera;
	ArrayList lista;
	public HiloThread(int segundosEspera, ArrayList lista) {
		super();
		this.segundosEspera = segundosEspera;
		this.lista = lista;
	}
	@Override
	public void run() {
		
		System.out.println("Hola soy el HiloThread\n ID: "+this.getId()
							+"\nNombre: "+this.getName());
		
		for (int i = 0; i<1000; i++) {
			lista.add("hiloThread-"+i);
		}
		
		try {
			Thread.sleep(segundosEspera*1000); //pasamos a milisegundos
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
