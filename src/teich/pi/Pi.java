package teich.pi;

public class Pi {

	public double calculatePi() {
		double sum = 0;
		for (int i = 1; i < 1000000000; i++) {
			sum += Math.pow((-1), i + 1) / ((2 * i) - 1);
		}
		double pi = sum * 4;
		return pi;
	}

	public static void main(String[] args) {
		Pi pi = new Pi();
		System.out.println(pi.calculatePi());
	}

}
