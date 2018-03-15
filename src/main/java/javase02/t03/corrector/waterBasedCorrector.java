package javase02.t03.corrector;

import javase02.t03.Corrector;

public class waterBasedCorrector extends Corrector {

    private double capacity;

    public waterBasedCorrector(double price, String producerName, double capacity) {
        super(price, producerName);
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString() + "waterBasedCorrector{" +
                "capacity=" + capacity +
                "} ";
    }
}
