package envioMulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class receptorMulticastWhile {

	public static void main(String[] args) throws IOException {
		int mcPort = 12345;
	    String mcIPStr = "230.1.1.1";  // esta es la dirección "especial"
	    MulticastSocket mcSocket = null;
	    InetAddress mcIPAddress = null;
	    mcIPAddress = InetAddress.getByName(mcIPStr);
	    mcSocket = new MulticastSocket(mcPort);
	    System.out.println("Multicast Receiver running at:"
	        + mcSocket.getLocalSocketAddress());
	    mcSocket.joinGroup(mcIPAddress);

	    DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);

	    System.out.println("Esperando mensaje multicast en "+mcIPStr+"...");
	    String msg = ""; // null da error
	     
	    while(!msg.equals("/quit")) {
		    mcSocket.receive(packet);
	    	msg = new String(packet.getData(), packet.getOffset(),
			        packet.getLength());
	    	System.out.println("[Multicast  Receiver] Recibido:" + msg);
	    }
	    	mcSocket.leaveGroup(mcIPAddress); //dejando de escuchar
	    	mcSocket.close();
	}

}
