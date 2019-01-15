package BackEnd;

import java.util.Date;

public class Gold extends Production {
    protected Date date;          //Thời gian bán hoặc mua sản phẩm
    protected String name;        //tên sản phẩm
    protected String type;        //loại sản phẩm (kiềng, lắc tay, nhẫn, ...)
    protected double weight;      //Khối lượng sản phẩm
    protected double otherweight; //Khối lượng khác ( đá, ...)
    protected int price;          //Đơn giá
    protected int wage;           //Tiền gia công
    protected int Cost;           //Số tiền phải trả


    public Gold(){
        setPath(null);
        date = null;
        name = null;
        type = null;
        weight = 0;
        otherweight = 0;
        price = 0;
        wage = 0;
        Cost = 0;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getOtherweight() {
        return otherweight;
    }

    public void setOtherweight(double otherweight) {
        this.otherweight = otherweight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }
}
