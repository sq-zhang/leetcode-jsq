/*
 * @lc app=leetcode.cn id=386 lang=java
 *
 * [386] 字典序排数
 *
 * https://leetcode-cn.com/problems/lexicographical-numbers/description/
 *
 * algorithms
 * Medium (66.41%)
 * Likes:    66
 * Dislikes: 0
 * Total Accepted:    5.3K
 * Total Submissions: 7.9K
 * Testcase Example:  '13'
 *
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * 
 * 例如，
 * 
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * 
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        inOrder(1, n, res);
        return res;
    }

    private void inOrder(int prefix, int n, List<Integer> res) {
        if (prefix > n) {
            return;
        }
        res.add(prefix);
        inOrder(prefix * 10, n, res);
        if (prefix % 10 != 9) {
            inOrder(prefix + 1, n, res);
        }
    }
}
// @lc code=end

