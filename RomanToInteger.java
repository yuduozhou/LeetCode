public class Solution {
    private HashMap<Character, Integer> map;
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        map = new HashMap<Character, Integer>();
    	map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
        int result = 0;
        for (int i = 0; i < s.length(); i++){
            result += sign(s, i) * map.get(s.charAt(i));
        }
        return result;
    }
    
    public int sign(String s, int i){
        if (i == s.length() - 1) return 1;
        if (map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) return -1;
        return 1;
    }