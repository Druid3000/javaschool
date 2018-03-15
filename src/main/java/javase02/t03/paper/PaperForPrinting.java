package javase02.t03.paper;

import javase02.t01.Color;
import javase02.t03.Paper;

public class PaperForPrinting extends Paper {
    private Format format;

    public PaperForPrinting(double price, String producerName, Color color, Format format) {
        super(price, producerName, format.getHeight(), format.getWidth(), color);
        this.format = format;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + "PaperForPrinting{" +
                "format=" + format +
                "} ";
    }
}
