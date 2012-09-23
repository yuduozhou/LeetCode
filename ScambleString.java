public class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n == 1) {
            return s1.equals(s2);
        }
        for (int i = 1; i <= s2.length()/2; i++) {
            String x1 = s1.substring(0, i);
            String y1 = s1.substring(n-i);
            String a1 = s1.substring(i);
            String b1 = s1.substring(0, n-i);
            String x2 = s2.substring(0, i);
            String y2 = s2.substring(n-i);
            String a2 = s2.substring(i);
            String b2 = s2.substring(0, n-i);
            // 0 -> i  vs 0 -> i && i -> n vs i -> n
            boolean r1 = isScramble(x1, x2) && isScramble(a1, a2);
            if (r1) return true;
            // 0 -> i vs n - i -> n && i -> n vs 0 -> n - i
            boolean r2 = isScramble(x1, y2) && isScramble(a1, b2);
            if (r2) return true;
            // n - i -> n vs 0 -> i && 0 -> n - i vs i -> n - i
            boolean r3 = isScramble(y1, x2) && isScramble(b1, a2);
            if (r3) return true;
            // n - i -> n vs n -i -> n && 0 -> n - i vs 0 -> i
            boolean r4 = isScramble(y1, y2) && isScramble(b1, b2);
            if (r4) return true;
        }
 
        return false;
    }
 
}