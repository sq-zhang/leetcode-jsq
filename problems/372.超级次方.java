/*
 * @lc app=leetcode.cn id=372 lang=java
 *
 * [372] 超级次方
 *
 * https://leetcode-cn.com/problems/super-pow/description/
 *
 * algorithms
 * Medium (37.06%)
 * Likes:    47
 * Dislikes: 0
 * Total Accepted:    2.6K
 * Total Submissions: 7K
 * Testcase Example:  '2\n[3]'
 *
 * 你的任务是计算 a^b 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * 
 * 示例 1:
 * 
 * 输入: a = 2, b = [3]
 * 输出: 8
 * 
 * 
 * 示例 2:
 * 
 * 输入: a = 2, b = [1,0]
 * 输出: 1024
 * 
 */

// @lc code=start
class Solution {

    public int myPow(int x, int n) {
        int res = 1;
        while(n > 0) {
            if ((n & 1) == 1) {
                res = (res * x) % 1337;
            }
            x = (x % 1337) * (x % 1337) % 1337;
            n >>= 1;
        }
        return res;
    }

    public int superPow(int a, int[] b) {
        int res = 1;
        for(int i : b) {
            res = myPow(res, 10) * myPow(a, i);
        }
        return res % 1337;
    }

}
// @lc code=end

