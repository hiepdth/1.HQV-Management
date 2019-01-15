package GUI.History;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ManagementHistory {

    @FXML
    private JFXButton close, minimize;

    @FXML
    private AnchorPane hisPane;


    public void handleAction(ActionEvent event){
        if(event.getTarget() == close) {
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        }
        else if(event.getTarget() == minimize){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.setIconified(true);
        }
    }

}
