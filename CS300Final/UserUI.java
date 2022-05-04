/**=======================
 * Title: UserUI
 * Author(s): Jacob Thieret, 
 * Function: Generates the menu options given to the console
 *///=====================
package CS300Final;

import static CS300Final.PrintData.*;
import static CS300Final.Sorting.*;
import java.util.Scanner;

public class UserUI {
    public static void initializeUI(String[][] playerStats) {
        Scanner input = new Scanner(System.in);
        final String[] statNames = "PlayerNumber Player Season Team Player_shooting_hand Position Games_played Goals Assists Points Plus-Minus Penalty_Minutes Points_per_Games_Played Even_Strength_Goals Even_Strength_Points Power_Play_Goal Power_Play_Points Shorthaded_Goals Shorthanded_Points Overtime_Goals Game_Winning_Goals Shots Shooting_Percentage Time_on_Ice_per_Game_Played Faceoff_Win_Percentage"
                .split(" ");
        int choice = -1;
        do {
            System.out.println("\n\nMain Menu\n============================================");
            System.out.print("1.) Display all player stats. \n");
            System.out.print("2.) Display a specific player's stats. \n");
            System.out.print("3.) Display X player(s) who were the best/worst in X stat \n");
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

                    break;

                case 3:

                    int statChoice = -1;
                    do {
                        System.out.println("1.) Games Played\n"
                                + "2.) Goals\n"
                                + "3.) Assists\n"
                                + "4.) Points\n"
                                + "5.) +/-\n"
                                + "6.) Penalty Minutes\n"
                                + "7.) Points per Game Played\n"
                                + "8.) Even Strength Goals\n"
                                + "9.) Even Strength Points\n"
                                + "10.) Power Play Goals\n"
                                + "11.) Power Play Points\n"
                                + "12.) Shorthanded Goals\n"
                                + "13.) Shorthanded Points\n"
                                + "14.) Overtime Goals\n"
                                + "15.) Game Winning Goals\n"
                                + "16.) Shots\n"
                                + "17.) Shooting Percentage\n"
                                + "18.) Time on Ice per Game Played\n"
                                + "19.) Faceoff Wim percentage\n");
                        System.out.print("Pick a Stat: ");
                        statChoice = input.nextInt();
                        if (statChoice < 1 || statChoice > 19)
                            uiInputError();
                    } while (statChoice < 1 || statChoice > 19);

                    int amountOfPlayers = -1;
                    do {
                        System.out.print("How many players(1-" + playerStats.length + "): ");
                        amountOfPlayers = input.nextInt();
                        if (amountOfPlayers < 1 || amountOfPlayers > playerStats.length)
                            System.out.println("You can pick any number between 1-" + playerStats.length + ".");
                    } while (amountOfPlayers < 1 || amountOfPlayers > playerStats.length);

                    int bestOrWorstChoice = -1;
                    do {
                        System.out.println("Do you want to view the top " + amountOfPlayers
                                + " best or worst players in " + statNames[statChoice + 5]);
                        System.out.println("1.) Top " + amountOfPlayers + " players in " + statNames[statChoice + 5]);
                        System.out
                                .println("2.) Bottom " + amountOfPlayers + " players in " + statNames[statChoice + 5]);
                        System.out.print("Enter a choice: ");
                        bestOrWorstChoice = input.nextInt();
                        if (bestOrWorstChoice != 1 && bestOrWorstChoice != 2)
                            uiInputError();

                    } while (bestOrWorstChoice != 1 && bestOrWorstChoice != 2);

                    sortStats((statChoice + 5), amountOfPlayers, playerStats, bestOrWorstChoice);
                    break;

                case 4:

                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    uiInputError();
            }
        } while (choice != 4);
    }
}
