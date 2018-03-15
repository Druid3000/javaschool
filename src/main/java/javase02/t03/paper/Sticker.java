package javase02.t03.paper;

import javase02.t03.Paper;

public class Sticker extends Paper{

    private int adhesiveness;

    public void setAdhesiveness(int adhesiveness) {
        this.adhesiveness = adhesiveness;
    }

    public void setPrice(){

    }

    public void setProducerName(){

    }

    public int getAdhesiveness() {
        return adhesiveness;
    }

    public double getPrice(){
        return 0.0;
    }
    public String getProducerName(){
        return "0.0";
    }
}
