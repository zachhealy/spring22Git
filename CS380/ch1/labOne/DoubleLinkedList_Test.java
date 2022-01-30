package CS380.ch1.labOne;

/**
 * Date: Jan 30, 2022
 * @author Zach Healy and John Stout
 */

public class DoubleLinkedList_Test {
    public static void main(String[] args) {
        //creates an array of Strings to add to the linked list
        String[] sArray = new String[3];
        sArray[0] = "Hello";
        sArray[1] = "Test";
        sArray[2] = "String";
        
        //creates the DoublyLinkedList
        DoublyLinkedList<String> sTest = new DoublyLinkedList(sArray);
        
        //tests the toString method
        System.out.println("Testing toString:");
        System.out.println(sTest.toString());
        System.out.println();
        
        //tests the getFirst method
        System.out.println("Testing getFirst:");
        System.out.println(sTest.getFirst());
        System.out.println();
        
        //tests the getLast method
        System.out.println("Testing getLast:");
        System.out.println(sTest.getLast());
        System.out.println();
        
        //tests the get method
        System.out.println("Testing get:");
        System.out.println(sTest.get(1));
        System.out.println();
        
        //tests the addFirst method
        System.out.println("Testing addFirst:");
        sTest.addFirst("Help");
        System.out.println(sTest.toString());
        System.out.println();
        
        //tests the addLast method
        System.out.println("Testing addLast:");
        sTest.addLast("Lists");
        System.out.println(sTest.toString());
        System.out.println();
        
        //tests the add method
        System.out.println("Testing add:");
        sTest.add(2, "Final");
        System.out.println(sTest.toString());
        System.out.println();
        
        //tests the remove method
        System.out.println("Testing remove:");
        sTest.remove(4);
        System.out.println(sTest.toString());
        System.out.println();
        
        //tests the removeFirst method
        System.out.println("Testing removeFirst:");
        sTest.removeFirst();
        System.out.println(sTest.toString());
        System.out.println();
        
        //tests the removeLast method
        System.out.println("Testing removeLast:");
        sTest.removeLast();
        System.out.println(sTest.toString());
        System.out.println();
        
        //tests the contains method
        System.out.println("Testing contains:");
        System.out.print("Test contains Final: ");
        System.out.println(sTest.contains("Final"));
        System.out.print("Test contains Fish: ");
        System.out.println(sTest.contains("Fish"));
        System.out.println();
        
        //tests indexOf method
        sTest.addLast("Final"); //Adds a second instance of "Final" to test index
        System.out.println("Testing indexOf:");
        System.out.print("Final has an index of: ");
        System.out.println(sTest.indexOf("Final"));
        System.out.println();
        
        //tests lastIndexOf
        System.out.println("Testing lastIndexOf:");
        System.out.print("Final has a last index of: ");
        System.out.println(sTest.lastIndexOf("Final"));
        System.out.println();
        
        //tests size
        System.out.println(sTest.size());
        System.out.println();
        
        //tests set
        System.out.println("Testing set:");
        System.out.print("List before set: ");
        System.out.println(sTest.toString());
        sTest.set(2, "Reset");
        System.out.print("List after set: ");
        System.out.println(sTest.toString());
        System.out.println();
        
        //tests listerIterator method
        System.out.println("Testing listerIterator: ");
        sTest.listerIterator();
        System.out.println(sTest.toString());
        System.out.println();
        
        //tests listIterator method
        System.out.println("Testing listIterator: ");
        sTest.listIterator(1);
        System.out.println(sTest.toString());
        System.out.println();
        
        //tests the clear method
        System.out.println("Testing clear:");
        sTest.clear();
        System.out.println(sTest.toString());  
        System.out.println();
        
        //creates an array of Integers to add to the linked list
        Integer[] iArray = new Integer[3];
        iArray[0] = 1;
        iArray[1] = 2;
        iArray[2] = 3;
        
        //creates the DoublyLinkedList
        DoublyLinkedList<Integer> iTest = new DoublyLinkedList(iArray);
        
        //tests the toString method
        System.out.println("Testing toString:");
        System.out.println(iTest.toString());
        System.out.println();
        
        //tests the getFirst method
        System.out.println("Testing getFirst:");
        System.out.println(iTest.getFirst());
        System.out.println();
        
        //tests the getLast method
        System.out.println("Testing getLast:");
        System.out.println(iTest.getLast());
        System.out.println();
        
        //tests the get method
        System.out.println("Testing get:");
        System.out.println(iTest.get(1));
        System.out.println();
        
        //tests the addFirst method
        System.out.println("Testing addFirst:");
        iTest.addFirst(4);
        System.out.println(iTest.toString());
        System.out.println();
        
        //tests the addLast method
        System.out.println("Testing addLast:");
        iTest.addLast(5);
        System.out.println(iTest.toString());
        System.out.println();
        
        //tests the add method
        System.out.println("Testing add:");
        iTest.add(2, 6);
        System.out.println(iTest.toString());
        System.out.println();
        
        //tests the remove method
        System.out.println("Testing remove:");
        iTest.remove(4);
        System.out.println(iTest.toString());
        System.out.println();
        
        //tests the removeFirst method
        System.out.println("Testing removeFirst:");
        iTest.removeFirst();
        System.out.println(iTest.toString());
        System.out.println();
        
        //tests the removeLast method
        System.out.println("Testing removeLast:");
        iTest.removeLast();
        System.out.println(iTest.toString());
        System.out.println();
        
        //tests the contains method
        System.out.println("Testing contains:");
        System.out.print("Test contains 6: ");
        System.out.println(iTest.contains(6));
        System.out.print("Test contains 7: ");
        System.out.println(iTest.contains(7));
        System.out.println();
        
        //tests indexOf method
        iTest.addLast(6); //Adds a second instance of 6 to test index
        System.out.println("Testing indexOf:");
        System.out.print("6 has an index of: ");
        System.out.println(iTest.indexOf(6));
        System.out.println();
        
        //tests lastIndexOf
        System.out.println("Testing lastIndexOf:");
        System.out.print("6 has a last index of: ");
        System.out.println(iTest.lastIndexOf(6));
        System.out.println();
        
        //tests size
        System.out.println(iTest.size());
        System.out.println();
        
        //tests set
        System.out.println("Testing set:");
        System.out.print("List before set: ");
        System.out.println(iTest.toString());
        iTest.set(2, 8);
        System.out.print("List after set: ");
        System.out.println(iTest.toString());
        System.out.println();
        
        //tests listerIterator method
        System.out.println("Testing listerIterator: ");
        iTest.listerIterator();
        System.out.println(iTest.toString());
        System.out.println();
        
        //tests listIterator method
        System.out.println("Testing listIterator: ");
        iTest.listIterator(1);
        System.out.println(iTest.toString());
        System.out.println();
        
        //tests the clear method
        System.out.println("Testing clear:");
        iTest.clear();
        System.out.println(iTest.toString());
        System.out.println();
    }
}
