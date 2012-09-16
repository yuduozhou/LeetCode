public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        Arrays.sort(candidates);
        combinationHelper(candidates, stack, result, target);
        return result;
    }
    
    public void combinationHelper(int[] candidates, Stack<Integer> stack, ArrayList<ArrayList<Integer>> result, int target){
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
        for (int i = 0; i < candidates.length; i ++){
            stack.push(candidates[i]);
            combinationHelper(candidates, stack, result, target - candidates[i]);
            stack.pop();
        }
    }
}