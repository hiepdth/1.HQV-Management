package baitap;

public class NvKinhdoanh extends Employee{
    private double doanhso;
    private double thuong;

    public NvKinhdoanh(String name, int age, String diachi, String id, String phone, double salary, double doanhso, double thuong) {
        super(name, age, diachi, id, phone, salary);
        this.doanhso = doanhso;
        this.thuong = thuong;
    }

    public double getDoanhso() {
        return doanhso;
    }

    public void setDoanhso(double doanhso) {
        this.doanhso = doanhso;
    }

    public double getThuong() {
        return thuong;
    }

    public void setThuong(double thuong) {
        this.thuong = thuong;
    }

    @Override
    public String toString() {
        return "NvKinhdoanh:" + getName()+"   Tuổi:" + getAge() + "   Địa chỉ:" + getAddress() +
                "   Mã nv:" + getId() +"    Phone:" + getPhone()+ "    Lương cơ bản:"+ getSalary() +
                "   Doanh số tháng:" + doanhso + "     Thưởng:" + thuong +"\n";
    }
}
