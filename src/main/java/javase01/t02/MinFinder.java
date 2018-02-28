package javase01.t02;

import static java.lang.Math.pow;

public class MinFinder {
    public static void main(String[] args) {
        double a;
        double e;
        double n;

        e = 0.0069;
        n = 0;
        do {
            n++;
            a = 1 / pow(n + 1, 2);
            if (a < e) {
                System.out.println("Элемент №" + n + " = " + a);
                System.out.println("Номер наименьшего элемента = " + n);
                break;
            } else {
                System.out.println("Элемент №" + n + " = " + a);
            }
        } while (true);
    }
}
