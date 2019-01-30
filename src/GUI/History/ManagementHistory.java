package GUI.History;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

import java.io.*;

public class ManagementHistory {

    @FXML
    private JFXButton close, minimize;
    @FXML
    private JFXButton vang, ngoaite, other;

    @FXML
    private FlowPane muaFlPane, banFlPane;
    @FXML
    private ScrollPane muaScPane, banScPane;

    @FXML
    public void handleAction(ActionEvent event){
        if(event.getTarget() == close) {
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        }
        else if(event.getTarget() == minimize){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.setIconified(true);
        }
        else if(event.getTarget() == vang){
            banFlPane.getChildren().clear();
            muaFlPane.getChildren().clear();
            updateHistory("src\\history\\ban\\banVang.txt", banFlPane, banScPane);
            updateHistory("src\\history\\mua\\muaVang.txt", muaFlPane, muaScPane);
        }
        else if(event.getTarget() == ngoaite){
            banFlPane.getChildren().clear();
            muaFlPane.getChildren().clear();
            updateNgoaite("src\\history\\ban\\banNgoaiTe.txt", banFlPane, banScPane);
            updateNgoaite("src\\history\\mua\\muaNgoaiTe.txt", muaFlPane, muaScPane);
        }
        else if(event.getTarget() == other){
            banFlPane.getChildren().clear();
            muaFlPane.getChildren().clear();
            updateOtherProduction("src\\history\\ban\\banKhac.txt", banFlPane, banScPane);
            updateOtherProduction("src\\history\\mua\\muaKhac.txt", muaFlPane, muaScPane);
        }
    }


