public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = A.length;
        int left = 0, right = len - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (A[mid] == target) return mid;
            // Right half.
            if (A[mid] < target){
                left = mid + 1;
            }
            // Left half.
            else{
                right = mid - 1;
            }
        }
        return left;
    }
}