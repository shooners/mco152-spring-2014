package teich.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StatisticsOfOWL {

	public static void main(String[] args) throws FileNotFoundException {
		Set<String> dictionary = new HashSet<String>();

		Scanner input = new Scanner(new File(System.getProperty("user.dir")
				+ "/OWL.txt"));
		while (input.hasNext()) {
			String word = input.next();
			if (word.equals(word.toUpperCase()) && !"-S]".equals(word)) {
				dictionary.add(word);
			}
		}
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z' };
		int[] count = new int[26];
		int[] wordCount = new int[26];
		double[] percentage = new double[26];
		int[] letter = new int[26];

		for (String d : dictionary) {
			for (int l = 0; l < 26; l++) {
				letter[l] = 0;
			}
			for (int i = 0; i < d.length(); i++) {
				char c = d.charAt(i);
				if (c == 'A') {
					count[0]++;
					letter[0]++;
					if (letter[0] == 1) {
						wordCount[0]++;
					}
				} else if (c == 'B') {
					count[1]++;
					letter[1]++;
					if (letter[1] == 1) {
						wordCount[1]++;
					}
				} else if (c == 'C') {
					count[2]++;
					letter[2]++;
					if (letter[2] == 1) {
						wordCount[2]++;
					}
				} else if (c == 'D') {
					count[3]++;
					letter[3]++;
					if (letter[3] == 1) {
						wordCount[3]++;
					}
				} else if (c == 'E') {
					count[4]++;
					letter[4]++;
					if (letter[4] == 1) {
						wordCount[4]++;
					}
				} else if (c == 'F') {
					count[5]++;
					letter[5]++;
					if (letter[5] == 1) {
						wordCount[5]++;
					}
				} else if (c == 'G') {
					count[6]++;
					letter[6]++;
					if (letter[6] == 1) {
						wordCount[6]++;
					}
				} else if (c == 'H') {
					count[7]++;
					letter[7]++;
					if (letter[7] == 1) {
						wordCount[7]++;
					}
				} else if (c == 'I') {
					count[8]++;
					letter[8]++;
					if (letter[8] == 1) {
						wordCount[8]++;
					}
				} else if (c == 'J') {
					count[9]++;
					letter[9]++;
					if (letter[9] == 1) {
						wordCount[9]++;
					}
				} else if (c == 'K') {
					count[10]++;
					letter[10]++;
					if (letter[10] == 1) {
						wordCount[10]++;
					}
				} else if (c == 'L') {
					count[11]++;
					letter[11]++;
					if (letter[11] == 1) {
						wordCount[11]++;
					}
				} else if (c == 'M') {
					count[12]++;
					letter[12]++;
					if (letter[12] == 1) {
						wordCount[12]++;
					}
				} else if (c == 'N') {
					count[13]++;
					letter[13]++;
					if (letter[13] == 1) {
						wordCount[13]++;
					}
				} else if (c == 'O') {
					count[14]++;
					letter[14]++;
					if (letter[14] == 1) {
						wordCount[14]++;
					}
				} else if (c == 'P') {
					count[15]++;
					letter[15]++;
					if (letter[15] == 1) {
						wordCount[15]++;
					}
				} else if (c == 'Q') {
					count[16]++;
					letter[16]++;
					if (letter[16] == 1) {
						wordCount[16]++;
					}
				} else if (c == 'R') {
					count[17]++;
					letter[17]++;
					if (letter[17] == 1) {
						wordCount[17]++;
					}
				} else if (c == 'S') {
					count[18]++;
					letter[18]++;
					if (letter[18] == 1) {
						wordCount[18]++;
					}
				} else if (c == 'T') {
					count[19]++;
					letter[19]++;
					if (letter[19] == 1) {
						wordCount[19]++;
					}
				} else if (c == 'U') {
					count[20]++;
					letter[20]++;
					if (letter[20] == 1) {
						wordCount[20]++;
					}
				} else if (c == 'V') {
					count[21]++;
					letter[21]++;
					if (letter[21] == 1) {
						wordCount[21]++;
					}
				} else if (c == 'W') {
					count[22]++;
					letter[22]++;
					if (letter[22] == 1) {
						wordCount[22]++;
					}
				} else if (c == 'X') {
					count[23]++;
					letter[23]++;
					if (letter[23] == 1) {
						wordCount[23]++;
					}
				} else if (c == 'Y') {
					count[24]++;
					letter[24]++;
					if (letter[24] == 1) {
						wordCount[24]++;
					}
				} else if (c == 'Z') {
					count[25]++;
					letter[25]++;
					if (letter[25] == 1) {
						wordCount[25]++;
					}
				}
			}
		}

		double length = dictionary.size();
		for (int k = 0; k < 26; k++) {
			percentage[k] = wordCount[k] / length;
		}

		DecimalFormat f = new DecimalFormat("#.##%");
		for (int j = 0; j < 26; j++) {
			System.out.println(letters[j] + "  " + count[j] + "  "
					+ f.format(percentage[j]));
		}
	}
}
