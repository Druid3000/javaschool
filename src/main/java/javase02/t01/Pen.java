package javase02.t01;

public class Pen implements Stationery {

    private int price;
    private Color color;
    private String producerName;

    public Pen (int price, Color color, String producerName){
        this.price = price;
        this.color = color;
        this.producerName = producerName;
    }

    public int getPrice() {
        return price;
    }

    public Color getColor(){
        return color;
    }

    public String getProducerName(){
        return producerName;
    }

    public boolean equals(Object obj) {
       if (this == obj)
           return true;

       if (null == obj)
           return false;

       if (getClass() != obj.getClass())
           return false;

       Pen pen = (Pen) obj;

       if(price != pen.price)
           return false;

       if (null == producerName){
           return (producerName == pen.producerName);
       } else {
           if(!producerName.equals(pen.producerName)){
               return false;
           }
       }

        if (null == color){
            return (color == pen.color);
        } else {
            if(!color.equals(pen.color)){
                return false;
            }
        }

        return true;
    }

    public int hashCode() {
        return (int) (31*price + ((null == color) ? 0 : color.hashCode())
                        +((null == producerName) ? 0 :producerName.hashCode()));
    }

    public String toString() {
        return getClass().getName() +"@" + "price: " + price
                +", color: " + color + ", producerName: " + producerName;
    }
}
