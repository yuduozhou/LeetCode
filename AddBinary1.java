public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lenA = a.length();
        int lenB = b.length();
        if (lenA < 1 || lenB < 1) return "";
        if (lenA < lenB){
            String temp = a;
            a = b;
            b = temp;
        }
        lenA = a.length();
        lenB = b.length();
        if (isZero(b)) return a;
        ArrayList<Character> chars = new ArrayList<Character>();
        char carry = '0';
        int i;
        for (i = lenB - 1; i >= 0; i--){
            if (a.charAt(i + lenA - lenB) == '1' && b.charAt(i) == '1'){
                chars.add(carry);
                carry = '1';
            }
            else if (a.charAt(i + lenA - lenB) == '0' && b.charAt(i) == '0'){
                chars.add(carry);
                carry = '0';
            }
            else{                
                if (carry == '0'){
                    chars.add('1');
                }
                else {
                    chars.add('0');
                }
            }
        }

        for (i = lenA - lenB - 1; i >= 0; i--){
            if (a.charAt(i) == '0'){
                chars.add(carry);
                carry = '0';
            }
            else{
                if (carry == '0'){
                    chars.add('1');
                }
                else{
                    chars.add('0');
                    carry = '1';
                }
            }
        }
        if (carry == '1'){
            chars.add('1');
        }
        StringBuilder sb = new StringBuilder();
        for (i = chars.size() - 1; i >= 0; i --){
            sb.append(chars.get(i));
        }
        
        return sb.toString();


    }
    public boolean isZero(String s){
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '1'){
                return false;
            }
        }
        return true;
    }
}