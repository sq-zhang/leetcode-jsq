/*
 * @lc app=leetcode.cn id=756 lang=java
 *
 * [756] 金字塔转换矩阵
 *
 * https://leetcode-cn.com/problems/pyramid-transition-matrix/description/
 *
 * algorithms
 * Medium (52.37%)
 * Likes:    32
 * Dislikes: 0
 * Total Accepted:    2.1K
 * Total Submissions: 3.8K
 * Testcase Example:  '"ABC"\n["ABD","BCE","DEF","FFF"]'
 *
 * 现在，我们用一些方块来堆砌一个金字塔。 每个方块用仅包含一个字母的字符串表示。
 * 
 * 使用三元组表示金字塔的堆砌规则如下：
 * 
 * 对于三元组(A, B, C) ，“C”为顶层方块，方块“A”、“B”分别作为方块“C”下一层的的左、右子块。当且仅当(A, B,
 * C)是被允许的三元组，我们才可以将其堆砌上。
 * 
 * 初始时，给定金字塔的基层 bottom，用一个字符串表示。一个允许的三元组列表 allowed，每个三元组用一个长度为 3 的字符串表示。
 * 
 * 如果可以由基层一直堆到塔尖就返回 true，否则返回 false。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: bottom = "BCD", allowed = ["BCG", "CDE", "GEA", "FFF"]
 * 输出: true
 * 解析:
 * 可以堆砌成这样的金字塔:
 * ⁠   A
 * ⁠  / \
 * ⁠ G   E
 * ⁠/ \ / \
 * B   C   D
 * 
 * 因为符合('B', 'C', 'G'), ('C', 'D', 'E') 和 ('G', 'E', 'A') 三种规则。
 * 
 * 
 * 示例 2:
 * 
 * 输入: bottom = "AABA", allowed = ["AAA", "AAB", "ABA", "ABB", "BAC"]
 * 输出: false
 * 解析:
 * 无法一直堆到塔尖。
 * 注意, 允许存在像 (A, B, C) 和 (A, B, D) 这样的三元组，其中 C != D。
 * 
 * 
 * 
 * 
 * 注意：
 * 
 * 
 * bottom 的长度范围在 [2, 8]。
 * allowed 的长度范围在[0, 200]。
 * 方块的标记字母范围为{'A', 'B', 'C', 'D', 'E', 'F', 'G'}。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<String>> maps = new HashMap<>();
        for(String allow : allowed) {
            maps.computeIfAbsent(allow.substring(0, 2), k -> new ArrayList<>()).add(allow.substring(2));
        }

        return dfs(bottom, maps);
    }

    private boolean dfs(String bottom, Map<String, List<String>> maps) {
        if (bottom.length() == 1) {
            return true;
        }
        for(int i = 0;i < bottom.length() - 1;i++) {
            if (!maps.containsKey(bottom.substring(i, i + 2))) {
                return false;
            }
        }
        List<String> list = new ArrayList<>();
        getList(bottom, 0, new StringBuilder(), list, maps);
        for(String l : list) {
            if (dfs(l, maps)) {
                return true;
            }
        }
        return false;
    }

    private void getList(String bottom, int idx, StringBuilder sb, List<String> res, Map<String, List<String>> maps) {
        if (idx == bottom.length() - 1) {
            res.add(sb.toString());
            return;
        }
        for(String s : maps.get(bottom.substring(idx, idx + 2))) {
            sb.append(s);
            getList(bottom, idx + 1, sb, res, maps);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
// @lc code=end

