/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 *
 * https://leetcode-cn.com/problems/add-two-numbers-ii/description/
 *
 * algorithms
 * Medium (52.37%)
 * Likes:    108
 * Dislikes: 0
 * Total Accepted:    11.2K
 * Total Submissions: 21.1K
 * Testcase Example:  '[7,2,4,3]\n[5,6,4]'
 *
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 * 
 * 
 * 
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * 进阶:
 * 
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 
 * 示例:
 * 
 * 
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode node1 = reverse(l1);
        ListNode node2 = reverse(l2);
        int carry = 0;
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        while (node1 != null || node2 != null){
            int x = node1 != null ? node1.val : 0;
            int y = node2 != null ? node2.val : 0;
            int num = (x + y + carry) % 10;
            ListNode node = new ListNode(num);
            curr.next = node;
            curr = node;
            carry = (x + y + carry) / 10;
            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;
        }
        // 最后加上 carry
        if (carry > 0) curr.next = new ListNode(carry);
        ListNode res = reverse(newHead.next);
        return res;
    }
    // 链表反转
    public ListNode reverse(ListNode head){
        if (head == null) return null;
        ListNode pre = null;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
// @lc code=end

