/*
 * @lc app=leetcode.cn id=777 lang=java
 *
 * [777] 在LR字符串中交换相邻字符
 *
 * https://leetcode-cn.com/problems/swap-adjacent-in-lr-string/description/
 *
 * algorithms
 * Medium (30.95%)
 * Likes:    43
 * Dislikes: 0
 * Total Accepted:    2.6K
 * Total Submissions: 8.1K
 * Testcase Example:  '"X"\n"L"'
 *
 * 在一个由 'L' , 'R' 和 'X'
 * 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时，
 * 返回True。
 * 
 * 
 * 
 * 示例 :
 * 
 * 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
 * 输出: True
 * 解释:
 * 我们可以通过以下几步将start转换成end:
 * RXXLRXRXL ->
 * XRXLRXRXL ->
 * XRLXRXRXL ->
 * XRLXXRRXL ->
 * XRLXXRRLX
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= len(start) = len(end) <= 10000。
 * start和end中的字符串仅限于'L', 'R'和'X'。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canTransform(String start, String end) {
        int n = start.length(), i = 0, j = 0;
        while(i < n || j < n) {
            while(i < n && start.charAt(i) == 'X') {
                i++;
            }
            while(j < n && end.charAt(j) == 'X') {
                j++;
            }
            if ((i < n) ^ (j < n)) {
                return false;
            }
            if (i >= n && j >= n) {
                return true;
            }
            if (start.charAt(i) != end.charAt(j)) {
                return false;
            }
            if ((start.charAt(i) == 'L' && i < j) || (end.charAt(j) == 'R' && i > j)) {
                return false;
            }
            i++;
            j++;
        }
        return i == j;
    }

}
// @lc code=end

