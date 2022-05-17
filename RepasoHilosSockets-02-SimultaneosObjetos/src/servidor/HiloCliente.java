package servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class HiloCliente extends Thread {

	Socket sock;
	boolean finalizado;
	ArrayList<Thread> listaHilos;

	public HiloCliente(Socket sock, ArrayList<Thread> listaHilos) {
		boolean finalizado = false;
		this.sock = sock;
		this.listaHilos = listaHilos;
	}

	@Override
	public void run() {
		Date fechaHora = null;
		ObjectOutputStream salida = null;
		System.out.println("[HiloCliente]: Socket conectado: " + sock.isConnected());
		try {
			salida = new ObjectOutputStream(sock.getOutputStream());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		while (!finalizado) {
			System.out.println("[HiloCliente]:Dentro del bucle");
			try {
				synchronized (listaHilos) {
					listaHilos.wait();
				}
			} catch (InterruptedException e) {
				finalizado = true;
				e.printStackTrace();
			}
			fechaHora = new Date();
			try {
				salida.writeObject(fechaHora);
			} catch (IOException e) {
				finalizado = true;
				synchronized (listaHilos) {
					listaHilos.remove(this);
				}
				System.out.println("[HiloCliente]: Cliente finalizado");
			}
		}
	}
}