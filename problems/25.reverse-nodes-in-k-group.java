/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
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
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode current = head;
        while(current != null && n != k) {
            current = current.next;
            n++;
        }
        if (n == k) {
            current = reverseKGroup(current, k);
            while(n > 0) {
                ListNode next = head.next;
                head.next = current;
                current = head;
                head = next;
                n--;
            }
            head = current;
        }

        return head;
    }

}

