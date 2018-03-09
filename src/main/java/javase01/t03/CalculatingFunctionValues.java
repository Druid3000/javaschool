package javase01.t03;
import static java.lang.Math.tan;

public class CalculatingFunctionValues {

    private double a;
    private double b;
    private double step;

    public CalculatingFunctionValues(double a, double b, double step) {
        this.a = a;
        this.b = b;
        this.step = step;
    }

    private double getValueOfFunction(double x) {
        return tan(2 * x) - 3;
    }

    public void printTable() {
        System.out.println("+---------------------------------+");
        System.out.println("|        x       |       f(x)     |");
        System.out.println("+---------------------------------+");

        for (double x = a; x < b; x += step) {
            System.out.printf("|% 3.9e|% 3.9e|%n", x, getValueOfFunction(x));
        }

        System.out.print("+---------------------------------+");
    }
}
