package javase02.t02;

public class WorkPlace {

    Array<Stationery> stationers = new Array<Stationery>();

    public void addStationery(Pen pen) {
        stationers.addItem(pen);
    }

    public void addStationery(Paper paper) {
        stationers.addItem(paper);
    }

    public void removeStationery(int index) {
        stationers.removeItem(index);
    }

    public Stationery getStationery(int index) {
        return stationers.getItem(index);
    }

    public int getPriceOfAllStationers() {
        int price;
        price = 0;
        for (int i = 0; i < stationers.size(); i++) {
            price += getStationery(i).getPrice();
        }
        return price;
    }

    public int getCountsOfAllStationers() {
        return stationers.size();
    }

    public int getCountsOfPens() {
        int counts;
        counts = 0;
        for (int i = 0; i < stationers.size(); i++) {
            if (getStationery(i) instanceof Pen) {
                counts++;
            }
        }
        return counts;
    }

    public int getCountsOfPapers() {
        int counts;
        counts = 0;
        for (int i = 0; i < stationers.size(); i++) {
            if (getStationery(i) instanceof Paper) {
                counts++;
            }
        }
        return counts;
    }
}