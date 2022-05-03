package servidor;

import java.io.IOException;
import java.net.Socket;

public class HiloConexion implements Runnable {
	Socket socket;
	ContadorConexiones contador;

	public HiloConexion(Socket socket, ContadorConexiones contador) {
		super();
		this.socket = socket;
		this.contador = contador;
	}

	@Override
	public void run() {
		contador.incConexiones();
		System.out.println("[HiloConexion]: Clientes conectados:"+contador.getConexiones());
		System.out.println("[HiloConexion]: Cliente Conectado: "+socket.getRemoteSocketAddress());
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		contador.decConexiones();
		System.out.println("[HiloConexion]: Clientes conectados:"+contador.getConexiones());
	}

}
