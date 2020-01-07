/*
 * @lc app=leetcode.cn id=306 lang=java
 *
 * [306] 累加数
 *
 * https://leetcode-cn.com/problems/additive-number/description/
 *
 * algorithms
 * Medium (31.51%)
 * Likes:    45
 * Dislikes: 0
 * Total Accepted:    3.3K
 * Total Submissions: 10.4K
 * Testcase Example:  '"112358"'
 *
 * 累加数是一个字符串，组成它的数字可以形成累加序列。
 * 
 * 一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 * 
 * 给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。
 * 
 * 说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * 
 * 示例 1:
 * 
 * 输入: "112358"
 * 输出: true 
 * 解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * 
 * 
 * 示例 2:
 * 
 * 输入: "199100199"
 * 输出: true 
 * 解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
 * 
 * 进阶:
 * 你如何处理一个溢出的过大的整数输入?
 * 
 */

// @lc code=start
class Solution {
    public boolean isAdditiveNumber(String num) {
        return dfs(num, 0, 0, 0, 0);
    }

    private boolean dfs(String num, long presum, long prenum, int i, int k) {
        if (k > 2 && i >= num.length()) {
            return true;
        }
        for(int len = 1;len + i <= num.length();len++) {
            long pre = isSum(presum, num, i, i + len - 1, k);
            if (pre >= 0) {
                if (dfs(num, pre + prenum, pre, i + len, k + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private long isSum(long sum, String num, int l, int h, int k) {
        if (num.charAt(l) == '0' && l < h) {
            return -1;
        }
        long res = 0;
        while(l <= h) {
            res = res * 10 + num.charAt(l++) - '0';
        }
        if (k < 2) {
            return res;
        }
        return res == sum ? res : -1;
    }
}
// @lc code=end

