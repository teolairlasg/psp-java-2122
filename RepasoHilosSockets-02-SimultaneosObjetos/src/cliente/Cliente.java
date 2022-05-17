package cliente;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket sock = new Socket("localhost", 5454);
		System.out.println("Socket conectado: "+sock.isConnected());
		int mensajes = 1;
		Date fechaHora = null;
		ObjectInputStream entrada = new ObjectInputStream(sock.getInputStream());
		while(mensajes <=3) {
			fechaHora = (Date) entrada.readObject();
			System.out.println("[Cliente]: Mensaje nº "+mensajes+": "+fechaHora);
			mensajes++;
		}
		sock.close();
	}

}
