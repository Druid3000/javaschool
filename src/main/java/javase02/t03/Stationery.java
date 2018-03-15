package javase02.t03;

abstract class Stationery {
    private double price;
    private String producerName;

    public abstract void setPrice();
    public abstract void setProducerName();

    public abstract double getPrice();
    public abstract String getProducerName();
}
