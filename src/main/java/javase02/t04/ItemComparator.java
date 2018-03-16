package javase02.t04;

import java.util.Comparator;
import javase02.t03.writingmaterials.Pen;

public class ItemComparator implements Comparator<Pen> {

    private SortingParameter sortingParameter;

    public ItemComparator(SortingParameter sortingParameter) {
        this.sortingParameter = sortingParameter;
    }

    public SortingParameter getSortingParameter() {
        return sortingParameter;
    }

    public void setSortingParameter(SortingParameter sortingParameter) {
        this.sortingParameter = sortingParameter;
    }

    public int compare(Pen pen1, Pen pen2) {
        switch (sortingParameter) {
            case PRICE:
                return Double.compare(pen1.getPrice(), pen2.getPrice());

            case PRODUCER_NAME:
                return pen1.getProducerName().compareTo(pen2.getProducerName());

            case PRICE_AND_PRODUCER_NAME:
                if (Double.compare(pen1.getPrice(), pen2.getPrice()) == 0) {
                    return pen1.getProducerName().compareTo(pen2.getProducerName());
                } else {
                    return Double.compare(pen1.getPrice(), pen2.getPrice());
                }

            default:
                throw new EnumConstantNotPresentException(SortingParameter.class, sortingParameter.name());
        }
    }
}
