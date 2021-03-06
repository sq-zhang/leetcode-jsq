/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 *
 * https://leetcode-cn.com/problems/largest-number/description/
 *
 * algorithms
 * Medium (34.66%)
 * Likes:    207
 * Dislikes: 0
 * Total Accepted:    19.9K
 * Total Submissions: 56.5K
 * Testcase Example:  '[10,2]'
 *
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 
 * 示例 1:
 * 
 * 输入: [10,2]
 * 输出: 210
 * 
 * 示例 2:
 * 
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numsArr = new String[n];
        for(int i = 0;i < n;i++) {
            numsArr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numsArr, (a, b) -> (b + a).compareTo(a + b));
        if (numsArr[0].equals("0")) {
            return "0";
        }

        StringBuilder res = new StringBuilder();
        for(String numArr : numsArr) {
            res.append(numArr);
        }
        return res.toString();
    }
}
// @lc code=end

