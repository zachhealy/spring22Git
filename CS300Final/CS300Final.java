//Zach's File

package CS300Final;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CS300Final {

    public static void main(String[] args) {
        // System.setProperty("webdriver.chrome.driver", "/usr/local/bin");
        String fullTable = getTableData();
        List<String> CleanedTable = cleanTable(fullTable);
        String[][] playerStats = PlayerStatsMatrix(CleanedTable);
        System.out.println(Arrays.deepToString(playerStats));
        // System.out.println(CleanedTable);

        Scanner input = new Scanner(System.in);

        int choice = -1;
        do {
            System.out.println("Main Menu\n");
            System.out.print("1.) Display all player stats. \n");
            System.out.print("2.) Display a specific player's stats. \n");
            System.out.print("3.) Option 3 \n");
            System.out.print("4.) Exit \n");
            System.out.print("\nEnter Your Menu Choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    prettyPrint(playerStats);
                    break;
                case 2:
                    int count = -1;

                    System.out.println("Enter a name: ");

                    Scanner play = new Scanner(System.in);
                    String in = play.nextLine();

                    for (int i = 0; i < 1004; i++) {
                        if (playerStats[i][1].equals(in)) {
                            count = i;
                        }
                    }

                    for (int i = 1; i < 25; i++) {
                        if (i < 24) {
                            System.out.print(playerStats[count][i] + ", ");

                        } else {
                            System.out.println(playerStats[count][i]);

                        }
                    }
                    System.out.println();

                    break;
                case 3:
                    System.out.println("chose 3");
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println(choice + " is not an option, please select different answer.");
            }
        } while (choice != 4);

    }

    // Loops through all 11 tables and grabs the table data from each.
    public static String getTableData() {
        ChromeOptions options = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(options);
        String text = null;
        for (int i = 0; i <= 11; i++) {
            driver.get(
                    "https://www.nhl.com/stats/skaters?reportType=season&seasonFrom=20212022&seasonTo=20212022&gameType=2&filter=gamesPlayed,gte,1&sort=points,goals,assists&page="
                            + i + "&pageSize=100");
            text += new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ReactTable"))).getText();

        }
        driver.quit();
        return text;

    }

    // Splits the string by newline character
    public static String[] splitString(String s) {
        String[] splitString = s.split("\n");
        return splitString;
    }

    public static List<String> cleanTable(String tableData) {
        String[] splitTableData = splitString(tableData);
        List<String> uncleanedTable = new ArrayList<>();
        List<String> cleanedTable = new ArrayList<>();
        List<String> badInput = new ArrayList<>();

        // moving the String[] data into a more easily modifyable ArrayList
        for (int i = 0; i < splitTableData.length; i++) {
            uncleanedTable.add(splitTableData[i]);
        }
        // REMOVING BAD INPUT, selects range of unwanted data from uncleanedTable and
        // stores them in a bad word keyword list
        for (int i = 25331; i < 25364; i++) {
            badInput.add(uncleanedTable.get(i));
        }
        for (int i = 25466; i < 25485; i++) {
            badInput.add(uncleanedTable.get(i));
        }
        for (int i = 0; i < 25; i++) {
            badInput.add(uncleanedTable.get(i));
        }

        // ENTERING CLEAN INPUT TO NEW ARRAY LIST, by testing to see if the item in the
        // uncleanTable contains a word from the bad work keylist
        for (int i = 0; i < uncleanedTable.size(); i++) {
            if (badInput.contains(uncleanedTable.get(i))) {
                // do nothing
            } else {
                cleanedTable.add(uncleanedTable.get(i));
            }

        }

        return cleanedTable;
    }

    /**
     * MAKES A 2x2 MATRIX THAT STORES EACH INDIVIDUAL PLAYER AND THEIR STATS
     * INTO THEYRE OWN ARRAY LIST we can use the matrix generated for adding
     * specific player data to a hashmap or something
     */
    public static String[][] PlayerStatsMatrix(List<String> List) {
        String[][] playerStatMatrix = new String[1004][25];
        int count = 0;
        for (int i = 0; i < 1004; i++) {
            for (int j = 0; j < 25; j++) {
                playerStatMatrix[i][j] = List.get(count);
                count++;
            }
        }

        return playerStatMatrix;
    }

    public static String[][] prettyPrint(String[][] arrayList) {
        System.out.println(Arrays.deepToString(arrayList).replace("], ", "]\n").replace(", ", "\t").replace("[", " ")
                .replace("]", " "));
        return arrayList;
    }

}
