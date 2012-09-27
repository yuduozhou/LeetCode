public class Solution {
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (str.length() < 1) return 0;
        boolean neg = false;
        boolean overflow = false;
        int result = 0;
        int i = 0;
        while (i < str.length()){
            char c = str.charAt(i);
            if (Character.isWhitespace(c)){
                i ++;
            }
            else if(c == '-' || c == '+' || Character.isDigit(c)){
                break;
            }
            else{
                return 0;
            }
        }
        if (str.charAt(i) == '-'){
            neg = true;
            i ++;
        }
        else if (str.charAt(i) == '+'){
            i ++;
        }

        while (i < str.length()){
            char c = str.charAt(i);
            if (Character.isDigit(c)){
        		int x = Character.digit(c, 10);
                if ((Integer.MAX_VALUE - x)/10 >= result){
                    result = result * 10 + x;
                    i ++;
                }
                else{
                    overflow = true;
                    break;
                }
            }
            else{
                break;
            }
        }
        if (overflow){
            if (neg) return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
        return (neg) ? -result : result;
    }
}