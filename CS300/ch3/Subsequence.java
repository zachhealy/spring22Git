package CS300.ch3;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author John Stout
 */
public class Subsequence {

    /**
     * Main method with driver code.
     *
     * @param args
     */
    public static void subsequencer() {
        Scanner input = new Scanner(System.in);

        // create linked list to store order
        LinkedList<Integer> list = new LinkedList<>();
        // create linked list to store input cache
        LinkedList<Integer> temp = new LinkedList<>();

        // user input
        System.out.println("Enter a series of numbers ending with 0:");
        int number = input.nextInt(); // First entry
        while (number != 0) { // input until 0 is entered
            list.add(number);
            number = input.nextInt();
        }

        int index = 0;
        int count = 0;

        // for each in input list
        for (int i = 0, size = list.size(); i < size; i++) {
            // If temp empty
            if (temp.isEmpty()) {
                temp.add(list.get(i));
            } // If temp not empty
            else {
                if (Objects.equals(temp.getLast(), list.get(i))) {
                    temp.add(list.get(i));

                    if (i == size - 1) {

                        // Check if temp size > count
                        if (count < temp.size()) {
                            count = temp.size();
                            index = i - count + 1; // + 1 because at last pos
                        }
                    }
                } else {

                    // Check if temp size > count
                    if (count < temp.size()) {
                        count = temp.size();
                        index = i - count; // see note above why not + 1
                    }

                    temp.clear();
                    temp.add(list.get(i));
                }
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