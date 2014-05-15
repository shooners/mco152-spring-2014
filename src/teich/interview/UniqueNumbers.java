package teich.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UniqueNumbers {

	public static void main(String[] args) {
		Scanner kybrd = new Scanner(System.in);
		Set<Integer> set = new HashSet<Integer>();
		int input;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int j = 0; j < 10; j++) {
			input = kybrd.nextInt();
			int value = 1;
			if (!map.containsKey(input)) {
				map.put(input, value);
			} else {
				map.get(value);
				map.put(input, value + 1);
			}
		}
		/*
		 * for (int i = 0; i < 10; i++) { input = kybrd.nextInt(); if
		 * (!set.contains(input)) { set.add(input); } } System.out.println(set);
		 */
		System.out.println(map);
	}
}
