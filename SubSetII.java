// Both solution will solve both Subset I and Subset II.

/* Bit-wise */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int n = num.length;
        if (n == 0) {
			return result;
		}
    	Arrays.sort(num);
        int max = 1 << n;
        for (int i = 0; i < max; i++){
            int k = i;
            int j = 0;
            ArrayList<Integer> subset = new ArrayList<Integer>();
            while (k > 0){
                if((k & 0x0001) == 0x0001){
                    subset.add(num[j]);
                }
                k >>= 1;
                j ++;
            }
            if(!result.contains(subset))
                result.add(subset);
            /*  This while will skip uncessary computation.
                But will mess up the output order. */
            /*
            while(i + 1 < n && num[i + 1] == num[i]){
                i++;
            }
            */
        }
		return result;
    }
}

/* back-track */
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
    	// Start typing your Java solution below
		// DO NOT write main() function

		//almost the same backtrack algorithm of combination sum II
		if (num.length == 0) {
			return null;
		}
		Arrays.sort(num);
		int[] backtrack = new int[num.length+1];
		backtrack[0] = -1;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ss(num, result, 0, backtrack);
		return result;
	}

	//backtrack array contains the indexes
	public void ss(int[] num, ArrayList<ArrayList<Integer>> result, int pos, int[] backtrack) {
		ArrayList<Integer> x = new ArrayList<Integer>();
		for (int i = 1; i <= pos; i++) {
			x.add(num[backtrack[i]]);
		}
		result.add(x);
		for (int i = backtrack[pos] + 1; i < num.length; i++) {
			backtrack[pos + 1] = i;
			ss(num, result, pos + 1,  backtrack);
			while (i + 1 < num.length && num[i] == num[i + 1]) {
				i++;
			}
		}
	}
}