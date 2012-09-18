public class Solution {
    public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n1 = num1.length(), n2 = num2.length();
        int n3 = n1 + n2;
        int[] num3 = new int[n3];
        for (int i = n1 - 1; i >= 0; i--) {
            int carry = 0, j, t;
            for (j = n2 - 1; j >= 0; j--) {
                t = carry + num3[i + j + 1] +
                    Character.getNumericValue(num1.charAt(i)) *
                    Character.getNumericValue(num2.charAt(j));
                num3[i + j + 1] = t % 10;
                carry = t / 10;
            }
            num3[i + j + 1] = carry;
        }
        String res = "";
        int i = 0;
        while (i < n3-1 && num3[i] == 0) i++;
        while (i < n3) res += num3[i++];
        return res;
    }
}