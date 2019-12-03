/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 *
 * https://leetcode-cn.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Medium (33.27%)
 * Likes:    59
 * Dislikes: 0
 * Total Accepted:    2.9K
 * Total Submissions: 8.6K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * 给定一个机票的字符串二维数组 [from,
 * to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从
 * JFK 出发。
 * 
 * 说明:
 * 
 * 
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"]
 * 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 
 * 
 * 示例 1:
 * 
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 
 * 
 * 示例 2:
 * 
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 * 
 */

// @lc code=start
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList<>();
        if(tickets == null || tickets.size() == 0) {
            return res;
        }

        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket : tickets) {
            PriorityQueue<String> pq = graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>());
            pq.add(ticket.get(1));
        }

        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while(!stack.isEmpty()) {
            PriorityQueue<String> pq = graph.get(stack.peek());
            while(pq != null && pq.size() > 0) {
                stack.push(pq.poll());
                pq = graph.get(stack.peek());
            }
            res.add(0, stack.pop());
        }

        return res;
    }
}
// @lc code=end

