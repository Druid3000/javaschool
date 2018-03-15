package javase02.t03;

abstract class Stationery {
    private double price;
    private String producerName;

    public Stationery(double price, String producerName) {
        this.price = price;
        this.producerName = producerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }
}
