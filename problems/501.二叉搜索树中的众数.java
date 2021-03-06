/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 *
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/description/
 *
 * algorithms
 * Easy (42.58%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    7K
 * Total Submissions: 16.5K
 * Testcase Example:  '[1,null,2,2]'
 *
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * 
 * 假定 BST 有如下定义：
 * 
 * 
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 
 * 
 * 例如：
 * 给定 BST [1,null,2,2],
 * 
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  2
 * 
 * 
 * 返回[2].
 * 
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
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

    private List<Integer> res = new LinkedList<>();
    private Integer current = 0;
    private Integer max = 0;
    private TreeNode pre;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        int[] resArr = new int[res.size()];
        for(int i = 0;i < res.size();i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        if (pre != null && pre.val == root.val) {
            current++;
        } else {
            current = 1;
        }
        if (current == max) {
            res.add(root.val);
        } else if (current > max) {
            max = current;
            res.clear();
            res.add(root.val);
        }
        pre = root;
        inOrder(root.right);
    }
}
// @lc code=end

