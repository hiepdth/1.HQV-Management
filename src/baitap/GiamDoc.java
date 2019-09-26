package baitap;

public class GiamDoc extends Person {
    private String phone;
    private String email;

    public GiamDoc(String name, int age, String diachi, String phone, String email) {
        super(name, age, diachi);
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "GiamDoc:" + getName() + "   Tuổi:" + getAge() + "   Địa chỉ:" + getAddress() +
                "   Số điện thoại:" + getPhone() + "    Email:"+ getEmail() +"\n";
    }
}
