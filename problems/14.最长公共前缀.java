/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 *
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (35.36%)
 * Likes:    777
 * Dislikes: 0
 * Total Accepted:    151.3K
 * Total Submissions: 427.8K
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1:
 * 
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 
 * 
 * 说明:
 * 
 * 所有输入只包含小写字母 a-z 。
 * 
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        int i = 0;
        while(true) {
            char last;
            if (i < strs[0].length()) {
                last = strs[0].charAt(i);
            } else {
                return strs[0].substring(0, i);
            }
            for(String s : strs) {
                if (i >= s.length() || s.charAt(i) != last) {
                    return strs[0].substring(0, i);
                }
            }
            i++;
        }
    }
}
// @lc code=end

