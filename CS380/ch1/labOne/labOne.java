package CS380.ch1.labOne;

/**
 * Date: Jan 30, 2022
 * @author Zach Healy and John Stout
 */

public class labOne {
    public static void main(String[] args) {
        
        DoublyLinkedList<String> stringTest = new DoublyLinkedList();
        stringTest.addFirst("Hello");
        stringTest.addFirst("Testing");
        stringTest.addFirst("World");

        DoublyLinkedList<Integer> intTest = new DoublyLinkedList();
        intTest.add(4);
        intTest.add(100);
        intTest.add(10);
        
        //tests the toString method
        System.out.println("toString Test:");
        System.out.println(stringTest.toString());
        System.out.println();
        
        //tests the getFirst method
        System.out.println("getFirst Test:");
        System.out.println(stringTest.getFirst());
        System.out.println();
        
        //tests the getLast method
        System.out.println("getLast Test:");
        System.out.println(stringTest.getLast());
        System.out.println();
        
        //tests the get method
        System.out.println("get Test:");
        System.out.println(stringTest.get(1));
        System.out.println();
        
        //tests the addFirst method
        System.out.println("addFirst Test:");
        stringTest.addFirst("Help");
        System.out.println(stringTest.toString());
        System.out.println();
        
        //tests the addLast method
        System.out.println("addLast Test:");
        stringTest.addLast("Lists");
        System.out.println(stringTest.toString());
        System.out.println();
        
        //tests the add method
        System.out.println("add Test:");
        stringTest.add(2, "Final");
        System.out.println(stringTest.toString());
        System.out.println();
       
        //tests the remove method
        System.out.println("remove Test:");
        stringTest.remove(1);
        System.out.println(stringTest.toString());
        System.out.println();
       
        //tests the removeFirst method
        System.out.println("removeFirst Test:");
        stringTest.removeFirst();
        System.out.println(stringTest.toString());
        System.out.println();
        
        //tests the removeLast method
        System.out.println("removeLast Test:");
        stringTest.removeLast();
        System.out.println(stringTest.toString());
        System.out.println();
        
        //tests the contains method
        System.out.println("contains Test:");
        System.out.print("Test contains Final: ");
        System.out.println(stringTest.contains("Final"));
        System.out.print("Test contains Fish: ");
        System.out.println(stringTest.contains("Fish"));
        System.out.println();
        
        //tests indexOf method
        stringTest.addLast("Final"); //Adds a second instance of "Final" to test index
        System.out.println("indexOf Test:");
        System.out.print("Final has an index of: ");
        System.out.println(stringTest.indexOf("Final"));
        System.out.println();
        
        //tests lastIndexOf
        System.out.println("lastIndexOf Test:");
        System.out.print("Final has a last index of: ");
        System.out.println(stringTest.lastIndexOf("Final"));
        System.out.println();
        
        //tests size
        System.out.println(stringTest.size());
        System.out.println();
        
        //tests set
        System.out.println("set Test:");
        System.out.print("List before set: ");
        System.out.println(stringTest.toString());
        stringTest.set(2, "Reset");
        System.out.print("List after set: ");
        System.out.println(stringTest.toString());
        System.out.println();
        
        //tests listerIterator method
        System.out.println("listerIterator Test: ");
        stringTest.listerIterator();
        System.out.println(stringTest.toString());
        System.out.println();
        
        //tests listIterator method
        System.out.println("listIterator Test: ");
        stringTest.listIterator(1);
        System.out.println(stringTest.toString());
        System.out.println();
        
        //tests the clear method
        System.out.println("clear Test:");
        stringTest.clear();
        System.out.println(stringTest.toString());  
        System.out.println();
        
        //tests the toString method
        System.out.println("toString Test:");
        System.out.println(intTest.toString());
        System.out.println();
        
        //tests the getFirst method
        System.out.println("getFirst Test:");
        System.out.println(intTest.getFirst());
        System.out.println();
        
        //tests the getLast method
        System.out.println("getLast Test:");
        System.out.println(intTest.getLast());
        System.out.println();
        
        //tests the get method
        System.out.println("get Test:");
        System.out.println(intTest.get(1));
        System.out.println();
        
        //tests the addFirst method
        System.out.println("addFirst Test:");
        intTest.addFirst(4);
        System.out.println(intTest.toString());
        System.out.println();
        
        //tests the addLast method
        System.out.println("addLast Test:");
        intTest.addLast(5);
        System.out.println(intTest.toString());
        System.out.println();
        
        //tests the add method
        System.out.println("add Test:");
        intTest.add(2, 6);
        System.out.println(intTest.toString());
        System.out.println();
        
        //tests the remove method
        System.out.println("remove Test:");
        intTest.remove(1);
        System.out.println(intTest.toString());
        System.out.println();
        
        //tests the removeFirst method
        System.out.println("removeFirst Test:");
        intTest.removeFirst();
        System.out.println(intTest.toString());
        System.out.println();
        
        //tests the removeLast method
        System.out.println("removeLast Test:");
        intTest.removeLast();
        System.out.println(intTest.toString());
        System.out.println();
        
        //tests the contains method
        System.out.println("contains Test:");
        System.out.print("Test contains 6: ");
        System.out.println(intTest.contains(6));
        System.out.print("Test contains 7: ");
        System.out.println(intTest.contains(7));
        System.out.println();
        
        //tests indexOf method
        intTest.addLast(6); //Adds a second instance of 6 to test index
        System.out.println("indexOf Test:");
        System.out.print("6 has an index of: ");
        System.out.println(intTest.indexOf(6));
        System.out.println();
        
        //tests lastIndexOf
        System.out.println("lastIndexOf Test:");
        System.out.print("6 has a last index of: ");
        System.out.println(intTest.lastIndexOf(6));
        System.out.println();
        
        //tests size
        System.out.println(intTest.size());
        System.out.println();
        
        //tests set
        System.out.println("set Test:");
        System.out.print("List before set: ");
        System.out.println(intTest.toString());
        intTest.set(2, 8);
        System.out.print("List after set: ");
        System.out.println(intTest.toString());
        System.out.println();
        
        //tests listerIterator method
        System.out.println("listerIterator Test: ");
        intTest.listerIterator();
        System.out.println(intTest.toString());
        System.out.println();
        
        //tests listIterator method
        System.out.println("listIterator Test: ");
        intTest.listIterator(1);
        System.out.println(intTest.toString());
        System.out.println();
        
        //tests the clear method
        System.out.println("Testing clear:");
        intTest.clear();
        System.out.println(intTest.toString());
        System.out.println();

        //finished
        System.out.println("Done testing!");
    }
}
