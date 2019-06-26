/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
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

    //   ✔ Accepted
    //   ✔ 55/55 cases passed (0 ms)
    //   ✔ Your runtime beats 100 % of java submissions
    //   ✔ Your memory usage beats 100 % of java submissions (34.7 MB)
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    //   ✔ Accepted
    //   ✔ 55/55 cases passed (0 ms)
    //   ✔ Your runtime beats 100 % of java submissions
    //   ✔ Your memory usage beats 100 % of java submissions (34.5 MB)
    public ListNode swapPairs2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head, next = head.next;
        if (next == null) {
            return head;
        } else {
            head = next;
        }
        ListNode tail = new ListNode(-1);
        tail.next = head;
        
        while (prev != null && next != null) {
            prev.next = next.next;
            next.next = prev;
            tail.next = next;
            tail = prev;
            if (prev != null) {
                prev = prev.next;
                if (prev != null) {
                    next = prev.next;
                }
            }
        }
        return head;
    }
}

