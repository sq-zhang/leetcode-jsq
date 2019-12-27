/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 *
 * https://leetcode-cn.com/problems/word-break-ii/description/
 *
 * algorithms
 * Hard (36.95%)
 * Likes:    94
 * Dislikes: 0
 * Total Accepted:    9.1K
 * Total Submissions: 24.4K
 * Testcase Example:  '"catsanddog"\n["cat","cats","and","sand","dog"]'
 *
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典
 * wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 
 * 说明：
 * 
 * 
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 
 * 
 * 示例 1：
 * 
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 * "cats and dog",
 * "cat sand dog"
 * ]
 * 
 * 
 * 示例 2：
 * 
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 * "pine apple pen apple",
 * "pineapple pen apple",
 * "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 
 * 
 * 示例 3：
 * 
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict), new HashMap<String, List<String>>());
    }

    public List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            String word = s.substring(i);
            if (wordDict.contains(word)) {
                if (i == 0) {
                    res.add(word);
                } else {
                    List<String> worList = dfs(s.substring(0, i), wordDict, map);
                    for(int k = 0;k < worList.size();k++) {
                        res.add(worList.get(k) + " " + word);
                    }
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
// @lc code=end

