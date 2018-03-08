package javase01.t02;

import static java.lang.Math.pow;

public class MinFinder {

    private static boolean conditionM(double a, double e) {
        return a < e;
    }

    private static double getA(int n) {
        return 1 / pow(n + 1, 2);
    }

    public static int findMin(double e) {
        for (int n = 1; ; n++) {
            if (conditionM(getA(n), e)) {
                System.out.println("Элемент №" + n + " = " + getA(n));
                System.out.println("Номер наименьшего элемента = " + n);
                return n;
            } else {
                System.out.println("Элемент №" + n + " = " + getA(n));
            }
        }
    }

    public static void main(String[] args) {
        findMin(0.0069);
    }
}
