/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 *
 * https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/description/
 *
 * algorithms
 * Medium (43.74%)
 * Likes:    62
 * Dislikes: 0
 * Total Accepted:    6K
 * Total Submissions: 13.2K
 * Testcase Example:  '[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]\r'
 *
 * 
 * 您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 
 * 扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入:
 * ⁠1---2---3---4---5---6--NULL
 * ⁠        |
 * ⁠        7---8---9---10--NULL
 * ⁠            |
 * ⁠            11--12--NULL
 * 
 * 输出:
 * 1-2-3-7-8-11-12-9-10-4-5-6-NULL
 * 
 * 
 * 
 * 
 * 以上示例的说明:
 * 
 * 给出以下多级双向链表:
 * 
 * 
 * 
 * 
 * 
 * 我们应该返回如下所示的扁平双向链表:
 * 
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        Node newHead = new Node(0, null, head, null);
        dfs(newHead, head);
        newHead.next.prev = null;
        return newHead.next;
    }
    private Node dfs(Node prev, Node cur) {
        if (cur == null) {
            return prev;
        }    
        cur.prev = prev;
        prev.next = cur;

        Node tempNext = cur.next;
        Node tail = dfs(cur, cur.child);
        cur.child = null;

        return dfs(tail, tempNext);
    }
}
// @lc code=end

