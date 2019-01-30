package GUI.Management;

import BackEnd.Currency;
import BackEnd.Management;
import BackEnd.Vangta;
import BackEnd.Vangtay;
import GUI.Payment.ManagementPayment;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Điều khiển các chức năng cho màn hình chỉnh của app
 */
public class ManagementFrame {
    @FXML
    private JFXButton home, vangta, vangtay, ngoaite, history, payment, chart, exit; //todo: Tạo các nút trên thanh công cụ
    @FXML
    private FlowPane vangtaPane, vangtayPane, ngoaitePane;
    @FXML
    private ScrollPane vangtaProducts, vangtayProducts, ngoaiteProducts;

    Management mana = new Management(); //todo: Đối tượng để ta lấy dữ liệu

    NewWin win = new NewWin();

    ManagementPayment pay = new ManagementPayment();

    @FXML
    private void handleAction(ActionEvent event) {   //todo: Hàm bắt xử kiện (Gộp chung) cho từng button
        //todo: Quay trở về trang chủ
        if (event.getTarget() == home) {
            try {
                win.makeWindow(new Stage(), "/GUI/Dashboard/dashboard.fxml");
                Stage stage = (Stage) home.getScene().getWindow();
                stage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //todo: HIện thị cửa sổ vàng ta
        else if (event.getTarget() == vangta) {
            vangtaProducts.setVisible(true);
            vangtayProducts.setVisible(false);
            ngoaiteProducts.setVisible(false);
        }
        //todo: Hiển thị cửa sổ vàng tây
        else if (event.getTarget() == vangtay) {
            vangtayProducts.setVisible(true);
            vangtaProducts.setVisible(false);
            ngoaiteProducts.setVisible(false);
        }
        //todo: Hiển thị cửa sổ Ngoại tệ
        else if (event.getTarget() == ngoaite) {
            ngoaiteProducts.setVisible(true);
            vangtaProducts.setVisible(false);
            vangtayProducts.setVisible(false);
        }
        //todo: Hiển thị cửa sổ thanh toán
        else if(event.getTarget() == payment){
            try {
                win.makeWindow(new Stage(), "/GUI/Payment/payment.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //todo: Hiển thị cửa sổ lịch sử giao dịch
        else if (event.getTarget() == history) {
            try {
                win.makeWindow(new Stage(), "/GUI/History/history.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //todo: Hiển thị cửa sổ biểu đồ doanh thu
        else if (event.getTarget() == chart) {
            try {
                win.makeWindow(new Stage(), "/GUI/Revenue/revenue.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //todo: Thoát
        else if (event.getTarget() == exit) {
            System.exit(0);
        }
    }
    //todo: Hàm để thêm các sản phẩm vàng ta
    public void addVangtaProduction(ArrayList<Vangta>list){
        vangtaPane.getChildren().clear();
        for(Vangta v : list) {
            ImageView img = new ImageView(new Image(new File(v.getPath()).toURI().toString()));
            img.setFitHeight(90);
            img.setFitWidth(90);
            JFXButton but = new JFXButton(v.getName(),img);
            but.setPrefSize(150,120);
            but.setTextFill(Color.WHITE);
            but.setGraphicTextGap(15);
            but.setCursor(Cursor.HAND);
            but.setContentDisplay(ContentDisplay.TOP);
            but.getStylesheets().add("style.css");  //add css
            vangtaPane.getChildren().add(but);

            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        win.makeWindow(new Stage(), "/GUI/Payment/payment.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        vangtaProducts.setContent(vangtaPane);
    }
    //todo: Hàm để thêm các sản phẩm vàng tây
    public void addVangtayProduction(ArrayList<Vangtay>list){
        vangtayPane.getChildren().clear();
        for(Vangtay v : list){
            ImageView img = new ImageView(new Image(new File(v.getPath()).toURI().toString()));
            img.setFitHeight(90);
            img.setFitWidth(90);
            JFXButton but = new JFXButton(v.getName(),img);
            but.setPrefSize(150,120);
            but.setTextFill(Color.WHITE);
            but.setGraphicTextGap(15);
            but.setCursor(Cursor.HAND);
            but.setContentDisplay(ContentDisplay.TOP);
            but.getStylesheets().add("style.css");  //add css
            vangtayPane.getChildren().add(but);

            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        win.makeWindow(new Stage(), "/GUI/Payment/payment.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        vangtayProducts.setContent(vangtayPane);
    }
    //todo: Hàm để thêm các sản phẩm ngoại tệ
    public void addNgoaiteProduction(ArrayList<Currency>list){
        ngoaitePane.getChildren().clear();
        for(Currency cur : list){
            ImageView img = new ImageView(new Image(new File(cur.getPath()).toURI().toString()));
            img.setFitHeight(90);
            img.setFitWidth(90);
            JFXButton but = new JFXButton(cur.getName(),img);
            but.setPrefSize(150,120);
            but.setTextFill(Color.WHITE);
            but.setGraphicTextGap(15);
            but.setCursor(Cursor.HAND);
            but.setContentDisplay(ContentDisplay.TOP);
            but.getStylesheets().add("style.css");  //add css
            ngoaitePane.getChildren().add(but);

            but.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        win.makeWindow(new Stage(), "/GUI/Payment/payment.fxml");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ngoaiteProducts.setContent(ngoaitePane);
    }
    @FXML
    public void initialize(){
        addVangtaProduction(mana.getVangtas());
        addVangtayProduction(mana.getVangtays());
        addNgoaiteProduction(mana.getCurrencies());
    }
}
