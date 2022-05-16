import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Emisor {
	public static void main(String[] args) throws IOException {
		InetAddress destinatario = InetAddress.getByName("192.168.102.111");
		DatagramSocket socket = new DatagramSocket();
		String mensaje = "Hola mundo";
		DatagramPacket datos = new DatagramPacket(mensaje.getBytes(), 
												  mensaje.getBytes().length,
												  destinatario, 5454);
		socket.send(datos);
		byte[] buffer = new byte[100];
		DatagramPacket datos2 = new DatagramPacket(buffer, 100);
		socket.receive(datos2);
		System.out.println(new String(datos2.getData()));
		socket.close();
	}
}
