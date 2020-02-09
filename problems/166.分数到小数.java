/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 *
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal/description/
 *
 * algorithms
 * Medium (25.14%)
 * Likes:    98
 * Dislikes: 0
 * Total Accepted:    7.7K
 * Total Submissions: 30.3K
 * Testcase Example:  '1\n2'
 *
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 * 
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * 
 * 示例 1:
 * 
 * 输入: numerator = 1, denominator = 2
 * 输出: "0.5"
 * 
 * 
 * 示例 2:
 * 
 * 输入: numerator = 2, denominator = 1
 * 输出: "2"
 * 
 * 示例 3:
 * 
 * 输入: numerator = 2, denominator = 3
 * 输出: "0.(6)"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 0) {
            return null;
        }
        StringBuilder res = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            res.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        long mod = dividend % divisor;
        res.append(String.valueOf(dividend / divisor));
        if (mod == 0) {
            return res.toString();
        }
        res.append(".");
        Map<Long, Integer> maps = new HashMap<>();
        while(mod != 0) {
            if (maps.containsKey(mod)) {
                res.insert(maps.get(mod), "(");
                res.append(")");
                break;
            }
            maps.put(mod, res.length());
            mod *= 10;
            res.append(String.valueOf(mod / divisor));
            mod %= divisor;
        }

        return res.toString();
    }
        
}
// @lc code=end

