public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        int l = 0;
        int r = 0;
        int n = s.length();
        int max = 0;
        while (r < n){
            String curr = s.substring(r, r + 1);
            if(visited.containsKey(curr)){
                l = visited.get(curr) + 1;
                r = l;
                visited.clear();
                continue;
            }
            else{
                visited.put(curr, r);
                r ++;
            }
            max = ((r - l) > max) ? (r - l) : max;
        }
        return max;
    }
}