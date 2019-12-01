/*
 * @lc app=leetcode.cn id=336 lang=java
 *
 * [336] 回文对
 *
 * https://leetcode-cn.com/problems/palindrome-pairs/description/
 *
 * algorithms
 * Hard (31.47%)
 * Likes:    34
 * Dislikes: 0
 * Total Accepted:    1.9K
 * Total Submissions: 6K
 * Testcase Example:  '["abcd","dcba","lls","s","sssll"]'
 *
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * 
 * 示例 1:
 * 
 * 输入: ["abcd","dcba","lls","s","sssll"]
 * 输出: [[0,1],[1,0],[3,2],[2,4]] 
 * 解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
 * 
 * 
 * 示例 2:
 * 
 * 输入: ["bat","tab","cat"]
 * 输出: [[0,1],[1,0]] 
 * 解释: 可拼接成的回文串为 ["battab","tabbat"]
 * 
 */

// @lc code=start
class Solution {

    private static class Node {
        public Node[] children = new Node[26];
        public List<Integer> words = new ArrayList<>();
        public List<Integer> suffix = new ArrayList<>();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Node root = new Node();
        for(int i = 0;i < words.length;i++) {
            String reverse = new StringBuilder(words[i]).reverse().toString();
            Node current = root;
            if(isPalindrome(reverse)) {
                current.suffix.add(i);
            }
            for(int j = 0;j < reverse.length();j++) {
                char c = reverse.charAt(j);
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new Node();
                }
                current = current.children[c - 'a'];
                if (isPalindrome(reverse.substring(j + 1))) {
                    current.suffix.add(i);
                }
            }
            current.words.add(i);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0;i < words.length;i++) {
            String word = words[i];
            Node current = root;
            int j = 0;
            for(;j < word.length();j++) {
                if(isPalindrome(word.substring(j))) {
                    for(int k : current.words) {
                        if (k != i) {
                            res.add(Arrays.asList(i, k));
                        }
                    }
                }
                char c = word.charAt(j);
                if(current.children[c - 'a'] == null) {
                    break;
                }
                current = current.children[c - 'a'];
            }
            if (j == word.length()) {
                for(int k : current.suffix) {
                    if (k != i) {
                        res.add(Arrays.asList(i, k));
                    }
                }
            }
        }

        return res;

    }

    private boolean isPalindrome(String w) {
        int i = 0, j = w.length() - 1;
        while(i < j) {
            if(w.charAt(i++) != w.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

