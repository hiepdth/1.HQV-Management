public class Rectangle {
    private double width, height;
    private MyPoint lefttop, rightdown;
    public Rectangle(){
        width = 1;
        height = 1;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }


    public double findArea(){
        return width*height;
    }
    public double findPerimeter(){
        return 2*(width+height);
    }

    public MyPoint findCenter(){
        return new MyPoint((lefttop.getX()+rightdown.getX())/2, (lefttop.getY()+rightdown.getY())/2);
    }
    public static double distanceBetween(Rectangle first, Rectangle second){
        return new MyPoint().distance(first.findCenter(), second.findCenter());
    }
    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", area=" + findArea() +
                ", perimeter=" + findPerimeter() +
                '}';
    }
    public static void main(String [] args){
        Rectangle rec = new Rectangle(3.14,3.14);
        System.out.println(rec.toString());

    }
}
