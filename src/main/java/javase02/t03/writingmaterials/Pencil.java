package javase02.t03.writingmaterials;

import javase02.t01.Color;
import javase02.t03.writingMaterials;

public class Pencil extends writingMaterials {
    private Hardness hardness;

    public Pencil(double price, String producerName, Color color, Hardness hardness) {
        super(price, producerName, color);
        this.hardness = hardness;
    }

    public Hardness getHardness() {
        return hardness;
    }

    public void setHardness(Hardness hardness) {
        this.hardness = hardness;
    }

    @Override
    public String toString() {
        return super.toString() + "Pencil{" +
                "hardness=" + hardness +
                "} ";
    }
}
