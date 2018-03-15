package javase02.t03;
import javase02.t01.Color;

public abstract class writingMaterials extends Stationery{

    protected Color color;

    public abstract void setPrice();
    public abstract void setProducerName();

    public abstract double getPrice();
    public abstract String getProducerName();
}
