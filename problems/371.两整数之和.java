/*
 * @lc app=leetcode.cn id=371 lang=java
 *
 * [371] 两整数之和
 *
 * https://leetcode-cn.com/problems/sum-of-two-integers/description/
 *
 * algorithms
 * Easy (52.90%)
 * Likes:    177
 * Dislikes: 0
 * Total Accepted:    19.8K
 * Total Submissions: 37.2K
 * Testcase Example:  '1\n2'
 *
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * 
 * 示例 1:
 * 
 * 输入: a = 1, b = 2
 * 输出: 3
 * 
 * 
 * 示例 2:
 * 
 * 输入: a = -2, b = 3
 * 输出: 1
 * 
 */

// @lc code=start
class Solution {
    public int getSum(int a, int b) {
        if ((a & b) == 0) {
            return a | b;
        }
        return getSum(a ^ b, (a & b) << 1);
    }
}
// @lc code=end

