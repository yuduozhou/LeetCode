public class Solution {
    public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean xZero = false, yZero = false;
        int m = matrix.length, n = matrix[0].length;
        // record first row.
        for (int i = 0; i < n; i ++){
            if (matrix[0][i] == 0){
                xZero = true;
                break;
            }
        }
        // record first column.
        for (int j = 0; j < m; j ++){
            if (matrix[j][0] == 0){
                yZero = true;
                break;
            }
        }
        // bubble each zero element
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // Row-wise.
        for (int i = 1; i < m; i ++){
            if (matrix[i][0] == 0){
                for (int j = 1; j < n; j ++){
                    matrix[i][j] = 0;
                }
            }
        }
        // Column-wise.
        for (int j = 1; j < n; j ++){
            if (matrix[0][j] == 0){
                for (int i = 1; i < m; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        if (xZero){
            for (int j = 0; j < n; j++){
                matrix[0][j] = 0;
            }
        }
        if (yZero){
            for (int i = 0; i < m; i ++){    
                matrix[i][0] = 0;
            }
        }
        
    }
}