public class Solution {
    public int jump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length <= 1) return 0;
        int len = A.length;
        int steps = 0;
        int marker = 0;
        // This will lead us to one step from the end.
        while (A[marker] < len - 1 - marker){
            int maxRange = marker + A[marker];
            int maxFrom = marker;
            for (int j = 1; j <= A[marker]; j++){
                if (j + marker >= len) break;
                if (A[marker + j] + marker + j > maxRange){
                    maxRange = A[marker + j] + marker + j;
                    maxFrom = marker + j;
                }
            }
            marker = maxFrom;
            steps++;
        }
        // Jump the last step.
        return steps + 1;
    }
}