package CS300.ch8;
/*
* Group Members: John Stout, Zach Healy, Noah Little, Jacob Thieret,
* Justin Kehoe, Trinity Smallwood, and Jalik Smith.
*/

import java.util.*;
import java.util.concurrent.ThreadLocalRandom; //ThreadLocalRandom used instead of random due to the increased efficiency

class CompareLists {
    // initialize ArrayList and HashSet
    static ArrayList<Double> MyArrayList = new ArrayList<Double>();
    static HashSet<Double> MyHashSet = new HashSet<Double>();
    // make extra list for testing
    static ArrayList<Double> testValuesList = new ArrayList<Double>();

    public static void main(String args[]) {
        Random random = new Random();
        // initialize value to add to arraylist/hashset
        double doubleValue;

        // add random values from 0-999999 to both MyArrayList, as well as MyHashSet
        for (int i = 0; i < 1000000; i++) {
            doubleValue = ThreadLocalRandom.current().nextDouble(0, 999999);
            MyArrayList.add(doubleValue);
            MyHashSet.add(doubleValue);
        }

        // add random values from 0-999999 to testValuesList for comparing
        for (int i = 0; i < 1000000; i++) {
            doubleValue = ThreadLocalRandom.current().nextDouble(0, 1999999);
            testValuesList.add(doubleValue);
        }

        // run methods to test the time for ArrayList and HashSet
        testTimeForArrayList();
        testTimeForHashSet();
    }

    static void testTimeForArrayList() {
        System.out.println("ArrayList Test Starting...");
        long startTime = System.currentTimeMillis(); // initialize and set startTime to current system time in
                                                     // milliseconds
        for (Double value : testValuesList) { // test if each value in testValuesList is in MyArrayList
            for (Double listValue : MyArrayList) {
                if (value == listValue)
                    break;
            }
        }
        long endTime = System.currentTimeMillis(); // initialize and set endTime to current system time in milliseconds

        System.out.print("Test time for MyArrayList :");
        System.out.println((endTime - startTime) + " milliseconds"); // calculate and print runtime
    }

    static void testTimeForHashSet() {
        System.out.println("HashSet Test Starting...");
        long startTime = System.currentTimeMillis(); // initialize and set startTime to current system time in
                                                     // milliseconds
        for (Double value : testValuesList) { // test if each value in testValuesList is in MyArrayList
            for (Double setValue : MyHashSet) {
                if (value == setValue)
                    break;
            }
        }
        long endTime = System.currentTimeMillis(); // initialize and set endTime to current system time in milliseconds

        System.out.print("Test time for MyHashSet: ");
        System.out.println((endTime - startTime) + " milliseconds"); // calculate and print runtime
    }
}