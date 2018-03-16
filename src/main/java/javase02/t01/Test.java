package javase02.t01;

public class Test {
    public static void main(String[] args) {
        Pen pen1 = new Pen(100, Color.BLACK, "Parker");
        Pen pen2 = new Pen(100, Color.BLACK, "Parker1");

        System.out.println(pen2.equals(pen1));

        System.out.println(pen1.hashCode());
        System.out.println(pen2.hashCode());

        System.out.println(pen1.toString());
    }
}
