import java.util.Random;
import java.util.StringTokenizer;

/**
 *      Bài 1
 */
public class SinhVien{
    private String id;
    private String name;
    private String group; //lớp học
    private String course; //khóa học

    public SinhVien(){}
    public SinhVien(String id, String name, String group, String course) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
    public static SinhVien generateSinhVien(){
        String[] ids = {
                "8516", "2516", "1200", "9862", "2071", "2810", "1306",
                "8569", "0052", "8888", "1119", "1234"};
        String[] groups = {
                "K13","K14","K15","K16","K17","K18","K19","K20","K21","K22",};
        String[] courses = {
                "INT2201","INT2202","INT2203","INT2204","INT2205","INT2206","INT2207","INT2208","INT2209",};

        String _id = randomOther(ids);
        String _name = randomName();
        String _group = randomOther(groups);
        String _course = randomOther(courses);
        return new SinhVien(_id, _name, _group, _course);
    }
    //Todo: Hàm sinh ngẫu nhiên tên n sinh viên
    public static String randomName(){
        String[] firstNames = {
                "Hoàng", "Hùng", "Dũng", "Huy", "Tuấn", "Minh", "Tâm",
                "Trang", "Yến", "Nhung", "Ngọc", "Mai", "Dung", "Hương", "Lan Anh", "Giang",
                "Vân", "Lan", "Ngân", "Khang", "Mai Anh", "Thủy", "Phương", "Nga", "Linh", "Anh",
                "Trâm Anh", "Quỳnh", "Thu", "Lâm", "Huyền", "Tùng", "Oanh", "Quân", "Chi"};

        String[] lastNames = {
                "Vũ","Phạm","Nguyễn", "Lê", "Hoàng", "Dương", "Trần", "Bùi",
                "Lương", "Võ", "Tạ", "Tống", "Đào", "Hà", "Trương", "Hồ", "Đinh", "Ngô"
        };

        String[] middleNames = {
                "Thế", "Văn", "Thị", "Mai", "Mạnh", "Quang", "Minh", "Thu", "Xuân", "Hạ", "Trung", "Ngọc", "Phương", "Thùy"
        };
        Random ran = new Random();
        String ranName = new String();
            int a = ran.nextInt(lastNames.length);
            int b = ran.nextInt(middleNames.length);
            int c = ran.nextInt(firstNames.length);
            ranName = lastNames[a] +" "+ middleNames[b] +" " + firstNames[c];
        return ranName;
    }
    //Todo : Hàm sinh ngẫu nhiên id, lớp, khóa
    public static String randomOther(String [] keys){
        Random ran = new Random();
        String random = new String();

        int a = ran.nextInt(keys.length);

        random = keys[a];
        return random;
    }


    /**
     * Bài 2
     */
    public static void arrStudent(){
        SinhVien [] sv = new SinhVien[100];
        for(int i = 0; i < sv.length; i++){
            sv[i] = SinhVien.generateSinhVien();
        }
        String [] names = new String[100];
        for(int i = 0; i < 100; i++) {
            names[i] = sv[i].getName();
        }
        System.out.println("*****Sắp xếp 100 sinh viên:");
        sort(names, sv);
        System.out.println("*****Sắp xếp sinh viên theo lớp:");
        for(int i = 0; i < sv.length; i++){
            if(sv[i].getGroup().equals("K18"))
                System.out.println(sv[i].toString());
        }

    }

    public static void arrStudentByGroup(){

    }

    public static void sort(String [] names, SinhVien [] sv){

        //todo: Hàm tách các token và lấy token cuối (tên)
        String [] arr = new String[names.length];       //tạo mảng trung gian lấy ra tên
        for(int i = 0; i < names.length; i++){
            String str= "";
            StringTokenizer token = new StringTokenizer(names[i], " ");//chuỗi token cách nhau bằng dấu space (" ")
            while( token.hasMoreTokens()){
                str = token.nextToken();
            }
            arr[i] = str;            //lấy token cuối cùng
        }


        //todo: Sắp xếp lại tên
        for(int i = 0; i < names.length-1; i++){
            for(int j = 0; j < names.length-1; j++){
                if(arr[j].compareToIgnoreCase(arr[j+1]) > 0){
                    String temp1 = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp1;

                    String temp2 = names[j];
                    names[j] = names[j+1];
                    names[j+1] = temp2;

                    SinhVien temp3 = sv[j];
                    sv[j] = sv[j+1];
                    sv[j+1] = temp3;
                }
            }
        }

        for(SinhVien s : sv)
            System.out.println(s.toString());
    //Phần kết quả có thấy thì chữ Đạt có chữ cái đầu là D và trong ascii là 272 lên xếp cuối
    }
    public static void main(String [] args){

        //Bài 1 - tạo random 1 sinh viên và in ra kết quả
        SinhVien sv = new SinhVien();
        String test = SinhVien.generateSinhVien().toString();
        System.out.println("Bài 1");
        System.out.println(test);

        //Bài 2 - tạo random 100 sinh viên sắp xếp tăng dần và theo group
        System.out.println("Bài 2");
        sv.arrStudent();

    }
}
