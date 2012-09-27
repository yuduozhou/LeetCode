public class Solution {
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for (int i = 0; i < A.length; i ++){
            if (A[i] == target) return true;
        }
        return false;
    }
}