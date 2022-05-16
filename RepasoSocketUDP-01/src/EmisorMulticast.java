import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EmisorMulticast {
	public static void main(String[] args) throws IOException {
		InetAddress grupoMulticast = InetAddress.getByName("224.0.0.1");
		DatagramSocket socket = new DatagramSocket();
		String mensaje = "Hola mundo";
		DatagramPacket datos = new DatagramPacket(mensaje.getBytes(), 
												  mensaje.getBytes().length,
												  grupoMulticast, 5554);
		
		socket.send(datos);
		
		socket.close();
	}
}
