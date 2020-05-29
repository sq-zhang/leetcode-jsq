/*
 * @lc app=leetcode.cn id=508 lang=java
 *
 * [508] 出现次数最多的子树元素和
 *
 * https://leetcode-cn.com/problems/most-frequent-subtree-sum/description/
 *
 * algorithms
 * Medium (59.46%)
 * Likes:    68
 * Dislikes: 0
 * Total Accepted:    5.9K
 * Total Submissions: 9.2K
 * Testcase Example:  '[5,2,-3]'
 *
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * 
 * 
 * 
 * 示例 1：
 * 输入:
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -3
 * 
 * 
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 * 
 * 示例 2：
 * 输入：
 * 
 * ⁠ 5
 * ⁠/  \
 * 2   -5
 * 
 * 
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 * 
 * 
 * 
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
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
    Map<Integer, Integer> counts = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        pathSum(root);
        List<Integer> res = new ArrayList<>();
        for(Integer num : counts.keySet()) {
            if (counts.get(num) == max) {
                res.add(num);
            }
        }
        int[] nums = new int[res.size()];
        for(int i = 0;i < res.size();i++) {
            nums[i] = res.get(i);
        }
        return nums;
    }

    private int pathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = pathSum(root.left);
        int right = pathSum(root.right);
        int val = left + right + root.val;
        counts.put(val, counts.getOrDefault(val, 0) + 1);
        max = Math.max(max, counts.get(val));
        return val;
    }
}
// @lc code=end

