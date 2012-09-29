import java.util.*;
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int SIZE = board.length;
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Character> validator = new HashSet<Character>();
        // Row
        for (int i = 0; i < SIZE; i++){
            validator.clear();
            for (int j = 0; j < SIZE; j++){
                if (board[i][j] == '.') continue;
                if(validator.contains(board[i][j])) return false;
                validator.add(board[i][j]);
            }
        }
        // Column
        for (int j = 0; j < SIZE; j++){
            validator.clear();
            for (int i = 0; i < SIZE; i++){
                if (board[i][j] == '.') continue;
                if(validator.contains(board[i][j])) return false;
                validator.add(board[i][j]);
            }
        }

        for (int i = 0; i < SIZE; i += 3){
            for (int j = 0; j < SIZE; j += 3){
                validator.clear();
                for (int m = 0; m < 3; m ++){
                    for (int n = 0; n < 3; n ++){
                        if (board[i + m][j + n] == '.') continue;
                        if(validator.contains(board[i + m][j + n])) return false;
                        validator.add(board[i + m][j + n]);                        
                    }
                }
            }
        }
        return true;
    }
}