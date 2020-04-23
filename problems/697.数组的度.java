/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 *
 * https://leetcode-cn.com/problems/degree-of-an-array/description/
 *
 * algorithms
 * Easy (49.93%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    14.5K
 * Total Submissions: 27.5K
 * Testcase Example:  '[1,2,2,3,1]'
 *
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释: 
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 
 * 
 * 注意:
 * 
 * 
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> maps = new HashMap<>();
        int degree = 0;
        for(int i = 0;i < nums.length;i++) {
            maps.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            degree = Math.max(degree, maps.get(nums[i]).size());
        }
        int res = nums.length;
        for(Map.Entry<Integer, List<Integer>> entry : maps.entrySet()) {
            List<Integer> numsList = entry.getValue();
            if (numsList.size() == degree) {
                res = Math.min(res, numsList.get(degree - 1) - numsList.get(0) + 1);
            }
        }
        return res;
    }
}
// @lc code=end

