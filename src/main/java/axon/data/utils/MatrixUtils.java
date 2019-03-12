package axon.data.utils;

public final class MatrixUtils {
    public static void flipAndInvert(final int[][] matrix) {
        final int m = matrix.length;
        final int n = matrix[0].length;
        for (final int[] row : matrix) {
            for (int i = 0; i < (n + 1) / 2; i++) {
                int temp = row[i] ^ 1;
                row[i] = row[n - 1 - i] ^ 1;
                row[n - 1 - i] = temp;
            }
        }
    }
}