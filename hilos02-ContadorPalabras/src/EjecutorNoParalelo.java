import java.util.ArrayList;

public class EjecutorNoParalelo {

	public static void main(String[] args) {
		long tInicio = System.nanoTime();
		ArrayList<String> ficheros = new ArrayList<String>();
		ficheros.add("./datos/salida.txt");
		ficheros.add("./datos/salida.txt");
		ficheros.add("./datos/salida.txt");
		ficheros.add("./datos/salida.txt");
		ficheros.add("./datos/salida.txt");
		ficheros.add("./datos/salida.txt");
		
		for (String rutaFichero : ficheros) {
			String[] parametros = {rutaFichero};
			ContadorPalabras.main(parametros);
		}
		
		System.out.println("Hilos finalizados. Tardaron "+(float)(System.nanoTime()-tInicio)/1000000+"ms.");
	}

}
