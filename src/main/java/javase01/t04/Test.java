package javase01.t04;

public class Test {
    public static void main(String[] args) {
        double[] a = new double[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MaxFinder obj = new MaxFinder(a);

        System.out.println("max = " + obj.getMaximum());
    }
}
