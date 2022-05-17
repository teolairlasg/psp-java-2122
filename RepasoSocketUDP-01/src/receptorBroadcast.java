import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class receptorBroadcast {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(5454);
		byte[] buffer = new byte[100];
		DatagramPacket datos = new DatagramPacket(buffer, 100);
		socket.receive(datos);
		System.out.println(new String(buffer));
		System.out.println(" Enviado desde: " + datos.getAddress() + ":" + datos.getPort());
		socket.close();
	}
}
