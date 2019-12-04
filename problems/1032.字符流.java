/*
 * @lc app=leetcode.cn id=1032 lang=java
 *
 * [1032] 字符流
 *
 * https://leetcode-cn.com/problems/stream-of-characters/description/
 *
 * algorithms
 * Hard (26.12%)
 * Likes:    13
 * Dislikes: 0
 * Total Accepted:    612
 * Total Submissions: 2.3K
 * Testcase Example:  '["StreamChecker","query","query","query","query","query","query","query","query","query","query","query","query"]\n' +
  '[[["cd","f","kl"]],["a"],["b"],["c"],["d"],["e"],["f"],["g"],["h"],["i"],["j"],["k"],["l"]]'
 *
 * 按下述要求实现 StreamChecker 类：
 * 
 * 
 * StreamChecker(words)：构造函数，用给定的字词初始化数据结构。
 * query(letter)：如果存在某些 k >= 1，可以用查询的最后
 * k个字符（按从旧到新顺序，包括刚刚查询的字母）拼写出给定字词表中的某一字词时，返回 true。否则，返回 false。
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // 初始化字典
 * streamChecker.query('a');          // 返回 false
 * streamChecker.query('b');          // 返回 false
 * streamChecker.query('c');          // 返回 false
 * streamChecker.query('d');          // 返回 true，因为 'cd' 在字词表中
 * streamChecker.query('e');          // 返回 false
 * streamChecker.query('f');          // 返回 true，因为 'f' 在字词表中
 * streamChecker.query('g');          // 返回 false
 * streamChecker.query('h');          // 返回 false
 * streamChecker.query('i');          // 返回 false
 * streamChecker.query('j');          // 返回 false
 * streamChecker.query('k');          // 返回 false
 * streamChecker.query('l');          // 返回 true，因为 'kl' 在字词表中。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * 字词只包含小写英文字母。
 * 待查项只包含小写英文字母。
 * 待查项最多 40000 个。
 * 
 * 
 */

// @lc code=start
class StreamChecker {

    public class Node {
        boolean isWord;
        Node[] data = new Node[26];
    }

    private Node tree;
    List<Character> charList;

    public StreamChecker(String[] words) {
        this.charList = new ArrayList<>();
        this.tree = new Node();
        for(String word : words) {
            Node current = tree;
            for(int i = word.length() - 1;i >= 0;i--) {
                char c = word.charAt(i);
                if (current.data[c - 'a'] == null) {
                    current.data[c - 'a'] = new Node();
                }
                current = current.data[c - 'a'];
            }
            current.isWord = true;
        }
    }
    
    public boolean query(char letter) {
        this.charList.add(letter);
        Node node = this.tree;
        for(int i = this.charList.size() - 1;i >= 0;i--) {
            int j = this.charList.get(i) - 'a';
            if (node.data[j] == null) {
                return false;
            }
            node = node.data[j];
            if(node.isWord) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
// @lc code=end

