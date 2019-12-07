/*
 * @lc app=leetcode.cn id=564 lang=java
 *
 * [564] 寻找最近的回文数
 *
 * https://leetcode-cn.com/problems/find-the-closest-palindrome/description/
 *
 * algorithms
 * Hard (13.02%)
 * Likes:    36
 * Dislikes: 0
 * Total Accepted:    1.1K
 * Total Submissions: 8.4K
 * Testcase Example:  '"1"'
 *
 * 给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。
 * 
 * “最近的”定义为两个整数差的绝对值最小。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "123"
 * 输出: "121"
 * 
 * 
 * 注意:
 * 
 * 
 * n 是由字符串表示的正整数，其长度不超过18。
 * 如果有多个结果，返回最小的那个。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String nearestPalindromic(String n) {
        int mid = n.length() / 2 + n.length() % 2;
        Long nLong = Long.valueOf(n);
        Long high = Long.valueOf(n.substring(0, mid));
        Long res = Long.MAX_VALUE;
        for(int i = -1;i <= 1;i++) {
            String candidate = String.valueOf(high + i);
            if (n.length() % 2 == 0) {
                candidate += new StringBuilder(candidate).reverse().toString();
            } else {
                candidate += new StringBuilder(candidate.substring(0, candidate.length() - 1)).reverse().toString();
            }
            if (candidate.equals(n)) {
                continue;
            }
            res = getCandidateDiffResult(Long.valueOf(candidate), res, nLong);
        }

        Long candidate1 = (long)(Math.pow(10, n.length() - 1) - 1);
        Long candidate2 = (long)(Math.pow(10, n.length()) + 1);
        res = getCandidateDiffResult(candidate1, res, nLong);
        res = getCandidateDiffResult(candidate2, res, nLong);

        return String.valueOf(res);
    }

    private Long getCandidateDiffResult(Long current, Long last, Long value) {
        long lastDiff = Math.abs(value - last);
        long currentDiff = Math.abs(current - value);
        if(lastDiff < currentDiff) {
            return last;
        } else if (lastDiff == currentDiff) {
            return Math.min(current, last);
        } else {
            return current;
        }
    }
}
// @lc code=end

