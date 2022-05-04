/**=======================
 * Title: PrepareData
 * Author(s): Jacob Thieret, 
 * Function: 
 * 1. grab data from website storing entire table as a string using selenium
 * 2. arrange in string[] with split
 * 3. scrub data of all unwanted entries
 * 4. moved data from 1d cleantable array to a 2d playerMatrix array 
 *///=====================
package CS300Final;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//The Data Prepared in this class will ultimately give us a 2d array with every line in the NHL statistics table its own array
//full data set returned is a String[1004][25] 2d array
public class PrepareData {
    // Loops through all 11 tables and grabs the table data from each.

    public static String[][] getTableData() {
        // System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\bin\\chromedriver.exe");
        // //MAKE SURE THIS IS TO YOUR CORRECT CHROMEDRIVER FILEPATH
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
        List<String> CleanedTable = cleanTable(text); // cleanup raw table data

        String[][] playerStats = PlayerStatsMatrix(CleanedTable); // add each player w/ their stats into an array of
                                                                  // arrays
        return playerStats; // add each player w/ their stats into an array of arrays

    }

    // Splits the string by newline character
    private static String[] splitString(String s) {
        String[] splitString = s.split("\n");
        return splitString;
    }

    public static List<String> cleanTable(String tableData) {
        // variable initialization
        String[] splitTableData = splitString(tableData);
        List<String> uncleanedTable = new ArrayList<>();
        List<String> cleanedTable = new ArrayList<>();
        List<String> badInput = new ArrayList<>();

        // moving the String[] data into a more easily modifyable ArrayList
        uncleanedTable.addAll(Arrays.asList(splitTableData));

        // REMOVING BAD INPUT
        // selects range of unwanted data from uncleanedTable and stores them in list of
        // words we want to scrub the uncleanedTable from
        for (int i = 25331; i < 25364; i++) {
            badInput.add(uncleanedTable.get(i));
        }
        for (int i = 25466; i < 25485; i++) {
            badInput.add(uncleanedTable.get(i));
        }
        for (int i = 0; i < 25; i++) {
            badInput.add(uncleanedTable.get(i));
        }

        // ENTERING CLEAN INPUT TO NEW ARRAY LIST
        // testing to see if the item in the uncleanTable contains a word from the
        // badInput list
        for (int i = 0; i < uncleanedTable.size(); i++) {
            if (badInput.contains(uncleanedTable.get(i))) {
                // do nothing
            } else {
                cleanedTable.add(uncleanedTable.get(i).replace("--", "null"));
            }
        }
        return cleanedTable;
    }

    // MAKES A 2x2 MATRIX OF PLAYER NAMES AND STATS
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
}
