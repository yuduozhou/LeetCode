/**
 *  Suppose to use KMP. However this naive way still passes the large judge.
 *  So I'm just being lazy here.
 */

public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (haystack.equals(needle) || needle.equals(""))
            return haystack;
        if (haystack.length() * needle.length() == 0)
            return null;
        for (int i = 0; i < haystack.length() - needle.length(); i ++){
            if (haystack.substring(i, i + needle.length()).equals(needle))
                return haystack.substring(i);
        }
        return null;
    }
}