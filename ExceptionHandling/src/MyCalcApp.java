public class MyCalcApp {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try {
            System.out.println(calculator.calDouble(0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(calculator.calDouble(-1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(calculator.calDouble(2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
