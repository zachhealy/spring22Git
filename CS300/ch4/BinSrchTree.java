package CS300.ch4;

/*
Members: Zach Healy, Jack Stout, Noah Little, Jacob Thieret, Jalik Smith, Trinity Smallwood
*/



import java.util.Queue; 
import java.util.Stack;
import java.util.LinkedList; 
/**
 *
 * @author ziping
 */
public class BinSrchTree<T extends Comparable<T>>{
    private static class BinNode<T extends Comparable<T>>{
        private T data;
        private BinNode<T> left, right;
        
        public BinNode(){
            left = null;
            right = null;
        }
        public BinNode(T data, BinNode<T> left, BinNode<T> right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }     
    
    private BinNode<T> root;
    private int counter = 0;
    public BinSrchTree(){
        root = null;
    }
    
    public BinSrchTree(T item){
        root = new BinNode(item, null, null);
        counter++;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public boolean Search (T item){
BinNode<T> cursor = root;
boolean found = false;
while (cursor != null && !found)   
{
            if (item.equals(cursor.data))
found = true;
            else if (item.compareTo(cursor.data) < 0)
cursor = cursor.left;
            else
cursor = cursor.right;
}
return found;
    } // end Search
    public boolean Insert(T item){
        boolean inList = false;
        BinNode<T> cursor = root;
        BinNode<T> parent = null; // root has no parent
        while (cursor != null && !inList){
            parent = cursor;
            if (item.equals(cursor.data))
                inList = true;
            else if (item.compareTo(cursor.data) < 0)
                cursor = cursor.left;
            else
                cursor = cursor.right;
        }
        if (inList)
            return false;  // not successful; already in list
        if (parent == null)
            root = new BinNode(item, null, null);
        else if (item.compareTo(parent.data) < 0)
            parent.left = new BinNode(item, null, null);
        else
            parent.right = new BinNode(item, null, null);
        counter++;
        return true; // successful insert
    } // end Insert 
    
    /*  Private utility function called by Delete member function.
Returns true iff elt found in tree;
        if found, location = pointer to node containing elt; 
        parent = pointer to parent of node containing elt;
    */
    private boolean Search2(T item, BinNode<T>[] nodes){
nodes[0] = root;
nodes[1] = null;
boolean found = false;
while (nodes[0] != null && !found){
            if (item == nodes[0].data)
found = true;
            else if (item.compareTo(nodes[0].data) < 0){
                nodes[1] = nodes[0];
                nodes[0] = nodes[0].left;
            }
            else{
                nodes[1] = nodes[0];
                nodes[0] = nodes[0].right;    
            }
}
return found;  
    }  
    
    boolean Delete(T item){
        BinNode[] nodes = new BinNode[2];
if (!Search2(item, nodes))
            return false;
BinNode location = nodes[0], parent = nodes[1];
/* In case the node to be deleted has two children, adjust location and 
parent
       to a node with only one child. */    
if (location.left != null && location.right != null){
            // Find node with data which comes next in order
            BinNode nextInOrder = location.right;  // go to the right subtree
            parent = location; // let the parent follow
            while (nextInOrder.left != null)  // go left till dead end
            {
parent = nextInOrder;
nextInOrder = nextInOrder.left;
            }
            // Copy data which comes next into location of data to be deleted
            location.data = nextInOrder.data;
            
            location = nextInOrder;  // Note that parent has already been adjusted.
}
/* Adjust parent->left or right to point to child of node to be deleted
   Note that in case above, left subtree is empty, so node has at most 1 
child; 
   in all other cases, the node to be deleted has 0 or 1 children.
*/
// Set a pointer to the child or to NULL
BinNode childPtr;
if (location.left != null)
            childPtr = location.left;
else if (location.right != null)
            childPtr = location.right;
else
            childPtr = null;
// Set parent to point to the child
// In case the root is being deleted, set the root to the child
if (location == root)
            root = childPtr;
// otherwise determine if the left or right child of the parent is being deleted
else if (location == parent.left)
            parent.left = childPtr;
else // it is the right child
            parent.right = childPtr;
    counter--;
    return true;  // successfully deleted
    } // end Delete
    
    public void Inorder(){ 
        InorderAux(root); 
    }
    public void InorderAux(BinNode node){   
        if (node != null){
           InorderAux(node.left);
           System.out.print(node.data + " ");
           InorderAux(node.right);
        }
    }    
    
    public void Preorder(){ 
        PreorderAux(root); 
    }
    public void PreorderAux(BinNode node){   
        if (node != null){
           System.out.print(node.data + " "); 
           PreorderAux(node.left);           
           PreorderAux(node.right);
        }
    }   
    
    public void Postorder(){ 
        PostorderAux(root); 
    }
    public void PostorderAux(BinNode node){   
        if (node != null){           
           PostorderAux(node.left);           
           PostorderAux(node.right);
           System.out.print(node.data + " "); 
        }
    }     
    
    public String traversePreOrder(BinNode root){ 
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.data);
        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";
        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);
        return sb.toString();
    }
    
    //traversing via recursive approach
    public void traverseNodes(StringBuilder sb, String padding, 
                        String pointer, BinNode node, boolean hasRightSibling){
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);
            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }
            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";
            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right !=
