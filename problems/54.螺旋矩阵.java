/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (37.82%)
 * Likes:    262
 * Dislikes: 0
 * Total Accepted:    35.2K
 * Total Submissions: 92.5K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return res;
        }
        int n = matrix[0].length;
        int k = 0, count = m * n, i = 0, j = 0;
        int r = n - 1, l = 0, u = 0, d = m - 1;
        char dir = 'R';
        while(k++ < count) {
            res.add(matrix[i][j]);
            if (dir == 'R') {
                if (j == r) {
                    dir = 'D';
                    u++;
                    i++;
                } else {
                    j++;
                }
            } else if (dir == 'L') {
                if (j == l) {
                    dir = 'U';
                    d--;
                    i--;
                } else {
                    j--;
                }
            } else if (dir == 'U') {
                if (i == u) {
                    dir = 'R';
                    l++;
                    j++;
                } else {
                    i--;
                }
            } else if (dir == 'D') {
                if (i == d) {
                    dir = 'L';
                    r--;
                    j--;
                } else {
                    i++;
                }
            }
        }

        return res;
    }
}
// @lc code=end

