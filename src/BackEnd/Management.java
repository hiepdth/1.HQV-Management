package BackEnd;

import java.io.*;
import java.util.ArrayList;

public class Management {
    private ArrayList<Vangta>vangtas = new ArrayList<>();
    private ArrayList<Vangtay>vangtays = new ArrayList<>();
    private ArrayList<Currency>currencies = new ArrayList<>();


    public Management(){
        init();
    }


    //todo: Hàm khởi tạo lấy dữ liệu từ tệp (thông tin path và name của sản phẩm vàngta-vàngtây-ngoạitệ
    public void init(){
        initVangtaProduct(vangtas, "src\\BackEnd\\products\\vangta.txt");
        initVangtayProduct(vangtays, "src\\BackEnd\\products\\vangtay.txt");
        initCurrencyProduct(currencies, "src\\BackEnd\\products\\ngoaite.txt");
    }

    //todo:Lấy data sản phẩm Vàng ta
    public void initVangtaProduct(ArrayList<Vangta>vangta, String path){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"UTF-8"));            String line;
            while((line = reader.readLine()) != null){
                String [] info = line.split(":");
                Vangta vangta1 = new Vangta();
                vangta1.setPath(info[0]);
                vangta1.setName(info[1]);
                vangta.add(vangta1);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //todo: Lấy data sản phẩm Vàng tây
    public void initVangtayProduct(ArrayList<Vangtay>vangtay, String path){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"UTF-8"));
            String line;
            while((line = reader.readLine()) != null){
                String [] info = line.split(":");
                Vangtay vangtay1 = new Vangtay();
                vangtay1.setPath(info[0]);
                vangtay1.setName(info[1]);
                vangtay.add(vangtay1);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //todo: Lấy data sản phẩm Ngoại tệ
    public void initCurrencyProduct(ArrayList<Currency>currencies, String path){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),"UTF-8"));            String line;
            while((line = reader.readLine()) != null){
                String [] info = line.split(":");
                Currency cur = new Currency();
                cur.setPath(info[0]);
                cur.setName(info[1]);
                currencies.add(cur);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Vangta> getVangtas() {
        return vangtas;
    }

    public void setVangtas(ArrayList<Vangta> vangtas) {
        this.vangtas = vangtas;
    }

    public ArrayList<Vangtay> getVangtays() {
        return vangtays;
    }

    public void setVangtays(ArrayList<Vangtay> vangtays) {
        this.vangtays = vangtays;
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<Currency> currencies) {
        this.currencies = currencies;
    }
}
