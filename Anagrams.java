import java.util.*;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, ArrayList<Integer>> ruler = new HashMap<String, ArrayList<Integer>>();

        for (int i = 0; i < strs.length; i ++){
            ArrayList<Integer> temp =  new ArrayList<Integer>();
            String hash = hashWord(strs[i]);
            if (ruler.containsKey(hash)){
                temp = ruler.get(hash);
            }
            temp.add(i);
            ruler.put(hash, temp);

        }

        Iterator it = ruler.entrySet().iterator(); 
        while(it.hasNext()) { 
            Map.Entry me = (Map.Entry)it.next();
            ArrayList<Integer> values = (ArrayList<Integer>) me.getValue();
            if (values.size() > 1){
                for (int index = 0; index < values.size(); index ++){
                    result.add(strs[values.get(index)]);
                }
            }
        }
        return result;
    }
    
    public String hashWord(String word){
        int[] letters = new int[26];
        for (int i = 0; i < 26; i ++) {
            letters[i] = 0;
        }
        for (int i = 0; i < word.length(); i++) {
            int index = (int) word.charAt(i) - 97;
            letters[index] ++;
        }
        String result = "";
        for (int i: letters){
            result += i + "/";
        }
        return result;
    }
}
