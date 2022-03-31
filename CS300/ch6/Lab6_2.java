package CS300.ch6;

import java.util.*;
import java.io.*;
public class Lab6_2 {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Java Source File");
        String filename = input.nextLine();
        File file = new File(filename);
        input = new Scanner(file);
        
        String text = "";
        while(input.hasNext()){
            String word = input.next();
            text += word + " ";
        }
        
        Map<String, Integer> map = new TreeMap<>();
        String[] words = text.split("[\\s+\\p{P}]");
        for(int i = 0; i < words.length; i++){
            String key = words[i].toLowerCase();
            
            if(key.length() > 0){
                if(!map.containsKey(key)){
                    map.put(key, 1);
                }
                else{
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }
        map.forEach((k,v) -> System.out.println(k + "\t" + v));
    }
}
