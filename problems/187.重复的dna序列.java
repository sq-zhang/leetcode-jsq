/*
 * @lc app=leetcode.cn id=187 lang=java
 *
 * [187] 重复的DNA序列
 *
 * https://leetcode-cn.com/problems/repeated-dna-sequences/description/
 *
 * algorithms
 * Medium (42.59%)
 * Likes:    46
 * Dislikes: 0
 * Total Accepted:    8.9K
 * Total Submissions: 20.8K
 * Testcase Example:  '"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"'
 *
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA
 * 中的重复序列有时会对研究非常有帮助。
 * 
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 * 
 */

// @lc code=start
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> res = new HashSet<>();
        Set<String> strSet = new HashSet<>();
        for(int i = 0;i <= s.length() - 10;i++) {
            String str = s.substring(i, i + 10);
            if (strSet.contains(str)) {
                res.add(str);
            } else {
                strSet.add(str);
            }
        }

        return new ArrayList<>(res);
    }
}
// @lc code=end

