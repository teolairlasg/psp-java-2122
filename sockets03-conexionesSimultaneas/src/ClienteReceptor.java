import java.io.DataInputStream;
import java.io.IOException;

public class ClienteReceptor implements Runnable {

	DataInputStream entrada;
	
	public ClienteReceptor(DataInputStream entrada) {
		super();
		this.entrada = entrada;
	}

	public void run() {
		String msj = null;
		try {
			msj = entrada.readUTF();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		while(!msj.equals("quit")) {
			try {
				System.out.println(entrada.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
