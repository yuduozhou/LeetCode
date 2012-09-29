// Can not pass the large judge and I have no idea how to improve this.
public class Solution {
    public boolean isMatch(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() == 0) {
            if (p.length() == 0) return true;
            if (p.charAt(0) == '*') return isMatch(s, p.substring(1));
			return false;
		}
        if (p.length() == 0) return false;
        if (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0))
            return isMatch(s.substring(1), p.substring(1));
        if (p.charAt(0) == '*'){
            int i = 0;
            while(i < p.length() && p.charAt(i) == '*')
                i ++;
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(i));
        }
		return false;
	}
}