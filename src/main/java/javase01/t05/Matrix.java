package javase01.t05;

public class Matrix {
    public static void main(String[] args) {

        int sizeOfMatrix;

        sizeOfMatrix = 11;

        //TODO Нужно проверять, является ли матрица квадратной
        //TODO и если нет, то чего-то с этим делать надо.

        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            matrix[i] = new int[sizeOfMatrix];
        }

        for (int column = 0; column < sizeOfMatrix; column++) {
            for (int row = 0; row < sizeOfMatrix; row++) {
                if (row == column || column == (sizeOfMatrix - 1 - row)) {
                    matrix[row][column] = 1;
                } else {
                    matrix[row][column] = 0;
                }
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
