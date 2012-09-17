public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length < 1) return false;
        if (A.length == 1) return true;
        int marker = A.length - 1;
        for (int i = A.length - 2; i >=0; i--){
            if(A[i] >= marker - i){
                marker = i;
            }
        }
        return marker == 0;
    }
}