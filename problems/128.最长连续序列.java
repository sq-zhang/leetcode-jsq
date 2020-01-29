/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 *
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/description/
 *
 * algorithms
 * Hard (46.94%)
 * Likes:    224
 * Dislikes: 0
 * Total Accepted:    23.4K
 * Total Submissions: 49.3K
 * Testcase Example:  '[100,4,200,1,3,2]'
 *
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 
 * 要求算法的时间复杂度为 O(n)。
 * 
 * 示例:
 * 
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> sets = new HashSet<Integer>();
        for (int num : nums) {
            sets.add(num);
        }
        int res = 0;
        for (int num : sets) {
            if (!sets.contains(num - 1)) {
                int ans = 1;
                while (sets.contains(num + 1)) {
                    num += 1;
                    ans += 1;
                }
                res = Math.max(res, ans);
            }
        }

        return res;
    }
}
// @lc code=end

