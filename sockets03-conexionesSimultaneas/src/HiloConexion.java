import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class HiloConexion extends Thread {
	Socket socket;
	ColaMensajes colaMensajes;
	public HiloConexion(Socket socket, ColaMensajes colaMensajes) {
		super();
		this.socket = socket;
		this.colaMensajes = colaMensajes;
	}
	@Override
	public void run() {
		
		System.out.println("Conectado cliente desde: "+
							socket.getInetAddress());
		System.out.println("Puerto local: " + socket.getLocalPort());
		System.out.println("Puerto remoto: " + socket.getPort());
		System.out.println("Ip Remota: " + socket.getInetAddress());
		DataInputStream entrada = null;
		try {
			 entrada = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			System.err.println("Error obteniendo el stream del socket");
			e.printStackTrace();
		}
		String txtMensaje = null;
		String origMensaje = socket.getInetAddress().toString();
		try {
			txtMensaje = entrada.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(!txtMensaje.equals("quit")) {
			Mensaje m = new Mensaje(txtMensaje, origMensaje);
			System.out.println(m);
			colaMensajes.anyadirMensaje(txtMensaje, origMensaje);
			synchronized (colaMensajes) {
				colaMensajes.notify();
			}
			try {
				txtMensaje = entrada.readUTF();
			} catch (IOException e) {
				System.err.println("Error en el stream");
				e.printStackTrace();
				txtMensaje = "quit";
			}
		}
		System.out.println("El cliente quiere salir");
		try {
			entrada.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
