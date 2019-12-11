/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning/description/
 *
 * algorithms
 * Medium (64.23%)
 * Likes:    186
 * Dislikes: 0
 * Total Accepted:    17.4K
 * Total Submissions: 26.9K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回 s 所有可能的分割方案。
 * 
 * 示例:
 * 
 * 输入: "aab"
 * 输出:
 * [
 * ⁠ ["aa","b"],
 * ⁠ ["a","a","b"]
 * ]
 * 
 */

// @lc code=start
class Solution {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, new ArrayList<>());
        return res;
    }

    private void dfs(String s, List<String> result) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(result));
            return;
        }

        for(int i = 0;i < s.length();i++) {
            if (isPalindrome(s.substring(0, i + 1))) {
                List<String> tmp = new ArrayList<>(result);
                tmp.add(s.substring(0, i + 1));
                dfs(s.substring(i + 1), tmp);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

