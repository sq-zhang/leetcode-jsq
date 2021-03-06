/*
 * @lc app=leetcode.cn id=924 lang=java
 *
 * [924] 尽量减少恶意软件的传播
 *
 * https://leetcode-cn.com/problems/minimize-malware-spread/description/
 *
 * algorithms
 * Hard (40.59%)
 * Likes:    29
 * Dislikes: 0
 * Total Accepted:    1.9K
 * Total Submissions: 5.1K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]\n[0,1]'
 *
 * 在节点网络中，只有当 graph[i][j] = 1 时，每个节点 i 能够直接连接到另一个节点 j。
 * 
 * 一些节点 initial
 * 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。
 * 
 * 假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。
 * 
 * 我们可以从初始列表中删除一个节点。如果移除这一节点将最小化 M(initial)， 则返回该节点。如果有多个节点满足条件，就返回索引最小的节点。
 * 
 * 请注意，如果某个节点已从受感染节点的列表 initial 中删除，它以后可能仍然因恶意软件传播而受到感染。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
 * 输出：0
 * 
 * 
 * 示例 2：
 * 
 * 输入：graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
 * 输出：0
 * 
 * 
 * 示例 3：
 * 
 * 输入：graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
 * 输出：1
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 < graph.length = graph[0].length <= 300
 * 0 <= graph[i][j] == graph[j][i] <= 1
 * graph[i][i] == 1
 * 1 <= initial.length < graph.length
 * 0 <= initial[i] < graph.length
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int[] root = new int[n];
        for(int i = 0;i < n;i++) {
            root[i] = i;
        }
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < n;j++) {
                if (graph[i][j] == 1) {
                    root = union(root, i, j);
                }
            }
        }
        int[] weights = new int[n], counts = new int[n];
        for(int i = 0;i < n;i++) {
            weights[find(root, i)]++;
        }
        for(int i : initial) {
            counts[find(root, i)]++;
        }
        Arrays.sort(initial);
        int max = -1, res = -1;
        for(int i : initial) {
            int x = find(root, i);
            if (counts[x] == 1 && weights[x] > max) {
                max = weights[x];
                res = i;
            }
        }
        return res == -1 ? initial[0] : res;
    }

    private int[] union(int[] root, int x, int y) {
        root[find(root, x)] = find(root, y);
        return root;
    }

    private int find(int[] root, int x) {
        if (x == root[x]) {
            return x;
        } else {
            root[x] = find(root, root[x]);
            return root[x];
        }
    }
}
// @lc code=end

