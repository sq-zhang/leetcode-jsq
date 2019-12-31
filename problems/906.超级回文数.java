/*
 * @lc app=leetcode.cn id=906 lang=java
 *
 * [906] 超级回文数
 *
 * https://leetcode-cn.com/problems/super-palindromes/description/
 *
 * algorithms
 * Hard (20.16%)
 * Likes:    11
 * Dislikes: 0
 * Total Accepted:    701
 * Total Submissions: 3.4K
 * Testcase Example:  '"4"\n"1000"'
 *
 * 如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。
 * 
 * 现在，给定两个正整数 L 和 R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：L = "4", R = "1000"
 * 输出：4
 * 解释：
 * 4，9，121，以及 484 是超级回文数。
 * 注意 676 不是一个超级回文数： 26 * 26 = 676，但是 26 不是回文数。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= len(L) <= 18
 * 1 <= len(R) <= 18
 * L 和 R 是表示 [1, 10^18) 范围的整数的字符串。
 * int(L) <= int(R)
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int superpalindromesInRange(String L, String R) {
        long l = Long.valueOf(L), r = Long.valueOf(R);
        int res = 0, maxK = 100000;

        for(int i = 1;i < maxK;i++) {
            StringBuilder s = new StringBuilder(Integer.toString(i));
            for(int j = s.length() - 2;j >= 0;j--) {
                s.append(s.charAt(j));
            }
            long v = Long.valueOf(s.toString());
            v *= v;
            if (v > r) {
                break;
            }
            if (v >= l && isPalindrome(v)) {
                res++;
            }
        }

        for(int i = 1;i < maxK;i++) {
            StringBuilder s = new StringBuilder(Integer.toString(i));
            for(int j = s.length() - 1;j >= 0;j--) {
                s.append(s.charAt(j));
            }
            long v = Long.valueOf(s.toString());
            v *= v;
            if (v > r) {
                break;
            }
            if (v >= l && isPalindrome(v)) {
                res++;
            }
        }

        return res;
    }

    private boolean isPalindrome(long x) {
        long n = 0, y = x;
        while(x > 0) {
            n = 10 * n + x % 10;
            x /= 10;
        }
        return n == y;
    }
}
// @lc code=end

