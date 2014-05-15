package teich.triangle;

public class Triangle {

	private int height;

	public Triangle(int height) {
		this.height = height;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		char blank = ' ';
		int numBlanks;
		int numStars;
		for (int row = 1; row <= height; row++) {

			numBlanks = height - row;
			int printedBlanks = 0;
			while (printedBlanks < numBlanks) {
				if (printedBlanks != 0) {
					builder.append(blank);
				}
				printedBlanks++;
			}
			numStars = row * 2 - 1;
			for (int printStars = 0; printStars < numStars; printStars++) {
				if (printStars == 0 || printStars == numStars - 1
						|| row == height) {
					builder.append("*");
				} else {
					builder.append(blank);
				}
			}

			builder.append("\n");
		}

		return builder.toString();
	}

	public static void main(String[] args) {
		Triangle t = new Triangle(7);
		System.out.print(t.toString());
	}
}
