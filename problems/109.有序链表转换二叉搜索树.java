/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 *
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/description/
 *
 * algorithms
 * Medium (69.46%)
 * Likes:    209
 * Dislikes: 0
 * Total Accepted:    27.9K
 * Total Submissions: 38.6K
 * Testcase Example:  '[-10,-3,0,5,9]'
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * 
 * ⁠     0
 * ⁠    / \
 * ⁠  -3   9
 * ⁠  /   /
 * ⁠-10  5
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        this.head = head;
        ListNode cur = head;
        int n = 0;
        while(cur != null) {
            cur = cur.next;
            n++;
        }
        return convertListToBST(0, n - 1);
    }

    private TreeNode convertListToBST(int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = convertListToBST(l, mid - 1);
        TreeNode node = new TreeNode(head.val);
        node.left = left;
        head = head.next;
        node.right = convertListToBST(mid + 1, r);
        return node;
    }
}
// @lc code=end

