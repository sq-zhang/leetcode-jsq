/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 *
 * https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/description/
 *
 * algorithms
 * Medium (57.32%)
 * Likes:    123
 * Dislikes: 0
 * Total Accepted:    4.2K
 * Total Submissions: 7.1K
 * Testcase Example:  '[3,10,5,25,2,8]'
 *
 * 给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 2^31 。
 * 
 * 找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
 * 
 * 你能在O(n)的时间解决这个问题吗？
 * 
 * 示例:
 * 
 * 
 * 输入: [3, 10, 5, 25, 2, 8]
 * 
 * 输出: 28
 * 
 * 解释: 最大的结果是 5 ^ 25 = 28.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int n = (Integer.toBinaryString(maxNum)).length();
        Set<Integer> prefix = new HashSet<>();
        int res = 0;
        for(int i = n - 1;i >= 0;i--) {
            res <<= 1;
            int cur = res | 1;
            prefix.clear();
            for(int num : nums) {
                prefix.add(num >> i);
            }
            for(int p : prefix) {
                if (prefix.contains(cur ^ p)) {
                    res = cur;
                    break;
                }
            }
        }
        return res;
    }
}
// @lc code=end

