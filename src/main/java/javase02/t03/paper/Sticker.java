package javase02.t03.paper;

import javase02.t01.Color;
import javase02.t03.Paper;

public class Sticker extends Paper {

    private int adhesiveness;

    public Sticker(double price, String producerName, int height, int width, Color color, int adhesiveness) {
        super(price, producerName, height, width, color);
        this.adhesiveness = adhesiveness;
    }

    public void setAdhesiveness(int adhesiveness) {
        this.adhesiveness = adhesiveness;
    }

    public int getAdhesiveness() {
        return adhesiveness;
    }

    @Override
    public String toString() {
        return super.toString() + "Sticker{" +
                "adhesiveness=" + adhesiveness +
                "} ";
    }
}
