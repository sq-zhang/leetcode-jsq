/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (55.22%)
 * Likes:    362
 * Dislikes: 0
 * Total Accepted:    35.3K
 * Total Submissions: 63.2K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 示例 :
 * 
 * 给定这个链表：1->2->3->4->5
 * 
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 
 * 说明 :
 * 
 * 
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode tmp = head;
        int step = 0;
        ListNode startK = null, endK, startKPre = newHead;
        while(tmp != null) {
            ListNode tmpNext = tmp.next;
            if (step == 0) {
                startK = tmp;
                step++;
            } else if (step == k - 1) {
                endK = tmp;
                ListNode pre = startK;
                ListNode cur = startK.next;
                if (cur == null) {
                    break;
                }
                ListNode endKNext = endK.next;
                while(cur != endKNext) {
                    ListNode next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                startKPre.next = endK;
                startK.next = endKNext;
                startKPre = startK;
                step = 0;
            } else {
                step++;
            }
            tmp = tmpNext;
        }
        
        return newHead.next;
    }
}
// @lc code=end

