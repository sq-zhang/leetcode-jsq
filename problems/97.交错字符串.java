/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 *
 * https://leetcode-cn.com/problems/interleaving-string/description/
 *
 * algorithms
 * Hard (37.33%)
 * Likes:    107
 * Dislikes: 0
 * Total Accepted:    7.4K
 * Total Submissions: 19.7K
 * Testcase Example:  '"aabcc"\n"dbbca"\n"aadbbcbcac"'
 *
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * 
 * 示例 1:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 * 
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] visited = new int[s1.length()][s2.length()];
        for(int[] arr : visited) {
            Arrays.fill(arr, -1);
        }

        return isInterleave(s1, 0, s2, 0, s3, 0, visited);
    }

    private boolean isInterleave(String s1, int i, String s2, int j, 
        String s3, int k, int[][] visited) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }

        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }

        if (visited[i][j] != -1) {
            return visited[i][j] == 1;
        }

        boolean ans = false;
        ans |= (s1.charAt(i) == s3.charAt(k)) && isInterleave(s1, i + 1, s2, j, s3, k + 1, visited);
        ans |= (s2.charAt(j) == s3.charAt(k)) && isInterleave(s1, i, s2, j + 1, s3, k + 1, visited);
        visited[i][j] = ans ? 1 : 0;
        return ans;
    }
}
// @lc code=end

