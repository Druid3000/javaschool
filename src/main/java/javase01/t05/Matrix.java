package javase01.t05;

public class Matrix {

    private int[][] matrix;
    private int sizeOfMatrix;

    public Matrix(int sizeOfMatrix) {
        this.sizeOfMatrix = sizeOfMatrix;

        matrix = new int[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            matrix[i] = new int[sizeOfMatrix];
        }

        initializeItems();
    }

    private void initializeItems() {
        for (int column = 0; column < sizeOfMatrix; column++) {
            for (int row = 0; row < sizeOfMatrix; row++) {
                if (row == column || column == (sizeOfMatrix - 1 - row)) {
                    matrix[row][column] = 1;
                } else {
                    matrix[row][column] = 0;
                }
            }
        }
    }

    public void printMatrix() {
        for (int column = 0; column < sizeOfMatrix; column++) {
            for (int row = 0; row < sizeOfMatrix; row++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
