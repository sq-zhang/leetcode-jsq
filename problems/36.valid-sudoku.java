import java.util.HashSet;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> cells = new HashSet<>();

        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (!cells.add(c + "in R" + i) || 
                    !cells.add(c + "in C" + j) ||
                    !cells.add(c + "in R" + i / 3 + "C" + j / 3)) {
                        return false;
                    }
            }
        }
        return true;
    }
}

