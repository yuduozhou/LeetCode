public class Solution {
    public static int number;
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        number = 0;
        int[] sol = new int[n];
        placeQueen(sol, 0);
        return number;
    }
    public void placeQueen(int[] sol, int row) {
        int n = sol.length;
        if (row == n) {
            number++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(sol, row, i)) {
                sol[row] = i;
                placeQueen(sol, row + 1);
            }
        }
    }
    public boolean check(int[] sol, int row, int col) {
        //check col and diag
        for (int i = 0; i < row; i++) {
            if (sol[i] == col) {
                return false;
            }
            if (row-i == Math.abs(col-sol[i])) {
                return false;
            }
        }
        return true;
    }
}