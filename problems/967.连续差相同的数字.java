/*
 * @lc app=leetcode.cn id=967 lang=java
 *
 * [967] 连续差相同的数字
 *
 * https://leetcode-cn.com/problems/numbers-with-same-consecutive-differences/description/
 *
 * algorithms
 * Medium (33.62%)
 * Likes:    12
 * Dislikes: 0
 * Total Accepted:    1.8K
 * Total Submissions: 5.3K
 * Testcase Example:  '3\n7'
 *
 * 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
 * 
 * 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。
 * 
 * 你可以按任何顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：N = 3, K = 7
 * 输出：[181,292,707,818,929]
 * 解释：注意，070 不是一个有效的数字，因为它有前导零。
 * 
 * 
 * 示例 2：
 * 
 * 输入：N = 2, K = 1
 * 输出：[10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= N <= 9
 * 0 <= K <= 9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> res = new ArrayList<>();
        if (N == 1) {
            return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        for(int i = 1;i < 10;i++) {
            dfs(i, i, N - 1, K, res);
        }

        int[] arr = new int[res.size()];
        for(int i = 0;i < res.size();i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void dfs(int val, int pre, int n, int k, List<Integer> res) {
        if (n == 0) {
            res.add(val);
            return;
        }

        for(int i = 0;i <= 9;i++) {
            if (pre - i == k || i - pre == k) {
                dfs(val * 10 + i, i, n - 1, k, res);
            }
        }
    }
}
// @lc code=end

