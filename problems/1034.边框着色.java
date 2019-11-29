/*
 * @lc app=leetcode.cn id=1034 lang=java
 *
 * [1034] 边框着色
 *
 * https://leetcode-cn.com/problems/coloring-a-border/description/
 *
 * algorithms
 * Medium (38.39%)
 * Likes:    1
 * Dislikes: 0
 * Total Accepted:    863
 * Total Submissions: 2.2K
 * Testcase Example:  '[[1,1],[1,2]]\n0\n0\n3'
 *
 * 给出一个二维整数网格 grid，网格中的每个值表示该位置处的网格块的颜色。
 * 
 * 只有当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一连通分量。
 * 
 * 连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
 * 
 * 给出位于 (r0, c0) 的网格块和颜色 color，使用指定颜色 color 为所给网格块的连通分量的边界进行着色，并返回最终的网格 grid
 * 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：grid = [[1,1],[1,2]], r0 = 0, c0 = 0, color = 3
 * 输出：[[3, 3], [3, 2]]
 * 
 * 
 * 示例 2：
 * 
 * 输入：grid = [[1,2,2],[2,3,2]], r0 = 0, c0 = 1, color = 3
 * 输出：[[1, 3, 3], [2, 3, 3]]
 * 
 * 
 * 示例 3：
 * 
 * 输入：grid = [[1,1,1],[1,1,1],[1,1,1]], r0 = 1, c0 = 1, color = 2
 * 输出：[[2, 2, 2], [2, 1, 2], [2, 2, 2]]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length <= 50
 * 1 <= grid[0].length <= 50
 * 1 <= grid[i][j] <= 1000
 * 0 <= r0 < grid.length
 * 0 <= c0 < grid[0].length
 * 1 <= color <= 1000
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int target = grid[r0][c0];
        if(color == target) {
            return grid;
        }
        
        int m = grid.length, n = grid[0].length;
        int[][] visited = new int[m][n];
        int[][] res = new int[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                res[i][j] = grid[i][j];
            }
        }

        int[][] dir = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
        List<Integer> queue = new ArrayList<>();
        queue.add(r0);
        queue.add(c0);

        while(!queue.isEmpty()) {
            List<Integer> newQueue = new ArrayList<>();
            for(int i = 0;i < queue.size();i += 2) {
                int x = queue.get(i), y = queue.get(i + 1);
                visited[x][y] = 1;
                for(int k = 0;k < 4;k++) {
                    int nx = x + dir[0][k], ny = y + dir[1][k];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (visited[nx][ny] == 0) {
                            if (grid[nx][ny] == target) {
                                visited[nx][ny] = 1;
                                newQueue.add(nx);
                                newQueue.add(ny);
                            } else {
                                res[x][y] = color;
                            }
                        }
                    } else {
                        res[x][y] = color;
                    }
                }
            }
            queue = newQueue;
        }
        return res;
    }
}
// @lc code=end

