/*
 * @lc app=leetcode.cn id=863 lang=java
 *
 * [863] 二叉树中所有距离为 K 的结点
 *
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/description/
 *
 * algorithms
 * Medium (44.50%)
 * Likes:    105
 * Dislikes: 0
 * Total Accepted:    5.2K
 * Total Submissions: 10.5K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n2'
 *
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * 
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 
 * 输出：[7,4,1]
 * 
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * 
 * 
 * 
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 给定的树是非空的，且最多有 K 个结点。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        dfs(root, target, K, res);
        return res;
    }

    private int dfs(TreeNode root, TreeNode target, int K, List<Integer> res) {
        if (root == null) {
            return -1;
        } else if (root == target) {
            dfs(root, 0, K, res);
            return 1;
        }
        int l = dfs(root.left, target, K, res), 
            r = dfs(root.right, target, K, res);
        if (l != -1) {
            if (l == K) {
                res.add(root.val);
            }
            dfs(root.right, l + 1, K, res);
            return l + 1;
        } else if (r != -1) {
            if (r == K) {
                res.add(root.val);
            }
            dfs(root.left, r + 1, K, res);
            return r + 1;
        } else {
            return -1;
        }
    }

    private void dfs(TreeNode root, int d, int K, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (d == K) {
            res.add(root.val);
        } else {
            dfs(root.left, d + 1, K, res);
            dfs(root.right, d + 1, K, res);
        }
    }
}
// @lc code=end

