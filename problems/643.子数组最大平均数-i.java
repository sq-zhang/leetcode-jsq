/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 *
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/description/
 *
 * algorithms
 * Easy (36.27%)
 * Likes:    61
 * Dislikes: 0
 * Total Accepted:    8.6K
 * Total Submissions: 23.6K
 * Testcase Example:  '[1,12,-5,-6,50,3]\n4'
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 
 * 示例 1:
 * 
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 * 
 * 
 * 注意:
 * 
 * 
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]。
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double res = 0;
        int i = 0;
        for(;i < nums.length && i < k;i++) {
            res += nums[i];
        }
        double last = res;
        while(i < nums.length) {
            last = last + nums[i] - nums[i - k];
            res = Math.max(res, last);
            i++;
        }
        
        return res / k;
    }
}
// @lc code=end

