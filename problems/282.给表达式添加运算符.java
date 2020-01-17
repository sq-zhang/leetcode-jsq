/*
 * @lc app=leetcode.cn id=282 lang=java
 *
 * [282] 给表达式添加运算符
 *
 * https://leetcode-cn.com/problems/expression-add-operators/description/
 *
 * algorithms
 * Hard (30.29%)
 * Likes:    58
 * Dislikes: 0
 * Total Accepted:    1.5K
 * Total Submissions: 4.8K
 * Testcase Example:  '"123"\n6'
 *
 * 给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
 * 
 * 示例 1:
 * 
 * 输入: num = "123", target = 6
 * 输出: ["1+2+3", "1*2*3"] 
 * 
 * 
 * 示例 2:
 * 
 * 输入: num = "232", target = 8
 * 输出: ["2*3+2", "2+3*2"]
 * 
 * 示例 3:
 * 
 * 输入: num = "105", target = 5
 * 输出: ["1*0+5","10-5"]
 * 
 * 示例 4:
 * 
 * 输入: num = "00", target = 0
 * 输出: ["0+0", "0-0", "0*0"]
 * 
 * 
 * 示例 5:
 * 
 * 输入: num = "3456237490", target = 9191
 * 输出: []
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        dfs(num, target, "", 0, 0, 0, res);
        return res;
    }

    private void dfs(String num, int target, String cur, int pos, long eval, long mult, List<String> res) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(cur);
            }
            return;
        }
        for(int i = pos;i < num.length();i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long n = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                dfs(num, target, cur + n, i + 1, n, n, res);
            } else {
                dfs(num, target, cur + "+" + n, i + 1, eval + n, n, res);
                dfs(num, target, cur + "-" + n, i + 1, eval - n, -n, res);
                dfs(num, target, cur + "*" + n, i + 1, eval - mult + mult * n, mult * n, res);
            }
        }
    }
}
// @lc code=end

