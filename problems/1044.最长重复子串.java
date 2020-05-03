/*
 * @lc app=leetcode.cn id=1044 lang=java
 *
 * [1044] 最长重复子串
 *
 * https://leetcode-cn.com/problems/longest-duplicate-substring/description/
 *
 * algorithms
 * Hard (14.58%)
 * Likes:    37
 * Dislikes: 0
 * Total Accepted:    1.6K
 * Total Submissions: 8.8K
 * Testcase Example:  '"banana"'
 *
 * 给出一个字符串 S，考虑其所有重复子串（S 的连续子串，出现两次或多次，可能会有重叠）。
 * 
 * 返回任何具有最长可能长度的重复子串。（如果 S 不含重复子串，那么答案为 ""。）
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入："banana"
 * 输出："ana"
 * 
 * 
 * 示例 2：
 * 
 * 输入："abcd"
 * 输出：""
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= S.length <= 10^5
 * S 由小写英文字母组成。
 * 
 * 
 */

// @lc code=start
class Solution {
    private long mod = (long)Math.pow(2, 32);
    public String longestDupSubstring(String S) {
        int n = S.length();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++) {
            nums[i] = S.charAt(i) - 'a';
        }
        int l = 1, r = n;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if (search(nums, n, mid) != -1) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int start = search(nums, n, l - 1);
        return start != - 1 ? S.substring(start, start + l - 1) : "";

    }

    private int search(int[] nums, int n, int mid) {
        long h = 0;
        for(int i = 0;i < mid;i++) {
            h = (h * 26 + nums[i]) % mod;
        }
        long aL = 1;
        for(int i = 1;i <= mid;i++) {
            aL = (aL * 26) % mod;
        }
        Set<Long> visited = new HashSet<>();
        visited.add(h);
        for(int i = 1;i < n - mid + 1;i++) {
            h = (h * 26 - nums[i - 1] * aL % mod + mod) % mod;
            h = (h + nums[i + mid - 1]) % mod;
            if (visited.contains(h)) {
                return i;
            }
            visited.add(h);
        }
        return -1;
    }
}
// @lc code=end

