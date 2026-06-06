import java.util.*;

class Main {
    public static void reverse(int[] matrix) {
        int i = 0, j = matrix.length - 1;

        while (i <= j) {
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(Arrays.deepToString(rotate(matrix1)));
    }
}