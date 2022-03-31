package CS300.ch5;
import java.util.*;
import java.io.*;


public class BinarySearchTree {
    
    class Node{
        String key;
        Node left;
        Node right;
        
        public Node(String word){
            key = new String(word);
            left = null;
            right = null;
        }
    }
    Node root;
    BinarySearchTree(){
        root = null;
    }
    
void insert(String key){ 
        if(search(root, key) != null) 
            return;
        root = recursiveInsert(root, key); 
    }

    Node recursiveInsert(Node root, String key){
        if (root == null){                
            root = new Node(key);
            return root;
        }
        if (key.compareTo(root.key) < 0)
            root.left = recursiveInsert(root.left, key);
        else if (key.compareTo(root.key) > 0)
            root.right = recursiveInsert(root.right, key);
        return root;
    }
    
    void printTree(){ 
         inOrderTraverse(root); 
    }
    
    void inOrderTraverse(Node root){
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.key + " ");
            inOrderTraverse(root.right);
        }
    }
 
    public Node search(Node root, String key){
        if (root == null)
            return root;
        int checkKey = root.key.compareTo(key);
        if(checkKey == 0) 
            return root;
        if (checkKey == -1)
           return search(root.right, key);
        return search(root.left, key);
    }
    
    public static int hash(String word){
        if(word.length() < 3) 
            return -1;
        int hash = 0;
        hash += (int)word.charAt(0) + (int)word.charAt(1) + (int)word.charAt(2);
        hash %= 11;            
        return hash;
    }
    
    public static void main(String[] args){
        BinarySearchTree poemTree[] = new BinarySearchTree[11];
        for(int i=0;i<11;++i)
                poemTree[i] = new BinarySearchTree();
        File poemFile = new File("C:\\Users\\jacob\\OneDrive\\Documents\\NetBeansProjects\\jdbcdemo\\src\\CS300\\Lab05\\textfiles\\poem.txt");
        Scanner poemScan = null;
        try{
            poemScan = new Scanner(poemFile);
        }catch(FileNotFoundException e){
                System.out.println("Error occurred in opening the file");
        }
        System.out.println("Printing Poem result:");
        while(poemScan.hasNextLine()){
            String line = poemScan.nextLine();
            String arr[] = line.split(" ");
            for(String s:arr){
                int hashVal = hash(s);
                if(hashVal == -1)
                    System.out.println("String:'" + s + "', is too short.");
                else{
                    poemTree[hashVal].insert(s);
                }
            }
        }
        poemScan.close();
        
        for(int i=0;i<11;++i){
            if(poemTree[i].root == null) continue;
            System.out.print(i + ". ");
            poemTree[i].printTree();
            System.out.println();
        } 
        System.out.println("===========================================");
        BinarySearchTree testDataTree[] = new BinarySearchTree[11];
        for(int i=0;i<11;++i)
                poemTree[i] = new BinarySearchTree();
        File testDataFile = new File("C:\\Users\\jacob\\OneDrive\\Documents\\NetBeansProjects\\jdbcdemo\\src\\CS300\\Lab05\\textfiles\\testdata-11b.txt");
        Scanner testDataScan = null;
        try{
            testDataScan = new Scanner(testDataFile);
        }catch(FileNotFoundException e){
                System.out.println("Error occurred in opening the file");
        }
        System.out.println("Printing testdata result:");
        while(testDataScan.hasNextLine()){
            String line = testDataScan.nextLine();
            String arr[] = line.split(" ");
            for(String s:arr){
                int hashVal = hash(s);
                if(hashVal == -1)
                    System.out.println("String:'" + s + "', is too short.");
                else{
                    poemTree[hashVal].insert(s);
                }
            }
        }
        testDataScan.close();
        
        for(int i=0;i<11;++i){
            if(poemTree[i].root == null) continue;
            System.out.print(i + ". ");
            poemTree[i].printTree();
            System.out.println();
        } 
    }
}
