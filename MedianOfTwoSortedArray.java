public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
         
        int m = A.length, n = B.length;
         
        //if m+n is even, then the median is the average of (m+n)/2 and (m+n)/2 - 1
        //if m+n is odd, then the median is (m+n)/2
 
        int mid = (m+n)/2;
        //look for mid in A
        //[start, end]: close region to try. inclusive.
        int start = 0, end = m-1, i = 0, j = 0;
        int median = 0;
        while (start <= end) {
            i = (start+end)/2;
            j = mid - i;
            if (get(B, j-1) <= get(A, i) && get(A, i) <= get(B, j)) //index out of bound here.
            {
                median = get(A, i);
                break;
            }
            else if (get(A, i)< get(B, j-1)) { //A[i] is smaller than the median
                start = i + 1;
                i = (start+end)/2;
                j = mid - i;
            }
            else if (get(A, i) > get(B, j)) { //A[i] is bigger than the median
                end = i - 1;
                i = (start+end)/2;
                j = mid - i;
            }
        }
         
        if (start <= end) //found the median
        {
            if ((m+n) % 2 == 0) { //index out of bound here
                int other = Math.max(get(A, i-1), get(B, j-1));
                return (median + other) * 0.5;
            }
            else {
                return (double)median;
            }
        }
        else { //not found the median
            //look for median in B
            return findMedianSortedArrays(B, A);
        }
    }
 
    public int get(int[] a, int i){
        if (i < 0) {
            return Integer.MIN_VALUE;
        }
        else if ( i >= a.length) {
            return Integer.MAX_VALUE;
        }
        else {
            return a[i];
        }
    }
}