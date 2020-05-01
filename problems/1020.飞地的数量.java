/*
 * @lc app=leetcode.cn id=1020 lang=java
 *
 * [1020] 飞地的数量
 *
 * https://leetcode-cn.com/problems/number-of-enclaves/description/
 *
 * algorithms
 * Medium (48.04%)
 * Likes:    18
 * Dislikes: 0
 * Total Accepted:    3.3K
 * Total Submissions: 6.5K
 * Testcase Example:  '[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]'
 *
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 * 
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * 
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释： 
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 
 * 示例 2：
 * 
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：
 * 所有 1 都在边界上或可以到达边界。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * 所有行的大小都相同
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numEnclaves(int[][] A) {
        int m = A.length, n = A[0].length;
        for(int i = 0;i < m;i++) {
            if (A[i][0] == 1) {
                dfs(A, i, 0);
            }
            if (A[i][n - 1] == 1) {
                dfs(A, i, n - 1);
            }
        }

        for(int i = 0;i < n;i++) {
            if (A[0][i] == 1) {
                dfs(A, 0, i);
            }
            if (A[m - 1][i] == 1) {
                dfs(A, m - 1, i);
            }
        }

        int res = 0;
        for(int i = 1;i < m - 1;i++) {
            for(int j = 1;j < n - 1;j++) {
                if (A[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(int[][] nums, int x, int y) {
        if (x >= 0 && y >= 0 && x < nums.length && y < nums[0].length
            && nums[x][y] == 1) {
            nums[x][y] = 0;
            dfs(nums, x - 1, y);
            dfs(nums, x, y - 1);
            dfs(nums, x + 1, y);
            dfs(nums, x, y + 1);
        }
    }
}
// @lc code=end

