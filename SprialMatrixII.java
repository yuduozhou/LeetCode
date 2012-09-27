public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[][] mat = new int[n][n];
		generateMatrix(mat, n, 1, 0, n);
		return mat;
    }
	public void generateMatrix(int[][] mat, int n, int x, int i, int len) {
		if (x > n*n) {
			return;
		}
		if (x == n*n) {
			mat[i][i] = n*n;
			return;
		}

		//top
		for (int k = i; k < len+i; k++) {
			mat[i][k] = x;
			x++;
		}

		//right
		for (int k = i+1; k < len+i-1; k++) {
			mat[k][len+i-1] = x;
			x++;
		}

		//bot
		if (len > 1) {
			for (int k = len+i-1; k >= i; k--) {
				mat[len+i-1][k] = x;
				x++;
			}

			//left
			for (int k = len+i-2; k > i; k--) {
				mat[k][i] = x;
				x++;
			}
		}

		generateMatrix(mat, n, x, i+1, len-2);
	}
}
