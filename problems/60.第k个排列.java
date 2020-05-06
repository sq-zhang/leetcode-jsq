/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 第k个排列
 *
 * https://leetcode-cn.com/problems/permutation-sequence/description/
 *
 * algorithms
 * Medium (47.56%)
 * Likes:    237
 * Dislikes: 0
 * Total Accepted:    32.1K
 * Total Submissions: 65.9K
 * Testcase Example:  '3\n3'
 *
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * 
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 说明：
 * 
 * 
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 
 * 
 * 示例 1:
 * 
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 
 * 
 * 示例 2:
 * 
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 
 * 
 */

// @lc code=start
class Solution {
    private int count = 0;
    private String res = "";
    public String getPermutation(int n, int k) {
        // backtrace(new boolean[n + 1], 0, k, n, new StringBuilder());
        // return res;
        int[] f = new int[n];
        List<Integer> nums = new ArrayList<>();
        f[0] = 1;
        nums.add(1);
        for(int i = 1;i < n;i++) {
            f[i] = f[i - 1] * i;
            nums.add(i + 1);
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = n -1;i >= 0;i--) {
            int idx = k / f[i];
            k -= idx * f[i];
            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }

    private void backtrace(boolean[] visited, int i, int k, int n, StringBuilder sb) {
        if (i == n) {
            count++;
            if (count == k) {
                res = sb.toString();
            }
            return;
        }
        if (res.length() > 0) {
            return;
        }
        for(int j = 1;j <= n;j++) {
            if (!visited[j]) {
                visited[j] = true;
                backtrace(visited, i + 1, k, n, sb.append(j));
                sb.deleteCharAt(sb.length() - 1);
                visited[j] = false;
            }
        }
    }
}
// @lc code=end

