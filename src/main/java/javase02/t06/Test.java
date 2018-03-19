package javase02.t06;

public class Test {
    public static void main(String[] args) {
        NuclearSubmarine submarine1 = new NuclearSubmarine();

        submarine1.printStatusOfSubmarine();

        submarine1.startSubmarine(5.0);
        submarine1.setDepth(50);
        submarine1.printStatusOfSubmarine();

        submarine1.changeSpeed(3);
        submarine1.setDepth(25);
        submarine1.printStatusOfSubmarine();

        submarine1.stopSubmarine();
        submarine1.setDepth(0);
        submarine1.printStatusOfSubmarine();
    }
}
