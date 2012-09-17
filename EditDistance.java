public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function

        if (word1.equals(word2)) return 0;
        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;
        
        int[][] dist = new int[len1 + 1][len2 + 1];
        dist[0][0] = 0;
        for (int i = 1; i <= len1; i ++){
            dist[i][0] = i;
        }
        for (int j = 1; j <= len2; j ++){
            dist[0][j] = j;
        }
        for (int i = 1; i <= len1; i ++){
            for (int j = 1; j <= len2; j ++){
                dist[i][j] = findMin(
                    dist[i - 1][j] + 1, dist[i][j - 1] + 1,
                    dist[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1));
            }
        }
        return dist[len1][len2];
    }
    
    public int findMin(int ... num){
        int min = num[0];
        for (int i = 1; i < num.length; i ++){
            if (num[i] < min){
                min = num[i];
            }
        }
        return min;
    }
}