/*
 * @lc app=leetcode.cn id=440 lang=java
 *
 * [440] 字典序的第K小数字
 *
 * https://leetcode-cn.com/problems/k-th-smallest-in-lexicographical-order/description/
 *
 * algorithms
 * Hard (30.03%)
 * Likes:    54
 * Dislikes: 0
 * Total Accepted:    1.9K
 * Total Submissions: 6.2K
 * Testcase Example:  '13\n2'
 *
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 * 
 * 注意：1 ≤ k ≤ n ≤ 10^9。
 * 
 * 示例 :
 * 
 * 
 * 输入:
 * n: 13   k: 2
 * 
 * 输出:
 * 10
 * 
 * 解释:
 * 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findKthNumber(int n, int k) {
        int prefix = 1, curPos = 1;
        while(curPos < k) {
            long count = getCount(prefix, n);
            if (curPos + count > k) {
                prefix *= 10;
                curPos++;
            } else {
                prefix++;
                curPos += count;
            }
        }
        return prefix;
    }

    private long getCount(int prefix, int n) {
        long count = 0;
        for(long i = prefix, j = prefix + 1;i <= n;i *= 10, j*= 10) {
            count += Math.min(n + 1, j) - i;
        }
        return count;
    }
}
// @lc code=end

