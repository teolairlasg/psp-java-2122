import java.util.ArrayList;

public class hiloLector implements Runnable {

	private ArrayList<String> listaCompra;

	public hiloLector(ArrayList<String> listaCompra) {
		super();
		this.listaCompra = listaCompra;
	}

	@Override
	public void run() {
		synchronized (listaCompra) {
			System.out.println(listaCompra);
		}

	}

}
