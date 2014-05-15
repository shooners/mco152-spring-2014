package teich.threads;

public class FactorialThreads {

	public static void main(String[] args) {

		Thread t1 = new Factorial(4);
		Thread t2 = new Factorial(1000L);

		t1.start();
		t2.start();
	}
}
