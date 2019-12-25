/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 *
 * https://leetcode-cn.com/problems/word-search/description/
 *
 * algorithms
 * Medium (39.53%)
 * Likes:    267
 * Dislikes: 0
 * Total Accepted:    29.6K
 * Total Submissions: 74.6K
 * Testcase Example:  '[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"'
 *
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 
 * 示例:
 * 
 * board =
 * [
 * ⁠ ['A','B','C','E'],
 * ⁠ ['S','F','C','S'],
 * ⁠ ['A','D','E','E']
 * ]
 * 
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * 
 */

// @lc code=start
class Solution {
    private int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        for(int i = 0;i < board.length;i++) {
            for(int j = 0;j < board[0].length;j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int start) {
        if (word.length() - 1 == start) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            board[i][j] = '#';
            for(int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                    continue;
                }
                if (dfs(board, word, x, y, start + 1)) {
                    return true;
                }
            }
            board[i][j] = word.charAt(start);
        }

        return false;
    }
}
// @lc code=end

