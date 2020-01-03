/*
 * @lc app=leetcode.cn id=1129 lang=java
 *
 * [1129] 颜色交替的最短路径
 *
 * https://leetcode-cn.com/problems/shortest-path-with-alternating-colors/description/
 *
 * algorithms
 * Medium (33.34%)
 * Likes:    17
 * Dislikes: 0
 * Total Accepted:    1.5K
 * Total Submissions: 4.7K
 * Testcase Example:  '3\n[[0,1],[1,2]]\n[]'
 *
 * 在一个有向图中，节点分别标记为 0, 1, ..., n-1。这个图中的每条边不是红色就是蓝色，且存在自环或平行边。
 * 
 * red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j]
 * 对表示从节点 i 到节点 j 的蓝色有向边。
 * 
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X
 * 的最短路径的长度，且路径上红色边和蓝色边交替出现。如果不存在这样的路径，那么 answer[x] = -1。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
 * 输出：[0,1,-1]
 * 
 * 
 * 示例 2：
 * 
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
 * 输出：[0,1,-1]
 * 
 * 
 * 示例 3：
 * 
 * 输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
 * 输出：[0,-1,-1]
 * 
 * 
 * 示例 4：
 * 
 * 输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
 * 输出：[0,1,2]
 * 
 * 
 * 示例 5：
 * 
 * 输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
 * 输出：[0,1,1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 100
 * red_edges.length <= 400
 * blue_edges.length <= 400
 * red_edges[i].length == blue_edges[i].length == 2
 * 0 <= red_edges[i][j], blue_edges[i][j] < n
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Set<Integer>[][] graph = new HashSet[2][n];
        for (int i = 0; i < n; i++) {
            graph[0][i] = new HashSet<>();
            graph[1][i] = new HashSet<>();
        }
        for (int[] re : red_edges) {
            graph[0][ re[0] ].add(re[1]);
        }
        for (int[] blu : blue_edges) {
            graph[1][ blu[0] ].add(blu[1]);
        }
        int[][] res = new int[2][n];
        for (int i = 1; i < n; i++) {
            res[0][i] = 2 * n;
            res[1][i] = 2 * n;
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        q.offer(new int[] {0, 1});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int color = cur[1], nextColor = 1 - cur[1];
            for (int next : graph[nextColor][cur[0]]) {
                if (res[nextColor][next] == 2 * n) {
                    res[nextColor][next] = 1 + res[color][cur[0]];
                    q.offer(new int[] {next, nextColor});
                }
            }
        }
        
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int t = Math.min(res[0][i], res[1][i]);
            ans[i] = (t == 2 * n) ? -1 : t;
        }
        return ans;
    }
}
// @lc code=end

