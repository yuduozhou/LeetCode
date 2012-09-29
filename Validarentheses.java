public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> left = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ')'){
                if (left.empty() || left.pop() != '('){
                    return false;
                }                
            }
            else if (c == ']'){
               if (left.empty() || left.pop() != '['){
                    return false;
                }                
            }
            else if (c == '}'){
               if (left.empty() || left.pop() != '{'){
                    return false;
                }                
            }
            else{
                left.push(c);
            }
        }
        return left.empty();
    }
}