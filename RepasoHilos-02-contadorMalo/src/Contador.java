
public class Contador {
	int num = 0;
	
	public synchronized void incrementar() {
		num++;
	}
	public void decrementar() {
		synchronized(this) {
			num--;
		}
	}
	@Override
	public String toString() {
		return "Contador [num=" + num + "]";
	}
}
