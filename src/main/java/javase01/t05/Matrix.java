package javase01.t05;

public class Matrix {
    public static void main(String[] args) {

        int sizeOfMatrix;

        sizeOfMatrix = 10;

        int[][] matrix = new int[sizeOfMatrix][sizeOfMatrix];

        //TODO Нужно проверять, является ли матрица квадратной
        //TODO и если нет, то чего-то с этим делать надо.

        for (int i = 0; i < sizeOfMatrix; i++) {
            matrix[i] = new int[sizeOfMatrix];
        }

        for (int j = 0; j < sizeOfMatrix; j++) {
            for (int i = 0; i < sizeOfMatrix; i++) {
                if (i == j || j == (sizeOfMatrix - 1 - i)) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < sizeOfMatrix; j++) {
            for (int i = 0; i < sizeOfMatrix; i++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
