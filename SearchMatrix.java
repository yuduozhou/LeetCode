public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        int n = matrix[0].length;
        int s = 0, e = m - 1, middle = 0;
        while (s <= e){
            middle = (int) Math.floor((s + e)/2);
            int left = matrix[middle][0];
            int right =  matrix[middle][n - 1];
            if (left > target){
                e = middle - 1;
            }
            else if (right < target){
                s = middle + 1;
            }
            else{
                break;
            }
        }
        for (int i = 0; i < n; i ++){
            if (matrix[middle][i] == target){
                return true;
            }                    
        }
        return false;
    }
}