null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }
    
    public void print(){
        StringBuilder sb = new StringBuilder();        
        System.out.println(traversePreOrder(root));
    }
    //LevelOrder traversing via queue 
    public void printLevelOrder(){ 
        Queue<BinNode> queue = new LinkedList<BinNode>(); 
        queue.add(root); 
        while (!queue.isEmpty()){ 
            BinNode tempNode = queue.poll(); 
            System.out.print(tempNode.data + " "); 
  
            /*Enqueue left child */
            if (tempNode.left != null) { 
                queue.add(tempNode.left); 
            } 
  
            /*Enqueue right child */
            if (tempNode.right != null) { 
                queue.add(tempNode.right); 
            } 
        } 
    }
    public T first(){
        if(root == null)
                return null;
        BinNode<T> temp = root;
        while(temp.left != null)
            temp = temp.left;
        return temp.data;
    }
    public T last(){
        if(root == null)
            return null;
        BinNode<T> temp = root;
        while(temp.right != null)
            temp = temp.right;
        return temp.data;
    }
    public T higher(T item){
        if(root == null)
            return null;
        Stack<BinNode<T>> bstStack = new Stack<BinNode<T>>();
        BinNode<T> cursor = root;
        while(cursor != null || bstStack.size() >0){
            while(cursor != null){
                bstStack.push(cursor);
                cursor = cursor.left;
            }
            cursor = bstStack.pop();
            if(cursor.data.compareTo(item)>0)
                return cursor.data;
            cursor = cursor.right;
        }
        return null;
    }
    public T lower(T item){
        if(root == null)
            return null;
        Stack<BinNode<T>> bstStack = new Stack<BinNode<T>>();
        BinNode<T> cursor = root;
        while(cursor != null || bstStack.size() > 0){
            while(cursor != null){
                bstStack.push(cursor);
                cursor = cursor.right;
            }
            cursor = bstStack.pop();
            if(cursor.data.compareTo(item) < 0)
                return cursor.data;
            cursor = cursor.left;
        } 
        return null;
        
    }
    public T ceiling(T item){
        if(root == null)
            return null;
        Stack<BinNode<T>> bstStack = new Stack<BinNode<T>>();
        BinNode<T> cursor = root;
        while(cursor != null || bstStack.size() > 0){
            while(cursor != null){
                bstStack.push(cursor);
                cursor = cursor.left;
            }
            cursor = bstStack.pop();
            if(cursor.data.compareTo(item) >= 0)
                return cursor.data;
            cursor = cursor.left;
        } 
        return null;
    }
    public T floor(T item){
        if(root == null)
            return null;
        Stack<BinNode<T>> bstStack = new Stack<BinNode<T>>();
        BinNode<T> cursor = root;
        while(cursor != null || bstStack.size() > 0){
            while(cursor != null){
                bstStack.push(cursor);
                cursor = cursor.right;
            }
            cursor = bstStack.pop();
            if(cursor.data.compareTo(item) <= 0)
                return cursor.data;
            cursor = cursor.left;
        } 
        return null;
    }
    public T pollFirst(){
        if(root == null)
            return null;
        BinNode<T> temp = root;
        while(temp.left != null)
            temp = temp.left;
        this.Delete(temp.data);
        return temp.data;
    }
    public T pollLast(){
        if(root == null)
            return null;
        BinNode<T> temp = root;
        while(temp.right != null)
            temp = temp.right;
        this.Delete(temp.data);
        return temp.data;
    }
    public int size(){
        return counter;
    }
    
    public BinSrchTree<T> subSet(T fromItem, boolean fromInclusive, T toItem, boolean toInclusive){
        if(root == null){
            return null;
        }
        BinSrchTree tree = new BinSrchTree();
        BinSrchTree sub = new BinSrchTree();
        clone(root, tree);
        if(fromInclusive && toInclusive){
            while(!tree.isEmpty()){
                T item = pollLast();
                if(item == null){
                    break;
                }
                if(item.compareTo(fromItem) == 0 || item.compareTo(toItem) == 0 || ((item.compareTo(fromItem) == 1) && (item.compareTo(toItem) == -1))){
                    sub.Insert(item);
                }
            }
        }
        else if(fromInclusive && (!toInclusive)){
            while(!tree.isEmpty()){
                T item = pollLast();
                if(item == null){
                    break;
                }
                if(item.compareTo(fromItem) == 0 || ((item.compareTo(fromItem) == 1) && (item.compareTo(toItem) == -1))){
                    sub.Insert(item);
                }
            }
        }
        else if((!fromInclusive) && toInclusive){
            while(!tree.isEmpty()){
                T item = pollLast();
                if(item == null){
                    break;
                }
                if(item.compareTo(toItem) == 0 || ((item.compareTo(fromItem) == 1) && (item.compareTo(toItem) == -1))){
                    sub.Insert(item);
                }
            }
        }
        if((!fromInclusive) && (!toInclusive)){
            while(!tree.isEmpty()){
                T item = pollLast();
                if(item == null){
                    break;
                }
                if(((item.compareTo(fromItem) == 1) && (item.compareTo(toItem) == -1))){
                    sub.Insert(item);
                }
            }
        }
        return sub;
    }
    
    //Used to clone
    public void clone(BinNode node, BinSrchTree tree){   
        if (node != null){
           tree.Insert(node.data); 
           clone(node.left, tree);           
           clone(node.right, tree);
        }
    }
}