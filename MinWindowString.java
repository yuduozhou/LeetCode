import java.util.*;
public class Solution {
    public String minWindow(String S, String T) {
       // Start typing your Java solution below
        // DO NOT write main() function
        
        // Validate input.
        int n = S.length();
        int m = T.length();
        if(n < m || n * m == 0){
            return "";
        }
        HashMap<String, Integer> target = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        String[] t = new String[m];   
        String[] s = new String[n];   
        for (int i = 0; i < n; i++){
            s[i] = S.substring(i, i+1);
        }
        for (int i = 0; i < m; i++){
            t[i] = T.substring(i, i+1);
            if(target.containsKey(t[i])){
                target.put(t[i],  target.get(t[i]) + 1);
            }
            else{
                target.put(t[i], 1);
            }
        }
        int count = 0, i = 0, j = 0;
        int[] min = new int[]{0, n};

        while (j < n){
            if (target.containsKey(s[j])){
                if (found.containsKey(s[j])){
                    if (found.get(s[j]) < target.get(s[j])){
                        count ++;
                    }
                    found.put(s[j], found.get(s[j]) +1 );
                }
                else {
                    found.put(s[j], 1);
                    count ++;
                }
                if (count == m){
                    while (i <= j){
                        if (found.containsKey(s[i])){
                            found.put(s[i], found.get(s[i]) -1);
                            if (found.get(s[i]) + 1 == target.get(s[i])) {
                                count --;
                                if (j - i < min[1] - min[0]) {
                                min[0] = i;
                                min[1] = j;
                                }
                            i ++;
                            break;
                            }
                        }
                        i++;
                    }
                }
            }
            j++;
        }
        if(min[1] == n){
            return    "";
        }
        return S.substring(min[0], min[1] + 1);
    }
}