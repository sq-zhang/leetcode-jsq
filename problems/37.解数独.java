/*
 * @lc app=leetcode.cn id=37 lang=java
 *
 * [37] 解数独
 *
 * https://leetcode-cn.com/problems/sudoku-solver/description/
 *
 * algorithms
 * Hard (58.37%)
 * Likes:    403
 * Dislikes: 0
 * Total Accepted:    26.8K
 * Total Submissions: 43.8K
 * Testcase Example:  '[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]'
 *
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * 
 * 一个数独的解法需遵循如下规则：
 * 
 * 
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 
 * 
 * 空白格用 '.' 表示。
 * 
 * 
 * 
 * 一个数独。
 * 
 * 
 * 
 * 答案被标成红色。
 * 
 * Note:
 * 
 * 
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10], cols = new boolean[9][10], boxs = new boolean[9][10];
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxs[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }
        backtrace(board, rows, cols, boxs, 0, 0);
    }

    private boolean backtrace(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] boxs, int i, int j) {
        if (j == board[0].length) {
            j = 0;
            i++;
            if (i == board.length) {
                return true;
            }
        }
        if (board[i][j] != '.') {
            return backtrace(board, rows, cols, boxs, i, j + 1);
        }
        for(int num = 1;num <= 9;num++) {
            int boxIndex = (i / 3) * 3 + j / 3;
            if (!(rows[i][num] || cols[j][num] || boxs[boxIndex][num])) {
                rows[i][num] = true;
                cols[j][num] = true;
                boxs[boxIndex][num] = true;
                board[i][j] = (char)(num + '0');
                if (backtrace(board, rows, cols, boxs, i, j + 1)) {
                    return true;
                }
                rows[i][num] = false;
                cols[j][num] = false;
                boxs[boxIndex][num] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }
}
// @lc code=end

