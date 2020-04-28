/*
 * @lc app=leetcode.cn id=864 lang=java
 *
 * [864] 获取所有钥匙的最短路径
 *
 * https://leetcode-cn.com/problems/shortest-path-to-get-all-keys/description/
 *
 * algorithms
 * Hard (38.28%)
 * Likes:    34
 * Dislikes: 0
 * Total Accepted:    1.1K
 * Total Submissions: 2.7K
 * Testcase Example:  '["@.a.#","###.#","b.A.B"]'
 *
 * 给定一个二维网格 grid。 "." 代表一个空房间， "#" 代表一堵墙， "@" 是起点，（"a", "b", ...）代表钥匙，（"A",
 * "B", ...）代表锁。
 * 
 * 
 * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
 * 
 * 假设 K 为钥匙/锁的个数，且满足 1 <= K <= 6，字母表中的前 K
 * 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
 * 
 * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：["@.a.#","###.#","b.A.B"]
 * 输出：8
 * 
 * 
 * 示例 2：
 * 
 * 输入：["@..aA","..B#.","....b"]
 * 输出：6
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= grid.length <= 30
 * 1 <= grid[0].length <= 30
 * grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
 * 钥匙的数目范围是 [1, 6]，每个钥匙都对应一个不同的字母，正好打开一个对应的锁。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int m = grid.length, n = grid[0].length();
        int[][][] dis = new int[m][n][1 << 6];
        for(int[][] d : dis) {
            for(int[] dd : d) {
                Arrays.fill(dd, Integer.MAX_VALUE);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int target = 0;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if (grid[i].charAt(j) == '@') {
                    queue.add(new int[]{i, j, 0, 0});
                    dis[i][j][0] = 0;
                } else if (Character.isLowerCase(grid[i].charAt(j))) {
                    target |= 1 << (grid[i].charAt(j) - 'a');
                }
            }
        }
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], step = cur[2], status = cur[3];
            if (status == target) {
                return step;
            }
            for(int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    char c = grid[nx].charAt(ny);
                    if (Character.isLowerCase(c)) {
                        int nextStatus = status | (1 << (c - 'a'));
                        if (dis[nx][ny][nextStatus] > step + 1) {
                            dis[nx][ny][nextStatus] = step + 1;
                            queue.add(new int[]{nx, ny, step + 1, nextStatus});
                        }
                    } else if (c == '.' || c == '@' || (Character.isUpperCase(c) && (status & 1 << (c - 'A')) != 0)) {
                        if (dis[nx][ny][status] > step + 1) {
                            dis[nx][ny][status] = step + 1;
                            queue.add(new int[]{nx, ny, step + 1, status});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
// @lc code=end

