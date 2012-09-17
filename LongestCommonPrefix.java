public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (strs.length == 0){
    		return "";
    	}
    	String prefix = strs[0];
    	if (strs.length == 1){
    		return prefix;
    	}
        for (int i = 1; i < strs.length; i++){
            prefix = CommonPrefix(prefix, strs[i]);
            if (prefix == "")
                return prefix;
        }
    	return prefix;
    }
    
    public String CommonPrefix(String a, String b){
    	int la= a.length();
		int lb = b.length();
		int limit = (la < lb)? la : lb;
		for (int i= 0; i < limit; i++){
			if(a.charAt(i) != b.charAt(i)){
				return a.substring(0, i);
			}
		}
		return a.substring(0, limit);
	}
}