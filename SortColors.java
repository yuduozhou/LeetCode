public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        int red = 0;
        int white = n - 1;
        int i = 0;
        while(i < n){
            int temp = -1;
            if(A[i] == 0){
                if (i < red){
                    i ++;
                    continue;
                }
                temp = A[red];
                A[red] = A[i];
                A[i] = temp;
                red++;
            }
            else if (A[i] == 2 && i < white){
                temp = A[white];
                A[white] = A[i];
                A[i] = temp;
                white--;                
            }
            else{
                i++;
            }
        }
    }
}