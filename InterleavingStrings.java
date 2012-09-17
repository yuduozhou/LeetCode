public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();
        if (l3 != l1 + l2){
            return false;
        }
        if (s1.equals("") || s2.equals("")){
            return s2.equals(s3) || s1.equals(s3);
        }

        if (s1.charAt(l1 - 1) == s3.charAt(l3 - 1)){
            // s3.last == both s1.last and s2.last
            if (s2.charAt(l2 - 1) == s3.charAt(l3 - 1)) {
                return (isInterleave(s1.substring(0, l1 - 1), s2, s3.substring(0, l3 - 1)) ||
                        isInterleave(s1, s2.substring(0, l2 - 1), s3.substring(0, l3 - 1)));
            }
            // s3.last == s1.last
            else {
                return isInterleave(s1.substring(0, l1 - 1), s2, s3.substring(0, l3 - 1));
            }
        }
        // s3.last == s2.last
        else if (s2.charAt(l2 - 1) == s3.charAt(l3 - 1)) {
            return isInterleave(s1, s2.substring(0, l2 - 1), s3.substring(0, l3 - 1));
        }
        else {
            return false;
        }
    }
}