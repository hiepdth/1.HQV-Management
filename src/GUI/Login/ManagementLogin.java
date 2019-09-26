package GUI.Login;

import GUI.Management.NewWin;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagementLogin {


    @FXML private JFXButton tat, _login;
    @FXML private JFXTextField _taikhoan;
    @FXML private JFXPasswordField _matkhau;
    @FXML private AnchorPane enter;
    public void handleAction(ActionEvent event){
        if(event.getTarget() == tat){
            Stage stage = (Stage) tat.getScene().getWindow();
            stage.close();
        }
        //TODO: Login
        else if(event.getTarget() == _login){
            acessAcount();
        }
    }
    public void login(Node node){
        node.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER) {
                    acessAcount();
                }
            }
        });
    }
    public void acessAcount(){
        NewWin win = new NewWin();
        if(_taikhoan.getText().equals("dinhhiep") && _matkhau.getText().equals("123")){
            try {
                win.makeWindow(new Stage(), "/GUI/Dashboard/dashboard.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage stage = (Stage) tat.getScene().getWindow();
            stage.close();
        }
        else if(_taikhoan.getText().isEmpty() && _matkhau.getText().isEmpty()){
            enter.getChildren().clear();
            Label warning = new Label("Hãy nhập tài khoản, mật khẩu!!.");
            warning.setAlignment(Pos.CENTER);
            warning.setPrefSize(295,37);

            warning.setTextFill(Color.RED);
            enter.getChildren().add(warning);
            _taikhoan.requestFocus();
        }
        else{
            enter.getChildren().clear();
            Label warning = new Label("Sai tài khoản hoặc mật khẩu. Vui lòng kiểm tra lại!!.");
            warning.setAlignment(Pos.CENTER);
            warning.setPrefSize(295,37);
            warning.setTextFill(Color.RED);
            enter.getChildren().add(warning);
            _taikhoan.requestFocus();
        }
    }


    @FXML
    private void initialize() {
        _taikhoan.setText("dinhhiep");
        _matkhau.setText("123");
        login(_taikhoan);
        login(_matkhau);
    }
}
