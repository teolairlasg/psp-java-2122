package cliente;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;

public class Cliente {
	public static void main(String[] args)  throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileReader("./app.properties"));
		int puerto = Integer.valueOf(prop.getProperty("puerto"));
		String servidor = prop.getProperty("servidor");
		Socket socket = new Socket(servidor, puerto);
		System.out.println(socket.getRemoteSocketAddress());
		socket.close();
	}
}
