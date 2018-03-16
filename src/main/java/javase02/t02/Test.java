package javase02.t02;

public class Test {
    public static void main(String[] args) {
        WorkPlace workPlaceOfEmployee1 = new WorkPlace();

        workPlaceOfEmployee1.addStationery(new Pen(100, Color.BLUE, "Parker"));
        workPlaceOfEmployee1.addStationery(new Paper(5, "SvetoCopy"));
        workPlaceOfEmployee1.addStationery(new Paper(3, "Snegurochka"));

        System.out.println(workPlaceOfEmployee1.getStationery(0));

        System.out.println("Price of all stationers: "
                + workPlaceOfEmployee1.getPriceOfAllStationers());

        System.out.println("Counts of all stationers: "
                + workPlaceOfEmployee1.getCountsOfAllStationers());

        System.out.println("Counts of pens: "
                + workPlaceOfEmployee1.getCountsOfPens());

        System.out.println("Counts of papers: "
                + workPlaceOfEmployee1.getCountsOfPapers());
    }
}
