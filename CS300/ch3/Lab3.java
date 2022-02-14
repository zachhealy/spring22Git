import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Lab3 extends JApplet {

 public Lab3() {
    //Creates text fields for 1s and 0s
    JTextField[] boxes = new JTextField[10 * 10];
    //Creates the grid
    JPanel grid = new JPanel(new GridLayout(10, 10));
    //Sets to either 1 or 0
    String number = "0";
    for (int i = 0; i < boxes.length; i++) {
        if(Math.random() < 0.5){
            number = "0";
        }
        else{
            number = "1";
        }
        boxes[i] = new JTextField(number, 2);
        boxes[i].setHorizontalAlignment(JTextField.CENTER);
        grid.add(boxes[i]);
    }
    //adds grid
    add(grid);
    //Creates bottom panel for buttons
    JPanel buttons = new JPanel();
    //Creates button text
    JButton refresh = new JButton("Refresh");
    //Adds button
    buttons.add(refresh);
    //Find largest Block text
    JButton largest = new JButton("Find Largest Block");
    //Adds largest block
    buttons.add(largest);
    //Adds to bottom of screen
    add(buttons, BorderLayout.SOUTH);
    //Adds refresh action
    refresh.addActionListener(new ActionListener() {   
    @Override
    public void actionPerformed(ActionEvent e) {
        String number = "0";
        //cycles through boxes and resets them to new numbe
        for (int i = 0; i < boxes.length; i++) {
            if(Math.random() < 0.5){
                number = "0";
            }
            else{
                number = "1";
            }
            //resets number
            boxes[i].setText(number);
            //resets color
            boxes[i].setForeground(Color.BLACK);
        }
    }
    });
    //action for finding largest box numbers
    largest.addActionListener(new ActionListener() {   
    @Override
    public void actionPerformed(ActionEvent e) {
        int[][] numbers = new int[10][10];
        //Stores numbers into matrix
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                numbers[i][j] = Integer.parseInt(boxes[i * 10 + j].getText());
            }
        }
        //Finds the current biggest box
        int row = 0;
        int column = 0;
        int largestSize = 0;
        //Searches each number
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                //Checks if one
                if (numbers[i][j] == 1) {
                    //checks if this is new best
                    int size = smallMatrix(i, j, numbers);
                    if (size > largestSize) {
                        //sets new location
                        row = i;
                        column = j;
                        largestSize = size;
                    }
                }
            }
        }
        //Sets the boxes to red
        for (int i = row; i < row + largestSize; i++) {
            for (int j =  column; j < column + largestSize; j++) {
                boxes[i * 10 + j].setForeground(Color.RED);
            }
        }   
    }
  });
}

public static int smallMatrix(int row, int column, int[][] numbers) {
    //size of new matrix
    int total = 0;
    
    for (int i = row; i < numbers.length; i++) {
        for (int j = column; j < numbers[i].length; j++) {
            for (int size = 1; size < numbers.length; size++) {
                if (!checkForOnes(row, column, size, numbers)) {
                    //sets new size
                    if (total < (size - 1)) {
                        total = size - 1;
                    }
                    break;
                }
            }
        }
    }
    return total;
}
 
public static boolean checkForOnes(int row, int column, int size, int[][] numbers) {
    //cycles through rows
    for (int i = row; i < row + size; i++) {
        //Returns false if not possible for row
        if (i >= numbers.length) {
            return false;
        }
        for (int j = column; j < column + size; j++) {
            //returns i if not possible for column
            if (j >= numbers[i].length) {
                return false;
            }
            //returns false if not a one
            if (numbers[i][j] != 1) {
                return false;
            }
        }
    }
    return true;
}
 
 public static void main(String[] args) {
    JFrame frame = new JFrame("Lab3");
    Lab3 show = new Lab3();
    frame.add(show);
    frame.pack();
    frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
    frame.setVisible(true);
 }
}