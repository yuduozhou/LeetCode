public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] perm = new int[num.length];
        boolean[] used = new boolean[num.length];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        Arrays.sort(num);
        permute(num, 0, perm, used, result);
        return result;
    }
 
    public void permute(int[] num, int level, int[] perm, boolean[] used, ArrayList<ArrayList<Integer>> result){
        if (num.length == level) {
            ArrayList<Integer> x = new ArrayList<Integer>();
            for (int i = 0; i < perm.length; i++) {
                x.add(perm[i]);
            }
             result.add(x);
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[level] = num[i];
                permute(num, level+1, perm, used, result);
                used[i] = false;
                while (i + 1 < num.length && num[i + 1] == num[i]){
                   i++;
                }
            }
        }
    }
}