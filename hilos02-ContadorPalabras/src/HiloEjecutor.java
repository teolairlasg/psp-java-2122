
public class HiloEjecutor extends Thread {

	private String rutaFichero;
	
	
	public HiloEjecutor(String rutaFichero) {
		super();
		this.rutaFichero = rutaFichero;
	}
	
	@Override
	public void run() {
		long tInicio = System.nanoTime();
		String[] vectorArgs = {rutaFichero};
		ContadorPalabras.main(vectorArgs);
		System.out.println("HiloEjecutor: "+this.getName()+". Tardé: "+(float)(System.nanoTime()-tInicio)/1000000+" ms.");
	}
	
		
}
