/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 *
 * https://leetcode-cn.com/problems/valid-perfect-square/description/
 *
 * algorithms
 * Easy (42.72%)
 * Likes:    85
 * Dislikes: 0
 * Total Accepted:    21.6K
 * Total Submissions: 50.4K
 * Testcase Example:  '16'
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * 
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * 
 * 示例 1：
 * 
 * 输入：16
 * 输出：True
 * 
 * 示例 2：
 * 
 * 输入：14
 * 输出：False
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1, r = num;
        while(l <= r) {
            long mid = l + (r - l) / 2;
            long sq = mid * mid;
            if (sq == num) {
                return true;
            } else if (sq < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
// @lc code=end

