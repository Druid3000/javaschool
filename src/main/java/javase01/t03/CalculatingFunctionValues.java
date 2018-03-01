package javase01.t03;
import static java.lang.Math.tan;

public class CalculatingFunctionValues {
    public static void main(String[] args) {
        double a;
        double b;
        double step;

        a = 0;
        b = 10;
        step = 0.5;

        System.out.println("+---------+----------+");
        System.out.println("|    X    |   F(x)   |");
        System.out.println("+---------+----------+");

        for (double i = a; i < b; i += step) {
            System.out.println("|   " + i + "   | " + (tan(2*i)-3)+"|");
        }

        System.out.println("+---------+----------+");
    }
}
