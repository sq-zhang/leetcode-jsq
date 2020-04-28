/*
 * @lc app=leetcode.cn id=861 lang=java
 *
 * [861] 翻转矩阵后的得分
 *
 * https://leetcode-cn.com/problems/score-after-flipping-matrix/description/
 *
 * algorithms
 * Medium (73.12%)
 * Likes:    65
 * Dislikes: 0
 * Total Accepted:    4.5K
 * Total Submissions: 6.1K
 * Testcase Example:  '[[0,0,1,1],[1,0,1,0],[1,1,0,0]]'
 *
 * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 * 
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 * 
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 * 
 * 返回尽可能高的分数。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * 输出：39
 * 解释：
 * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] 是 0 或 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        for(int i = 0;i < m;i++) {
            if (A[i][0] == 0) {
                for(int j = 0;j < n;j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        for(int j = 0;j < n;j++) {
            int count = 0;
            for(int i = 0;i < m;i++) {
                count += A[i][j] == 0 ? 1 : 0;
            }
            if (count > m / 2) {
                for(int i = 0;i < m;i++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }

        int res = 0;
        for(int i = 0;i < m;i++) {
            int num = 0;
            for(int j = 0;j < n;j++) {
                num += A[i][j] * (1 << (n - 1 - j));
            }
            res += num;
        }
        return res;
    }

}
// @lc code=end

