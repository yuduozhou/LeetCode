// Done via NextPermutation
public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [] num = new int[n];
        for (int i = 1; i <= n; i ++){
            num[i - 1] = i;
        }
        int j = 1;
        while (j < k){
            nextPermutation(num);
            j++;
        }
        String result = "";
        for (int i : num){
            result += i;
        }
        return result;
    }
      public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = num.length;
        for (int i = n - 1; i >= 1; i--) {
            if (num[i] > num[i-1]) {
                //swap the 2 numbers
                swapRange(num, i, n-1);
                for (int j = i; j < n; j++) {
                    if (num[j]>num[i-1]) {
                        swap(num, i-1, j);
                        return;
                    }
                }
            }
        }
        //swap each pair
        swapRange(num, 0, n-1);
    }
 
    public void swapRange(int[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swap(num, i, j);
        }
    }
 
    public void swap(int[] num, int i, int j) {
        if (num[i] == num[j]) return;
        num[i] = num[i]^num[j];
        num[j] = num[i]^num[j];
        num[i] = num[i]^num[j];
    }
}


// Magic way by heartfire.cc
// What's him doing?
public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
 
        if (n==1) {
            return "1";
        }
        int fac = 1; //n-1 factorial
        for (int i = 1; i <= n-1; i++) {
            fac *= i;
        }
 
        StringBuilder sb = new StringBuilder();
 
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            used[i] = false;
        }
 
        k--; //k starting from 1 is messing things up
        for (int i = 0; i < n; i++) {
            int d = k/fac + 1; //d-th available number
            int j = 0;
            for (; j < n; j++) {
                if (used[j] == false) {
                    d--;
                }
                if (d == 0) {
                    break;
                }
            }
            used[j] = true;
            sb.append(j+1);
            if (i < n-1) {
                k = k%fac;
                fac = fac/(n-1-i);
            }
        }
        return sb.toString();
    }
}