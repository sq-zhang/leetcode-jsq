/*
 * @lc app=leetcode.cn id=859 lang=java
 *
 * [859] 亲密字符串
 *
 * https://leetcode-cn.com/problems/buddy-strings/description/
 *
 * algorithms
 * Easy (27.40%)
 * Likes:    65
 * Dislikes: 0
 * Total Accepted:    8.5K
 * Total Submissions: 30.8K
 * Testcase Example:  '"ab"\n"ba"'
 *
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false
 * 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 
 * 
 * 示例 2：
 * 
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 
 * 
 * 示例 3:
 * 
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 
 * 
 * 示例 4：
 * 
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 
 * 
 * 示例 5：
 * 
 * 输入： A = "", B = "aa"
 * 输出： false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        Set<Character> chars = new HashSet<>();
        Character lastA = null, lastB = null;
        boolean duplicate = false;
        int k = 0;
        for(int i = 0;i < A.length();i++) {
            if (chars.contains(A.charAt(i))) {
                duplicate = true;
            } else {
                chars.add(A.charAt(i));
            }

            if (A.charAt(i) != B.charAt(i)) {
                if (k == 0) {
                    lastA = A.charAt(i);
                    lastB = B.charAt(i);
                } else if (k == 1) {
                    if (lastA != B.charAt(i) || lastB != A.charAt(i)) {
                        return false;
                    }
                } else {
                    return false;
                }
                k++;
            }
        }

        return (k == 0 && duplicate) || k == 2;
    }
}
// @lc code=end

