public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        int left = 0, right = len - 1;
        while (left <= right){
            int mid = left + ((right - left)/2);
            if (A[mid] == target) return mid;
            // Left half is sorted.
            if (A[left] <= A[mid]){
                if (A[left] <= target && target < A[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            // Right half is sorted.
            else{
                if (target <= A[right] && target > A[mid]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

}