/*
 * @lc app=leetcode.cn id=498 lang=java
 *
 * [498] 对角线遍历
 *
 * https://leetcode-cn.com/problems/diagonal-traverse/description/
 *
 * algorithms
 * Medium (39.14%)
 * Likes:    64
 * Dislikes: 0
 * Total Accepted:    8.8K
 * Total Submissions: 22.4K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * 
 * 解释:
 * 
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 给定矩阵中的元素总数不会超过 100000 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        System.out.println("m =" + m + " n = " + n);
        int i = 0, j = 0,k = 0;
        boolean up = true;
        while(k < m * n) {
            if (up) {
                while(i >= 0 && j < n) {
                    res[k++] = matrix[i][j];
                    i--;
                    j++;
                }
                i++;
                j--;
                if (j < n - 1) {
                    j++;
                } else {
                    i++;
                }
                up = false;
            } else {
                while(i < m && j >= 0) {
                    res[k++] = matrix[i][j];
                    i++;
                    j--;
                }
                i--;
                j++;
                if(i < m - 1) {
                    i++;
                } else {
                    j++;
                }
                up = true;
            }
        }

        return res;
    }
}
// @lc code=end

