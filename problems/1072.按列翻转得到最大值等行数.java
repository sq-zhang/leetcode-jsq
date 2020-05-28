/*
 * @lc app=leetcode.cn id=1072 lang=java
 *
 * [1072] 按列翻转得到最大值等行数
 *
 * https://leetcode-cn.com/problems/flip-columns-for-maximum-number-of-equal-rows/description/
 *
 * algorithms
 * Medium (44.69%)
 * Likes:    27
 * Dislikes: 0
 * Total Accepted:    1.7K
 * Total Submissions: 3.2K
 * Testcase Example:  '[[0,1],[1,1]]'
 *
 * 给定由若干 0 和 1 组成的矩阵 matrix，从中选出任意数量的列并翻转其上的 每个 单元格。翻转后，单元格的值从 0 变成 1，或者从 1 变为
 * 0 。
 * 
 * 返回经过一些翻转后，行上所有值都相等的最大行数。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[[0,1],[1,1]]
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 
 * 
 * 示例 2：
 * 
 * 输入：[[0,1],[1,0]]
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 
 * 
 * 示例 3：
 * 
 * 输入：[[0,0,0],[0,0,1],[1,1,0]]
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= matrix.length <= 300
 * 1 <= matrix[i].length <= 300
 * 所有 matrix[i].length 都相等
 * matrix[i][j] 为 0 或 1
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        Map<String ,Integer> maps = new HashMap<>();
        int res = 0, n = matrix.length, m = matrix[0].length;
        for(int i = 0;i < n;i++) {
            StringBuilder col = new StringBuilder();
            for(int j = 0;j < m;j++) {
                col.append((matrix[i][0] == 0) ? matrix[i][j] : matrix[i][j] ^ 1);
            }
            String colStr = col.toString();
            maps.put(colStr, maps.getOrDefault(colStr, 0) + 1);
            res = Math.max(res, maps.get(colStr));
        }
        return res;
    }
}
// @lc code=end

