package servidorSSLwindows;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ssl.SSLServerSocketFactory;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//almacen del certificado de servidor
		System.setProperty("javax.net.ssl.keyStore",
				"M:/SSL/almacenServidor.p12");
		//contraseña del almacen del certificado del servidor
		System.setProperty("javax.net.ssl.keyStorePassword", "test123");
		//almacen de certificados en que confío (en este caso tengo el mismo almacen para
		//el certificado propio y el certificado de los sitios en que confio)
		System.setProperty("javax.net.ssl.trustStore", 
				"M:/SSL/almacenServidor.p12");
		//contraseña del almacen de los certificados en que confío
		System.setProperty("javax.net.ssl.trustStorePassword", "test123");
		
		//creamos el socket seguro
		SSLServerSocketFactory sslFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
		ServerSocket servSock = sslFactory.createServerSocket(5252);
		
		Socket socket = servSock.accept();
		DataInputStream entrada = 
				new DataInputStream(socket.getInputStream());
		while(true) {
			System.out.println(entrada.readUTF());
		}
	}

}