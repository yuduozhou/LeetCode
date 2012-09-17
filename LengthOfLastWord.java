public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() < 1){
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = 0;
        boolean flag = false;
        for (int i = chars.length - 1; i >=0; i--){
            if (chars[i] == ' '){
                if(flag){
                    return len;
                }
                len = 0;
            }
            if (chars[i] != ' '){
                flag = true;
                len ++;
            }
        }
        return len;
    }
}