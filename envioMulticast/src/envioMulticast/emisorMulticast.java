package envioMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class emisorMulticast {

	public static void main(String[] args) throws IOException {
		int mcPort = 12345;
		String mcIPStr = "230.1.1.1";
		DatagramSocket udpSocket = new DatagramSocket();

		InetAddress mcIPAddress = InetAddress.getByName(mcIPStr);
		byte[] msg = "Hello".getBytes();
		DatagramPacket packet = new DatagramPacket(msg, msg.length);
		packet.setAddress(mcIPAddress);
		packet.setPort(mcPort);
		udpSocket.send(packet);

		System.out.println("Mensaje enviado a " + mcIPStr + ".");
		System.out.println("Saliendo...");
		udpSocket.close();

	}

}
