package GUI.Dashboard;

import GUI.Management.NewWin;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagementDashboard {

    NewWin win = new NewWin();
    @FXML
    private JFXButton minimize, close;
    @FXML
    private Pane vangta, vangtay, ngoaite, thanhtoan, lichsu, doanhthu;
    @FXML
    private AnchorPane test;
    @FXML
    public void handleAction(ActionEvent event){
        if(event.getTarget() == minimize){
            Stage stage = (Stage) minimize.getScene().getWindow();
            stage.setIconified(true);
        }
        else if (event.getTarget() == close){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
            try {
                win.makeWindow(new Stage(), "/GUI/Management/ManagementFrame.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void initialize(){
        vangta.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/Management/ManagementFrame.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        vangtay.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/Management/ManagementFrame.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        ngoaite.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/Management/ManagementFrame.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thanhtoan.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/Payment/payment.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        lichsu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/History/history.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        doanhthu.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    Stage stage = (Stage) close.getScene().getWindow();
                    stage.close();
                    win.makeWindow(new Stage(), "/GUI/Revenue/revenue.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
