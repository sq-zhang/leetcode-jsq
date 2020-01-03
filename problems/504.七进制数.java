/*
 * @lc app=leetcode.cn id=504 lang=java
 *
 * [504] 七进制数
 *
 * https://leetcode-cn.com/problems/base-7/description/
 *
 * algorithms
 * Easy (47.30%)
 * Likes:    29
 * Dislikes: 0
 * Total Accepted:    7.6K
 * Total Submissions: 16K
 * Testcase Example:  '100'
 *
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * 
 * 示例 1:
 * 
 * 
 * 输入: 100
 * 输出: "202"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: -7
 * 输出: "-10"
 * 
 * 
 * 注意: 输入范围是 [-1e7, 1e7] 。
 * 
 */

// @lc code=start
class Solution {
    public String convertToBase7(int num) {
        StringBuilder res = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        } else if (num == 0) {
            return res.append("0").toString();
        }
        while(num > 0) {
            res.append(num % 7);
            num /= 7;
        }

        if (negative) {
            res.append("-");
        }

        return res.reverse().toString();
    }
}
// @lc code=end

