package CS300.ch7;

import java.util.*;

public class Ex26_2 {
    public static void main(String[] args) {
        // BinSrchTree<Integer> tree = new BinSrchTree<>();
        ArrayList<Integer> list = new ArrayList<>();
        int x;
        for (int i = 0; i < 500000; i++) {
            x = (int) (Math.random() * 1000);
            list.add(x);

        }
        System.out.print(list.toString());

    }

}