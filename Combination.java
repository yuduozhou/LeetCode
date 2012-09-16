public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return findCombine(n, k);
        
    }
    
    public ArrayList<ArrayList<Integer>> findCombine(int n, int k){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (k == 1){
            for (int i = 1; i <=n; i++){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                result.add(temp);
            }
            return result;
        }
        else{
            for (int m = n; m >0; m--){
                for (ArrayList<Integer> al : findCombine(m - 1, k - 1)){
                    al.add(m);
                    result.add(al);
                }
            }
            return result;
        }
        
    }
}