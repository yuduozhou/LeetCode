// Thanks to heartfire.cc
public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        //the following is an O(n2) solution, which is not optimal
        int[] max = new int[s.length()];
        //special case s.length() == 0
        if (s.length() == 0) {
            return new String();
        }
        //init to 0s
        for (int i = 0; i < s.length(); i++) {
            max[i] = 0;
        }
         //try for each possible center.
        for (int c = 0; c < s.length(); c++) {
            //the center is at c
            int l = c, r = c;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    max[c] = r - l + 1;
                }
                else {
                    break;
                }
                l--;
                r++;
            }
            //the center is between c and c+1
            l = c;
            r = c+1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    if (max[c] < r - l + 1) {
                        max[c] = r - l + 1;
                    }
                }
                else {
                    break;
                }
                l--;
                r++;
            }
        }
        //find the max
        int m = 0, index = 0;
        for (int i = 0 ; i < s.length(); i++) {
            if (m < max[i]) {
                m = max[i];
                index = i;
            }
        }
        return s.substring(index-(max[index] - 1)/2, index + max[index]/2 + 1);
    }
}