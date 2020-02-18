/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/description/
 *
 * algorithms
 * Medium (58.75%)
 * Likes:    204
 * Dislikes: 0
 * Total Accepted:    39.6K
 * Total Submissions: 65.9K
 * Testcase Example:  '[10,1,2,7,6,1,5]\n8'
 *
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 
 * 说明：
 * 
 * 
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * ⁠ [1, 7],
 * ⁠ [1, 2, 5],
 * ⁠ [2, 6],
 * ⁠ [1, 1, 6]
 * ]
 * 
 * 
 * 示例 2:
 * 
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> nums, Set<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for(int i = start;i < candidates.length;i++) {
            if (candidates[i] <= target) {
                nums.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, nums, res);
                nums.remove(nums.size() - 1);
            } else {
                break;
            }
        }
    }
}
// @lc code=end

