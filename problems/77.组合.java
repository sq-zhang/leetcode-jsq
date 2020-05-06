/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 *
 * https://leetcode-cn.com/problems/combinations/description/
 *
 * algorithms
 * Medium (71.62%)
 * Likes:    190
 * Dislikes: 0
 * Total Accepted:    28.1K
 * Total Submissions: 39.1K
 * Testcase Example:  '4\n2'
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 
 * 示例:
 * 
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * ⁠ [2,4],
 * ⁠ [3,4],
 * ⁠ [2,3],
 * ⁠ [1,2],
 * ⁠ [1,3],
 * ⁠ [1,4],
 * ]
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void backtrace(int n, int k, int s, List<Integer> nums, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for(int i = s;i <= n;i++) {
            nums.add(i);
            backtrace(n, k - 1, i + 1, nums, res);
            nums.remove(nums.size() - 1);
        }
    }
}
// @lc code=end

