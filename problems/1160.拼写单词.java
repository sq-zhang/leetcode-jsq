/*
 * @lc app=leetcode.cn id=1160 lang=java
 *
 * [1160] 拼写单词
 *
 * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/description/
 *
 * algorithms
 * Easy (63.27%)
 * Likes:    18
 * Dislikes: 0
 * Total Accepted:    6.4K
 * Total Submissions: 10.1K
 * Testcase Example:  '["cat","bt","hat","tree"]\n"atach"'
 *
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 
 * 注意：每次拼写时，chars 中的每个字母都只能用一次。
 * 
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释： 
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 
 * 
 * 示例 2：
 * 
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * 所有字符串中都仅包含小写英文字母
 * 
 * 
 */

// @lc code=start
class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i = 0;i < chars.length();i++) {
            if (!charCount.containsKey(chars.charAt(i))) {
                charCount.put(chars.charAt(i), 1);
            } else {
                charCount.put(chars.charAt(i), charCount.get(chars.charAt(i)) + 1);
            }
        }

        int res = 0;
        for(String word : words) {
            if(match(word, charCount)) {
                res += word.length();
            }
        }

        return res;
    }

    private boolean match(String word, Map<Character, Integer> charCount) {
        Map<Character, Integer> counts = new HashMap<>(charCount);
        for(int i = 0;i < word.length();i++) {
            if (!counts.containsKey(word.charAt(i)) || counts.get(word.charAt(i)) == 0) {
                return false;
            }
            counts.computeIfPresent(word.charAt(i), (k, v) -> (v - 1));
        }
        return true;
    }

}
// @lc code=end

