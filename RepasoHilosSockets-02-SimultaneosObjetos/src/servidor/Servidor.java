package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	public final static int puerto = 5454;
	private static ArrayList<Thread> listaClientes;
	private static boolean finalizado = false;
	public static void finalizar() {
		finalizado = true;
	}
	public static boolean finalizado() {
		return finalizado;
	}
	public static void main(String[] args) throws IOException {
		listaClientes = new ArrayList<Thread>();
		ServerSocket servSock = new ServerSocket(puerto);
		Thread hiloPropagador = new Thread(new Propagador(listaClientes, 5));
		hiloPropagador.start();
		HiloCliente hiloCliente = null;
		Socket sock = null;
		while(!finalizado) {
			sock = servSock.accept();
			System.out.println("[Servidor]: Cliente conectado desde "+sock.getRemoteSocketAddress());
			hiloCliente = new HiloCliente(sock, listaClientes);
			synchronized (listaClientes) {
				System.out.println("[Servidor]: Cliente añadido a la lista");
				listaClientes.add(hiloCliente);
			}
			System.out.println("[Servidor]: Iniciando cliente...");
			hiloCliente.start();
		}
		
	}

}
