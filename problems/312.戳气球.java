/*
 * @lc app=leetcode.cn id=312 lang=java
 *
 * [312] 戳气球
 *
 * https://leetcode-cn.com/problems/burst-balloons/description/
 *
 * algorithms
 * Hard (56.52%)
 * Likes:    177
 * Dislikes: 0
 * Total Accepted:    6.4K
 * Total Submissions: 11.2K
 * Testcase Example:  '[3,1,5,8]'
 *
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的
 * left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 * 
 * 求所能获得硬币的最大数量。
 * 
 * 说明:
 * 
 * 
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 
 * 
 * 示例:
 * 
 * 输入: [3,1,5,8]
 * 输出: 167 
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxCoins(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        nums = appendWithBorder(nums);

        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = n - 2; i > -1; i--) {
            for (int j = i + 2; j < n; j++) {
                int max = 0, muitij = nums[i] * nums[j];
                for (int k = i + 1; k < j; k++) {
                    max = Math.max(max, dp[i][k] + dp[k][j] + nums[k] * muitij);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][n - 1];
    }

    private int[] appendWithBorder(int[] nums) {
        int[] res = new int[nums.length + 2];
        res[0] = 1;
        res[nums.length + 1] = 1;
        for(int i = 0;i < nums.length;i++) {
            res[i + 1] = nums[i];
        }
        return res;
    }
}
// @lc code=end

