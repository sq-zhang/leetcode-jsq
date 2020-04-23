/*
 * @lc app=leetcode.cn id=689 lang=java
 *
 * [689] 三个无重叠子数组的最大和
 *
 * https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
 *
 * algorithms
 * Hard (41.32%)
 * Likes:    46
 * Dislikes: 0
 * Total Accepted:    1.2K
 * Total Submissions: 2.7K
 * Testcase Example:  '[1,2,1,2,6,7,5,1]\n2'
 *
 * 给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。
 * 
 * 每个子数组的长度为k，我们要使这3*k个项的和最大化。
 * 
 * 返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * 
 * 示例:
 * 
 * 
 * 输入: [1,2,1,2,6,7,5,1], 2
 * 输出: [0, 3, 5]
 * 解释: 子数组 [1, 2], [2, 6], [7, 5] 对应的起始索引为 [0, 3, 5]。
 * 我们也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 * 
 * 
 * 注意:
 * 
 * 
 * nums.length的范围在[1, 20000]之间。
 * nums[i]的范围在[1, 65535]之间。
 * k的范围在[1, floor(nums.length / 3)]之间。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return nums;
        }
        int[] sum = new int[n + 1], left = new int[n], right = new int[n], res = new int[3];
        for(int i = 0;i < n;i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for(int i = k, t = sum[k] - sum[0];i < n;i++) {
            if (sum[i + 1] - sum[i + 1 - k] > t) {
                left[i] = i + 1 - k;
                t = sum[i + 1] - sum[i + 1 - k];
            } else {
                left[i] = left[i - 1];
            }
        }
        right[n - k] = n - k;
        for(int i = n - k - 1, t = sum[n] - sum[n - k];i >= 0;i--) {
            if (sum[i + k] - sum[i] >= t) {
                right[i] = i;
                t = sum[i + k] - sum[i];
            } else {
                right[i] = right[i + 1];
            }
        }
        int maxsum = 0;
        for(int i = k;i <= n - 2 * k;i++) {
            int l = left[i - 1], r = right[i + k];
            int t = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (t > maxsum) {
                maxsum = t;
                res = new int[]{l, i, r};
            }
        }

        return res;
    }
}
// @lc code=end

