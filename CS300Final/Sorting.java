/**=======================
 * Title: Sorting
 * Author(s): Jacob Thieret
 * Functions:
 * 1. Stores the PlayerName and specified index into a new 2d String array
 * 2. Puts entries from array into a HashMap, where it is then made into a linked list
 * 3. Used collections library to compare entries and sort the data
 * 4. Items from list are returned to a HashMap and data is printed from there
 * 
 *///=====================
package CS300Final;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Sorting {
    public static void sortStats(int index, int amount, String[][] playerMatrix, int orderChoice) {

        String[][] playerStat = new String[playerMatrix.length][2];

        for (int i = 0; i < playerMatrix.length; i++) {
            for (int j = 0; j < playerMatrix[i].length; j++) {
                if (j == 1) {
                    playerStat[i][0] = playerMatrix[i][j];
                } else if (j == index)
                    playerStat[i][1] = playerMatrix[i][j];
            }
        }
        String[][] finalList = null;
        if (orderChoice == 1) {
            finalList = sortHighToLow(playerStat, amount);
        } else if (orderChoice == 2) {
            finalList = sortLowToHigh(playerStat, amount);
        }

    }

    // Currently no implementation in UserUI
    private static String[][] sortLowToHigh(String[][] ogList, int amount) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < ogList.length; i++) {
            hashMap.put(ogList[i][0], Integer.parseInt(ogList[i][1]));
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(hashMap.entrySet());

        // Sort the list
        Collections.sort(list, (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> (o1.getValue())
                .compareTo(o2.getValue()));
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        int i = 1;
        for (String name : temp.keySet()) {
            String key = name;
            String value = temp.get(name).toString();
            System.out.println("#" + i++ + ": " + key + " " + value);
            amount--;
            if (amount < 1)
                break;
        }
        return null;
    }

    private static String[][] sortHighToLow(String[][] ogList, int amount) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < ogList.length; i++) {
            hashMap.put(ogList[i][0], Integer.parseInt(ogList[i][1]));
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(hashMap.entrySet());

        // Sort the list
        Collections.sort(list, (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) -> (o1.getValue())
                .compareTo(o2.getValue()));
        Collections.reverse(list);
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        int i = 1;
        for (String name : temp.keySet()) {
            String key = name;
            String value = temp.get(name).toString();
            System.out.println("#" + i++ + ": " + key + " " + value);
            amount--;
            if (amount < 1)
                break;
        }
        return null;
    }
}
