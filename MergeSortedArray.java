public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (B.length < 1) return;
        int endA = m - 1;
        int endB = n - 1;
        for (int end = m + n - 1; end >= 0; end --){
            if (endB < 0) return;
            if (get(A, endA) > get(B, endB)){
                A[end] = A[endA];
                endA --;                
            }
            else{
                A[end] = B[endB];
                endB --;
            }
        }
    }
    public int get(int[] A, int i){
        if (i < A.length && i >= 0) return A[i];
        return Integer.MIN_VALUE;
    }
}