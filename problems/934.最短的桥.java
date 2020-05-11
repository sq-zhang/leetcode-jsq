/*
 * @lc app=leetcode.cn id=934 lang=java
 *
 * [934] 最短的桥
 *
 * https://leetcode-cn.com/problems/shortest-bridge/description/
 *
 * algorithms
 * Medium (42.49%)
 * Likes:    75
 * Dislikes: 0
 * Total Accepted:    5.2K
 * Total Submissions: 11.9K
 * Testcase Example:  '[[0,1],[1,0]]'
 *
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 * 
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 * 
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[[0,1],[1,0]]
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 输入：[[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 
 * 
 * 示例 3：
 * 
 * 输入：[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length = A[0].length <= 100
 * A[i][j] == 0 或 A[i][j] == 1
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] color = dfs(A, m, n);
        
        List<Integer> queue = new ArrayList<>();
        Set<Integer> target = new HashSet<>();
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if (color[i][j] == 1) {
                    queue.add(i * n + j);
                } else if (color[i][j] == 2){
                    target.add(i * n + j);
                }
            }
        }
        int res = 0;
        while(!queue.isEmpty()) {
            List<Integer> newQueue = new ArrayList<>();
            for(Integer node : queue) {
                if (target.contains(node)) {
                    return res - 1;
                }
                int r = node / n, c = node % n;
                for(int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && color[nr][nc] != 1) {
                        color[nr][nc] = 1;
                        newQueue.add(nr * n + nc);
                    }
                }
            }
            queue = newQueue;
            res++;
        }

        return -1;
    }

    private int[][] dfs(int[][] A, int m, int n) {
        int[][] color = new int[m][n];
        int t = 0;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if (color[i][j] != 0 || A[i][j] != 1) {
                    continue;
                }
                Stack<Integer> stack = new Stack<>();
                stack.push(i * n + j);
                color[i][j] = ++t;
                while(!stack.isEmpty()) {
                    int node = stack.pop();
                    int r = node / n, c = node % n;
                    for(int[] dir : dirs) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n 
                            && A[nr][nc] == 1 && color[nr][nc] == 0) {
                            color[nr][nc] = t;
                            stack.push(nr * n + nc);
                        }
                    }
                }
            }
        }
        return color;
    }
}
// @lc code=end

