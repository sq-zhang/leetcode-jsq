/*
 * @lc app=leetcode.cn id=1043 lang=java
 *
 * [1043] 分隔数组以得到最大和
 *
 * https://leetcode-cn.com/problems/partition-array-for-maximum-sum/description/
 *
 * algorithms
 * Medium (61.51%)
 * Likes:    23
 * Dislikes: 0
 * Total Accepted:    1.2K
 * Total Submissions: 2K
 * Testcase Example:  '[1,15,7,9,2,5,10]\n3'
 *
 * 给出整数数组 A，将该数组分隔为长度最多为 K 的几个（连续）子数组。分隔完成后，每个子数组的中的值都会变为该子数组中的最大值。
 * 
 * 返回给定数组完成分隔后的最大和。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：A = [1,15,7,9,2,5,10], K = 3
 * 输出：84
 * 解释：A 变为 [15,15,15,9,10,10,10]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= K <= A.length <= 500
 * 0 <= A[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int domainMax = A[i];
            for (int j = 1; j <= K && i - j + 1 >= 0; j++) {
                domainMax = Math.max(domainMax, A[i - j + 1]);
                if (i - j >= 0) {
                    dp[i] = Math.max(dp[i], dp[i - j] + j * domainMax);
                } else {
                    dp[i] = Math.max(dp[i], j * domainMax);
                }
            }
        }
        return dp[A.length - 1];
    }
}
// @lc code=end

