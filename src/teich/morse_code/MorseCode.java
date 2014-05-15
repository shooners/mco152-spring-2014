package teich.morse_code;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MorseCode {

	private Map<String, Character> toPlainText = new HashMap<>();

	private Map<Character, String> toMorse = new HashMap<>();

	public MorseCode() {
		Character[] alpha = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', '/' };
		String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
				"....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
				"--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
				"-.--", "--..", "-----", ".----", "..---", "...--", "....-",
				".....", "-....", "--...", "---..", "----.", " " };
		for (int a = 0; a < alpha.length; a++) {
			toPlainText.put(morse[a], alpha[a]);
			toMorse.put(alpha[a], morse[a]);
		}
	}

	public String toMorseCode(String msg) {
		StringBuilder builder = new StringBuilder();
		String upperCase = msg.toUpperCase();
		for (int i = 0; i < msg.length(); i++) {
			char c = upperCase.charAt(i);
			builder.append(toMorse.get(c));
			if (i != msg.length() - 1) {
				builder.append(" ");
			}
		}
		return builder.toString();
	}

	public String toPlainText(String morse) {
		StringBuilder b = new StringBuilder();

		StringTokenizer t = new StringTokenizer(morse);

		while (t.hasMoreElements()) {
			String token = t.nextToken();
			b.append(toPlainText.get(token));
		}

		return b.toString();
	}

}
