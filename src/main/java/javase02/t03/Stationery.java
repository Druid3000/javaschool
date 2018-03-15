package javase02.t03;

abstract class Stationery {
    protected double price;
    protected String producerName;

    public abstract void setPrice();
    public abstract void setProducerName();

    public abstract double getPrice();
    public abstract String getProducerName();
}
