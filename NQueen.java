public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> ret = new ArrayList<String[]>();
        if (n <= 0) {
            return ret;
        }
        int[] sol = new int[n]; //the i-th element is the column number of the queen in the i-th row
        placeQueen(sol, 0, ret);
        return ret;
    }
 
    public void placeQueen(int[] sol, int row, ArrayList<String[]> ret) {
        int n = sol.length;
        if (row == n) {
            ret.add(transform(sol));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(sol, row, i)) {
                sol[row] = i;
                placeQueen(sol, row + 1, ret);
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
 
    public String[] transform(int[] sol){
        int n = sol.length;
        String[] ret = new String[n];   
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == sol[i]) {
                    sb.append("Q");
                }
                else {
                    sb.append(".");
                }
            }
            ret[i] = sb.toString();
        }
        return ret;
    }
}