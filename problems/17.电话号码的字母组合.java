/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 *
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (51.65%)
 * Likes:    693
 * Dislikes: 0
 * Total Accepted:    108.1K
 * Total Submissions: 202.8K
 * Testcase Example:  '"23"'
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 * 
 */

// @lc code=start
class Solution {
    String[] maps = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        
        if (digits.length() == 0) {
            return res;
        }
        backtrace(digits, 0, new StringBuilder());
        return res;
    }

    private void backtrace(String digits, int i, StringBuilder sb) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String letters = maps[digits.charAt(i) - '0'];
        for(char c : letters.toCharArray()) {
            backtrace(digits, i + 1, sb.append(c));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
// @lc code=end

