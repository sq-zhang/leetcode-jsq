/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (63.02%)
 * Likes:    343
 * Dislikes: 0
 * Total Accepted:    43.2K
 * Total Submissions: 67.4K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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

    Map<Integer, Integer> maps = new HashMap<>();
    Integer rootIndex = 0;

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if (left == right) {
            return null;
        }

        int rootVal = preorder[rootIndex++];
        TreeNode root = new TreeNode(rootVal);

        int index = maps.get(rootVal);
        root.left = helper(preorder, inorder, left, index);
        root.right = helper(preorder, inorder, index + 1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0;i < inorder.length;i++) {
            maps.put(inorder[i], i);
        }
        
        return helper(preorder, inorder, 0, inorder.length);
    }
}
// @lc code=end

