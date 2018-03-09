package javase01.t04;

public class MaxFinder {

    private double[] a;

    public MaxFinder(double[] a) {
        this.a = a;
    }

    public double getMaximum(){

        double max = Double.NEGATIVE_INFINITY;
        double subsequentA = max;
        for (int i = 0; i < a.length; i++) {
            if (subsequentA + a[i] > max) {
                max = subsequentA + a[i];
            }
            subsequentA = a[i];
        }
        return max;
    }
}
