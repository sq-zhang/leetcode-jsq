/*
 * @lc app=leetcode.cn id=479 lang=java
 *
 * [479] 最大回文数乘积
 *
 * https://leetcode-cn.com/problems/largest-palindrome-product/description/
 *
 * algorithms
 * Hard (30.32%)
 * Likes:    17
 * Dislikes: 0
 * Total Accepted:    1.2K
 * Total Submissions: 3.9K
 * Testcase Example:  '1'
 *
 * 你需要找到由两个 n 位数的乘积组成的最大回文数。
 * 
 * 由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。
 * 
 * 示例:
 * 
 * 输入: 2
 * 
 * 输出: 987
 * 
 * 解释: 99 x 91 = 9009, 9009 % 1337 = 987
 * 
 * 说明:
 * 
 * n 的取值范围为 [1,8]。
 * 
 */

// @lc code=start
class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }

        long max = (long) Math.pow(10, n) - 1;
        for(long i = max;i > max / 10;i--) {
            String s = String.valueOf(i);
            long res = Long.parseLong(s + new StringBuilder(s).reverse().toString());
            for(long j = max;j * j >= res;j--) {
                if(res % j == 0) {
                    return (int)(res % 1337);
                }
            }
        }

        return -1;
    }
}
// @lc code=end

