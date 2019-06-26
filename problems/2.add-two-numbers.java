/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (31.20%)
 * Likes:    5281
 * Dislikes: 1360
 * Total Accepted:    893.7K
 * Total Submissions: 2.9M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example:
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 
 * 
 */
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
        ListNode head = new ListNode(0);
        ListNode n = head;
        int carries = 0;
        while (l1 != null || l2 != null || carries > 0) {
            if (l1 != null) {
                carries += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carries += l2.val;
                l2 = l2.next;
            }
            n.next = new ListNode(carries % 10);
            n = n.next;
            carries /= 10;
        }
        return head.next;
    }
}

