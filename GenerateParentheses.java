public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<String> result = new ArrayList<String>();
        char[] parens = new char[n+n];
        gp (result, 0, 0, n, parens);
        return result;
    }
    
    public void gp(ArrayList<String> result, int left, int right, int n, char[] parens) {
        if (left == right && left == n) {
            result.add(new String(parens));
            return;
        }
        
        if (left < n) {
            parens[left + right] = '(';
            gp(result, left + 1, right, n, parens);
        }
        
        if (right < left) {
            parens[left + right] = ')';
            gp(result, left, right + 1, n, parens);
        }
    }
}