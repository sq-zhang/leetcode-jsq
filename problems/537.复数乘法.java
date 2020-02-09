/*
 * @lc app=leetcode.cn id=537 lang=java
 *
 * [537] 复数乘法
 *
 * https://leetcode-cn.com/problems/complex-number-multiplication/description/
 *
 * algorithms
 * Medium (66.90%)
 * Likes:    23
 * Dislikes: 0
 * Total Accepted:    4K
 * Total Submissions: 5.9K
 * Testcase Example:  '"1+1i"\n"1+1i"'
 *
 * 给定两个表示复数的字符串。
 * 
 * 返回表示它们乘积的字符串。注意，根据定义 i^2 = -1 。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "1+1i", "1+1i"
 * 输出: "0+2i"
 * 解释: (1 + i) * (1 + i) = 1 + i^2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "1+-1i", "1+-1i"
 * 输出: "0+-2i"
 * 解释: (1 - i) * (1 - i) = 1 + i^2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
 * 
 * 
 * 注意:
 * 
 * 
 * 输入字符串不包含额外的空格。
 * 输入字符串将以 a+bi 的形式给出，其中整数 a 和 b 的范围均在 [-100, 100] 之间。输出也应当符合这种形式。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String complexNumberMultiply(String a, String b) {
        // (a1+b1i)*(a2+b2i) = a1a2-b1b2+(a1b2+a2b1)i
        int[] num1 = getComplexNumber(a);
        int[] num2 = getComplexNumber(b);
        int i = num1[0] * num2[0] - num1[1] * num2[1];
        int j = num1[0] * num2[1] + num1[1] * num2[0];
        return i + "+" + j + "i";
    }

    private int[] getComplexNumber(String a) {
        String[] nums = a.split("\\+");
        return new int[]{Integer.valueOf(nums[0]), 
            Integer.valueOf(nums[1].substring(0, nums[1].length() - 1))};
    }
}
// @lc code=end

