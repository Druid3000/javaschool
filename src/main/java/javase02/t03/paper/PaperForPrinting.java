package javase02.t03.paper;

import javase02.t01.Color;
import javase02.t03.Paper;

public class PaperForPrinting extends Paper{
    private Format format;

    public PaperForPrinting(double price, String producerName, int height, int width, Color color, Format format) {
        super(price, producerName, height, width, color);
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }
}
