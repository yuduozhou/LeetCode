public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n == 0) return 1;
        if (n == 1) return x;
        boolean neg = false;
        if (n < 0) {
            neg = true;
            n *= -1;
        }
        double result = pow(x, n >> 1);
        result *= result;
        if ((n & 0x1) == 1)
            result *= x;
        if (neg)
            result = 1/result;
        return result;
    }
}