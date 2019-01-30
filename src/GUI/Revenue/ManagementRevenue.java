package GUI.Revenue;

import GUI.DatabaseProduct.DataPro;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;


public class ManagementRevenue {
    @FXML
    private JFXButton close, minimize;
    @FXML private Label nhanta, kiengta, taita, matta, dayta, lacta, vongxi, TongVangta;
    @FXML private Label nhannam, nhannu, nhancuoi, bo, kiengtay, taitay, mattay, daytay, lactay, TongVangtay;
    @FXML private Label usd, yen, bat, sing, te, euro, uc, malaysia, canada, won, dailoan, bang, rub, thuysi, lao;
    @FXML private Label btmc, sjc, doji;
    @FXML private Label Tien;

    DataPro data = new DataPro();
    HashMap<String,Integer> maindata = data.getList();
    private String money;

    public void handleAction(ActionEvent event){
        if(event.getTarget() == close){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.close();
        }
        else if(event.getTarget() == minimize){
            Stage stage = (Stage) close.getScene().getWindow();
            stage.setIconified(true);
        }
    }

    public void readData(String path){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"UTF-8"));
            //Vàng ta
            nhanta.setText(maindata.get("Nhẫn ta").toString());
            kiengta.setText(maindata.get("Kiềng ta").toString());
            taita.setText(maindata.get("Tai ta").toString());
            matta.setText(maindata.get("Mặt ta").toString());
            dayta.setText(maindata.get("Dây ta").toString());
            lacta.setText(maindata.get("Lắc ta").toString());
            vongxi.setText(maindata.get("Vòng xi").toString());
            int tong = maindata.get("Nhẫn ta")+maindata.get("Kiềng ta")+maindata.get("Tai ta")+maindata.get("Mặt ta")+
                    maindata.get("Dây ta")+maindata.get("Lắc ta") + maindata.get("Vòng xi");
            TongVangta.setText(Integer.toString(tong));
            btmc.setText(maindata.get("btmc").toString());
            sjc.setText(maindata.get("sjc").toString());
            doji.setText(maindata.get("doji").toString());
            //Vàng tây
            nhannam.setText(maindata.get("Nhẫn nam").toString());
            nhannu.setText(maindata.get("Nhẫn nữ").toString());
            nhancuoi.setText(maindata.get("Nhẫn cưới").toString());
            bo.setText(maindata.get("Bộ").toString());
            kiengtay.setText(maindata.get("Kiềng tây").toString());
            taitay.setText(maindata.get("Tai tây").toString());
            mattay.setText(maindata.get("Mặt tây").toString());
            daytay.setText(maindata.get("Dây tây").toString());
            lactay.setText(maindata.get("Lắc tây").toString());
            int tong1 = maindata.get("Nhẫn nam")+maindata.get("Nhẫn nữ")+maindata.get("Nhẫn cưới")+maindata.get("Bộ")+
                    maindata.get("Kiềng tây")+maindata.get("Tai tây")+maindata.get("Mặt tây")+maindata.get("Dây tây")+maindata.get("Lắc tây");
            TongVangtay.setText(Integer.toString(tong1));

            //Ngoại tệ
            usd.setText(maindata.get("USD").toString());
            yen.setText(maindata.get("Yên").toString());
            bat.setText(maindata.get("Bạt").toString());
            sing.setText(maindata.get("Sing").toString());
            te.setText(maindata.get("Tệ").toString());
            euro.setText(maindata.get("Euro").toString());
            uc.setText(maindata.get("Úc").toString());
            malaysia.setText(maindata.get("Malaysia").toString());
            canada.setText(maindata.get("Canada").toString());
            won.setText(maindata.get("Won").toString());
            dailoan.setText(maindata.get("Đài Loan").toString());
            bang.setText(maindata.get("Bảng").toString());
            rub.setText(maindata.get("Rub").toString());
            thuysi.setText(maindata.get("Thụy sĩ").toString());
            lao.setText(maindata.get("Lào").toString());

            //Tổng tiền ngăn kéo
            Tien.setText(String.format("%,13d",maindata.get("Tiền")));
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String addMoney(String oldmoney, String change){
        int a = Integer.parseInt(oldmoney);
        int b = Integer.parseInt(change);
        int sum = a+b;
        return Integer.toString(sum);

    }
    public String subMoney(String oldmoney, String change){
        int a = Integer.parseInt(oldmoney);
        int b = Integer.parseInt(change);
        int sub = a-b;
        return Integer.toString(sub);
    }



    /**
     *  TODO: Xử lí cho việc mua hàng
     */

    public void updateBought(){
        try {
            //todo: cập nhật khi mua Vàng
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src\\history\\mua\\muaVang.txt")),"UTF-8"));
            String line;
            while ((line = reader.readLine()) != null){
                String info [] = line.split(":");
                //todo: TẤT CẢ CÁC MẶT HÀNG (Nếu mua thì chỉ trừ tiền gốc không cộng thêm sản phẩm)
                if(info[14].equals("Tiền mặt"))
                    money = subMoney(money, info[8]);
            }
            //todo: cập nhật khi mua Ngoại tệ
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src\\history\\mua\\muaNgoaiTe.txt")),"UTF-8"));
            while ((line = reader.readLine()) != null){
                String info [] = line.split(":");
                //todo: ĐÔ (MỸ)
                if(info[1].toLowerCase().equals("usd") ||info[1].toLowerCase().equals("đô")) {
                    usd.setText(addMoney(usd.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: YÊN NHẬT
                else if(info[1].toLowerCase().equals("yên") ||info[1].toLowerCase().equals("nhật")) {
                    yen.setText(addMoney(yen.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: BẠT (THÁI)
                else if(info[1].toLowerCase().equals("bạt") ||info[1].toLowerCase().equals("thái")) {
                    bat.setText(addMoney(bat.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: SINGAPORE
                else if(info[1].toLowerCase().equals("sing") ||info[1].toLowerCase().equals("singapore")) {
                    sing.setText(addMoney(sing.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: TỆ (TRUNG)
                else if(info[1].toLowerCase().equals("tệ") ||info[1].toLowerCase().equals("trung")) {
                    te.setText(addMoney(te.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: EURO
                else if(info[1].toLowerCase().equals("euro") ||info[1].toLowerCase().equals("oi")) {
                    euro.setText(addMoney(euro.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: ÚC (AUSTRALIA)
                else if(info[1].toLowerCase().equals("úc") ||info[1].toLowerCase().equals("uc")) {
                    uc.setText(addMoney(uc.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: MALAYSIA
                else if(info[1].toLowerCase().equals("malay") ||info[1].toLowerCase().equals("malaysia")) {
                    malaysia.setText(addMoney(malaysia.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: CANADA
                else if(info[1].toLowerCase().equals("ca") ||info[1].toLowerCase().equals("canada")) {
                    canada.setText(addMoney(canada.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: WON
                else if(info[1].toLowerCase().equals("won") ||info[1].toLowerCase().equals("hàn")) {
                    won.setText(addMoney(won.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: ĐÀI LOAN
                else if(info[1].toLowerCase().equals("đài") ||info[1].toLowerCase().equals("đài loan")) {
                    dailoan.setText(addMoney(dailoan.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: BẢNG (ẢNH)
                else if(info[1].toLowerCase().equals("bảng") ||info[1].toLowerCase().equals("bảng anh")) {
                    bang.setText(addMoney(bang.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: RUB (NGA)
                else if(info[1].toLowerCase().equals("rub") ||info[1].toLowerCase().equals("rub nga")) {
                    rub.setText(addMoney(rub.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: THỤY SĨ
                else if(info[1].toLowerCase().equals("thụy sĩ")) {
                    thuysi.setText(addMoney(thuysi.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
                //todo: LÀO
                else if(info[1].toLowerCase().equals("lào")) {
                    lao.setText(addMoney(lao.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = subMoney(money, info[5]);
                }
            }
            //TODO: Mua các sản phẩm khác
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src\\history\\mua\\muaKhac.txt")),"UTF-8"));
            while ((line = reader.readLine()) != null){
                String info [] = line.split(":");
                if(info[11].equals("Tiền mặt"))
                    money = subMoney(money, info[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    /**
     *  TODO: Xử lí cho việc bán hàng
     */



    public void updateSell(){
        try {
            //todo: cập nhật khi bán Vàng
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src\\history\\ban\\banVang.txt")),"UTF-8"));
            String line;
            while ((line = reader.readLine()) != null){
                String info [] = line.split(":");
                //todo: NHẪN VÀNG TA (NHẪN + KIM TIỀN)
                if(info[2].toLowerCase().equals("nhẫn ta") ||info[2].toLowerCase().equals("kim tiền")) {
                    nhanta.setText(subMoney(nhanta.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: KIỀNG VÀNG TA
                else if(info[2].toLowerCase().equals("kiềng ta") ||info[2].toLowerCase().equals("kiềng vàng ta")) {
                    kiengta.setText(subMoney(kiengta.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: TAI VÀNG TA
                else if(info[2].toLowerCase().equals("tai ta") ||info[2].toLowerCase().equals("tai vàng ta")) {
                    taita.setText(subMoney(taita.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: MẶT VÀNG TA
                else if(info[2].toLowerCase().equals("mặt ta") ||info[2].toLowerCase().equals("mặt vàng ta")) {
                    matta.setText(subMoney(matta.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: DÂY VÀNG TA
                else if(info[2].toLowerCase().equals("dây ta") ||info[2].toLowerCase().equals("dây vàng ta")) {
                    dayta.setText(subMoney(dayta.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: LẮC VÀNG TA
                else if(info[2].toLowerCase().equals("lắc ta") ||info[2].toLowerCase().equals("lắc vàng ta")) {
                    lacta.setText(subMoney(lacta.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: VÒNG XI
                else if(info[2].toLowerCase().equals("vòng xi")) {
                    vongxi.setText(subMoney(vongxi.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: BẢO TÍN MINH CHÂU
                else if(info[2].toLowerCase().equals("bảo tín minh châu") ||info[2].toLowerCase().equals("btmc")) {
                    btmc.setText(subMoney(btmc.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: DOJI
                else if(info[2].toLowerCase().equals("doji") ||info[2].toLowerCase().equals("do ji")) {
                    doji.setText(subMoney(doji.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: SJC
                else if(info[2].toLowerCase().equals("sjc") ||info[2].toLowerCase().equals("vàng sjc")) {
                    sjc.setText(subMoney(sjc.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: NHẪN NAM VÀNG TÂY
                else if(info[2].toLowerCase().equals("nhẫn nam") ||info[2].toLowerCase().equals("nhẫn nam vàng tây")) {
                    nhannam.setText(subMoney(nhannam.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: NHẪN NỮ VÀNG TÂY
                else if(info[2].toLowerCase().equals("nhẫn nữ") ||info[2].toLowerCase().equals("nhẫn nữ vàng tây")) {
                    nhannu.setText(subMoney(nhannu.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: NHẪN CƯỚI (NHẪN ĐÔI)
                else if(info[2].toLowerCase().equals("nhẫn cưới") ||info[2].toLowerCase().equals("nhẫn đôi")) {
                    nhancuoi.setText(subMoney(nhancuoi.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: BỘ
                else if(info[2].toLowerCase().equals("bộ")) {
                    bo.setText(subMoney(bo.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: KIỀNG VÀNG TÂY
                else if(info[2].toLowerCase().equals("kiềng tây") ||info[2].toLowerCase().equals("kiềng vàng tây")) {
                    kiengtay.setText(subMoney(kiengtay.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: TAI VÀNG TÂY
                else if(info[2].toLowerCase().equals("tai tây") ||info[2].toLowerCase().equals("tai vàng tây")) {
                    taitay.setText(subMoney(taitay.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: MẶT VÀNG TÂY
                else if(info[2].toLowerCase().equals("mặt tây") ||info[2].toLowerCase().equals("mặt vàng tây")) {
                    mattay.setText(subMoney(mattay.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: DÂY VÀNG TÂY
                else if(info[2].toLowerCase().equals("dây tây") ||info[2].toLowerCase().equals("dây vàng tây")) {
                    daytay.setText(subMoney(daytay.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }
                //todo: LẮC VÀNG TÂY
                else if(info[2].toLowerCase().equals("lắc tây") ||info[2].toLowerCase().equals("lắc vàng tây")) {
                    lactay.setText(subMoney(lactay.getText(), info[5]));
                    if(info[14].equals("Tiền mặt"))
                        money = addMoney(money, info[8]);
                }

            }
            //todo: cập nhật khi bán Ngoại tệ
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src\\history\\ban\\banNgoaiTe.txt")),"UTF-8"));
            while ((line = reader.readLine()) != null){
                String info [] = line.split(":");
                //todo: ĐÔ (MỸ)
                if(info[1].toLowerCase().equals("usd") ||info[1].toLowerCase().equals("đô")) {
                    usd.setText(subMoney(usd.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: YÊN (NHẬT)
                else if(info[1].toLowerCase().equals("yên") ||info[1].toLowerCase().equals("nhật")) {
                    yen.setText(subMoney(yen.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: BẠT (THÁI)
                else if(info[1].toLowerCase().equals("bạt") ||info[1].toLowerCase().equals("thái")) {
                    bat.setText(subMoney(bat.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: SINGAPORE
                else if(info[1].toLowerCase().equals("sing") ||info[1].toLowerCase().equals("singapore")) {
                    sing.setText(subMoney(sing.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: TỆ (TRUNG)
                else if(info[1].toLowerCase().equals("tệ") ||info[1].toLowerCase().equals("trung")) {
                    te.setText(subMoney(te.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: EURO
                else if(info[1].toLowerCase().equals("euro") ||info[1].toLowerCase().equals("oi")) {
                    euro.setText(subMoney(euro.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: ÚC (AUSTRAYLIA)
                else if(info[1].toLowerCase().equals("úc") ||info[1].toLowerCase().equals("uc")) {
                    uc.setText(subMoney(uc.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: MALAYSIA
                else if(info[1].toLowerCase().equals("malay") ||info[1].toLowerCase().equals("malaysia")) {
                    malaysia.setText(subMoney(malaysia.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: CANADA
                else if(info[1].toLowerCase().equals("ca") ||info[1].toLowerCase().equals("canada")) {
                    canada.setText(subMoney(canada.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: WON
                else if(info[1].toLowerCase().equals("won") ||info[1].toLowerCase().equals("hàn")) {
                    won.setText(subMoney(won.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: ĐÀI LOAN
                else if(info[1].toLowerCase().equals("đài") ||info[1].toLowerCase().equals("đài loan")) {
                    dailoan.setText(subMoney(dailoan.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: BẢNG (ANH)
                else if(info[1].toLowerCase().equals("bảng") ||info[1].toLowerCase().equals("bảng anh")) {
                    bang.setText(subMoney(bang.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: RUB (NGA)
                else if(info[1].toLowerCase().equals("rub") ||info[1].toLowerCase().equals("rub nga")) {
                    rub.setText(subMoney(rub.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: THỤY SĨ
                else if(info[1].toLowerCase().equals("thụy sĩ")) {
                    thuysi.setText(subMoney(thuysi.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
                //todo: LÀO
                else if(info[1].toLowerCase().equals("lào")) {
                    lao.setText(subMoney(lao.getText(), info[2]));
                    if(info[11].equals("Tiền mặt"))
                        money = addMoney(money, info[5]);
                }
            }
            //TODO: Bán các sản phẩm khác
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src\\history\\mua\\muaKhac.txt")),"UTF-8"));
            while ((line = reader.readLine()) != null){
                String info [] = line.split(":");
                if(info[11].equals("Tiền mặt"))
                    money = addMoney(money, info[5]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    @FXML
    private void initialize(){
        readData("src\\Data\\data.txt");
        money = maindata.get("Tiền").toString();
        updateSell();
        updateBought();
        Tien.setText(String.format("%,13d",Integer.parseInt(money)));
    }
}
