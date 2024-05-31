import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MatrixMultiplier {
    private final int[][] resultMatrix;
    private final int[][] matrixA;
    private final int[][] matrixB;
    private final int numRowsA;
    private final int numColsA;
    private final int numColsB;

    public MatrixMultiplier(int[][] matrixA, int[][] matrixB) {
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.numRowsA = matrixA.length;
        this.numColsA = matrixA[0].length;
        this.numColsB = matrixB[0].length;
        this.resultMatrix = new int[numRowsA][numColsB];
    }

    public int[][] multiply() {
        ExecutorService executor = Executors.newFixedThreadPool(numRowsA);

        for (int i = 0; i < numRowsA; i++) {
            final int row = i;
            executor.submit(() -> computeRow(row));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return resultMatrix;
    }

    private void computeRow(int row) {
        for (int col = 0; col < numColsB; col++) {
            int sum = 0;
            for (int k = 0; k < numColsA; k++) {
                sum += matrixA[row][k] * matrixB[k][col];
            }
            resultMatrix[row][col] = sum;
        }
    }
}

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] matrixB = {
            {7, 8},
            {9, 10},
            {11, 12}
        };

        MatrixMultiplier multiplier = new MatrixMultiplier(matrixA, matrixB);
        int[][] result = multiplier.multiply();

        // Print the result matrix
        for (int[] row : result) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
