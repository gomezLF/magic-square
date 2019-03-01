package cunstomtExceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class OddNumberException extends Exception {

    public OddNumberException(){
        super("For this magic square, you need to choose an odd number for the size of the magic square");
    }

    public void message(){
        Alert alert = new Alert(Alert.AlertType.ERROR, "Caused by: \n" + "even number or number 1 inserted in the size of the magic square", ButtonType.CLOSE);
        alert.setHeaderText(super.getMessage());
        alert.show();
    }
}
