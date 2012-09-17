public class Solution {
    public int firstMissingPositive(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length < 1) return 1;
        int i = 0;
        for (i = 0; i < A.length; i++){
            while (A[i] > 0 && A[i] <= A.length && A[i] != i + 1 && A[A[i] - 1] != A[i]){
                int temp = A[i];
                A[i] = A[temp - 1];
                A[temp - 1] = temp;
            }
        }
        
        for (i = 0; i < A.length; i++){
            if (A[i] != i + 1)
                return i + 1;
        }
        return i + 1;
    }
}