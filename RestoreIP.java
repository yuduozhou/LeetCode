public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        exhaustIP(s, "", result, 4);
        return result;
    }
    public void exhaustIP(String s, String ip, ArrayList<String> result, int piece){
        if (piece == 1){
            if (isValid(s)){
                result.add(ip + s);
            }
            return;
        }
        for (int i = 1; i < 4 && i < s.length(); i++){
            String part = s.substring(0, i);
            if (isValid(part)){
                exhaustIP(s.substring(i), ip + part + ".", result, piece - 1);
            }
        }
    }
    
    public boolean isValid(String part){
        if (part.charAt(0) == '0') return part.length() == 1;
        try{
            int i = Integer.parseInt(part);
            return 0 <= i && i <= 255;
        }catch(Exception e){
            return false;
        }
    }
}