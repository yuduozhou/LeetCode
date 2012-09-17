public class Solution {
    public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        boolean neg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (neg) {
                return -1 + divide(dividend + b, b);
            }
            else {
                return 1 - divide(dividend + b, b);
            }
        }
        int product = b, result = 0;
        while (a >= b) {
            int q = 1;
            while (a - product >= product) {
                q = q << 1;
                product = product << 1;
            }
            a = a - product;
            product = b;
            result += q;
        }
        return (neg) ? -result : result;
    }
}