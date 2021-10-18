import java.io.IOException;

public class ejecutarBash {

	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder constructor = new ProcessBuilder("bash", 
				"/home/alumno/repos/psp-test/retorno.sh", "3");
		Process proc1 = constructor.start();
		System.out.println(proc1.pid());
		int retorno = proc1.waitFor();
		System.out.println(retorno);
		
		constructor = new ProcessBuilder("bash", 
				"/home/alumno/repos/psp-test/retorno.sh", Integer.toString(retorno));
		Process proc2 = constructor.start();
		int retorno2 = proc2.waitFor();
		System.out.println(retorno2);
	}

}
