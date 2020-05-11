/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 *
 * https://leetcode-cn.com/problems/reorganize-string/description/
 *
 * algorithms
 * Medium (37.81%)
 * Likes:    75
 * Dislikes: 0
 * Total Accepted:    6.6K
 * Total Submissions: 16.1K
 * Testcase Example:  '"aab"'
 *
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * 
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 * 
 * 示例 1:
 * 
 * 
 * 输入: S = "aab"
 * 输出: "aba"
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: S = "aaab"
 * 输出: ""
 * 
 * 
 * 注意:
 * 
 * 
 * S 只包含小写字母并且长度在[1, 500]区间内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        int n = S.length();
        for(char c : S.toCharArray()) {
            counts[c - 'a'] += 100;
        }
        for(int i = 0;i < 26;i++) {
            counts[i] += i;
        }
        Arrays.sort(counts);
        char[] res = new char[n];
        int k = 1;
        for(int i = 0;i < 26;i++) {
            char c = (char)((counts[i] % 100) + 'a');
            int count = counts[i] / 100;
            if (count > (n + 1) / 2) {
                return "";
            }
            for(int j = 0;j < count;j++) {
                if (k >= n) {
                    k = 0;
                }
                res[k] = c;
                k += 2;
            }
        }
        return String.valueOf(res);
    }
}
// @lc code=end

