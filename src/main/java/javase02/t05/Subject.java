package javase02.t05;

public enum Subject {
    BIOLOGY(false),
    CHEMISTRY(false),
    ENGLISH(false),
    MATHS(true),
    PHYSICS(false);

    final boolean isDouble;

    Subject(boolean isDouble) {
        this.isDouble = isDouble;
    }

    public Number convertMark(Number mark) {
        if (isDouble)
            return mark.doubleValue();
        return mark.intValue();
    }
}