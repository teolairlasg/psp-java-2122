import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("localhost", 5454);
		System.out.println(sock.getRemoteSocketAddress());
		DataInputStream entrada = 
				new DataInputStream(sock.getInputStream());
		DataOutputStream salida = 
				new DataOutputStream(sock.getOutputStream());
		
		salida.writeUTF("Hola soy el cliente 123 ");
		
		String recibido = entrada.readUTF();
		System.out.println("Recibido mensaje: "+recibido);
		
		entrada.close();
		salida.close();
		sock.close();
	}
}
