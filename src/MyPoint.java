import java.util.Scanner;

public class MyPoint {
    private double x,y;

    public MyPoint(){

    }
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint secondPoint){
        return Math.sqrt((secondPoint.x - x)*(secondPoint.x - x) + (secondPoint.y - y)*(secondPoint.y-y));
    }
    public static double distance(MyPoint first, MyPoint second){
        return Math.sqrt((second.x - first.x)*(second.x - first.x) + (second.y - first.y)*(second.y-first.y));

    }
    public MyPoint translate(double _x ,double _y){
        return new MyPoint(x + _x, y + _y);
    }
    public MyPoint(MyPoint mP){
        this.x = mP.x;
        this.y = mP.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n:");
        int n = sc.nextInt();
        double x , y;
        MyPoint [] points = new MyPoint[n];
        for(int i = 0; i < n; i++){
            x = sc.nextDouble();
            y = sc.nextDouble();
            points[i].setX(x);
            points[i].setY(y);
        }
        double max = 0;
        MyPoint m1 = null, m2 = null;
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(distance(points[i], points[j]) > max){
                    max = distance(points[i], points[j]);
                    m1 = points[i];
                    m2 = points[j];
                }
            }
        }
        System.out.println("2 Điểm có khoảng cách lớn nhất: " + m1 + " " + m2 + " có độ dài:" + max);
    }


}
