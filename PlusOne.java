public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = digits.length;
        int carry = 1;
        for (int i = len - 1; i >=0; i--){
            int digit = digits[i] + carry;
            digits[i] = digit % 10;
            carry = digit / 10;
            if (carry == 0) return digits;
        }
        int[] result = new int[len + 1];
        result[0] = 1;
        for (int i = 0; i < len; i++){
            result[i + 1] = digits[i];
        }
        return result;
    }
}