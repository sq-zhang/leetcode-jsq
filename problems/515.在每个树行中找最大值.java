/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
 *
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (56.76%)
 * Likes:    54
 * Dislikes: 0
 * Total Accepted:    6.4K
 * Total Submissions: 11.1K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * 您需要在二叉树的每一行中找到最大的值。
 * 
 * 示例：
 * 
 * 
 * 输入: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * 输出: [1, 3, 9]
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            List<TreeNode> newQueue = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for(TreeNode node : queue) {
                max = Math.max(max, node.val);
                if (node.left != null) {
                    newQueue.add(node.left);
                }
                if (node.right != null) {
                    newQueue.add(node.right);
                }
            }
            res.add(max);
            queue = newQueue;
        }
        return res;
    }
}
// @lc code=end

