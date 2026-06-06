import java.util.*;

class Main {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int srow = 0, erow = n - 1, scol = 0, ecol = m - 1;
        List<Integer> res = new ArrayList<>();

        while (srow <= erow && scol <= ecol) {
            for (int j = scol; j <= ecol; j++) {
                res.add(matrix[srow][j]);
            }
            for (int i = srow + 1; i <= erow; i++) {
                res.add(matrix[i][ecol]);
            }
            for (int j = ecol - 1; j >= scol; j--) {
                if (srow == erow) {
                    break;
                }
                res.add(matrix[erow][j]);
            }
            for (int i = erow - 1; i >= srow + 1; i--) {
                if (scol == ecol) {
                    break;
                }
                res.add(matrix[i][scol]);
            }
            srow++;
            scol++;
            erow--;
            ecol--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(spiralOrder(matrix1));
    }
}