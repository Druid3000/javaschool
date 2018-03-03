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

        //TODO Переименовать i в row, а j в cells, кажется так.
        for (int j = 0; j < sizeOfMatrix; j++) {
            for (int i = 0; i < sizeOfMatrix; i++) {
                if (i == j || j == (sizeOfMatrix - 1 - i)) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
