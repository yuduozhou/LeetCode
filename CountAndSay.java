public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String result = "1";
    	for (int i = 0; i < n-1; i++) {
			result = sayIt(result);
		}
		return result;
    }

	public String sayIt(String s) {
		StringBuilder buf = new StringBuilder();
        int length = s.length();
		for (int i = 0; i < length; i++) {
			int count = 1;
			while (i + 1 < length && s.charAt(i + 1) == s.charAt(i)) {
				i++;
				count++;
			}
			buf.append(String.valueOf(count) + String.valueOf(s.charAt(i)));
		}	
		return buf.toString();
	}
}