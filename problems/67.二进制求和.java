/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 *
 * https://leetcode-cn.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (51.53%)
 * Likes:    276
 * Dislikes: 0
 * Total Accepted:    53.5K
 * Total Submissions: 103.6K
 * Testcase Example:  '"11"\n"1"'
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * 
 * 输入为非空字符串且只包含数字 1 和 0。
 * 
 * 示例 1:
 * 
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 
 * 示例 2:
 * 
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * 
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, flag = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0 || flag > 0) {
            if (i >= 0) {
                flag += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                flag += b.charAt(j--) - '0';
            }
            res.append(flag % 2);
            flag /= 2;
        }

        return res.reverse().toString();
    }
}
// @lc code=end

