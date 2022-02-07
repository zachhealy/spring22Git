
package CS300.ch2;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author ziping, Zach Healy, John Stout, Noah Little, Jacob Thieret, Trinity Smallwood, Jalik Smith
 */
public class JavaSortingEx {

    //Main Method

    public static void main(String[] args) {
        MyArray<Integer> A = new MyArray(Integer.class);
        for (int i = 0; i < MyArray.CAPACITY; i++)
            A.Insert((int) (Math.random() * (999 - 0)), i);
        System.out.println("BubbleSort");
        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(A.get(i) + ", ");
        System.out.println();
        A.BubbleSort();
        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(A.get(i) + ", ");
        System.out.println();

        MyArray<Integer> B = new MyArray(Integer.class);
        for (int i = 0; i < MyArray.CAPACITY; i++)
            B.Insert((int) (Math.random() * (999 - 0)), i);
        System.out.println("\nInsertionSort");
        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(B.get(i) + ", ");
        System.out.println();
        B.InsertionSort();
        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(B.get(i) + ", ");
        System.out.println();

        MyArray<Integer> C = new MyArray(Integer.class);
        for (int i = 0; i < MyArray.CAPACITY; i++)
            C.Insert((int) (Math.random() * (999 - 0)), i);
        System.out.println("\nSelectionSort");
        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(C.get(i) + ", ");
        System.out.println();
        C.SelectionSort();
        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(C.get(i) + ", ");
        System.out.println();

        /*
         * MyArray<Integer> D = new MyArray(Integer.class);
         * for(int i = 0; i < MyArray.CAPACITY; i++)
         * D.Insert((int)(Math.random() * (999 - 0)), i);
         * System.out.println("\nShellSort");
         * for(int i = 0; i < MyArray.CAPACITY; i++)
         * System.out.print(D.get(i) + ", ");
         * System.out.println();
         * D.ShellSort();
         * for(int i = 0; i < MyArray.CAPACITY; i++)
         * System.out.print(D.get(i) + ", ");
         * System.out.println();
         */
        MyArray<Integer> D = new MyArray(Integer.class);
        D.Insert(69, 0);
        D.Insert(35, 1);
        D.Insert(18, 2);
        D.Insert(87, 3);
        D.Insert(50, 4);
        D.Insert(58, 5);
        D.Insert(79, 6);
        System.out.println("\nShellSort");
        for (int i = 0; i < D.size(); i++)
            System.out.print(D.get(i) + ", ");
        System.out.println();
        D.ShellSort();
        for (int i = 0; i < D.size(); i++)
            System.out.print(D.get(i) + ", ");
        System.out.println();

        MyArray<Integer> E = new MyArray(Integer.class);
        for (int i = 0; i < MyArray.CAPACITY; i++)
            E.Insert((int) (Math.random() * (999 - 0)), i);
        System.out.println("\nQuickSort");
        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(E.get(i) + ", ");
        System.out.println();
        E.Quicksort(0, E.size() - 1);
        for (int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(E.get(i) + ", ");
        System.out.println();

        /*
         * MyArray<Integer> F = new MyArray(Integer.class);
         * for(int i = 0; i < MyArray.CAPACITY; i++)
         * F.Insert((int)(Math.random() * (999 - 0)), i);
         * 
         * System.out.println("\nMergeSort");
         * 
         * for(int i = 0; i < MyArray.CAPACITY; i++)
         * System.out.print(F.get(i) + ", ");
         * 
         * System.out.println();
         * 
         * F.MergeSort(Integer.class, 0, F.size() - 1);
         * 
         * for(int i = 0; i < MyArray.CAPACITY; i++)
         * System.out.print(F.get(i) + ", ");
         * 
         * System.out.println();
         */

        // New Code for cLab2
        System.out.println("\nNEW CODE FOR CLAB2");

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
        System.out.println("\nNon-recursive Quicksort: ");
        System.out.println("Unsorted array: " + Arrays.toString(unsorted));

        iterativeQsort(unsorted);
        System.out.println("Sorted array: " + Arrays.toString(unsorted));

        System.out.println();

        // Number 4
        Integer[] data = new Integer[] { 54, 32, 21, 25, 32, 66, 99, 12, 15, 13 };
        System.out.println("3-way Merge Sort:");
        System.out.println("Unsorted array: " + Arrays.toString(data));

        mergeSort3Way(data);

        System.out.println("Sorted array: " + Arrays.toString(data));
        /*
        System.out.println("After 3 way merge sort: ");
        for (int i = 0; i < data.length; i++)
            System.out.print(data[i] + " ");
            */

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

    // Number 4 Methods

    public static void mergeSort3Way(Integer[] gArray) {
        // if array of size is zero returns null
        if (gArray == null)
            return;

        // creating duplicate of given array
        Integer[] fArray = new Integer[gArray.length];

        // copying alements of given array into
        // duplicate array
        for (int i = 0; i < fArray.length; i++)
            fArray[i] = gArray[i];

        // sort function
        mergeSort3WayRec(fArray, 0, gArray.length, gArray);

        // copy back elements of duplicate array
        // to given array
        for (int i = 0; i < fArray.length; i++)
            gArray[i] = fArray[i];
    }

    public static void mergeSort3WayRec(Integer[] gArray,
            int low, int high, Integer[] destArray) {
        if (high - low < 2)
            return;

        int mid1 = low + ((high - low) / 3);
        int mid2 = low + 2 * ((high - low) / 3) + 1;

        mergeSort3WayRec(destArray, low, mid1, gArray);
        mergeSort3WayRec(destArray, mid1, mid2, gArray);
        mergeSort3WayRec(destArray, mid2, high, gArray);

        merge(destArray, low, mid1, mid2, high, gArray);
    }

    public static void merge(Integer[] gArray, int low,
            int mid1, int mid2, int high,
            Integer[] destArray) {
        int i = low, j = mid1, k = mid2, l = low;

        while ((i < mid1) && (j < mid2) && (k < high)) {
            if (gArray[i].compareTo(gArray[j]) < 0) {
                if (gArray[i].compareTo(gArray[k]) < 0)
                    destArray[l++] = gArray[i++];

                else
                    destArray[l++] = gArray[k++];
            } else {
                if (gArray[j].compareTo(gArray[k]) < 0)
                    destArray[l++] = gArray[j++];
                else
                    destArray[l++] = gArray[k++];
            }
        }

        while ((i < mid1) && (j < mid2)) {
            if (gArray[i].compareTo(gArray[j]) < 0)
                destArray[l++] = gArray[i++];
            else
                destArray[l++] = gArray[j++];
        }

        while ((j < mid2) && (k < high)) {
            if (gArray[j].compareTo(gArray[k]) < 0)
                destArray[l++] = gArray[j++];

            else
                destArray[l++] = gArray[k++];
        }

        while ((i < mid1) && (k < high)) {
            if (gArray[i].compareTo(gArray[k]) < 0)
                destArray[l++] = gArray[i++];
            else
                destArray[l++] = gArray[k++];
        }

        while (i < mid1)
            destArray[l++] = gArray[i++];

        while (j < mid2)
            destArray[l++] = gArray[j++];

        while (k < high)
            destArray[l++] = gArray[k++];
    }

}
