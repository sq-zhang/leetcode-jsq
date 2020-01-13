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
        List<Integer> nums1 = getNums(l1);
        List<Integer> nums2 = getNums(l2);
        ListNode res = null;
        int i = nums1.size() - 1, j = nums2.size() - 1, n = 0;
        while(i >= 0 || j >= 0 || n > 0) {
            if (i >= 0) {
                n += nums1.get(i--);
            }
            if (j >= 0) {
                n += nums2.get(j--);
            }
            ListNode cur = new ListNode(n % 10);
            cur.next = res;
            res = cur;
            n /= 10;
        }

        return res;
    }

    List<Integer> getNums(ListNode l) {
        List<Integer> nums = new ArrayList<>();
        while(l != null) {
            nums.add(l.val);
            l = l.next;
        }
        return nums;
    }
}
// @lc code=end

