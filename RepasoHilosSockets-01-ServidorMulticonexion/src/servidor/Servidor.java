package servidor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

public class Servidor {
	private static boolean finalPrograma = false;
	public static synchronized void finalizarPrograma() {
		finalPrograma = true;
		System.out.println("Han llamado a finalizar Programa: "+finalPrograma);
	}
	public static synchronized boolean finalizado() {
		System.out.println("[Servidor]: Comprobando si finalizado: "+ finalPrograma);
		return finalPrograma;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		ContadorConexiones contador = new ContadorConexiones();
		Properties prop = new Properties();
		prop.load(new FileReader("./app.properties"));
		int puerto = Integer.valueOf(prop.getProperty("puerto"));
		ServerSocket servSock = new ServerSocket(puerto);
		Thread h = null;
		while(!finalizado()) {			
			System.out.println("[Servidor]: Clientes conectados:" + contador.getConexiones());
			System.out.println("[Servidor]: Esperando conexión...");
			h=new Thread(new HiloConexion(servSock.accept(), contador));
			h.start();
		}
		System.out.println("[Servidor]: Esperando hilo...");
		h.join();
		servSock.close();
	}	
}
