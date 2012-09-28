public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] table = new int[m][n];
        table[0][0] = 1;
        if (obstacleGrid[0][0] == 1) table[0][0] = 0;
        for (int i = 1; i < m; i ++){
            if (obstacleGrid[i][0] == 1) table[i][0] = 0;
            else table[i][0] = table[i - 1][0];
        }
        for (int j = 1; j < n; j ++){
            if (obstacleGrid[0][j] == 1) table[0][j] = 0;
            else table[0][j] = table[0][j - 1];
        }
        for (int i  = 1; i < m; i ++){
            for (int j = 1; j < n; j ++){
                if (obstacleGrid[i][j] == 1) table[i][j] = 0;
                else table[i][j] = table[i][j - 1] + table[i - 1][j];
            }
        }
        return table[m - 1][n - 1];
    }
}