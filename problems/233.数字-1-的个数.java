/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 *
 * https://leetcode-cn.com/problems/number-of-digit-one/description/
 *
 * algorithms
 * Hard (31.40%)
 * Likes:    85
 * Dislikes: 0
 * Total Accepted:    4.4K
 * Total Submissions: 13.9K
 * Testcase Example:  '13'
 *
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 
 * 示例:
 * 
 * 输入: 13
 * 输出: 6 
 * 解释: 数字 1 出现在以下数字中: 1, 10, 11, 12, 13 。
 * 
 */

// @lc code=start
class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            res += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0), i);
        }
        return res;
    }
}
// @lc code=end

