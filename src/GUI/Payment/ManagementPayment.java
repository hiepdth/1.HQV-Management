package GUI.Payment;

import BackEnd.Animation;
import GUI.DatabaseProduct.DataPro;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

public class ManagementPayment {

    Animation notifi = new Animation();

    @FXML
    private JFXButton close, minimize, cancel, cancel1, cancel2;
    @FXML
    private JFXButton mua, ban;
    @FXML
    private JFXButton gold, cur, other;
    @FXML
    private AnchorPane vangPane, ngoaitePane, otherPane;

    @FXML
    private int TienHienCo;
    //Các biến quản lí thời gian
    @FXML
    private JFXTextField dd , mm, yyyy, hour, minute;
    @FXML
    private JFXTextField dd1 , mm1, yyyy1, hour1, minute1;
    @FXML
    private JFXTextField dd2 , mm2, yyyy2, hour2, minute2;

    @FXML
    private JFXToggleButton TienMat, TienMat1, TienMat2, Card, Card1, Card2;


    //Các biến quản lí thanh toán sản phẩm Vàng
    @FXML private JFXButton thanhtoan;
    @FXML private JFXTextField KhachHang, TenSp, Type, DonGia, KhoiLuong, SoLuong, NhapLai, GiaCong, TongTien;
    @FXML private TextArea note;
    @FXML private Label Tong;


    //Các biến quản lí thanh toán Ngoại tệ
    @FXML private JFXButton thanhtoan1;
    @FXML private JFXTextField KhachHang1, LoaiTien, SoLuong1, DonGia1, PhuPhi, TongTien1;
    @FXML private TextArea note1;
    @FXML private Label Tong1;
    //Các biến quản lí thanh toán sản phẩm khác


    @FXML private JFXButton thanhtoan2;
    @FXML private JFXTextField KhachHang2, Ten, SoLuong2, DonGia2, PhuPhi2, TongTien2;
    @FXML private TextArea note2;
    @FXML private Label Tong2;


