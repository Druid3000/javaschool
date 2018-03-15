package javase02.t03.corrector;
import javase02.t03.Corrector;

public class tapeCorrector extends Corrector{
    private double lengthOfTape;

    public tapeCorrector(double price, String producerName, double lengthOfTape) {
        super(price, producerName);
        this.lengthOfTape = lengthOfTape;
    }

    public double getLengthOfTape() {
        return lengthOfTape;
    }

    public void setLengthOfTape(double lengthOfTape) {
        this.lengthOfTape = lengthOfTape;
    }
}

