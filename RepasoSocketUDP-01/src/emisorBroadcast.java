
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class emisorBroadcast {

	public static void main(String[] args) throws IOException {
		InetAddress direccionBroadCast = InetAddress.getByName("192.168.102.255");
		DatagramSocket socket = new DatagramSocket();
		String mensaje = "Hola mundo";
		DatagramPacket datos = new DatagramPacket(mensaje.getBytes(), 
													mensaje.getBytes().length, 
													direccionBroadCast, 5454);

		socket.send(datos);

		socket.close();
	}
}
