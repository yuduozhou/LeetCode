public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> left = new Stack<Integer>();
        ArrayList<Integer> couples = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                left.push(i);
            }
            else if (c == ')'){
                if (!left.isEmpty()){
                    int l = left.pop();
                    couples.add(l);
                    couples.add(i);
                }
            }
        }
        if (couples.size() < 2){
            return 0;
        }
        Collections.sort(couples);
        int max = 0;
        int i = 0;
        int j = 0;
        while (j < couples.size()){
            if(couples.get(j) - couples.get(i) > j - i){
                max = (max > (j - i))? max : j-i;
                i = j;
            }
            else{
                j ++;
            }
        }
        max = (max > (j - i))? max : j-i;
        return max;
    }
}