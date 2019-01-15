package GUI.Payment;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManagementPayment {

    @FXML
    private JFXButton close, minimize, cancel;
    @FXML
    private AnchorPane payPane;
    @FXML
    public void handleAction(ActionEvent event){
        if(event.getTarget() == close || event.getTarget() == cancel){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        }
        else if(event.getTarget() == minimize){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.setIconified(true);
        }
    }

}
