package bigoh;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author John Stout
 */

public class bigO {
	public static void indexTest() {
		Scanner sc = new Scanner(System.in);
		// String prompt
		System.out.println("Enter your first string: ");
		String s1 = sc.nextLine();
		System.out.println("Enter your second string: ");
		String s2 = sc.nextLine();

		int index = -1; // store index of s2 as substring of s1
		int count = 0; // Count

		// looped test to see whether s2 is a substring of s1
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0) && count == 0) {
				index = i;
				count++;
			} else if (s1.charAt(i) == s2.charAt(count)) {
				count++;
			} else {
				count = 0;
				index = -1;
			}
			if (count == s2.length()) {
				break;
			}
		}
		// print results
		if (index > 1)
			System.out.println("Matched at index: " + index);
		else
			System.out.println("String 2 is not a substring of String 1");
	}

	public static void subsquencer() {
		Scanner sc = new Scanner(System.in);

		// create linkedlists to store our input order
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> temp = new LinkedList<>();

		// User input
		System.out.println("Enter a series of numbers ending with 0: ");
		int n = sc.nextInt(); // entry 1
		while (n != 0) { // Enter until input is 0
			list.add(n);
			n = sc.nextInt();
		}

		int index = 0;
		int count = 0;

		for (int i = 0, size = list.size(); i < size; i++) {
			// if temp empty
			if (temp.isEmpty()) {
				temp.add(list.get(i));
			} // if temp not empty
			else {
				if (Objects.equals(temp.getLast(), list.get(i))) {
					temp.add(list.get(i));
					if (i == size - 1) {
						// check if temp size > count
						if (count < temp.size()) {
							count = temp.size();
							index = i - count + 1;
						}
					}
				} else if (count < temp.size()) {
					count = temp.size();
					index = i - count;
				}
				temp.clear();
				temp.add(list.get(i));
			}
		}
		int value = list.get(index);
		System.out.println(format(index, count, value));
	}

	public static String format(int index, int count, int value) {
		return String.format("The longest same number sequence starts at index %d with %d values of %d", index, count,
				value);
	}
}
