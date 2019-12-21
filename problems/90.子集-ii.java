/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 *
 * https://leetcode-cn.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (57.94%)
 * Likes:    144
 * Dislikes: 0
 * Total Accepted:    17.7K
 * Total Submissions: 30.5K
 * Testcase Example:  '[1,2,2]'
 *
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: [1,2,2]
 * 输出:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> arr, List<List<Integer>> res) {
        res.add(new ArrayList<>(arr));

        for(int i = start;i < nums.length;i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            arr.add(nums[i]);
            dfs(nums, i + 1, arr, res);
            arr.remove(arr.size() - 1);
        }
    }
}
// @lc code=end

