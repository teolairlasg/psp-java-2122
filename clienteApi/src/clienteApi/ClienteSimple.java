package clienteApi;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import org.apache.hc.core5.net.URIBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClienteSimple {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		// HttpRequest --> Petición
		// HttpResponse --> Respuesta
		String apikey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZW8ubGFpcmxhQGllc3NpZXJyYWRlZ3VhcmEuY29tIiwianRpIjoiODVjNmIwY2MtMTZiNC00OGFhLWIzMzAtNTlhMWVmYWVmMDM1IiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2NDQxODkxNTQsInVzZXJJZCI6Ijg1YzZiMGNjLTE2YjQtNDhhYS1iMzMwLTU5YTFlZmFlZjAzNSIsInJvbGUiOiIifQ.SP46yMOxpf3Qvs8GadWzC5Qu7SOz238deb-PF8PK2hc";
		String idema = "9491X";
		//construir la dirección uri
		URI direccion = new URIBuilder()
						.setScheme("https")  // protocolo
						.setHost("opendata.aemet.es") // servidor
						// el path es lo que va después del servidor, el recurso.
						.setPath("opendata/api/observacion/convencional/datos/estacion/"+idema)
						.addParameter("api_key", apikey) //?api_key=eyJhbG...
						.build();
		
		//construir la petición
		HttpRequest peticion = 
			HttpRequest.newBuilder()
			  .uri(direccion)
			  .GET()
			  .timeout(Duration.ofSeconds(10))
			  .version(HttpClient.Version.HTTP_2)
			  .build();
		
		//construir el cliente
		HttpClient cliente = HttpClient.newBuilder()
							
							.build();
		
		//solicitar la respuesta enviando la petición
		//desde el cliente.
		HttpResponse<String> respuesta = 
				cliente.send(peticion, BodyHandlers.ofString());
		
		System.out.println(respuesta.headers());
		System.out.println(respuesta.body());
		
		Gson gson = new Gson();
		RespuestaAemet respAemet = 
				gson.fromJson(respuesta.body(), RespuestaAemet.class);
		
		System.out.println(respAemet.descripcion);
		System.out.println(respAemet.datos);
		
		HttpRequest peticionDatos = HttpRequest.newBuilder()
							.uri(respAemet.datos)
							.GET()
							.version(HttpClient.Version.HTTP_2)
							.build();
		
		HttpResponse<String> respuestaDatos = 
				cliente.send(peticionDatos, BodyHandlers.ofString());
		
		System.out.println(respuestaDatos.body());
		Gson gson2 = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd'T'hh:mm:ss")
				.create();
		DatosEstacion[] datosAlmudevar = 
				gson2.fromJson(respuestaDatos.body(), DatosEstacion[].class);
		for (DatosEstacion datosEstacion : datosAlmudevar) {
			System.out.println(datosEstacion);
		}
	}

}
