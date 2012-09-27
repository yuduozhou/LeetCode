public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix.length == 0) {
        	return new ArrayList<Integer>();
		}
		return spiralOrder(matrix, 0, 0, matrix.length, matrix[0].length);
    }
    public ArrayList<Integer> spiralOrder(int[][] matrix, int x, int y, int m, int n)  {
    	ArrayList<Integer> seq = new ArrayList<Integer>();

		if (m <= 0 || n <= 0) {
			return seq;	
		}

		//be careful of the 4 corners, do not duplicate them
		//top side
		for (int j = y; j < y+n; j++) {
			seq.add(matrix[x][j]);
		}
		//right side
		for (int i = x+1; i < x+m-1; i++) {
			seq.add(matrix[i][y+n-1]);
		}

		//bot side
		if (m > 1) {
			for (int j = y+n-1; j >= y; j--) {
				seq.add(matrix[x+m-1][j]);
			}
		}

		//left side
		if (n > 1) {
			for (int i = x+m-2; i > x; i--) {
				seq.add(matrix[i][y]);
			}
		}
		seq.addAll(spiralOrder(matrix, x + 1, y + 1, m - 2, n - 2));

		return seq;
	}
}