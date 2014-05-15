package teich.threads;

import java.math.BigInteger;

public class Factorial extends Thread {
	private long val;

	public Factorial(long n) {
		val = n;
	}

	public static BigInteger factorial(long num) {
		BigInteger product = BigInteger.valueOf(num);
		for (long i = num - 1; i > 0; i--) {
			product = product.multiply(BigInteger.valueOf(i));
		}
		return product;
	}

	@Override
	public void run() {
		super.run();

		System.out.println(factorial(val));

	}
}
