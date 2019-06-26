import javafx.util.Pair;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    //   ✔ 131/131 cases passed (3 ms)
    //   ✔ Your runtime beats 87.13 % of java submissions
    //   ✔ Your memory usage beats 19.4 % of java submissions (43.6 MB)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return partition(lists, 0, lists.length - 1);
    }

    public ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode l1 = partition(lists, start, mid);
        ListNode l2 = partition(lists, mid + 1, end);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // ✔ Accepted
    // ✔ 131/131 cases passed (36 ms)
    // ✔ Your runtime beats 34.28 % of java submissions
    // ✔ Your memory usage beats 26.24 % of java submissions (41.8 MB)
    public ListNode mergeKListsWithQueue(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode res = new ListNode(0);
        ListNode head = res;

        Queue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,
            (a, b) -> a.val - b.val
        );

        for(ListNode l : lists) {
            if (l != null) {
                queue.add(l);
            }
        }
        while(!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;
            if (head.next != null) {
                queue.add(head.next);
            }
        }
        return res.next;
    }
}

