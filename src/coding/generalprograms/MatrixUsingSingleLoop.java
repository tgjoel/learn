package coding.generalprograms;

public class MatrixUsingSingleLoop {
    public static void main(String[] args) {

        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println();
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        int rowSize = matrix.length;
        int columnSize = matrix[0].length;
        for (int i = 0; i < rowSize * columnSize; i++) {
            int rowIndex = i/columnSize;
            int columnIndex = i%columnSize;
            System.out.print(matrix[rowIndex][columnIndex] + " ");

        }
    }
}
