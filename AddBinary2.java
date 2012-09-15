// A much better solution.
public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1 = a.length(), l2 = b.length();
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        
        for (int i = 0; i < Math.max(l1, l2); i++) {
            int b1 = getBitAt(a, l1-1-i), b2 = getBitAt(b, l2-1-i);
            int sum = b1 + b2 + carry;
            sb.append(sum%2);
            carry = sum/2;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
    
    public int getBitAt(String s, int index) {
        if (index < 0) {
            return 0;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        else {
            return 1;
        }
    }
}