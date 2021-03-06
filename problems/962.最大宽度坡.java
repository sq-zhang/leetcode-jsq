/*
 * @lc app=leetcode.cn id=962 lang=java
 *
 * [962] 最大宽度坡
 *
 * https://leetcode-cn.com/problems/maximum-width-ramp/description/
 *
 * algorithms
 * Medium (34.49%)
 * Likes:    50
 * Dislikes: 0
 * Total Accepted:    4.4K
 * Total Submissions: 11.9K
 * Testcase Example:  '[6,0,8,2,1,5]'
 *
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * 
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 
 * 
 * 示例 2：
 * 
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxWidthRamp(int[] A) {
        int n = A.length;
        Integer[] nums = new Integer[n];
        for(int i = 0;i < n;i++) {
            nums[i] = i;
        }
        Arrays.sort(nums, (a, b) -> A[a] - A[b]);
        int res = 0, last = n;
        for(int num : nums) {
            res = Math.max(res, num - last);
            last = Math.min(last, num);
        }
        return res;
    }
}
// @lc code=end

