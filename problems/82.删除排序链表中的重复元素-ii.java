/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/description/
 *
 * algorithms
 * Medium (44.64%)
 * Likes:    186
 * Dislikes: 0
 * Total Accepted:    26.6K
 * Total Submissions: 59.4K
 * Testcase Example:  '[1,2,3,3,4,4,5]'
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 
 * 
 * 示例 2:
 * 
 * 输入: 1->1->1->2->3
 * 输出: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(-1), last = null;
        ListNode current = res;
        boolean delete = true;
        while(head != null) {
            if (last == null || last.val != head.val) {
                if (!delete) {
                    current.next = last;
                    current = current.next;
                }
                last = head;
                delete = false;
            } else {
                delete = true;
            }
            head = head.next;
        }
        
        current.next = delete ? null : last;

        return res.next;
    }
}
// @lc code=end

