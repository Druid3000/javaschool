package javase02.t04;

import java.util.ArrayList;
import java.util.Comparator;

import javase02.t01.Color;
import javase02.t02.Array;
import javase02.t03.writingmaterials.Pen;
import javase02.t03.writingmaterials.TypeOfInk;

public class Test {
    public static void main(String[] args) {

        Comparator<Pen> comparator = new ItemComparator(SortingParameter.PRICE_AND_PRODUCER_NAME);

        System.out.println("Сортировка элементов методом sort класса ArrayList библиотеки Java");

        ArrayList<Pen> pens1 = new ArrayList<Pen>();

        pens1.add(new Pen(100, "A", Color.BLUE, TypeOfInk.CAPILLARY));
        pens1.add(new Pen(100, "Z", Color.BLACK, TypeOfInk.GEL));
        pens1.add(new Pen(25, "Pinkerton", Color.GREEN, TypeOfInk.CAPILLARY));
        pens1.add(new Pen(25, "A", Color.BLUE, TypeOfInk.GEL));
        pens1.add(new Pen(25, "Parker", Color.GREEN, TypeOfInk.GEL));
        pens1.add(new Pen(38, "Big", Color.BLUE, TypeOfInk.GEL));

        pens1.sort(comparator);

        for (int i = 0; i < pens1.size(); i++) {
            System.out.println(pens1.get(i));
        }

        System.out.println("\nСортировка элементов методом sort класса javase02.t02.Array");

        Array<Pen> pens2 = new Array<Pen>();

        pens2.addItem(new Pen(100, "A", Color.BLUE, TypeOfInk.CAPILLARY));
        pens2.addItem(new Pen(100, "Z", Color.BLACK, TypeOfInk.GEL));
        pens2.addItem(new Pen(25, "Pinkerton", Color.GREEN, TypeOfInk.CAPILLARY));
        pens2.addItem(new Pen(25, "A", Color.BLUE, TypeOfInk.GEL));
        pens2.addItem(new Pen(25, "Parker", Color.GREEN, TypeOfInk.GEL));
        pens2.addItem(new Pen(38, "Big", Color.BLUE, TypeOfInk.GEL));

        pens2.sort(comparator);

        for (int i = 0; i < pens2.size(); i++) {
            System.out.println(pens2.getItem(i));
        }
    }
}
