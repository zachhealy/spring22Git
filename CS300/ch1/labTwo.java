package CS300.ch1;

import java.util.Arrays;
import java.util.Stack;

import CS300.ch2.MyArray;

/*
* Author: Zach Healy, Noah Little, John Stout, Trinity Smallwood, Jalik Smith, and Jacob Thieret
*/

public class labTwo {
    public static void main(String[] args) {

        // Number 1
        MyArray<Integer> F = new MyArray(Integer.class);
        for (int i = 0; i < MyArray.CAPACITY; i++)
            F.Insert((int) (Math.random() * (999 - 0)), i);

        System.out.println("\nDouble End Sort");

        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(F.get(i) + ", ");

        System.out.println();

        F.dSelSort();

        for (int i = MyArray.CAPACITY - 1; i >= 0; i--)
            System.out.print(F.get(i) + ", ");

        System.out.println();


        // Number 2
        MyArray<Integer> G = new MyArray(Integer.class);
        for (int i = 0; i < MyArray.CAPACITY; i++)
            G.Insert((int) (Math.random() * (999 - 0)), i);

        System.out.println("\nNew Quicksort");

        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(G.get(i) + ", ");

        System.out.println();

        G.newQuicksort(0, G.size() - 1);

        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(G.get(i) + ", ");

        System.out.println();


        // Number 3
        int[] unsorted = { 54, 32, 21, 25, 32, 66, 99, 12, 15, 13 };
        System.out.println("\nUnsorted array: " + Arrays.toString(unsorted));

        iterativeQsort(unsorted);
        System.out.println("Sorted array: " + Arrays.toString(unsorted));

        System.out.println();


        // Number 4


    }

    ////////////////////////////////////////////////////////////////////////////////////////

    // Number 3 Methods
    private static void iterativeQsort(int[] numbers) {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(numbers.length);

        while (!stack.isEmpty()) {
            int end = (int) stack.pop();
            int start = (int) stack.pop();
            if (end - start < 2) {
                continue;
            }
            int p = start + ((end - start) / 2);
            p = partition(numbers, p, start, end);

            stack.push(p + 1);
            stack.push(end);

            stack.push(start);
            stack.push(p);
        }
    }

    private static int partition(int[] input, int position, int start, int end) {
        int l = start;
        int h = end - 2;
        int piv = input[position];
        swap(input, position, end - 1);
        while (l < h) {
            if (input[l] < piv) {
                l++;
            } else if (input[h] >= piv) {
                h--;
            } else {
                swap(input, l, h);
            }
        }
        int idx = h;
        if (input[h] < piv) {
            idx++;
        }
        swap(input, end - 1, idx);
        return idx;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
