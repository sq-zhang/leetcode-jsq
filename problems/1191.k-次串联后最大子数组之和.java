/*
 * @lc app=leetcode.cn id=1191 lang=java
 *
 * [1191] K 次串联后最大子数组之和
 *
 * https://leetcode-cn.com/problems/k-concatenation-maximum-sum/description/
 *
 * algorithms
 * Medium (22.93%)
 * Likes:    16
 * Dislikes: 0
 * Total Accepted:    1.6K
 * Total Submissions: 7.1K
 * Testcase Example:  '[1,2]\n3'
 *
 * 给你一个整数数组 arr 和一个整数 k。
 * 
 * 首先，我们要对该数组进行修改，即把原数组 arr 重复 k 次。
 * 
 * 
 * 举个例子，如果 arr = [1, 2] 且 k = 3，那么修改后的数组就是 [1, 2, 1, 2, 1, 2]。
 * 
 * 
 * 然后，请你返回修改后的数组中的最大的子数组之和。
 * 
 * 注意，子数组长度可以是 0，在这种情况下它的总和也是 0。
 * 
 * 由于 结果可能会很大，所以需要 模（mod） 10^9 + 7 后再返回。 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：arr = [1,2], k = 3
 * 输出：9
 * 
 * 
 * 示例 2：
 * 
 * 输入：arr = [1,-2,1], k = 5
 * 输出：2
 * 
 * 
 * 示例 3：
 * 
 * 输入：arr = [-1,-2], k = 7
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= arr.length <= 10^5
 * 1 <= k <= 10^5
 * -10^4 <= arr[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int res = 0, sum = 0;
        int mod = 1_000_000_007;
        for(int i = 0;i < arr.length;i++) {
            sum += arr[i];
            res = Math.max(res, sum);
            sum = Math.max(sum, 0);
        }
        if (k == 1) {
            return res;
        }

        int headMax = 0, tailMax = 0;
        sum  = 0;
        for(int i = 0;i < arr.length;i++) {
            sum += arr[i];
            headMax = Math.max(headMax, sum);
        }
        sum = 0;
        for(int i = arr.length - 1;i >= 0;i--) {
            sum += arr[i];
            tailMax = Math.max(tailMax, sum);
        }

        return Math.max(res, Math.max((headMax + tailMax) % mod, 
            (int)(((long)sum * (k - 2)) % mod + headMax + tailMax) % mod));

    }
}
// @lc code=end

