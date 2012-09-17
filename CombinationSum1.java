public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        //reverse the array
        for (int i = 0; i < candidates.length/2; i++) {
            int temp = candidates[i];
            candidates[i] = candidates[candidates.length-1-i];
            candidates[candidates.length-1-i] = temp;
        }
        return cs (candidates, target, 0);
    }
    public ArrayList<ArrayList<Integer>> cs (int[] candidates, int target, int index) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        if (index >= candidates.length) {
            return null;
        }
        for (int i = 0; candidates[index] * i <= target; i++) {
            ArrayList<ArrayList<Integer>> r = cs (candidates, target-candidates[index] * i, index + 1);
            if (r != null) {
                //add i candidates[index] to all of the arraylists
                for (int j = 0; j < r.size(); j++) {
                    for (int k = 0; k < i; k++) {
                        r.get(j).add(candidates[index]);
                    }
                }
                ret.addAll(r);
            }
        }
        return ret;
    }
}