import java.util.ArrayList;
import java.util.Scanner;

//Author: Zach Healy, John Stout, Jacob Theiret, Noah Little, Jalik Smith, Trinity Smallwood

public class numFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of objects: ");
        int num = input.nextInt();
        ArrayList<Integer> obj = new ArrayList<>();

        System.out.print("Enter the weights of the objects: ");
        for (int i = 0; i < num; i++) {
            obj.add(input.nextInt());

        }
        int container = 1;
        while (!obj.isEmpty()) {
            System.out.println("Container " + container++ + " conterins objects with weight " + getContainer(obj, 10));

        }

    }

    static String getContainer(ArrayList<Integer> obj, int max) {
        String result = "";
        int temp;

        for (int i = 0; i < obj.size(); i++) {
            if (obj.get(i) <= max) {
                temp = obj.get(i);
                result += temp + " ";
                obj.remove(i);
                return result + getContainer(obj, max - temp);

            }
        }
        return result;

    }

}
