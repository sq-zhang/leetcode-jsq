/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 *
 * https://leetcode-cn.com/problems/valid-number/description/
 *
 * algorithms
 * Hard (16.94%)
 * Likes:    65
 * Dislikes: 0
 * Total Accepted:    7.1K
 * Total Submissions: 42K
 * Testcase Example:  '"0"'
 *
 * 验证给定的字符串是否可以解释为十进制数字。
 * 
 * 例如:
 * 
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * " -90e3   " => true
 * " 1e" => false
 * "e3" => false
 * " 6e-1" => true
 * " 99e2.5 " => false
 * "53.5e93" => true
 * " --6 " => false
 * "-+3" => false
 * "95a54e53" => false
 * 
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 * 
 * 
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 
 * 
 * 当然，在输入中，这些字符的上下文也很重要。
 * 
 * 更新于 2015-02-10:
 * C++函数的形式已经更新了。如果你仍然看见你的函数接收 const char * 类型的参数，请点击重载按钮重置你的代码。
 * 
 */

// @lc code=start
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean hasPoint = false, hasE = false, number = false;
        for(int i = 0;i < s.length();i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                number = true;
            } else if (c == '.') {
                if (hasPoint || hasE) {
                    return false;
                }
                hasPoint = true;
            } else if (c == 'e') {
                if (hasE || !number) {
                    return false;
                }
                hasE = true;
                number = false;
            } else if (c == '-' || c == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return number;
    }
}
// @lc code=end

