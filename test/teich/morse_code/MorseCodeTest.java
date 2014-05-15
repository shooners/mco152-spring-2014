package teich.morse_code;

import org.junit.Assert;
import org.junit.Test;

public class MorseCodeTest {

	@Test
	public void testAlphabetToMorseCode() {

		MorseCode morseCode = new MorseCode();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String code = morseCode.toMorseCode(alphabet);
		String expected = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";

		Assert.assertEquals(expected, code);

	}

	@Test
	public void testMorseCodeToPlainText() {

		MorseCode mCode = new MorseCode();
		String morse = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --.. ----- .---- ..--- ...-- ....- ..... -.... --... ---.. ----.";
		String actual = mCode.toPlainText(morse);
		String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

		Assert.assertEquals(expected, actual);
	}

}
