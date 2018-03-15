package javase02.t03;

import javase02.t01.Color;

public abstract class Paper extends Stationery {
    private int height;
    private int width;
    private Color color;

    public Paper(double price, String producerName, int height, int width, Color color) {
        super(price, producerName);
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "Paper{" +
                "height=" + height +
                ", width=" + width +
                ", color=" + color +
                "} ";
    }
}
