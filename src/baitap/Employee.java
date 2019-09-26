package baitap;

public class Employee extends Person {
    private String id;
    private String phone;
    private double salary;

    public Employee(String name, int age, String diachi, String id, String phone, double salary) {
        super(name, age, diachi);
        this.id = id;
        this.phone = phone;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Nhân viên:" + getName()+"   Tuổi:" + getAge() + "   Địa chỉ:" + getAddress() +
                "   Mã nv:" + id +"    Phone:" + phone+ "    Lương cơ bản:" + salary + "\n";
    }
}
