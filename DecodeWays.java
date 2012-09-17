public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (s.equals("") || s.charAt(0) == '0'){            
            return 0;
        }
        if (s.length() == 1){
            return 1;
        }
        return count(s);
    }
    
    public int count(String s){
        int len = s.length();
        int[] code = new int[len];
        int[] dWays = new int[len];
        for (int i = 0; i < len; i++){
            code[i] = Integer.parseInt(s.substring(i, i + 1));
            // Avoid all zeros.
            if (code[i] == 0){
                if (code[i - 1] != 1 && code[i - 1] != 2){
                    return 0;
                }
            }
        }
        dWays[0] = (code[1] == 0)? 0 : 1;
        int temp = code[0] * 10 + code[1];
        dWays[1] = ( temp > 26 || temp % 10 == 0) ? 1 : 2;
        
        for (int i = 2; i < len; i++){
            int number = code[i - 1] * 10 + code[i];
            if (number % 10 == 0){
                dWays[i] = dWays[i - 2];
            }
            else if (number <= 26 && number > 10){
                dWays[i] = dWays[i - 1] + dWays[i - 2];
            }
            else{
                dWays[i] = dWays[i - 1];
            }
        }
        return dWays[len - 1];
    }    
}