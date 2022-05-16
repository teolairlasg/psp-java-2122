import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
		// creo el ServerSocket
		ServerSocket servSock = new ServerSocket(5454);
		// Espero a una conexión sobre el server socket, esto me devolverá
		// un socket, cuando alguien se conecte.
		Socket sock = servSock.accept();
		System.out.println(sock.getRemoteSocketAddress());
		DataInputStream entrada = 
				new DataInputStream(sock.getInputStream());
		DataOutputStream salida = 
				new DataOutputStream(sock.getOutputStream());
		
		String mensaje = entrada.readUTF();
		System.out.println("Recibido el mensaje: "+mensaje);
		salida.writeUTF("Leído tu mensaje, era '"+mensaje+
					"' desde la ip:" + sock.getRemoteSocketAddress());	
		
		entrada.close();
		salida.close();
		sock.close();
		servSock.close();
	}
}
