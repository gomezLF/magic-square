package userInterface;

import cunstomtExceptions.OddNumberException;
import javafx.scene.control.*;
import model.MagicSquare;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MagicSquareController {

    private MagicSquare magicSquare;

    @FXML
    private ComboBox<String> starPointComboB;

    @FXML
    private ComboBox<String> orientationComboB;

    @FXML
    private TextField sizeTextField;

    @FXML
    private AnchorPane settingsWindow;

    @FXML
    private ScrollPane matrixWindow;


    @FXML
    void initialize(){
        settingsWindow.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        starPointComboB.getItems().addAll(MagicSquare.TOP, MagicSquare.DOWN , MagicSquare.RIGHT, MagicSquare.LEFT);
    }


    @FXML
    void starPointClicked() {
        if (!(orientationComboB.getItems().isEmpty())){
            orientationComboB.getItems().clear();
        }

        switch (starPointComboB.getValue()) {
            case MagicSquare.TOP:
                orientationComboB.getItems().addAll(MagicSquare.NORTHEAST, MagicSquare.NORTHWEST);
                break;
            case MagicSquare.DOWN:
                orientationComboB.getItems().addAll(MagicSquare.SOUTHEAST, MagicSquare.SOUTHWEST);
                break;
            case MagicSquare.RIGHT:
                orientationComboB.getItems().addAll(MagicSquare.NORTHEAST, MagicSquare.SOUTHEAST);
                break;
            case MagicSquare.LEFT:
                orientationComboB.getItems().addAll(MagicSquare.NORTHWEST, MagicSquare.SOUTHWEST);
                break;
        }
    }



    @FXML
    void startClicked() {

        try{
            magicSquare = new MagicSquare(Integer.parseInt(sizeTextField.getText()), starPointComboB.getValue(), orientationComboB.getValue());
            magicSquare.createMagicSquare();
            createGameBoard();

        }catch(NullPointerException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Caused by \n" + "Some options weren't chosen", ButtonType.CLOSE);
            alert.setHeaderText("For create the magic square, fill all the options");
            alert.show();
        }catch(OddNumberException e){
            e.message();
        }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Caused by: \n" + "blank space or a letter inserted for the size of the magic square", ButtonType.CLOSE);
            alert.setHeaderText("Insert a number for the size of the square");
            alert.show();
        }catch (NegativeArraySizeException e){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Caused by: \n" + "Negative number ingresed like the size of the magic square", ButtonType.CLOSE);
            alert.setHeaderText("Insert a positive number for the size of the square");
            alert.show();
        }
    }

    private void createGameBoard() {
        GridPane grid = new GridPane();
        grid.setHgap(3);
        grid.setVgap(3);
        grid.setAlignment(Pos.CENTER);
        magicSquare.passNumbers(grid);


        matrixWindow.setContent(grid);
    }
}
