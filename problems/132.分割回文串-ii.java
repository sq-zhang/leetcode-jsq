/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 *
 * https://leetcode-cn.com/problems/palindrome-partitioning-ii/description/
 *
 * algorithms
 * Hard (40.69%)
 * Likes:    77
 * Dislikes: 0
 * Total Accepted:    5.6K
 * Total Submissions: 13.9K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回符合要求的最少分割次数。
 * 
 * 示例:
 * 
 * 输入: "aab"
 * 输出: 1
 * 解释: 进行一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 
 * 
 */

// @lc code=start
class Solution {

    private int res = Integer.MAX_VALUE;

    public int minCut(String s) {
        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n];
        for(int i = 0;i < n;i++) {
            dp[i] = i;
        }
        boolean[][] checkPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (i - j <= 2 || 
                    checkPalindrome[j + 1][i - 1])) {
                    checkPalindrome[j][i] = true;
                }
            }
        }

        for(int i = 1;i < n;i++) {
            if (checkPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }

            for(int j = 0;j < i;j++) {
                if (checkPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
// @lc code=end

