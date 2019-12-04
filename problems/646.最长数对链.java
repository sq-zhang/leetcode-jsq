/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 *
 * https://leetcode-cn.com/problems/maximum-length-of-pair-chain/description/
 *
 * algorithms
 * Medium (51.36%)
 * Likes:    46
 * Dislikes: 0
 * Total Accepted:    3.8K
 * Total Submissions: 7.3K
 * Testcase Example:  '[[1,2], [2,3], [3,4]]'
 *
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * 
 * 示例 :
 * 
 * 
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 * 
 * 
 * 注意：
 * 
 * 
 * 给出数对的个数在 [1, 1000] 范围内。
 * 
 * 
 */

// @lc code=start
class Solution {

    public int findLongestChain(int[][] pairs) {
        if(pairs.length == 0) {
            return 0;
        }

        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                if(p1[0] != p2[0]) {
                    return p1[0] - p2[0];
                }
                return p1[1] - p2[1];
            }
        });

        int res = 0;
        int[] dp = new int[pairs.length];
        for(int i = 0;i < pairs.length;i++) {
            dp[i] = 1;
            for(int j = i - 1;j >= 0;j--) {
                if(pairs[i][0] > pairs[j][1]) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
// @lc code=end

