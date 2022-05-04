/**=======================
 * Title: FinalProject_CS300
 * Author(s): Jacob Thieret, 
 * Function: Final Project main function
 *///=====================
package CS300Final;

import static CS300Final.PrepareData.*;
import static CS300Final.UserUI.*;

public class FinalProject_CS300 {

    /**
     * ===============================================================================
     * REQUIREMENTS TO BUILD AND RUN
     * chromedriver installed
     * selenium library installed
     * latest version of chrome installed
     * NetBeans 13 required for selenium to work, earlier versions wont work
     * 
     * @param args
     */// ==============================================================================

    public static void main(String[] args) {
        final String[][] playerStats = getTableData(); // add each player w/ their stats into a 2d array
        initializeUI(playerStats); // initialize the user input
    }

}
