public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result = 0;
        boolean neg = x < 0;
        if (neg) x = -x;
        while(x > 0){
            int digit = x % 10;
            result = result * 10 + digit;
            x /= 10;
        }
        if (neg) result = - result;
        result = (result > Integer.MAX_VALUE) ? Integer.MAX_VALUE : result;
        result = (result < Integer.MIN_VALUE) ? Integer.MIN_VALUE : result;
        return result;
    }
}