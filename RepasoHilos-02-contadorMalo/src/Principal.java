
public class Principal {

	public static void main(String[] args) throws InterruptedException {
		Contador c = new Contador();
		Hilo h1 = new Hilo(c, true);
		Hilo h2 = new Hilo(c, false);
		h1.start();
		h2.start();
		h1.join();
		h2.join();
		System.out.println(c);
	}

}
