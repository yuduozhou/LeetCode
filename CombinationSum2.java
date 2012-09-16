public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        Arrays.sort(candidates);
        combinationHelper(candidates, stack, result, target, 0);
        return result;
    }
    
    public void combinationHelper(int[] candidates, Stack<Integer> stack, ArrayList<ArrayList<Integer>> result, int target, int start){
        if (target <= 0){
            if (target == 0){
                ArrayList<Integer> temp = new ArrayList<Integer>(stack);
                Collections.sort(temp);
                if (!result.contains(temp)){
                    result.add(temp);
                }
            }
            return;
        }
        if (start == candidates.length) return;
        for (int i = start; i < candidates.length; i ++){
            stack.push(candidates[i]);
            combinationHelper(candidates, stack, result, target - candidates[i], ++start);
            stack.pop();
        }

    }
}