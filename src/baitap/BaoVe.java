package baitap;

public class BaoVe extends Employee {
    private double phucap;
    private double ngaycong;

    public BaoVe(String name, int age, String diachi, String id, String phone, double salary, double phucap, double ngaycong) {
        super(name, age, diachi, id, phone, salary);
        this.phucap = phucap;
        this.ngaycong = ngaycong;
    }

    public double getPhucap() {
        return phucap;
    }

    public void setPhucap(double phucap) {
        this.phucap = phucap;
    }

    public double getNgaycong() {
        return ngaycong;
    }

    public void setNgaycong(double ngaycong) {
        this.ngaycong = ngaycong;
    }
    @Override
    public String toString() {
        return "Bảo Vệ:" + getName()+"   Tuổi:" + getAge() + "   Địa chỉ:" + getAddress() +
                "   Mã nv:" + getId() +"    Phone:" + getPhone()+ "    Lương cơ bản:"+ getSalary() +
                "   Tiền phụ cấp:" + phucap + "     Số ngày công:" + ngaycong +"\n";
    }
}
