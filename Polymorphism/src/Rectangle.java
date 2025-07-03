public class Rectangle extends Shape{
    double length;
    double width;

    @Override
    public double calculatePerimeter() {
        return setDimensions(length,width);
    }

    @Override
    public double calculateArea() {
        return setDimensions(length);
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }


    public double setDimensions(double length){
       return length * length;


    }
    public double setDimensions(double length, double width){
        return length * width;
        }

}
