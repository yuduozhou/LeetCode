// Thanks to http://heartfire.cc
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num); 
        int[] backtrack = new int[num.length+1];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        backtrack[0] = -1;
        solve (num, 0, target, backtrack, result, 0);
        return result;
    }
 
    public void solve(int[] num, int sum, int target, int[] backtrack, ArrayList<ArrayList<Integer>> result, int n){
        //backtrack records the indexes in num array
        //what is my next number's index? start trying from backtrack[n] + 1 to num's end
        if (target == sum) {
            //add everything in backtrack to result
            ArrayList<Integer> ret = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                ret.add(num[backtrack[i]]);
            }
            result.add(ret);
        }
        if (target < sum) {
            return;
        }
        for (int i = backtrack[n] + 1; i < num.length; i++) {
            backtrack[n+1] = i; 
            solve(num, sum+num[i], target, backtrack, result, n+1);
 
            while (i+1 < num.length && num[i+1] == num[i]) {
                i++;
            }
        }
    }
}