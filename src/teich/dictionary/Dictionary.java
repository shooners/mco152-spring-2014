package teich.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

	private Map<String, String> dictionary;

	public Dictionary() throws FileNotFoundException {
		dictionary = new HashMap<String, String>();

		Scanner input = new Scanner(new File(System.getProperty("user.dir")
				+ "/OWL.txt"));
		while (input.hasNext()) {

			String word = input.next();
			dictionary.put(word, input.nextLine());
		}
	}

	public Iterator<String> iterator() {
		return dictionary.keySet().iterator();
	}

	public int size() {
		return dictionary.size();
	}

	public boolean exists(String s) {
		return (dictionary.containsKey(s.toUpperCase()));
	}

	public String getDefinition(String word) {
		return dictionary.get(word.toUpperCase());
	}
}
