/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 *
 * https://leetcode-cn.com/problems/sum-of-left-leaves/description/
 *
 * algorithms
 * Easy (52.84%)
 * Likes:    104
 * Dislikes: 0
 * Total Accepted:    13.6K
 * Total Submissions: 25.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 计算给定二叉树的所有左叶子之和。
 * 
 * 示例：
 * 
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * 
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
    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            for(int i = 0;i < queue.size();i++) {
                TreeNode node = queue.get(i);
                if (node.left != null) {
                    if (node.left.left == null && node.left.right == null) {
                        res += node.left.val;
                    } else {
                        tmp.add(node.left);
                    }
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            queue = tmp;
        }

        return res;
    }
}
// @lc code=end

