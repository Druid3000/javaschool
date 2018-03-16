package javase02.t03;

import javase02.t01.Color;
import javase02.t02.Array;

import javase02.t03.corrector.tapeCorrector;
import javase02.t03.corrector.waterBasedCorrector;

import javase02.t03.paper.Format;
import javase02.t03.paper.PaperForPrinting;
import javase02.t03.paper.Sticker;

import javase02.t03.writingmaterials.Hardness;
import javase02.t03.writingmaterials.Pen;
import javase02.t03.writingmaterials.Pencil;
import javase02.t03.writingmaterials.TypeOfInk;

public class Test {
    public static void main(String[] args) {

        Array<Stationery> setForBeginner = new Array<Stationery>();
        setForBeginner.addItem(new tapeCorrector(10, "Attache", 13));
        setForBeginner.addItem(new waterBasedCorrector(9, "ReVise", 20));
        setForBeginner.addItem(new PaperForPrinting(8, "SvetoCopy", Color.WHITE, Format.A4));
        setForBeginner.addItem(new Sticker(7, "Comus", 75, 75, Color.GREEN, 20));
        setForBeginner.addItem(new Pen(6, "Paker", Color.BLUE, TypeOfInk.GEL));
        setForBeginner.addItem(new Pencil(5, "KOHINOOR", Color.BLACK, Hardness.M));

        for (int i = 0; i < setForBeginner.size(); i++) {
            System.out.println(setForBeginner.getItem(i));
        }
    }
}
