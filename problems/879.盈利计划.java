/*
 * @lc app=leetcode.cn id=879 lang=java
 *
 * [879] 盈利计划
 *
 * https://leetcode-cn.com/problems/profitable-schemes/description/
 *
 * algorithms
 * Hard (28.87%)
 * Likes:    19
 * Dislikes: 0
 * Total Accepted:    905
 * Total Submissions: 2.7K
 * Testcase Example:  '5\n3\n[2,2]\n[2,3]'
 *
 * 帮派里有 G 名成员，他们可能犯下各种各样的罪行。
 * 
 * 第 i 种犯罪会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。
 * 
 * 让我们把这些犯罪的任何子集称为盈利计划，该计划至少产生 P 的利润。
 * 
 * 有多少种方案可以选择？因为答案很大，所以返回它模 10^9 + 7 的值。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：G = 5, P = 3, group = [2,2], profit = [2,3]
 * 输出：2
 * 解释： 
 * 至少产生 3 的利润，该帮派可以犯下罪 0 和罪 1 ，或仅犯下罪 1 。
 * 总的来说，有两种方案。
 * 
 * 
 * 示例 2:
 * 
 * 输入：G = 10, P = 5, group = [2,3,5], profit = [6,7,8]
 * 输出：7
 * 解释：
 * 至少产生 5 的利润，只要他们犯其中一种罪就行，所以该帮派可以犯下任何罪行 。
 * 有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= G <= 100
 * 0 <= P <= 100
 * 1 <= group[i] <= 100
 * 0 <= profit[i] <= 100
 * 1 <= group.length = profit.length <= 100
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int mod = 1_000_000_007, n = group.length;
        int[][] dp = new int[P + 1][G + 1];
        dp[0][0] = 1;
        for(int i = 0;i < n;i++) {
            int g = group[i], p = profit[i];
            for(int j = P;j >= 0;j--) {
                for(int k = G - g;k >= 0;k--) {
                    int x = Math.min(P, j + p);
                    dp[x][k + g] = (dp[x][k + g] + dp[j][k]) % mod;
                }
            }
        }
        for(int i = 0;i <= P;i++) {
            for(int j = 0;j <= G;j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println("");
        }
        long res = 0;
        for(int i = 0;i <= G;i++) {
            res = (res + dp[P][i]) % mod;
        }
        return (int)res;
    }
}
// @lc code=end

