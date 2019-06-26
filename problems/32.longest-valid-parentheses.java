/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */
class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        int i = 0, max = 0;
        while (i < s.length()) {
            int left = 0, right = 0, j = i, nextI = i + 1;
            while(j < s.length() && left >= right) {
                if (s.charAt(j++) == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left == right) {
                    max = Math.max(max, j - i);
                    nextI = j;
                }
            }
            i = nextI;
        }
        return max;
    }
}

