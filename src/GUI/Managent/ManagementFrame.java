package GUI.Managent;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.controls.JFXPopup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.PopupControl;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.io.File;

/**
 * Điều khiển các chức năng cho màn hình chỉnh của app
 */
public class ManagementFrame {
    @FXML
    private JFXButton home, vangta, vangtay, ngoaite, history, chart, exit; //todo: Tạo các nút trên thanh công cụ
    @FXML
    private FlowPane vangtaPane, vangtayPane, ngoaitePane;
    @FXML
    private ScrollPane vangtaProducts, vangtayProducts, ngoaiteProducts;
    @FXML
    private JFXPopup popup;
    //todo: Hàm bắt xử kiện (Gộp chung) cho từng button
    @FXML
    private void handleAction(ActionEvent event){
        //todo: Quay trở về trang chủ
        if(event.getTarget() == home){
            vangtaProduction();
        }
        //todo: HIện thị cửa sổ vàng ta
        else if(event.getTarget() == vangta){

        }
        //todo: Hiển thị cửa sổ vàng tây
        else if(event.getTarget() == vangtay){

        }
        //todo: Hiển thị cửa sổ Ngoại tệ
        else if(event.getTarget() == ngoaite){

        }
        //todo: Hiển thị cửa sổ lịch sử giao dịch
        else if(event.getTarget() == history){
        }
        //todo: Hiển thị cửa sổ biểu đồ doanh thu
        else if(event.getTarget() == chart){

        }
        //todo: Thoát
        else if(event.getTarget() == exit){
            System.exit(0);
        }
    }
    //todo: Hàm để thêm các sản phẩm vàng ta
    public void  vangtaProduction(){
        for(int i = 0; i < 50; i++) {
            ImageView img = new ImageView(new Image(new File("src/images/vangta/namphan.jpg").toURI().toString()));
            img.setFitHeight(90);
            img.setFitWidth(90);
            JFXButton but = new JFXButton("Dang test scroll",img);
            but.setPrefSize(150,120);
            but.setTextFill(Color.WHITE);
            but.setGraphicTextGap(15);
            but.setCursor(Cursor.HAND);
            but.setContentDisplay(ContentDisplay.TOP);
            but.getStylesheets().add("style.css");  //add css
            vangtaPane.getChildren().add(but);
        }
        vangtaProducts.setContent(vangtaPane);
    }
}
