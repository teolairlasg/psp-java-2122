package servidor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Servidor {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		ContadorConexiones contador = new ContadorConexiones();
		Properties prop = new Properties();
		prop.load(new FileReader("./app.properties"));
		int puerto = Integer.valueOf(prop.getProperty("puerto"));
		ServerSocket servSock = new ServerSocket(puerto);
		
		while(true) {			
			System.out.println("[Servidor]: Clientes conectados:" + contador.getConexiones());
			System.out.println("[Servidor]: Esperando conexión...");
			new Thread(new HiloConexion(servSock.accept(), contador)).start();
		}
	}	
}
