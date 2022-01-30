package CS380.ch1.labOne;

import java.util.Iterator;
import java.util.ListIterator;


public class DoublyLinkedList<E> implements MyList<E>{
    private Node<E> head, tail;
    private int size = 0; 

    public DoublyLinkedList() {
    }

    public DoublyLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]); 
    }

    public E getFirst() {
        if (size == 0)
            return null;
        else
            return head.element;
    }  

    public E getLast() {
        if (size == 0)
            return null;
        else
            return tail.element;
    }
  
    @Override
    public E get(int index) {
        // When the index is not in the list
        if (index < 0 || index >= size)
            return null;
        
        else if (index == 0) // When the index is the head
            return getFirst();
        
        else if (index == size - 1) // When the index is the tail
            return getLast();
        
        else {
            int fromTail = size - 1 - index;
            if (fromTail < index) {
                Node<E> current = tail; // Create a pointer to cycle through the list
                
                for (int i = size - 1; i > index; i--)
                    current = current.previous; // Move the pointer to the previous node
                
                return current.previous.element; // Return the previous node's element
                
            }
            else {
                Node<E> current = head; // Create a pointer to cycle through the list
                
                for (int i = 1; i < index; i++)
                  current = current.next; // move the pointer to the next node
                
                return current.next.element; // return the next node's element
            }
        }
    }


    public void addFirst(E elem) {
        Node<E> newNode = new Node<>(elem); // Create a new node
        newNode.next = head; // Link the new node with the head (new's next)
        head = newNode; // Head points to the new node
        size++; // Increase list size

        if (tail == null) // The new node is the only node in list
            tail = head;
    }

    
    public void addLast(E elem) {
      Node<E> newNode = new Node<>(elem); // Create a new for element elem

      if (tail == null)
          head = tail = newNode; // The new node is the only node in list
      else {
          tail.next = newNode; // Link the new with the last node (tail's next)
          newNode.previous = tail; // Link the last with the new node (new's previous)
          tail = newNode; // Tail now points to the last node
      }

      size++;
    }

    @Override
    public void add(int index, E elem) {
        if (index == 0) { // If the index is the head
            addFirst(elem);
        }
        else if (index >= size) { // If the index would be at the tail
            addLast(elem);
        }
        else {
            int fromTail = size - 1 - index;
            if (fromTail < index) {
                Node<E> current = tail; // Create pointer to cycle through the list
                for (int i = size - 1; i > index; i--)
                    current = current.previous; // Move the pointer to the previous node
                
                Node<E> newNode = new Node<>(elem); // Create a new node for the element elem
                
                newNode.previous = current.previous; // Links the new node to the previous node (new's previous)
                newNode.previous.next = newNode; // Links the previous node to the next node (previous' next)
                
                current.previous = newNode; // Links the current node to the new Node
                newNode.next = current; // Links the new Node to the current Node
                size++; // Increases the size of the list
            }
            else {
                Node<E> current = head; // Create a pointer to cycle through the list
                for (int i = 1; i < index; i++)
                  current = current.next; // Move the pointer to next Node
                
                Node<E> newNode = new Node<>(elem); // Create a new node for the element elem

                newNode.next = current.next; // Links the new node to the next node (new's next)
                newNode.next.previous = newNode; // Links the next node to the previous node (next's previous)

                current.next = newNode; // Links the current node to the new Node
                newNode.previous = current; // Links the new Node to the current Node
                size++; // Increases the size of the list
            }
        }
    }


    public E removeFirst() {
        if (size == 0)
            return null;
        else {
            E temp = head.element; // Store the element to return when done
            head = head.next; // Make the next element the head
            head.previous = null; // Remove the link from new to old head
            size--; // Shrink list size
            if (head == null) { // If the list is empty...
              tail = null; // ... make the tail not point to anything
            }
            return temp; // Return the remeoved element
        }
    }

    public E removeLast() {
        if (size == 0)
            return null;
        else if (size == 1) {
            E temp = head.element;
            head = tail = null;
            size = 0;
            return temp;
        }
        else {
            Node<E> current = tail.previous; // Point to the second to last element

            E temp = tail.element; // Store the element to return when done
            tail = current; // Make the tail the second to last element
            tail.next = null; // Remove the link to the old tail, no need to remove the old tail's previous
            size--; // 
            return temp;
        }
    }

    @Override
    public E remove(int index) {
        // When the index is not in the list
        if (index < 0 || index >= size)
            return null;
        
        else if (index == 0) { // When the index is the head
            return removeFirst();
        }
        
        else if (index == size - 1) { // When the index is the tail
            return removeLast();
        }
        else {
            int fromTail = size - 1 - index;
            if (fromTail < index) {
                Node<E> current = tail; // Set a pointer to tail
                
                for (int i = size - 1; i > index; i--)
                    current = current.previous; // Move the pointer to the previous node
                
                Node<E> previous = current.previous; // Set a second pointer to aid visualization
                previous.next = current.next; // Set previous' next to current's next
                current.next.previous = previous; // Set current's next's previous to 'previous'
                size--; // Lower the size
                return current.element; // Return the removed element
            }
            else {
                Node<E> previous = head; // Set a pointer to head

                for (int i = 1; i < index; i++)
                    previous = previous.next; // Move the pointer to the next node

                Node<E> current = previous.next; // Set a second pointer to aid visualization
                previous.next = current.next; // Set previous' next to the node following current
                current.next.previous = previous; // Set the new next's previous to 'previous'
                size--; // Lower the size
                return current.element; // Return the removed element
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null)
                result.append(", "); // Separate two elements with a comma
            else
                result.append("]"); // Insert the closing ] in the string
        }

        return result.toString();
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public boolean contains(Object elem) {
        // Left as an exercise 
        Node<E> current = head;
        while(current != tail){
            if(current.element.equals(elem))
                return true; 
            current = current.next;
        }     
        return tail.element == elem;
    }

    @Override
    public int indexOf(Object elem) {
        Node<E> current = head; // Declare local variable for head Node.
        for (int i = 0; i < size; i++) // For-loop to iterate until i is equal to the size.
            if(elem.equals(current.element))
                return i; // Return current index
            else
                current = current.next; // Set next node
        return -1; // The item is not in the list
    }

    @Override
    public int lastIndexOf(E elem) {
        int result = size-1;// Declare local variable for a result to be returned.
        
        Node<E> current = tail; // Create pointer to cycle through the list
                
        while (!elem.equals(current.element)){ // Traverse in backwards manner until index of element is matched.
            current = current.previous; // Move the pointer to the previous node
            if (--result == -1)
                return result;
        }
        
        return result;
    } 

    @Override
    public int size() {
        return size;
    }
    
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;
        
        public Node(E element) {
            this.element = element;
        }
    }

    @Override
    public Object set(int index, Object elem) {
        // When the index is not in the list
        if (index < 0 || index >= size)
            return null;
        
        else if (index == 0) { // When the index is the head
            E old = head.element;
            head.element = (E) elem;
            return old;
        }
        
        else if (index == size - 1) { // When the index is the tail
            E old = tail.element;
            tail.element = (E) elem;
            return old;
        }
        
        else {
            int fromTail = size-1-index;
            Node<E> current;
            E old;
            if (fromTail < index) {
                current = tail; // Set pointer to cycle through the list
                for (int i = size - 1; i > index; i--)
                    current = current.previous; // Move back one element
            }
            else {
                current = head; // Set pointer to cycle through the list
                for (int i = 0; i < index; i++)
                    current = current.next; // Move forward one element
            }
            old = current.element;
            current.element = (E) elem; // Set the element equal to the argument elem
            return old;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head; // Current index 
    
        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
        E e = current.element;
        current = current.next;
        return e;
        }

        @Override
        public void remove() {
          // Left as an exercise
          if(size != 0){
            Node<E> preCur = head;
            Node<E> prePreCur = null;

            while(preCur.next != null){
                if(preCur.next == current)
                    break;
                prePreCur = preCur;
                preCur = preCur.next;          
            }
            prePreCur.next = preCur.next;
            size--;
          }
        }
    }
    

    public Iterator<E> listerIterator() {
        return this.iterator();
    }

    public Iterator<E> listIterator(int index) {
        Iterator<E> itr = this.iterator();
        for (int i = 1; i < index; i ++) {
            if (itr.hasNext()){
                itr.next();
            }
            else{
                System.out.println("Index " + index + " does not exist./n Returning ListIterator from last element...");
            }
        }
        return itr;
    }
}