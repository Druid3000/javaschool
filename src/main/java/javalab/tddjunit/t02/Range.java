package javalab.tddjunit.t02;

import java.util.Iterator;
import java.util.List;

public class Range {

    boolean isBefore(Range otherRange){
        return false;
    }

    boolean isAfter(Range otherRange){
        return false;
    }

    boolean isConcurrent(Range otherRange){
        return false;
    }

    long getLowerBound(){
        return 0;
    }

    long getUpperBound(){
        return 0;
    }

    boolean contains(long value){
        return false;
    }

    List<Long> asList(){
        return null;
    }

    Iterator<Long> asIterator(){
        return null;
    }
}
