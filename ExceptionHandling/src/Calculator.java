public class Calculator {

    double calDouble(int number) {
        if (number == 0) {
            throw new ArithmeticException("Zero not allowed");

        } else if (number < 0) {
            throw new ArithmeticException("Negative not allowed");
        } else {
            return number;
        }
    }
}
