package CS300.ch7;

import java.util.*;

public class Ex26_2 {
    public static void main(String[] args) {
        BinSrchTree<Integer> tree = new BinSrchTree<>();
        ArrayList<Integer> list = new ArrayList<>();
        int x;
        for (int i = 0; i < 500000; i++) {
            x = (int) (Math.random() * 1000);
            list.add(x);

        }
        long start = System.currentTimeMillis();
        for (Integer num : list) {
            tree.Insert(num);
        }
        Collections.shuffle(list);
        for (Integer num : list) {
            tree.Search(num);
        }
        Collections.shuffle(list);
        for (Integer num : list) {
            tree.Delete(num);
        }
        long end = System.currentTimeMillis();

        System.out.println("BST Time: " + (end - start) + " milliseconds");

        Collections.shuffle(list);
        AVLTree<Integer> Atree = new AVLTree<>();

        start = System.currentTimeMillis();

        for (Integer num : list) {
            Atree.Insert(num);
        }
        Collections.shuffle(list);
        for (Integer num : list) {
            Atree.Search(num);
        }
        Collections.shuffle(list);
        for (Integer num : list) {
            Atree.Delete(num);
        }
        end = System.currentTimeMillis();

        System.out.println("AVL Tree Time: " + (end - start) + " milliseconds");

    }

}