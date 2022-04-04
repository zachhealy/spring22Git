package CS300.ch7.Ex5;

/*
* Group Members: Zach Healy, John Stout, Noah Little, Jacob Thieret,
* Trinity Smallwood, and Jalik Smith.
*/

import java.util.*;

public class Ex26_5 {
  public static void main(String[] args) {
    AVLTree<Double> tree = new AVLTree<>();
    Scanner input = new Scanner(System.in);
    System.out.print("Enter 15 numbers: ");
    for (int i = 0; i < 15; i++) {
      tree.insert(input.nextDouble());
    }

    System.out.print("Enter k: ");
    int k = input.nextInt();
    System.out.println("The " + k + "th smallest number is " + tree.find(k));
  }
}