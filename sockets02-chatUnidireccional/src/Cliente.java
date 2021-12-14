import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket = new Socket("localhost", 5252);
		DataOutputStream salida = 
				new DataOutputStream(socket.getOutputStream());
		Scanner teclado = new Scanner(System.in);
		while (true) {
			salida.writeUTF(teclado.nextLine());
		}
	}

}
