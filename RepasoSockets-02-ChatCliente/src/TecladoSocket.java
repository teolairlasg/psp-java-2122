import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TecladoSocket extends Thread {
	DataOutputStream salidaSocket;

	public TecladoSocket(DataOutputStream salidaSocket) {
		super();
		this.salidaSocket = salidaSocket;
	}

	@Override
	public void run() {
		int contador = 10;
		Scanner teclado = new Scanner(System.in);
		while (contador > 0) {
			try {
				salidaSocket.writeUTF(teclado.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			contador--;
		}
	}

}
