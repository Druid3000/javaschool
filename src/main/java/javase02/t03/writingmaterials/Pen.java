package javase02.t03.writingmaterials;
import javase02.t01.Color;
import javase02.t03.writingMaterials;

public class Pen extends writingMaterials{

    private TypeOfInk typeOfInk;

    public Pen(double price, String producerName, Color color, TypeOfInk typeOfInk) {
        super(price, producerName, color);
        this.typeOfInk = typeOfInk;
    }

    public TypeOfInk getTypeOfInk() {
        return typeOfInk;
    }

    public void setTypeOfInk(TypeOfInk typeOfInk) {
        this.typeOfInk = typeOfInk;
    }
}
