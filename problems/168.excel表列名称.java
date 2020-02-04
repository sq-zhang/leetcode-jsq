/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 *
 * https://leetcode-cn.com/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (35.84%)
 * Likes:    166
 * Dislikes: 0
 * Total Accepted:    18.5K
 * Total Submissions: 50.8K
 * Testcase Example:  '1'
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 
 * 例如，
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * ⁠   ...
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "A"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 28
 * 输出: "AB"
 * 
 * 
 * 示例 3:
 * 
 * 输入: 701
 * 输出: "ZY"
 * 
 * 
 */

// @lc code=start
class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while(n > 0) {
            if (n % 26 == 0) {
                res.append('Z');
                n -= 1;
            } else {
                char c = (char)('A' + (n % 26) - 1);
                res.append(c);
            }
            n /= 26;
        }
        return res.reverse().toString();
    }
}
// @lc code=end

