/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 *
 * https://leetcode-cn.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (64.99%)
 * Likes:    210
 * Dislikes: 0
 * Total Accepted:    50.6K
 * Total Submissions: 77.8K
 * Testcase Example:  '5'
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 5
 * 输出:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(new ArrayList<>());
        res.get(0).add(1);
        for(int i = 1;i < numRows;i++) {
            List<Integer> rows = new ArrayList<>();
            List<Integer> lastRow = res.get(i - 1);
            rows.add(1);
            for(int j = 1;j < lastRow.size();j++) {
                rows.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            rows.add(1);
            res.add(rows);
        }

        return res;
    }
}
// @lc code=end

