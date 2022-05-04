/**=======================
 * Title: PrintData
 * Author(s): Jacob Thieret
 * Function: prints an arrayList data set in a layout more palatable to the eye
 *///=====================
package CS300Final;

import java.util.Arrays;
import java.util.Scanner;

public class PrintData {
    public static void prettyPrint(String[][] arrayList) {
        System.out.println(Arrays.deepToString(arrayList).replace("], ", "]\n").replace(", ", "\t").replace("[", "")
                .replace("]", ""));

    }

    public static void uiInputError() {
        System.out.println("Please enter a valid input from the list of options above");
    }
}
