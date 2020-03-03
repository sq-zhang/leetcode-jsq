/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 *
 * https://leetcode-cn.com/problems/summary-ranges/description/
 *
 * algorithms
 * Medium (49.54%)
 * Likes:    39
 * Dislikes: 0
 * Total Accepted:    7.3K
 * Total Submissions: 14.2K
 * Testcase Example:  '[0,1,2,4,5,7]'
 *
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 * 
 * 示例 1:
 * 
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 
 * 示例 2:
 * 
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 * 
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        int last = nums[0];
        for(int i = 0;i < nums.length;i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1] - 1) {
                continue;
            } else {
                if (last == nums[i]) {
                    res.add(last + "");
                } else {
                    res.add(last + "->" + nums[i]);
                }
                if (i < nums.length - 1) {
                    last = nums[i + 1];
                }
            }
        }
        
        return res;
    }
}
// @lc code=end

