/**
 Thanks to heartfire.cc.
 Use the ¡°max area under a histogram¡± algorithm as a building block. For each row in
 the 2D matrix, we suppose the potential max rectangle ends at this row, and call the 
¡° max area under a histogram¡± algorithm. The heights for each column should be the 
 number of ¡¯1¡äs after the last seen ¡¯0¡ä for that column.

 This is the optimal solution. Time complexity O(n^2).
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
    	if (matrix.length == 0) {
			return 0;
		}
		int m = matrix.length, n = matrix[0].length, max = 0;
		int[] heights = new int[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					heights[j]++;
				}
				else {
					heights[j] = 0;
				}
			}

			max = Math.max(max, maxHistoArea(heights));
		}

		return max;
    }

	public int maxHistoArea(int[] heights) {
		class Ele {
			int h;
			int i;
			public Ele (int h, int i) {
				this.h = h;
				this.i = i;
			}
		}	

		Stack<Ele> st = new Stack<Ele>();
		int max = 0, i = 0;

		for (i = 0; i < heights.length; i++) {
			if (st.empty() || heights[i] > st.peek().h) {
				st.push(new Ele(heights[i], i));
			}
			else if (heights[i] < st.peek().h) { //ignore the equal case
				int prev = 0;
				while (!st.empty() && heights[i] < st.peek().h) {
					Ele e = st.pop();
					prev = e.i;
					max = Math.max(max, e.h * (i - e.i));
				}
				st.push(new Ele(heights[i], prev));
			}
		}

		while (!st.empty()) {
			Ele e = st.pop();
			max  = Math.max(max, e.h * (i - e.i));
		}

		return max;
	}
}