/*
 * @lc app=leetcode.cn id=1139 lang=java
 *
 * [1139] 最大的以 1 为边界的正方形
 *
 * https://leetcode-cn.com/problems/largest-1-bordered-square/description/
 *
 * algorithms
 * Medium (38.92%)
 * Likes:    13
 * Dislikes: 0
 * Total Accepted:    2.1K
 * Total Submissions: 5K
 * Testcase Example:  '[[1,1,1],[1,0,1],[1,1,1]]'
 *
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回
 * 0。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 * 
 * 
 * 示例 2：
 * 
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length <= 100
 * 1 <= grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                boolean f1 = true;
                int cur = res;
                while(i + cur < m && j + cur < n) {
                    boolean f2 = true;
                    for(int k = i;k < i + cur + 1;k++) {
                        if (grid[k][j] == 0) {
                            f1 = false;
                            break;
                        }
                    }
                    if (f1 == false) {
                        break;
                    }
                    for(int k = j;k < j + cur + 1;k++) {
                        if (grid[i][k] == 0) {
                            f1 = false;
                            break;
                        }
                    }
                    if (f1 == false) {
                        break;
                    }
                    for(int k = i;k < i + cur + 1;k++) {
                        if (grid[k][j + cur] == 0) {
                            cur += 1;
                            f2 = false;
                            break;
                        }
                    }
                    if (f2 == false) {
                        continue;
                    }
                    for(int k = j;k < j + cur + 1;k++) {
                        if (grid[i + cur][k] == 0) {
                            f2 = false;
                            cur += 1;
                            break;
                        }
                    }
                    if (f2 == false) {
                        continue;
                    }
                    cur += 1;
                    res = cur;
                }
            }
        }
        return res * res;
    }
}
// @lc code=end

