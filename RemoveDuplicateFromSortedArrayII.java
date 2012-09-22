public class Solution {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int i = 0, int j = 1;
        boolean seen
        for(; j < A.length; j ++){
            if (A[j] != A[j - 1]) {
                A[++i] = A[j];
                seen = false;
            }
            else if(!seen){
                A[++i] = A[j];
                seen = true;
            }
        }
       return ++i;
    }
}