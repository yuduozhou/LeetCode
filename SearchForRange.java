public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int s = 0, e = n - 1;
        int[] result = new int[]{-1, -1};
        while (s <= e){
            int middle = (e + s) /2;
            if (A[middle] < target){
                s = middle + 1;
            }
            else if (A[middle] > target){
                e = middle - 1;
            }
            else{
                result[0] = middle;
                result[1] = middle;
                // use binary expand here to optimize to total from O(n) to O(lgn)
                for(int i = middle - 1; i >=0; i--){
                    if (A[i] == target){
                        result[0] = i;
                    }
                }
                for(int i = middle + 1; i < n; i++){
                    if (A[i] == target){
                        result[1] = i;
                    }
                }
                return result;
            }            
        }
        return result;        
    }
}