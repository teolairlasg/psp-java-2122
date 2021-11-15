import java.util.ArrayList;

public class Ejecutor {

	public static void main(String[] args) {
		long tInicio = System.nanoTime();
		ArrayList<String> ficheros = new ArrayList<String>();
		//ficheros.add("/home/alumno/repos/psp-c/prog12-EjercicioCompleto-Prod-Separado/main.c");
		//ficheros.add("/home/alumno/repos/psp-c/prog12-EjercicioCompleto-Prod-Separado/Makefile");
		
		//se ha añadido el fichero salida al repositorio. En una carpeta datos dentro del proyecto
		//así os funcionará en casa
		ficheros.add("./datos/salida.txt");
		ficheros.add("./datos/salida.txt");
		ficheros.add("./datos/salida.txt");
		ficheros.add("./datos/salida.txt");
		ficheros.add("./datos/salida.txt");
		ficheros.add("./datos/salida.txt");
		
		ArrayList<HiloEjecutor> listaHilos= new ArrayList<HiloEjecutor>();
		long tInicioCreacion = System.nanoTime();
		for (String rutaFichero : ficheros) {
			listaHilos.add(new HiloEjecutor(rutaFichero));
		}
		System.out.println("Hilos Creados tardé "+ (float)(System.nanoTime()-tInicioCreacion)/1000000+" ms.");
		long tInicioLanzamiento = System.nanoTime();
		for (HiloEjecutor hilo : listaHilos) {
			hilo.start();
		}
		System.out.println("Hilos lanzados. Tardé "+ (float)(System.nanoTime()-tInicioLanzamiento)/1000000+"ms." );
		for (HiloEjecutor hilo: listaHilos) {
			try {
				hilo.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Hilos finalizados. Tardaron "+(float)(System.nanoTime()-tInicio)/1000000+"ms.");
	}
}
