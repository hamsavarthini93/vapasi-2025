import java.util.ArrayList;
import java.util.List;

public class ShapeCalculator {

    public static void main(String[] args){
        Shape c = new Circle(23);
        c.calculateArea();
        c.calculatePerimeter();
        Shape r = new Rectangle(2,3);
        r.calculateArea();
        r.calculatePerimeter();
        Shape t = new Triangle(2,4,6);
        t.calculatePerimeter();
        t.calculateArea();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(c);
        shapes.add(r);
        shapes.add(t);

        shapes.forEach(s -> System.out.println(s.getClass().getSimpleName()+
                "\n"+" Area "+ s.calculateArea()+" "+"Perimeter "+s.calculatePerimeter()));
        }
}
