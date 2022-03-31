package CS300.ch4;

/*
Members: Zach Healy, Jack Stout, Noah Little, Jacob Thieret, Jalik Smith, Trinity Smallwood
*/

public class Lab4 {
    public static void main(String[] args){
        BinSrchTree<Integer> tree = new BinSrchTree();
        tree.Insert(3);
        tree.Insert(0);
        tree.Insert(1);
        tree.Insert(5);
        tree.Insert(7);
        tree.Insert(8);
        System.out.println("Originial: ");
        tree.Preorder();
        System.out.println("\nFirst: " + tree.first());
        System.out.println("Last: " + tree.last());
        System.out.println("Higher when 3: " + tree.higher(3));
        System.out.println("Lower when 5: " + tree.lower(5));
        System.out.println("Floor when 4: " + tree.floor(4));
        System.out.println("Ceiling when 2: " + tree.ceiling(2));
        System.out.println("Size: " + tree.size());
        System.out.println("PollFirst: " + tree.pollFirst());
        System.out.println("PollLast: " + tree.pollLast());
        BinSrchTree<Integer> treeTwo = tree.subSet(3,false,7, true);
        System.out.println("Subset from 3 to 7 not including 3: ");
        treeTwo.Preorder();
    }
}
