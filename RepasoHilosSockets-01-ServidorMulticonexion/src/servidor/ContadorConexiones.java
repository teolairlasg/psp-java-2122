package servidor;

public class ContadorConexiones {
	private int conexiones;
	public ContadorConexiones() {
		super();
		this.conexiones = 0;
	}
	public synchronized void incConexiones(){
		conexiones++;
	}
	public synchronized void decConexiones() {
		conexiones--;
	}
	public int getConexiones() {
		return conexiones;
	}	
}
