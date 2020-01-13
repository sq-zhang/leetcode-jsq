/*
 * @lc app=leetcode.cn id=745 lang=java
 *
 * [745] 前缀和后缀搜索
 *
 * https://leetcode-cn.com/problems/prefix-and-suffix-search/description/
 *
 * algorithms
 * Hard (29.32%)
 * Likes:    15
 * Dislikes: 0
 * Total Accepted:    689
 * Total Submissions: 2.3K
 * Testcase Example:  '["WordFilter","f"]\n[[["apple"]],["a","e"]]'
 *
 * 给定多个 words，words[i] 的权重为 i 。
 * 
 * 设计一个类 WordFilter 实现函数WordFilter.f(String prefix, String suffix)。这个函数将返回具有前缀
 * prefix 和后缀suffix 的词的最大权重。如果没有这样的词，返回 -1。
 * 
 * 例子:
 * 
 * 
 * 输入:
 * WordFilter(["apple"])
 * WordFilter.f("a", "e") // 返回 0
 * WordFilter.f("b", "") // 返回 -1
 * 
 * 
 * 注意:
 * 
 * 
 * words的长度在[1, 15000]之间。
 * 对于每个测试用例，最多会有words.length次对WordFilter.f的调用。
 * words[i]的长度在[1, 10]之间。
 * prefix, suffix的长度在[0, 10]之前。
 * words[i]和prefix, suffix只包含小写字母。
 * 
 * 
 */

// @lc code=start
class WordFilter {
    class Node {
        Node[] next = new Node[27];
        int weight;
    }

    Node trie;
    public WordFilter(String[] words) {
        trie = new Node();
        for (int w = 0; w < words.length; w++) {
            String word = words[w] + "{";
            for (int i = 0; i < word.length(); ++i) {
                Node cur = trie;
                cur.weight = w;
                for (int j = i; j < 2 * word.length() - 1; j++) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (cur.next[k] == null)
                        cur.next[k] = new Node();
                    cur = cur.next[k];
                    cur.weight = w;
                }
            }
        }
    }
    public int f(String prefix, String suffix) {
        Node cur = trie;
        for (char c: (suffix + '{' + prefix).toCharArray()) {
            if (cur.next[c - 'a'] == null) {
                return -1;
            }
            cur = cur.next[c - 'a'];
        }
        return cur.weight;
    }
}

// class WordFilter {

//     class Node {
//         Node[] next = new Node[26];
//         boolean isWord = false;
//         Set<Integer> index = new HashSet<>();
//     }

//     private Node preRoot;
//     private Node sufRoot;

//     public WordFilter(String[] words) {
//         preRoot = new Node();
//         sufRoot = new Node();
//         for(int i = 0;i < words.length;i++) {
//             insert(preRoot, words[i], i);
//             insert(sufRoot, new StringBuilder(words[i]).reverse().toString(), i);
//         }
//     }
    
//     public void insert(Node root, String word, int index) {
//         Node cur = root;
//         cur.index.add(index);
//         for(char c : word.toCharArray()) {
//             Node next = cur.next[c - 'a'];
//             if (next == null) {
//                 cur.next[c - 'a'] = new Node();
//             }
//             cur = cur.next[c - 'a'];
//             cur.index.add(index);
//         }
        
//         cur.isWord = true;
//     }
    
//     public int f(String prefix, String suffix) {
//         Set<Integer> preMatch = startsWith(prefix);
//         System.out.println("pre: " + preMatch);
        
//         if (preMatch == null) {
//             return -1;
//         }

//         Set<Integer> sufMatch = endsWith(suffix);
//         System.out.println("suf: " + sufMatch);
        
//         if (sufMatch == null) {
//             return -1;
//         }

//         sufMatch.retainAll(preMatch);
//         if (sufMatch.size() == 0) {
//             return -1;
//         }
//         System.out.println("ans: " + sufMatch);

//         return Collections.max(sufMatch);
//     }

//     private Set<Integer> match(String word, Node node, int start) {
//         if (start == word.length()) {
//             return node.index;
//         }
//         char w = word.charAt(start);
//         if (node.next[w - 'a'] == null) {
//             return null;
//         }
//         return match(word, node.next[w - 'a'], start + 1);
//     }
    
//     public Set<Integer> startsWith(String prefix) {
//         return match(prefix, preRoot, 0);
//     }

//     public Set<Integer> endsWith(String suffix) {
//         String suff = new StringBuilder(suffix).reverse().toString();
//         return match(suff, sufRoot, 0);
//     }

// }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
// @lc code=end

