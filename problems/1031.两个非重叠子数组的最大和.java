/*
 * @lc app=leetcode.cn id=1031 lang=java
 *
 * [1031] 两个非重叠子数组的最大和
 *
 * https://leetcode-cn.com/problems/maximum-sum-of-two-non-overlapping-subarrays/description/
 *
 * algorithms
 * Medium (49.39%)
 * Likes:    39
 * Dislikes: 0
 * Total Accepted:    1.9K
 * Total Submissions: 3.7K
 * Testcase Example:  '[0,6,5,2,2,5,1,9,4]\n1\n2'
 *
 * 给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。（这里需要澄清的是，长为 L 的子数组可以出现在长为
 * M 的子数组之前或之后。）
 * 
 * 从形式上看，返回最大的 V，而 V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ...
 * + A[j+M-1]) 并满足下列条件之一：
 * 
 * 
 * 
 * 
 * 0 <= i < i + L - 1 < j < j + M - 1 < A.length, 或
 * 0 <= j < j + M - 1 < i < i + L - 1 < A.length.
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * 
 * 
 * 示例 2：
 * 
 * 输入：A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * 
 * 
 * 示例 3：
 * 
 * 输入：A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * L >= 1
 * M >= 1
 * L + M <= A.length <= 1000
 * 0 <= A[i] <= 1000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int n = A.length, ln = n - L + 1, lm = n - M + 1;;
        int[] sum = new int[n], lsum = new int[ln], msum = new int[lm];
        sum[0] = A[0];
        for(int i = 1;i < n;i++) {
            sum[i] = sum[i - 1] + A[i];
        }
        lsum[0] = sum[L - 1];
        msum[0] = sum[M - 1];
        for(int i = 1;i < n;i++) {
            if (i + L - 1 < n) {
                lsum[i] = sum[i + L - 1] - sum[i - 1];
            }
            if (i + M - 1 < n) {
                msum[i] = sum[i + M - 1] - sum[i - 1];
            }
        }
        int res = 0;
        for(int i = 0;i <= n - L;i++) {
            for(int j = 0;j <= n - M;j++) {
                if (j + M <= i || j >= i + L) {
                    res = Math.max(res, lsum[i] + msum[j]);
                }
            }
        }
        return res;
    }

}
// @lc code=end

