public class Triangle extends Shape{
    int side1;
    int side2;
    int side3;

    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double calculateArea() {
        return 0.5 * side1 * side2;
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}
