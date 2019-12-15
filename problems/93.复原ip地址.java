/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 *
 * https://leetcode-cn.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (44.84%)
 * Likes:    166
 * Dislikes: 0
 * Total Accepted:    19.9K
 * Total Submissions: 44.1K
 * Testcase Example:  '"25525511135"'
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 
 * 示例:
 * 
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 
 */

// @lc code=start
class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(String s, List<String> nums, int start) {
        if (nums.size() > 4) {
            return;
        }
        if (nums.size() == 4 && start == s.length()) {
            res.add(String.join(".", nums));
            return;
        }

        for(int i = 1;i <= 3;i++) {
            if (start + i > s.length()) {
                continue;
            }
            String num = s.substring(start, start + i);
            if ((s.charAt(start) != '0' || i == 1) && Integer.valueOf(num) <= 255) {
                List<String> tmp = new ArrayList<>(nums);
                tmp.add(num);
                dfs(s, tmp, start + i);
            } 
        }
    }
}
// @lc code=end

