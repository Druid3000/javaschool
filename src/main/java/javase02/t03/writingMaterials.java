package javase02.t03;
import javase02.t01.Color;

public abstract class writingMaterials extends Stationery{

    private Color color;

    public writingMaterials(double price, String producerName, Color color) {
        super(price, producerName);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
