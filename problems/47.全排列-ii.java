/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 *
 * https://leetcode-cn.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (55.54%)
 * Likes:    185
 * Dislikes: 0
 * Total Accepted:    30.4K
 * Total Submissions: 54.3K
 * Testcase Example:  '[1,1,2]'
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,1,2]
 * 输出:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void backtrace(int[] nums, boolean[] visited, List<Integer> numList, List<List<Integer>> res) {
        if (numList.size() == nums.length) {
            res.add(new ArrayList<>(numList));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            // 避免重复
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            numList.add(nums[i]);
            visited[i] = true;
            backtrace(nums, visited, numList, res);
            numList.remove(numList.size() - 1);
            visited[i] = false;
        }
    }
}
// @lc code=end

