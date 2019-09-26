package baitap;

public class Main {
    public static void display(Object object){
        System.out.println(object.toString());
    }
    public static void main(String [] args){
        GiamDoc gd = new GiamDoc("Vũ Thị Hải Yến", 20, "hà nội", "0945455387", "dinhiep@gmail.com");
        NvKinhdoanh kd = new NvKinhdoanh("Vũ Thị Hải Yến", 20, "Hà Nội", "1306",
                "0988682740", 5000000, 100, 1000000);
        BaoVe bv = new BaoVe("Vũ Thị Hải Yến", 20, "Hà Nội", "1306",
                "0988682740", 5000000, 100, 1000000);
        Employee em = new Employee("Vũ Thị Hải Yến", 20, "Hà Nội", "1306",
                "0988682740", 5000000);
        display(gd);
        display(kd);
        display(bv);
        display(em);
    }
}
