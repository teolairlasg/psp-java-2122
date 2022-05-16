import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class ReceptorMulticast {
	public static void main(String[] args) throws IOException {
		InetAddress grupoMulticast = InetAddress.getByName("224.0.0.1");
		MulticastSocket mSocket = new MulticastSocket(5554);
		mSocket.joinGroup(grupoMulticast);
		
		byte[] buffer = new byte[1024];
		DatagramPacket datos = new DatagramPacket(buffer, buffer.length);
		mSocket.receive(datos);
		
		System.out.println(datos.getAddress()+":_"+new String(datos.getData()));
		
		mSocket.close();
		
	}
}
