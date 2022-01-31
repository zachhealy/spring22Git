package CS380.ch1.labOne;

/**
 * Date: Jan 30, 2022
 * @author Zach Healy and John Stout
 */

import java.util.Iterator;


public class DoublyLinkedList<E> implements MyList<E>{
    private Node<E> head, tail;
    private int size = 0; 

    //constructor
    public DoublyLinkedList() {
    }

    //constructor
    public DoublyLinkedList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]); 
    }

    //return first element
    public E getFirst() {
        if (size == 0)
            return null;
        else
            return head.element;
    }  

    //return last element
    public E getLast() {
        if (size == 0)
            return null;
        else
            return tail.element;
    }
  
    //return a certain element
    @Override
    public E get(int index) {
        // Checks to make sure it is not last element
        if (index < 0 || index >= size)
            return null;
        
        else if (index == 0)
            return getFirst();
        
        else if (index == size - 1)
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


    //add element to first slot in DLL
    public void addFirst(E elem) {
        Node<E> newNode = new Node<>(elem); 
        newNode.next = head; 
        head = newNode; 
        size++; 

        if (tail == null) 
            tail = head;
    }

    //add something to the back of the DLL
    public void addLast(E elem) {
      Node<E> newNode = new Node<>(elem); 

      if (tail == null)
          head = tail = newNode; 
      else {
          tail.next = newNode; 
          newNode.previous = tail; 
          tail = newNode;
      }

      size++;
    }

    //add item to DLL in certain spot
    @Override
    public void add(int index, E elem) {
        if (index == 0) { 
            addFirst(elem);
        }
        else if (index >= size) {
            addLast(elem);
        }
        else {
            int fromTail = size - 1 - index;
            if (fromTail < index) {
                Node<E> current = tail; 
                for (int i = size - 1; i > index; i--)
                    current = current.previous; 
                
                Node<E> newNode = new Node<>(elem); 
                
                newNode.previous = current.previous; 
                newNode.previous.next = newNode; 
                
                current.previous = newNode; 
                newNode.next = current; 
                size++; 
            }
            else {
                Node<E> current = head; 
                for (int i = 1; i < index; i++)
                  current = current.next; 
                
                Node<E> newNode = new Node<>(elem); 

                newNode.next = current.next; 
                newNode.next.previous = newNode; 

                current.next = newNode; 
                newNode.previous = current; 
                size++; 
            }
        }
    }

    //remove the first element in the DLL
    public E removeFirst() {
        if (size == 0)
            return null;
        else {
            E temp = head.element; 
            head = head.next; 
            head.previous = null; 
            size--; 
            if (head == null) {
              tail = null; 
            }
            return temp; 
        }
    }

    //remove the last element in the DLL
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
            Node<E> current = tail.previous; 
            
            E temp = tail.element;
            tail = current;
            tail.next = null;
            size--;
            return temp;
        }
    }

    //remove a ceratin index spot
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size)
            return null;
        
        else if (index == 0) { 
            return removeFirst();
        }
        
        else if (index == size - 1) { 
            return removeLast();
        }
        else {
            int fromTail = size - 1 - index;
            if (fromTail < index) {
                Node<E> current = tail; 
                
                for (int i = size - 1; i > index; i--)
                    current = current.previous; 
                
                Node<E> previous = current.previous;
                previous.next = current.next; 
                current.next.previous = previous; 
                size--; 
                return current.element; 
            }
            else {
                Node<E> previous = head; 

                for (int i = 1; i < index; i++)
                    previous = previous.next; 

                Node<E> current = previous.next; 
                previous.next = current.next; 
                current.next.previous = previous; 
                size--; 
                return current.element; 
            }
        }
    }

    //toString
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null)
                result.append(", "); 
            else
                result.append("]"); 
        }

        return result.toString();
    }

    //clears the DLL
    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    //Checks if an object is within the DLL
    @Override
    public boolean contains(Object elem) {
        Node<E> current = head;
        while(current != tail){
            if(current.element.equals(elem))
                return true; 
            current = current.next;
        }     
        return tail.element == elem;
    }

    //Checks what spot a certain element is in
    @Override
    public int indexOf(Object elem) {
        Node<E> current = head; 
        for (int i = 0; i < size; i++) 
            if(elem.equals(current.element))
                return i; 
            else
                current = current.next;
        return -1; 
    }

    //checks what the last index is
    @Override
    public int lastIndexOf(E elem) {
        int result = size-1;
        
        Node<E> current = tail; 
                
        while (!elem.equals(current.element)){ 
            current = current.previous; 
            if (--result == -1)
                return result;
        }
        
        return result;
    } 

    //returns size of DLL
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

    //sets a certain index to a certain element
    @Override
    public Object set(int index, Object elem) {
        if (index < 0 || index >= size)
            return null;
        
        else if (index == 0) {
            E old = head.element;
            head.element = (E) elem;
            return old;
        }
        
        else if (index == size - 1) { 
            E old = tail.element;
            tail.element = (E) elem;
            return old;
        }
        
        else {
            int fromTail = size-1-index;
            Node<E> current;
            E old;
            if (fromTail < index) {
                current = tail; 
                for (int i = size - 1; i > index; i--)
                    current = current.previous; // Move back one element
            }
            else {
                current = head;
                for (int i = 0; i < index; i++)
                    current = current.next; 
            }
            old = current.element;
            current.element = (E) elem; 
            return old;
        }
    }

    //iterator
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