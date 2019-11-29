/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 *
 * https://leetcode-cn.com/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (75.35%)
 * Likes:    127
 * Dislikes: 0
 * Total Accepted:    19.8K
 * Total Submissions: 26.3K
 * Testcase Example:  '3'
 *
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 8, 9, 4 ],
 * ⁠[ 7, 6, 5 ]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n]; 
        int i = 0, j = 0;
        int l = 0, r = 0, u = 0, d = 0;
        char direction = 'R';
        for(int k = 1;k <= n * n;k++) {
            res[i][j] = k;
            if (direction == 'R') {
                j++;
                if (j == n - 1 - r) {
                    direction = 'D';
                    u++;
                }
            } else if (direction == 'L') {
                j--;
                if (j == l) {
                    direction = 'U';
                    d++;
                }
            } else if (direction == 'U') {
                i--;
                if (i == u) {
                    direction = 'R';
                    l++;
                }
            } else if (direction == 'D') {
                i++;
                if (i == n - 1 - d) {
                    direction = 'L';
                    r++;
                }
            }
        }

        return res;
        
    }
}
// @lc code=end

