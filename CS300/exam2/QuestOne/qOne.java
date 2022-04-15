package CS300.exam2.QuestOne;

import java.util.SortedSet;

/**
 * Written by Zach Healy
 * Code for exam question is at end of BinSrchTree.java
 */

public class qOne {
    public static void main(String[] args) {
        BinSrchTree<Integer> bst = new BinSrchTree<>();
        bst.Insert(40);
        bst.Insert(10);
        bst.Insert(2);

        System.out.println();
        SortedSet<Integer> sortedSet = bst.GreaterThanSet(bst, 5);
        System.out.println(sortedSet.toString());

    }
}