    //TODO: update Lịch giao dịch cho sản phẩm Vàng
    public void updateHistory(String path, FlowPane fl, ScrollPane sc){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"UTF-8"));
            String line;
            int index = 1;
            while((line = reader.readLine()) != null){
                String [] info = line.split(":");
                AnchorPane pane = new AnchorPane();
                pane.setPrefSize(1000, 65);
                //tên khách hàng
                Label name = new Label(Integer.toString(index)+".Khách hàng: "+info[0].toUpperCase());
                name.setFont(Font.font("System", FontPosture.ITALIC, 18));
                name.setTextFill(Color.WHITE);
                name.setLayoutX(0);
                name.setLayoutY(0);
                name.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                //ngày
                Label date = new Label(info[9] +"/" + info[10] + "/" + info[11]);
                date.setFont(Font.font("System", FontPosture.ITALIC, 20));
                date.setTextFill(Color.WHITE);
                date.setLayoutX(490);
                date.setLayoutY(0);
                date.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                //giờ
                Label time = new Label(info[12] + ":" + info[13]);
                time.setTextFill(Color.WHITE);
                time.setFont(Font.font("System", FontPosture.ITALIC, 20));
                time.setLayoutX(950);
                time.setLayoutY(0);
                time.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                //data
                Label database = new Label("Tên sản phẩm: "+info[1]+"        "+"Loại sản phẩm: " + info[2]+"        "+
                                               "Đơn giá: "+info[3]+"        "+
                                                "Khối lượng: "+info[4]+"        "+
                                               "Số lượng: "+info[5]+"        "+
                                                "Nhập lại: "+info[6]+"        " +
                                               "Gia Công: "+info[7]+"        "+
                                                "Tổng tiền: "+String.format("%,8d",Integer.parseInt(info[8])));
                database.setFont(Font.font("System", FontPosture.ITALIC, 13));
                database.setLayoutX(0);
                database.setLayoutY(35);
                database.setTextFill(Color.WHITE);
                database.setAlignment(Pos.CENTER);
                database.setPrefSize(1000,35);
                pane.getChildren().addAll(name, date, time, database);
                pane.setStyle("-fx-background-color: #d65764");
//                pane.setStyle("-fx-border-size: 5em");
//                pane.setStyle("-fx-border-color: transparent");
                if(info[14].equals("Card")){
                    Label card = new Label("Card");
                    card.setTextFill(Color.BLACK);
                    card.setFont(Font.font("System", FontPosture.REGULAR, 13));
                    card.setLayoutX(700);
                    card.setLayoutY(0);
                    card.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                    pane.getChildren().add(card);
                    pane.setStyle("-fx-background-color: #dd8a42");
                }
                index++;
                fl.getChildren().add(pane);
            }
            reader.close();
            sc.setContent(fl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Lịch sử giao dịch rỗng");
        }
    }


    //TODO: Update lịch sử giao dịch cho sản phẩm ngoại tệ
    public void updateNgoaite(String path, FlowPane fl, ScrollPane sc){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"UTF-8"));
            String line;
            int index = 1;
            while((line = reader.readLine()) != null){
                String [] info = line.split(":");
                AnchorPane pane = new AnchorPane();
                pane.setPrefSize(1000, 65);
                //tên khách hàng
                Label name = new Label(Integer.toString(index)+".Khách hàng: " + info[0].toUpperCase());
                name.setFont(Font.font("System", FontPosture.ITALIC, 18));
                name.setTextFill(Color.WHITE);
                name.setLayoutX(0);
                name.setLayoutY(0);
                name.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                //ngày
                Label date = new Label(info[6] +"/" + info[7] + "/" + info[8]);
                date.setFont(Font.font("System", FontPosture.ITALIC, 20));
                date.setLayoutX(490);
                date.setLayoutY(0);
                date.setTextFill(Color.WHITE);
                date.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                //giờ
                Label time = new Label(info[9] + ":" + info[10]);
                time.setFont(Font.font("System", FontPosture.ITALIC, 20));
                time.setLayoutX(950);
                time.setLayoutY(0);
                time.setTextFill(Color.WHITE);
                time.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                //data
                Label database = new Label("Loại tiền: "+info[1]+"        "+
                        "Số lượng: " + String.format("%,8d",Integer.parseInt(info[2]))+"        "+
                        "Đơn giá: "+info[3]+"        "+"Phụ phí: "+info[4]+"        "+
                        "Tổng tiền: "+String.format("%,8d",Integer.parseInt(info[5])));
                database.setFont(Font.font("System", FontPosture.ITALIC, 13));
                database.setLayoutX(0);
                database.setLayoutY(35);
                database.setAlignment(Pos.CENTER);
                database.setTextFill(Color.WHITE);
                database.setPrefSize(1000,35);
                pane.getChildren().addAll(name, date, time, database);
                pane.setStyle("-fx-background-color: #d65764");
                if(info[11].equals("Card")){
                    Label card = new Label("Card");
                    card.setTextFill(Color.BLACK);
                    card.setFont(Font.font("System", FontPosture.REGULAR, 13));
                    card.setLayoutX(700);
                    card.setLayoutY(0);
                    card.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                    pane.getChildren().add(card);
                    pane.setStyle("-fx-background-color: #dd8a42");
                }
                index++;
                fl.getChildren().add(pane);
            }
            reader.close();
            sc.setContent(fl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Lịch sử giao dịch rỗng");
        }
    }


    //TODO: Update lịch sử giao dịch cho các sản phẩm khác
    public void updateOtherProduction(String path, FlowPane fl, ScrollPane sc){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"UTF-8"));
            String line;
            int index = 1;
            while((line = reader.readLine()) != null){
                String [] info = line.split(":");
                AnchorPane pane = new AnchorPane();
                pane.setPrefSize(1000, 65);
                //tên khách hàng
                Label name = new Label(Integer.toString(index)+".Khách hàng"+info[0].toUpperCase());
                name.setFont(Font.font("System", FontPosture.ITALIC, 18));
                name.setLayoutX(0);
                name.setLayoutY(0);
                name.setTextFill(Color.WHITE);
                name.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                //ngày
                Label date = new Label(info[6] +"/" + info[7] + "/" + info[8]);
                date.setFont(Font.font("System", FontPosture.ITALIC, 20));
                date.setLayoutX(490);
                date.setLayoutY(0);
                date.setTextFill(Color.WHITE);
                date.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                //giờ
                Label time = new Label(info[9] + ":" + info[10]);
                time.setFont(Font.font("System", FontPosture.ITALIC, 20));
                time.setLayoutX(950);
                time.setLayoutY(0);
                time.setTextFill(Color.WHITE);
                time.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                //data
                Label database = new Label("Tên sản phẩm: "+info[1]+"        "+
                        "Số lượng: " + info[2]+"        "+
                        "Đơn giá: "+info[3]+"        "+"Phụ phí: "+info[4]+"        "+
                        "Tổng tiền: "+String.format("%,8d",Integer.parseInt(info[5])));
                database.setFont(Font.font("System", FontPosture.ITALIC, 13));
                database.setLayoutX(0);
                database.setLayoutY(35);
                database.setAlignment(Pos.CENTER);
                database.setTextFill(Color.WHITE);
                database.setPrefSize(1000,35);
                pane.getChildren().addAll(name, date, time, database);
                pane.setStyle("-fx-background-color: #d65764");
                if(info[11].equals("Card")){
                    Label card = new Label("Card");
                    card.setTextFill(Color.BLACK);
                    card.setFont(Font.font("System", FontPosture.REGULAR, 13));
                    card.setLayoutX(700);
                    card.setLayoutY(0);
                    card.setPrefSize(Label.USE_COMPUTED_SIZE, Label.USE_COMPUTED_SIZE);
                    pane.getChildren().add(card);
                    pane.setStyle("-fx-background-color: #dd8a42");
                }
                index++;
                fl.getChildren().add(pane);
            }
            reader.close();
            sc.setContent(fl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Lịch sử giao dịch rỗng");
        }
    }

    @FXML
    public void initialize(){
        updateHistory("src\\history\\ban\\banVang.txt", banFlPane, banScPane);
        updateHistory("src\\history\\mua\\muaVang.txt", muaFlPane, muaScPane);
    }
}
