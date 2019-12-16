/*
 * @lc app=leetcode.cn id=301 lang=java
 *
 * [301] 删除无效的括号
 *
 * https://leetcode-cn.com/problems/remove-invalid-parentheses/description/
 *
 * algorithms
 * Hard (44.13%)
 * Likes:    84
 * Dislikes: 0
 * Total Accepted:    4.1K
 * Total Submissions: 9.3K
 * Testcase Example:  '"()())()"'
 *
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 * 
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 * 
 * 示例 1:
 * 
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 
 * 
 * 示例 2:
 * 
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 
 * 
 * 示例 3:
 * 
 * 输入: ")("
 * 输出: [""]
 * 
 */

// @lc code=start
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        List<String> res = new ArrayList<>();
        dfs(s, left, right, new StringBuilder(s), 0, res);
        return res;
    }

    private void dfs(String s, int l, int r, StringBuilder sb, int start, List<String> res) {
        if (l == 0 && r == 0 && isValid(sb.toString())) {
            res.add(sb.toString());
            return;
        }

        for(int i = start;i < s.length();i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                if (r > 0 && s.charAt(i) == ')') {
                    dfs(sb.toString(), l ,r - 1, sb, i, res);
                } else if (l > 0 && s.charAt(i) == '(') {
                    dfs(sb.toString(), l - 1, r, sb, i, res);
                }
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }
            if (c == ')') {
                count--;
            }
            if(count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
// @lc code=end

