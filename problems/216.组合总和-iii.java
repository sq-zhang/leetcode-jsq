/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 *
 * https://leetcode-cn.com/problems/combination-sum-iii/description/
 *
 * algorithms
 * Medium (69.23%)
 * Likes:    75
 * Dislikes: 0
 * Total Accepted:    11.1K
 * Total Submissions: 16.1K
 * Testcase Example:  '3\n7'
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * 
 * 说明：
 * 
 * 
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 
 * 
 * 示例 1:
 * 
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int k, int n, int start, List<Integer> sums, List<List<Integer>> res) {
        if (k < 0 || n < 0) {
            return;
        }
        if (k == 0 && n == 0) {
            if (!sums.isEmpty()) {
                res.add(new ArrayList<>(sums));
            }
            return;
        }

        for(int i = start;i <= 9;i++) {
            sums.add(i);
            dfs(k - 1, n - i, i + 1, sums, res);
            sums.remove(sums.size() - 1);
        }
    }
}
// @lc code=end