    @FXML
    public void handleAction(ActionEvent event){
        if(event.getTarget() == close || event.getTarget() == cancel || event.getTarget() == cancel1|| event.getTarget() == cancel2){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        }
        else if(event.getTarget() == minimize){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.setIconified(true);
        }
        else if(event.getTarget() == mua){
            mua.setStyle("-fx-background-color: #31bb4d");
            ban.setStyle("-fx-background-color: transparent");
        }
        else if(event.getTarget() == ban){
            ban.setStyle("-fx-background-color: #31bb4d");
            mua.setStyle("-fx-background-color: transparent");
        }
        else if(event.getTarget() == gold){
            vangPane.setVisible(true);
            ngoaitePane.setVisible(false);
            otherPane.setVisible(false);
            gold.setStyle("-fx-background-color: #a7148a");
            cur.setStyle("-fx-background-color: transparent");
            other.setStyle("-fx-background-color: transparent");
        }
        else if(event.getTarget() == cur){
            ngoaitePane.setVisible(true);
            vangPane.setVisible(false);
            otherPane.setVisible(false);
            cur.setStyle("-fx-background-color: #a7148a");
            gold.setStyle("-fx-background-color: transparent");
            other.setStyle("-fx-background-color: transparent");
        }
        else if(event.getTarget() == other){
            otherPane.setVisible(true);
            vangPane.setVisible(false);
            ngoaitePane.setVisible(false);
            other.setStyle("-fx-background-color: #a7148a");
            gold.setStyle("-fx-background-color: transparent");
            cur.setStyle("-fx-background-color: transparent");
        }

        //TODO: Thanh toán cho sản phẩm vàng
        else if (event.getTarget() == thanhtoan){
            String a1  = KhachHang.getText();
            String a2  = TenSp.getText();
            String a3  = Type.getText();
            String a4  = DonGia.getText();
            String a5  = KhoiLuong.getText();
            String a6  = SoLuong.getText();
            String a7  = NhapLai.getText();
            String a8  = GiaCong.getText();
            String a9  = TongTien.getText();
            String a10 = dd.getText();
            String a11 = mm.getText();
            String a12 = yyyy.getText();
            String a13 = hour.getText();
            String a14 = minute.getText();
            String muaorban;       //mua = 1, bán = 2;
            String thanhtoan = null;      //tiền mặt = 1, quẹt thẻ = 2;
            String ghichu = note.getText();
            if(TienMat.isSelected()){
                thanhtoan = "Tiền mặt";
            }
            else if(Card.isSelected()){
                thanhtoan = "Card";
            }
            else
                thanhtoan = "Tiền mặt";
            String his = a1+":"+a2+":"+a3+":"+a4+":"+a5+":"+a6+":"+a7+":"+a8+":"+a9+":"+a10+":"+a11+":"+a12+":"+a13+":"+a14+":"+thanhtoan+":"+ghichu;
            if(mua.getStyle() == "-fx-background-color: #31bb4d")
                saveHistory(his, "src\\history\\mua\\muaVang.txt");
            else
                saveHistory(his, "src\\history\\ban\\banVang.txt");
            notifi.done(vangPane, "Giao dịch thành công!!");
            KhachHang.setText("");
            TenSp.setText("");
            Type.setText("");
            DonGia.setText("");
            KhoiLuong.setText("");
            SoLuong.setText("");
            NhapLai.setText("");
            GiaCong.setText("");
            note.setText("");
            TongTien.setText("");
            TienMat.setSelected(false);
            Card.setSelected(false);
            initialize();
//            Stage stage = (Stage) close.getScene().getWindow();
//            stage.close();
        }
        //TODO: Thanh toán cho sản phẩm ngoại tệ
        else if (event.getTarget() == thanhtoan1){
            String a1 = KhachHang1.getText();
            String a2 = LoaiTien.getText();
            String a3 = SoLuong1.getText();
            String a4 = DonGia1.getText();
            String a5 = PhuPhi.getText();
            String a6 = TongTien1.getText();
            String a7 = dd1.getText();
            String a8 = mm1.getText();
            String a9 = yyyy1.getText();
            String a10 = hour1.getText();
            String a11 = minute1.getText();
            String muaorban;       //mua = 1, bán = 2;
            String thanhtoan = "";      //tiền mặt = 1, quẹt thẻ = 2;
            String ghichu = note1.getText();
            if(TienMat1.isSelected())
                thanhtoan = "Tiền mặt";
            else if(Card1.isSelected())
                thanhtoan = "Card";
            else
                thanhtoan = "Tiền mặt";
            String his = a1+":"+a2+":"+a3+":"+a4+":"+a5+":"+a6+":"+a7+":"+a8+":"+a9+":"+a10+":"+a11+":"+thanhtoan+":"+ghichu;
            if(mua.getStyle() == "-fx-background-color: #31bb4d")
                saveHistory(his, "src\\history\\mua\\muaNgoaiTe.txt");
            else
                saveHistory(his, "src\\history\\ban\\banNgoaiTe.txt");
            notifi.done(ngoaitePane, "Giao dịch thành công!!");
            KhachHang1.setText("");
            LoaiTien.setText("");
            SoLuong1.setText("");
            DonGia1.setText("");
            PhuPhi.setText("");
            TongTien1.setText("");
            note1.setText("");
            TienMat.setSelected(false);
            Card.setSelected(false);
            initialize();
//            Stage stage = (Stage) close.getScene().getWindow();
//            stage.close();
        }

        //TODO: Thanh toán cho sản phẩm khác
        else if(event.getTarget() == thanhtoan2){
            String a1 = KhachHang2.getText();
            String a2 = Ten.getText();
            String a3 = SoLuong2.getText();
            String a4 = DonGia2.getText();
            String a5 = PhuPhi2.getText();
            String a6 = TongTien2.getText();
            String a7 = dd2.getText();
            String a8 = mm2.getText();
            String a9 = yyyy2.getText();
            String a10 = hour2.getText();
            String a11 = minute2.getText();
            String muaorban;       //mua = 1, bán = 2;
            String thanhtoan = "";      //tiền mặt = 1, quẹt thẻ = 2;
            String ghichu = note2.getText();
            if(TienMat2.isSelected())
                thanhtoan = "Tiền mặt";
            else if(Card2.isSelected())
                thanhtoan = "Card";
            else
                thanhtoan = "Tiền mặt";

            String his = a1+":"+a2+":"+a3+":"+a4+":"+a5+":"+a6+":"+a7+":"+a8+":"+a9+":"+a10+":"+a11+":"+thanhtoan+":"+ghichu;
            if(mua.getStyle() == "-fx-background-color: #31bb4d")
                saveHistory(his, "src\\history\\mua\\muaKhac.txt");
            else
                saveHistory(his, "src\\history\\ban\\banKhac.txt");
            notifi.done(otherPane, "Giao dịch thành công!!");

            KhachHang2.setText("");
            Ten.setText("");
            SoLuong2.setText("");
            DonGia2.setText("");
            PhuPhi2.setText("");
            TongTien2.setText("");
            note2.setText("");
            TienMat.setSelected(false);
            Card.setSelected(false);
            initialize();
//            Stage stage = (Stage) close.getScene().getWindow();
//            stage.close();
        }

    }
    @FXML
    public void initialize(){
        Calendar c = Calendar.getInstance();
        dd.setText(Integer.toString(c.get(Calendar.DAY_OF_MONTH)));
        mm.setText(Integer.toString(c.get(Calendar.MONTH)+1));
        yyyy.setText(Integer.toString(c.get(Calendar.YEAR)));
        hour.setText(Integer.toString(c.get(Calendar.HOUR_OF_DAY)));
        minute.setText(Integer.toString(c.get(Calendar.MINUTE)));

        dd1.setText(Integer.toString(c.get(Calendar.DAY_OF_MONTH)));
        mm1.setText(Integer.toString(c.get(Calendar.MONTH)+1));
        yyyy1.setText(Integer.toString(c.get(Calendar.YEAR)));
        hour1.setText(Integer.toString(c.get(Calendar.HOUR_OF_DAY)));
        minute1.setText(Integer.toString(c.get(Calendar.MINUTE)));

        dd2.setText(Integer.toString(c.get(Calendar.DAY_OF_MONTH)));
        mm2.setText(Integer.toString(c.get(Calendar.MONTH)+1));
        yyyy2.setText(Integer.toString(c.get(Calendar.YEAR)));
        hour2.setText(Integer.toString(c.get(Calendar.HOUR_OF_DAY)));
        minute2.setText(Integer.toString(c.get(Calendar.MINUTE)));
    }

    public void saveHistory(String history, String path){
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path),true), "UTF-8"));
            writer.write(history);
            writer.newLine();
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveData(String path){
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(path),true), "UTF-8"));
//            for(int i = 0; i < )
            writer.newLine();
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public JFXTextField getTenSp() {
        return TenSp;
    }

    public JFXTextField getLoaiTien() {
        return LoaiTien;
    }

    public JFXTextField getTen() {
        return Ten;
    }

}
