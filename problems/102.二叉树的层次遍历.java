/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (59.94%)
 * Likes:    512
 * Dislikes: 0
 * Total Accepted:    138.7K
 * Total Submissions: 220.7K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 返回其层次遍历结果：
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        if (root != null) {
            level.add(root);
        }
        while(!level.isEmpty()) {
            List<Integer> nums = new ArrayList<>();
            List<TreeNode> newLevel = new ArrayList<>();
            for(TreeNode node : level) {
                nums.add(node.val);
                if (node.left != null) {
                    newLevel.add(node.left);
                }
                if (node.right != null) {
                    newLevel.add(node.right);
                }
            }
            res.add(nums);
            level = newLevel;
        }
        return res;
    }
}
// @lc code=end

