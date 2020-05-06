/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.54%)
 * Likes:    995
 * Dislikes: 0
 * Total Accepted:    122.9K
 * Total Submissions: 163.1K
 * Testcase Example:  '3'
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：n = 3
 * 输出：[
 * ⁠      "((()))",
 * ⁠      "(()())",
 * ⁠      "(())()",
 * ⁠      "()(())",
 * ⁠      "()()()"
 * ⁠    ]
 * 
 * 
 */

// @lc code=start
class Solution {
    private List<String>  res;
    
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        backtrace(n, n, new StringBuilder());
        return res;
    }

    private void backtrace(int left, int right, StringBuilder sb) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > 0) {
            backtrace(left - 1, right, sb.append("("));
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            backtrace(left, right - 1, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

