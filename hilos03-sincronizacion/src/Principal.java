import java.util.ArrayList;

public class Principal {

	
	public static Thread insertarProducto(String prod, ArrayList<String> lista) {
		Thread h = new Thread(new hiloEscritor(prod, lista));
		h.start();
		return h;
	}
	
	public static void main(String[] args) {
		ArrayList<String> listaCompra = new ArrayList<String>();
		ArrayList<Thread> escritores = new ArrayList<Thread>();
		escritores.add(insertarProducto("Manzanas", listaCompra));
		escritores.add(insertarProducto("Patatas", listaCompra));
		escritores.add(insertarProducto("Tomates", listaCompra));
		escritores.add(insertarProducto("Limones", listaCompra));
		for(Thread hilo : escritores) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		new Thread(new hiloLector(listaCompra)).start();
	}

}
