package httpConexion;

import java.io.BufferedInputStream;
import java.io.Console;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class descargaWeb {

	public static void main(String[] args) throws IOException {
		String stringURL = "https://wikpedia.org";
		URL objetoURL = new URL(stringURL); //lanza excepción url mal formada
		//URLConnection conexionURL = objetoURL.openConnection(); //lanza excepción E/S
		HttpsURLConnection conexionHttps = (HttpsURLConnection) objetoURL.openConnection(); //lanza excepción E/S
		BufferedInputStream lectorURL = new BufferedInputStream(objetoURL.openStream());
		System.out.println("El servidor devuelve: " + conexionHttps.getResponseCode());
		byte[] buffer = new byte[2048];
		int bytesLeidos = lectorURL.read(buffer);
		while (bytesLeidos != -1 ) {
			System.out.println(new String(buffer));
			bytesLeidos = lectorURL.read(buffer);
		}
		System.out.println(new String(buffer));
	}
	
}
