package clienteSSL;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;

public class ClienteSSL {
	 public static void main(String[] args) throws UnknownHostException, IOException {
		
		 //almacen del certificado de cliente
		 System.setProperty("javax.net.ssl.keyStore",
				 "/home/alumno/SSL/almacenCliente.p12");
		 //contraseña del almacen del certificado del cliente
		 System.setProperty("javax.net.ssl.keyStorePassword", "test321");
		 //almacen de certificados en que confío (en este caso tengo el mismo almacen para
		 //el certificado propio y el certificado de los sitios en que confio)
		 System.setProperty("javax.net.ssl.trustStore", 
				 "/home/alumno/SSL/almacenCliente.p12");
		 //contraseña del almacen de los certificados en que confío
		 System.setProperty("javax.net.ssl.trustStorePassword", "test321");
		 
		 
		 SSLSocketFactory sslFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		 
		 Socket socket = sslFactory.createSocket("192.168.102.100",5566);
		 
		 socket.close();
	}

	
	 
}
