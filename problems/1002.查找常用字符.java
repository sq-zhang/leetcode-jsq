/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 *
 * https://leetcode-cn.com/problems/find-common-characters/description/
 *
 * algorithms
 * Easy (65.09%)
 * Likes:    43
 * Dislikes: 0
 * Total Accepted:    7.7K
 * Total Submissions: 11.8K
 * Testcase Example:  '["bella","label","roller"]'
 *
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3
 * 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * 
 * 你可以按任意顺序返回答案。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 
 * 
 * 示例 2：
 * 
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] 是小写字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> commonChars(String[] A) {
        int[] charCount = new int[26];
        Arrays.fill(charCount, -1);
        for(String str : A) {
            int tmp[] = new int[26];
            for(char c : str.toCharArray()) {
                tmp[c - 'a']++;
            }

            for(int i = 0;i < 26;i++) {
                if (charCount[i] != -1) {
                    charCount[i] = Math.min(charCount[i], tmp[i]);
                } else {
                    charCount[i] = tmp[i];
                }
            }
        }

        List<String> res = new ArrayList<>();
        for(int i = 0;i < 26;i++) {
            if (charCount[i] <= 0) {
                continue;
            }
            String tmp = String.valueOf((char)('a' + i));
            for(int j = 0;j < charCount[i];j++) {
                res.add(tmp);
            }
        }

        return res;
    }
}
// @lc code=end

