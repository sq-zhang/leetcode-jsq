/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (27.38%)
 * Likes:    3686
 * Dislikes: 356
 * Total Accepted:    570.4K
 * Total Submissions: 2.1M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
class Solution {

    private int maxM, maxN, max = 0;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        for(int i = 0;i < s.length() - 1;i++) {
            expendPalindromic(s, i, i);
            expendPalindromic(s, i, i + 1);
        }
        return s.substring(maxM, maxN);
    }

    private void expendPalindromic(String s, int m, int n) {
        while (m >= 0 && n < s.length() && s.charAt(m) == s.charAt(n)) {
            m -= 1;
            n += 1;
        }
        if (n - m - 1 > max) {
            max = n - m - 1;
            maxM = m + 1;
            maxN = n;
        }
    }
}

