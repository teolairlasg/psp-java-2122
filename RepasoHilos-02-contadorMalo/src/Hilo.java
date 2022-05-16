
public class Hilo extends Thread {
	Contador c_hilo;
	boolean incrementa;
	public Hilo(Contador c_hilo, boolean incrementa) {
		super();
		this.c_hilo = c_hilo;
		this.incrementa = incrementa;
	}
	@Override
	public void run() {
		if (incrementa) {
			for (int i = 0; i<100000; i++) {
				c_hilo.incrementar();
			}	
		}else {
			for (int i = 0; i<100000; i++) {
				c_hilo.decrementar();
			}
		}
	}
}
