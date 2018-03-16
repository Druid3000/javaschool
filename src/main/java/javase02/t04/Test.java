package javase02.t04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javase02.t01.Color;
import javase02.t03.writingmaterials.Pen;
import javase02.t03.writingmaterials.TypeOfInk;

public class Test {
    public static void main(String[] args) {
        ArrayList<Pen> pens = new ArrayList<Pen>();

        pens.add(new Pen(100, "A", Color.BLUE, TypeOfInk.CAPILLARY));
        pens.add(new Pen(100, "Z", Color.BLACK, TypeOfInk.GEL));
        pens.add(new Pen(25, "Pinkerton", Color.GREEN, TypeOfInk.CAPILLARY));
        pens.add(new Pen(25, "A", Color.BLUE, TypeOfInk.GEL));
        pens.add(new Pen(25, "Parker", Color.GREEN, TypeOfInk.GEL));
        pens.add(new Pen(38, "Big" ,Color.BLUE, TypeOfInk.GEL));

        Comparator<Pen> comparator = new ItemComparator(SortingParameter.PRICE_AND_PRODUCER_NAME);

        Collections.sort(pens, comparator);

        for(int i=0; i<pens.size(); i++){
            System.out.println(pens.get(i));
        }
    }
}
