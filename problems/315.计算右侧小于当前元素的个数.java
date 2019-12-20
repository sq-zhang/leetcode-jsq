/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 *
 * https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/description/
 *
 * algorithms
 * Hard (36.59%)
 * Likes:    118
 * Dislikes: 0
 * Total Accepted:    7.6K
 * Total Submissions: 20.8K
 * Testcase Example:  '[5,2,6,1]'
 *
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于
 * nums[i] 的元素的数量。
 * 
 * 示例:
 * 
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0] 
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        int[] dp = new int[n];
        for(int i = n - 2;i >= 0;i--) {
            int count = 0;
            for(int j = i + 1;j < n;j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
                if (nums[j] == nums[i]) {
                    count += dp[j];
                    break;
                }
            }
            dp[i] = count;
        }

        for(int i = 0;i < n;i++) {
            res.add(dp[i]);
        }

        return res;
    }
}
// @lc code=end

