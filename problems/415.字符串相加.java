/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 *
 * https://leetcode-cn.com/problems/add-strings/description/
 *
 * algorithms
 * Easy (48.26%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    18.4K
 * Total Submissions: 38K
 * Testcase Example:  '"0"\n"0"'
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 
 * 注意：
 * 
 * 
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, num = 0;
        while(i >= 0 || j >= 0 || num > 0) {
            if (i >= 0) {
                num += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                num += num2.charAt(j--) - '0';
            }
            res.append(String.valueOf(num % 10));
            num /= 10;
        }

        return res.reverse().toString();
    }
}
// @lc code=end

