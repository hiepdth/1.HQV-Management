package GUI.Login;

import BackEnd.Animation;
import GUI.Management.NewWin;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ManagementLogin {


    @FXML private JFXButton tat, login;
    @FXML private JFXTextField taikhoan;
    @FXML private JFXPasswordField matkhau;
    @FXML private AnchorPane enter;
    public void handleAction(ActionEvent event){
        if(event.getTarget() == tat){
            Stage stage = (Stage) tat.getScene().getWindow();
            stage.close();
        }
        else if(event.getTarget() == login){
            NewWin win = new NewWin();
            if(taikhoan.getText().equals("dinhhiep") && matkhau.getText().equals("123")){
                try {
                    win.makeWindow(new Stage(), "/GUI/Dashboard/dashboard.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = (Stage) tat.getScene().getWindow();
                stage.close();
            }
            else if(taikhoan.getText().isEmpty() && matkhau.getText().isEmpty()){
                enter.getChildren().clear();
                Label warning = new Label("Hãy nhập tài khoản, mật khẩu!!.");
                warning.setAlignment(Pos.CENTER);
                warning.setPrefSize(295,37);

                warning.setTextFill(Color.RED);
                enter.getChildren().add(warning);
                taikhoan.requestFocus();
            }
            else{
                enter.getChildren().clear();
                Label warning = new Label("Sai tài khoản hoặc mật khẩu. Vui lòng kiểm tra lại!!.");
                warning.setAlignment(Pos.CENTER);
                warning.setPrefSize(295,37);
                warning.setTextFill(Color.RED);
                enter.getChildren().add(warning);
                taikhoan.requestFocus();
            }
        }
    }
}
