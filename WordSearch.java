public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length;
        int n = board[0].length;
        if (m * n == 0 || m * n < word.length()) return false;
        // Initialize visted.
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j++){
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j++){
                if (existHelper(board, visited, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean existHelper(char[][] board, boolean[][] visited, int i, int j, String word, int k){
        if (board[i][j] != word.charAt(k)) return false;
        if (word.length() == k + 1) return true;
        visited[i][j] = true;
        k++;
        int m = board.length;
        int n = board[0].length;
        if (i > 0 && !visited[i - 1][j] && existHelper(board, visited, i - 1, j, word, k))
            return true;
        if (i < m - 1 && !visited[i + 1][j] && existHelper(board, visited, i + 1, j, word, k))
            return true;
        if (j > 0 && !visited[i][j - 1] && existHelper(board, visited, i, j - 1, word, k))
            return true;
        if (j < n - 1 && !visited[i][j + 1] && existHelper(board, visited, i, j + 1, word, k))
            return true;
        visited[i][j] = false;
        return false;
    }
}