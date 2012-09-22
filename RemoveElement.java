public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A.length == 0) return 0;
        int slow = 0, fast = 0;
        while(fast < A.length){
            if(A[fast] != elem){
                A[slow] = A[fast];
                slow ++;
            }
            fast ++;
        }
        return slow ++;
    }
}