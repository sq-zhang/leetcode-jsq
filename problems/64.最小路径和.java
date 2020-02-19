/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (63.49%)
 * Likes:    342
 * Dislikes: 0
 * Total Accepted:    46.9K
 * Total Submissions: 73.9K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 
 * 说明：每次只能向下或者向右移动一步。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;i++) {
            for(int j = 1;j <= n;j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
                } else if (j == 1) {
                    dp[i][j] = dp[i - 1][j] + grid[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
// @lc code=end

