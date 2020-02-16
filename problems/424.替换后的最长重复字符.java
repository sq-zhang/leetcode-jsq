/*
 * @lc app=leetcode.cn id=424 lang=java
 *
 * [424] 替换后的最长重复字符
 *
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (44.08%)
 * Likes:    65
 * Dislikes: 0
 * Total Accepted:    4.1K
 * Total Submissions: 9K
 * Testcase Example:  '"ABAB"\n2'
 *
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k
 * 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 
 * 注意:
 * 字符串长度 和 k 不会超过 10^4。
 * 
 * 示例 1:
 * 
 * 输入:
 * s = "ABAB", k = 2
 * 
 * 输出:
 * 4
 * 
 * 解释:
 * 用两个'A'替换为两个'B',反之亦然。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * s = "AABABBA", k = 1
 * 
 * 输出:
 * 4
 * 
 * 解释:
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int left = 0, right = 0;
        int charMax = 0;
        for (right = 0; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            charMax = Math.max(charMax, map[index]);
            if (right - left + 1 > charMax + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }
}
// @lc code=end

