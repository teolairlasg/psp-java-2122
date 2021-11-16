
public class hiloMonitor implements Runnable {

	ListaCompra lista;
	
	public hiloMonitor(ListaCompra lista) {
		super();
		this.lista = lista;
	}

	@Override
	public void run() {
		while(true) {
			synchronized (lista) {
				try {
					lista.wait();
					System.out.println(lista);
					//Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
