import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Programa {
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket sock = new Socket("192.168.102.111", 5454);
		DataInputStream entradaSocket = 
				new DataInputStream(sock.getInputStream());
		DataOutputStream salidaSocket = 
				new DataOutputStream(sock.getOutputStream());
		
		TecladoSocket hilo1 = new TecladoSocket(salidaSocket);
		SocketPantalla hilo2 = new SocketPantalla(entradaSocket);
		
		hilo1.start();
		hilo2.start();
		hilo1.join();
		hilo2.join();
		sock.close();
	}
	
	
}
