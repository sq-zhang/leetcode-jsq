/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 *
 * https://leetcode-cn.com/problems/pascals-triangle-ii/description/
 *
 * algorithms
 * Easy (59.12%)
 * Likes:    104
 * Dislikes: 0
 * Total Accepted:    34K
 * Total Submissions: 57.3K
 * Testcase Example:  '3'
 *
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 
 * 
 * 
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: [1,3,3,1]
 * 
 * 
 * 进阶：
 * 
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        res.add(1);
        int pre = 1;
        for(int i = 1;i <= rowIndex;i++) {
            for(int j = i - 1;j > 0;j--) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
            res.add(1);
        }

        return res;
    }
}
// @lc code=end

