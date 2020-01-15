/*
 * @lc app=leetcode.cn id=423 lang=java
 *
 * [423] 从英文中重建数字
 *
 * https://leetcode-cn.com/problems/reconstruct-original-digits-from-english/description/
 *
 * algorithms
 * Medium (51.29%)
 * Likes:    33
 * Dislikes: 0
 * Total Accepted:    2.5K
 * Total Submissions: 4.7K
 * Testcase Example:  '"owoztneoer"'
 *
 * 给定一个非空字符串，其中包含字母顺序打乱的英文单词表示的数字0-9。按升序输出原始的数字。
 * 
 * 注意:
 * 
 * 
 * 输入只包含小写英文字母。
 * 输入保证合法并可以转换为原始的数字，这意味着像 "abc" 或 "zerone" 的输入是不允许的。
 * 输入字符串的长度小于 50,000。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: "owoztneoer"
 * 
 * 输出: "012" (zeroonetwo)
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "fviefuro"
 * 
 * 输出: "45" (fourfive)
 * 
 * 
 */

// @lc code=start
class Solution {
    public String originalDigits(String s) {
        int[] chars = new int[26];
        for(char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        int[] nums = new int[10];
        nums[0] = chars['z' - 'a'];
        nums[2] = chars['w' - 'a'];
        nums[4] = chars['u' - 'a'];
        nums[6] = chars['x' - 'a'];
        nums[8] = chars['g' - 'a'];
        nums[3] = chars['h' - 'a'] - nums[8];
        nums[5] = chars['f' - 'a'] - nums[4];
        nums[7] = chars['s' - 'a'] - nums[6];
        nums[9] = chars['i' - 'a'] - nums[5] - nums[6] - nums[8];
        nums[1] = chars['n' - 'a'] - nums[7] - nums[9] * 2;

        StringBuilder res = new StringBuilder();
        for(int i = 0;i < 10;i++) {
            for(int j = 0;j < nums[i];j++) {
                res.append(i);
            }
        }
        return res.toString();
    }
}
// @lc code=end

