package javase02.t03.paper;

public enum Format {
    A1, A2, A3, A4;

    public int getHeight() {
        if (this == A4) {
            return 297;
        } else {
            return 594;
        }
    }

    public int getWidth() {
        if (this == A1) {
            return 841;
        } else if (this == A2) {
            return 420;
        } else if (this == A3) {
            return 297;
        } else if (this == A4) {
            return 210;
        } else {
            return 0;
        }
    }
}
