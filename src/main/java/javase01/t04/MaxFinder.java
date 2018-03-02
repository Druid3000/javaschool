package javase01.t04;

public class MaxFinder {
    public static void main(String[] args) {

        double[] a = new double[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        double max = Double.NEGATIVE_INFINITY;
        double subsequentA = max;
        for (int i = 0; i < a.length; i++) {
            if (subsequentA + a[i] > max) {
                max = subsequentA + a[i];
            }
            subsequentA = a[i];
        }
        System.out.println("max = " + max);
    }
}
