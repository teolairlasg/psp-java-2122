package servidor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class Servidor {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileReader("./app.properties"));
		int puerto = Integer.valueOf(prop.getProperty("puerto"));
		ServerSocket servSock = new ServerSocket(puerto);
		Socket socket = servSock.accept();
		System.out.println(socket.getRemoteSocketAddress());
		socket.close();
	}	
}
