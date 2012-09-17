public class Solution {
    public HashMap<Integer, String[]> Dict = new HashMap<Integer, String[]>();
    public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        if (digits.equals("")){
            result.add("");
            return result;
        }
        initialDictionary();
        result = printAllCombination(digits);
        return result;
    }
    
    public ArrayList<String> printAllCombination(String digits){
        ArrayList<String> result = new ArrayList<String>();
        if (digits.length() == 1){
            Integer number = Integer.parseInt(digits);
            String[] temp = Dict.get(number);
            for (String s : temp){
                result.add(s);
            }
            return result;
        }
        Integer pivot = Integer.parseInt(digits.substring(0, 1));
        String remains = digits.substring(1);
        String[] temp = Dict.get(pivot);
        for (String s : temp){
            for (String p : printAllCombination(remains)){
                result.add(s + p);
            }
        }
        return result;        
    }
    
    public void initialDictionary(){
        Dict.put(2, new String[]{"a", "b", "c"});
        Dict.put(3, new String[]{"d", "e", "f"});
        Dict.put(4, new String[]{"g", "h", "i"});
        Dict.put(5, new String[]{"j", "k", "l"});
        Dict.put(6, new String[]{"m", "n", "o"});
        Dict.put(7, new String[]{"p", "q", "r", "s"});
        Dict.put(8, new String[]{"t", "u", "v"});
        Dict.put(9, new String[]{"w", "x", "y", "z"});
    }
}