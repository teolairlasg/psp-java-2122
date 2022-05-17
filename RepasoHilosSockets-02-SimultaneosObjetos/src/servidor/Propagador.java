package servidor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Propagador implements Runnable {
	private boolean finalPrograma;
	private ArrayList<Thread> listaClientes;
	private int freqSecs;
	public Propagador(ArrayList<Thread> listaClientes, int freqSecs) {
		this.listaClientes = listaClientes;
		this.freqSecs = freqSecs;
	}
	public void finalizar() {
		finalPrograma = true;
	}
	@Override
	public void run() {
		System.out.println("[Propagador]: Servicio iniciado");
		while (!finalPrograma) {
			try {
				Thread.sleep(freqSecs*1000);
			} catch (InterruptedException e) {
				System.err.println("[HiloPropagador]: El programa ha sido interrumpido!");
				e.printStackTrace();
			}
			synchronized (listaClientes) {
				listaClientes.notifyAll();
			}
		}
	}

}
