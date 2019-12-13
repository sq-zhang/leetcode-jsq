/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *
 * algorithms
 * Medium (65.12%)
 * Likes:    135
 * Dislikes: 0
 * Total Accepted:    19K
 * Total Submissions: 29K
 * Testcase Example:  '[9,3,15,20,7]\n[9,15,7,20,3]'
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int is, int ir, int[] postorder, int ps, int pr) {
        if (is > ir || ps > pr) {
            return null;
        }

        int rootNum = postorder[pr];
        int rootIndex = is;

        while (inorder[rootIndex] != rootNum) {
            rootIndex++;
        }
        TreeNode root = new TreeNode(rootNum);
        root.left = buildTree(inorder, is, rootIndex - 1, postorder, ps, pr - ir + rootIndex - 1);
        root.right = buildTree(inorder, rootIndex + 1, ir, postorder, pr - ir + rootIndex, pr - 1);
        
        return root;
    }
}
// @lc code=end

