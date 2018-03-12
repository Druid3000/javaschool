package javase02.t02;

public class Paper implements Stationery {

    private int price;
    private String producerName;

    public Paper(int price, String producerName) {
        this.price = price;
        this.producerName = producerName;
    }

    public int getPrice() {
        return price;
    }

    public String getProducerName() {
        return producerName;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (null == obj)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Paper paper = (Paper) obj;

        if (price != paper.price)
            return false;

        if (null == producerName) {
            return (producerName == paper.producerName);
        } else {
            if (!producerName.equals(paper.producerName)) {
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        return (int) (31 * price
                + ((null == producerName) ? 0 : producerName.hashCode()));
    }

    public String toString() {
        return getClass().getName() + "@" + "price: " + price
                + ", producerName: " + producerName;
    }
}

