/*
 * @lc app=leetcode.cn id=395 lang=java
 *
 * [395] 至少有K个重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/description/
 *
 * algorithms
 * Medium (41.34%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    6K
 * Total Submissions: 14.8K
 * Testcase Example:  '"aaabb"\n3'
 *
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * s = "aaabb", k = 3
 * 
 * 输出:
 * 3
 * 
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入:
 * s = "ababbc", k = 2
 * 
 * 输出:
 * 5
 * 
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || k > n) {
            return 0;
        }
        if (k < 2) {
            return n;
        }

        return maxSub(s.toCharArray(), k, 0, n - 1);
    }

    private int maxSub(char[] chars, int k, int i, int j) {
        if (j - i + 1 < k) {
            return 0;
        }
        int[] counts = new int[26];
        for(int l = i;l <= j;l++) {
            counts[chars[l] - 'a']++;
        }
        while(j - i + 1 >= k && counts[chars[i] - 'a'] < k) {
            i++;
        }
        while(j - i + 1 >= k && counts[chars[j] - 'a'] < k) {
            j--;
        }
        if (j - i + 1 < k) {
            return 0;
        }
        for(int l = i;l <= j;l++) {
            if (counts[chars[l] - 'a'] < k) {
                return Math.max(maxSub(chars, k, i, l - 1), maxSub(chars, k, l + 1, j));
            }
        }

        return j - i + 1;
    }
}
// @lc code=end

