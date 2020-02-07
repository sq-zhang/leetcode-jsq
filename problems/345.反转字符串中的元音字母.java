/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 *
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/description/
 *
 * algorithms
 * Easy (48.38%)
 * Likes:    73
 * Dislikes: 0
 * Total Accepted:    22.9K
 * Total Submissions: 46.9K
 * Testcase Example:  '"hello"'
 *
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 
 * 示例 1:
 * 
 * 输入: "hello"
 * 输出: "holle"
 * 
 * 
 * 示例 2:
 * 
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 
 * 说明:
 * 元音字母不包含字母"y"。
 * 
 */

// @lc code=start
class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while(left < right) {
            while(left < right && !isVowel(chars[left])) {
                left++;
            }
            while(left < right && !isVowel(chars[right])) {
                right--;
            }
            if (left >= right) {
                break;
            }
            char c = chars[left];
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
        return new String(chars);
    }

    boolean isVowel(char c) {
        return c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' 
            || c == 'I' || c == 'o' || c == 'O' || c == 'u' || c == 'U';
    }
}
// @lc code=end

