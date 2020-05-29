/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
 *
 * https://leetcode-cn.com/problems/find-bottom-left-tree-value/description/
 *
 * algorithms
 * Medium (67.28%)
 * Likes:    88
 * Dislikes: 0
 * Total Accepted:    14.7K
 * Total Submissions: 20.9K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 
 * 示例 1:
 * 
 * 
 * 输入:
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * 输出:
 * 1
 * 
 * 
 * 
 * 
 * 示例 2: 
 * 
 * 
 * 输入:
 * 
 * ⁠       1
 * ⁠      / \
 * ⁠     2   3
 * ⁠    /   / \
 * ⁠   4   5   6
 * ⁠      /
 * ⁠     7
 * 
 * 输出:
 * 7
 * 
 * 
 * 
 * 
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
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
    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        if (root != null) {
            level.add(root);
        }
        while(!level.isEmpty()) {
            List<TreeNode> newLevel = new ArrayList<>();
            for(TreeNode node : level) {
                if (node.left != null) {
                    newLevel.add(node.left);
                }
                if (node.right != null) {
                    newLevel.add(node.right);
                }
            }
            if (newLevel.isEmpty()) {
                return level.get(0).val;
            }
            level = newLevel;
        }
        return 0;
    }
}
// @lc code=end

