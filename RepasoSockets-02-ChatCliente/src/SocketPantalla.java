import java.io.DataInputStream;
import java.io.IOException;

public class SocketPantalla extends Thread {
	DataInputStream entradaSocket;

	public SocketPantalla(DataInputStream entradaSocket) {
		super();
		this.entradaSocket = entradaSocket;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(entradaSocket.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
