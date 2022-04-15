package CS300.exam2.QuestTwo;

import java.util.*;

public class qTwo {
    public static void main(String[] args) {
        // Create HashSets for Both, S, and M
        HashSet<Integer> Both = new HashSet<Integer>();
        HashSet<Integer> S = new HashSet<Integer>();
        HashSet<Integer> M = new HashSet<Integer>();

        // Create HasMap for Con
        HashMap<String, Set<Integer>> Con = new HashMap<>();

        // Set up test sets
        // Adding numbers to simulate word being
        // On those lines in a file
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Con.put("SET", set);

        Set<Integer> mSet = new HashSet<>();
        mSet.add(3);
        mSet.add(4);
        mSet.add(5);
        Con.put("MULTISET", mSet);

        // Running checks to see if the word is included
        if (Con.containsKey("SET")) {
            S.addAll(Con.get("SET"));
        }

        if (Con.containsKey("MULTISET")) {
            M.addAll(Con.get("MULTISET"));
        }

        for (Integer i : M) {
            if (M.contains(i) && S.contains(i)) {
                Both.add(i);

            }
        }

        // HashMap for line contents
        HashMap<Integer, Set<String>> line_contents = new HashMap<Integer, Set<String>>();

        for (String word : Con.keySet()) {
            for (Integer lineNum : Con.get(word)) {
                if (!line_contents.containsKey(lineNum)) {
                    line_contents.put(lineNum, new HashSet<String>());
                }
                line_contents.get(lineNum).add(word);
            }
        }
        // printing results
        System.out.println();
        System.out.println(line_contents);

        System.out.println();
        System.out.println(Con);

        System.out.println();
        System.out.println("SET: " + S);
        System.out.println("MULTISET: " + M);
        System.out.println("BOTH: " + Both);
    }

}
