package javase02.t02;

public class WorkPlace {
    private Stationery[] stationers = {
            new Pen(100, Color.BLACK, "Parker"),
            new Paper(5, "SvetoCopy"),
            new Paper(3, "Snegurochka")
    };

    public int getPriceOfAllStationers() {
        int price;
        price = 0;
        for (Stationery stationery : stationers)
            price += stationery.getPrice();
        return price;
    }

    public int getCountsOfAllStationers() {
        return stationers.length;
    }

    public int getCountsOfPens() {
        int counts;
        counts = 0;
        for (Stationery stationery : stationers) {
            if (stationery instanceof Pen) {
                counts++;
            }
        }
        return counts;
    }

    public int getCountsOfPaper() {
        int counts;
        counts = 0;
        for (Stationery stationery : stationers) {
            if (stationery instanceof Paper) {
                counts++;
            }
        }
        return counts;
    }
}
