package model;

import cunstomtExceptions.OddNumberException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import static javafx.scene.paint.Color.*;

public class MagicSquare {

    public static final String TOP = "Top";
    public static final String RIGHT = "Right";
    public static final String DOWN = "Down";
    public static final String LEFT = "Left";

    public static final String NORTHEAST = "Northeast";
    public static final String NORTHWEST = "Northwest";
    public static final String SOUTHEAST = "Southeast";
    public static final String SOUTHWEST = "Southwest";

    private int[][] matrix;
    private int size;
    private int magicConstant;
    private String startPoint;
    private String orientation;



    public MagicSquare(int size, String startPoint, String orientation){
        this.size = size;
        this.magicConstant = 0;
        this.startPoint = startPoint;
        this.orientation = orientation;

        matrix = new int[size][size];
    }

    public String getStartPoint(){
        return startPoint;
    }

    public String getOrientation(){
        return orientation;
    }

    public int getSize(){
        return size;
    }

    public int[][] getMatrix(){
        return matrix;
    }

    public int getMagicConstant(){
        return magicConstant;
    }


    private void calculateMagicConstant(){
        magicConstant = (((size*size) + 1)*size) / 2;
    }



    private void changeColor(Button button, Button[][] array, GridPane grid){
        String[] position = button.getId().split(",");
        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);

        for (Button[] buttons : array) {
            buttons[y].setBackground(new Background(new BackgroundFill(YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        }
        for (int i = 0; i < array.length; i++) {
            array[x][i].setBackground(new Background(new BackgroundFill(YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        }

        Label label = new Label("" + magicConstant);
        label.setAlignment(Pos.CENTER);
        label.setPrefHeight(30);
        label.setPrefWidth(40);

        Label label2 = new Label("" + magicConstant);
        label2.setAlignment(Pos.CENTER);
        label2.setPrefHeight(30);
        label2.setPrefWidth(40);

        grid.add(label, y, size);
        grid.add(label2, size, x);
    }



    public void passNumbers(GridPane grid){
        Button[][] buttons = new Button[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                Button button = new Button();
                button.setAlignment(Pos.CENTER);
                button.setPrefHeight(30);
                button.setPrefWidth(40);
                button.setText("" + matrix[i][j]);
                button.setId(i + "," + j);

                button.setOnMouseClicked(e -> {changeColor(button, buttons, grid);});
                buttons[i][j] = button;
                grid.add(button, j, i);
            }
        }
    }



    public void createMagicSquare() throws OddNumberException{
        int n = 1;

        if (size % 2 != 1 || size == 1){
            throw new OddNumberException();
        }else {
            calculateMagicConstant();

            switch (startPoint) {
                case TOP:
                    startTop(n);
                    break;
                case DOWN:
                    startDown(n);
                    break;
                case RIGHT:
                    startRight(n);
                    break;
                case LEFT:
                    startLeft(n);
                    break;
            }
        }
    }



    private void startTop(int n){
        int i = 0;
        int j = size / 2;
        matrix[i][j] = n;
        if (orientation.equals(NORTHEAST)){
            northeastOrientation(i, j, n);
        }else if(orientation.equals(NORTHWEST)){
            northwestOrientation(i, j, n);
        }
    }

    private void startDown(int n){
        int i = size - 1;
        int j = size / 2;
        matrix[i][j] = n;
        if (orientation.equals(SOUTHEAST)){
            southeastOrientation(i, j, n);
        }else if(orientation.equals(SOUTHWEST)){
            southwestOrientation(i, j, n);
        }
    }

    private void startRight(int n){
        int i = size / 2;
        int j = size - 1;
        matrix[i][j] = n;
        if (orientation.equals(NORTHEAST)){
            northeastOrientation(i, j, n);
        }else if(orientation.equals(SOUTHEAST)){
            southeastOrientation(i, j, n);
        }
    }

    private void startLeft(int n){
        int i = size / 2;
        int j = 0;
        matrix[i][j] = n;
        if (orientation.equals(NORTHWEST)){
            northwestOrientation(i, j, n);
        }else if(orientation.equals(SOUTHWEST)){
            southwestOrientation(i, j, n);
        }
    }



    private void northeastOrientation(int row, int column, int number){
        int counter = size * size;
        int n  = number;
        int i = row;
        int j = column;

        int x = row;
        int y = column;

        while (counter--> 1){
            n ++;
            i = i - 1;
            j = j + 1;

            if (i < 0) {
                i = matrix.length - 1;
            }
            if (j == matrix.length) {
                j = 0;
            }
            if (matrix[i][j] != 0) {
                if (startPoint.equals(TOP)) {
                    i = x + 1;
                    j = y;
                    matrix[i][y] = n;
                } else if (startPoint.equals(RIGHT)) {
                    i = x;
                    j = y - 1;
                    matrix[i][j] = n;
                }
            } else {
                x = i;
                y = j;
                matrix[i][j] = n;
            }
        }
    }

    private void northwestOrientation(int row, int column, int number){
        int counter = size * size;
        int n  = number;
        int i = row;
        int j = column;

        int x = row;
        int y = column;

        while(counter--> 1){
            n ++;
            i = i - 1;
            j = j - 1;

            if (i < 0) {
                i = matrix.length - 1;
            }
            if (j < 0) {
                j = matrix[0].length - 1;
            }
            if (matrix[i][j] != 0) {
                if (startPoint.equals(TOP)) {
                    i = x + 1;
                    j = y;
                    matrix[i][y] = n;
                } else if (startPoint.equals(LEFT)) {
                    i = x;
                    j = y + 1;
                    matrix[i][j] = n;
                }
            } else {
                x = i;
                y = j;
                matrix[i][j] = n;
            }
        }
    }

    private void southeastOrientation(int row, int column, int number){
        int counter = size * size;
        int n  = number;
        int i = row;
        int j = column;

        int x = row;
        int y = column;

        while(counter--> 1){
            n ++;
            i = i + 1;
            j = j + 1;

            if (i == matrix.length) {
                i = 0;
            }
            if (j == matrix[0].length) {
                j = 0;
            }
            if (matrix[i][j] != 0) {
                if (startPoint.equals(DOWN)) {
                    i = x - 1;
                    j = y;
                    matrix[i][j] = n;
                } else if (startPoint.equals(RIGHT)) {
                    i = x;
                    j = y - 1;
                    matrix[i][j] = n;
                }
            } else {
                x = i;
                y = j;
                matrix[i][j] = n;
            }
        }
    }

    private void southwestOrientation(int row, int column, int number){
        int counter = size * size;
        int n = number;
        int i = row;
        int j = column;

        int x = row;
        int y = column;

        while(counter--> 1){
            n ++;
            i = i + 1;
            j = j - 1;

            if (i == matrix.length) {
                i = 0;
            }
            if (j < 0) {
                j = matrix[0].length - 1;
            }
            if (matrix[i][j] != 0) {
                if (startPoint.equals(DOWN)) {
                    i = x - 1;
                    j = y;
                    matrix[i][j] = n;
                } else if (startPoint.equals(LEFT)) {
                    i = x;
                    j = y + 1;
                    matrix[i][j] = n;
                }
            } else {
                x = i;
                y = j;
                matrix[i][j] = n;
            }
        }
    }


}
