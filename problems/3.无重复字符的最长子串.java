/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (32.17%)
 * Likes:    3060
 * Dislikes: 0
 * Total Accepted:    328.8K
 * Total Submissions: 1M
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] indexs = new int[128];
        Arrays.fill(indexs, -1);
        int res = 0, i = 0;
        for(int j = 0;j < s.length();j++) {
            char c = s.charAt(j);
            int index = c - 'a' + 65;
            if (indexs[index] >= 0) {
                res = Math.max(res, j - i);
                i = Math.max(i, indexs[index] + 1);
            }
            indexs[index] = j;
        }

        res = Math.max(res, s.length() - i);
        return res;
    }
}
// @lc code=end

