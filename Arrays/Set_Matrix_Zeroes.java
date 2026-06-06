import java.util.*;
class Main{
    //Brute-Force
    public static int[][] setZeroesBrute(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        int [][]temp=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                temp[i][j]=matrix[i][j];
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    for(int k=0;k<m;k++){
                        temp[i][k]=0;
                    }
                    for(int k=0;k<n;k++){
                        temp[k][j]=0;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=temp[i][j];
            }
        }
        return matrix;
    }

    //Optimized
    public static int[][] setZeroesOptimized(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        boolean[]row=new boolean[n];
        boolean[]col=new boolean[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]||col[j]){
                    matrix[i][j]=0;
                }
            }
        }
        return matrix;
    }
    public static void main(String[] args) {
        int[][]matrix1={{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(Arrays.deepToString(setZeroesBrute(matrix1)));

        int[][]matrix2={{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(Arrays.deepToString(setZeroesOptimized(matrix2)));
    }
}