/*
 * @lc app=leetcode.cn id=796 lang=java
 *
 * [796] 旋转字符串
 *
 * https://leetcode-cn.com/problems/rotate-string/description/
 *
 * algorithms
 * Easy (48.58%)
 * Likes:    56
 * Dislikes: 0
 * Total Accepted:    6.6K
 * Total Submissions: 13.5K
 * Testcase Example:  '"abcde"\n"cdeab"'
 *
 * 给定两个字符串, A 和 B。
 * 
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea'
 * 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * 
 * 
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 * 
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 * 
 * 注意：
 * 
 * 
 * A 和 B 长度不超过 100。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.equals(B)) {
            return true;
        }

        for(int i = 1;i <= A.length() - 1;i++) {
            if (B.equals(A.substring(i) + A.substring(0, i))) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end

