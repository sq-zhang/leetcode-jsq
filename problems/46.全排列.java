/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 *
 * https://leetcode-cn.com/problems/permutations/description/
 *
 * algorithms
 * Medium (72.99%)
 * Likes:    474
 * Dislikes: 0
 * Total Accepted:    63.2K
 * Total Submissions: 86.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 
 * 示例:
 * 
 * 输入: [1,2,3]
 * 输出:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> numList, List<List<Integer>> res) {
        if (numList.size() == nums.length) {
            res.add(new ArrayList<>(numList));
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if (visited[i]) {
                continue;
            }
            numList.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, numList, res);
            numList.remove(numList.size() - 1);
            visited[i] = false;
        }
    }
}
// @lc code=end

