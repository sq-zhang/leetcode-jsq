/*
 * @lc app=leetcode.cn id=1036 lang=java
 *
 * [1036] 逃离大迷宫
 *
 * https://leetcode-cn.com/problems/escape-a-large-maze/description/
 *
 * algorithms
 * Hard (24.86%)
 * Likes:    10
 * Dislikes: 0
 * Total Accepted:    657
 * Total Submissions: 2.6K
 * Testcase Example:  '[[0,1],[1,0]]\n[0,0]\n[0,2]'
 *
 * 在一个 10^6 x 10^6 的网格中，每个网格块的坐标为 (x, y)，其中 0 <= x, y < 10^6。
 * 
 * 我们从源方格 source 开始出发，意图赶往目标方格 target。每次移动，我们都可以走到网格中在四个方向上相邻的方格，只要该方格不在给出的封锁列表
 * blocked 上。
 * 
 * 只有在可以通过一系列的移动到达目标方格时才返回 true。否则，返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 
 * 
 * 示例 2：
 * 
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= blocked[i][j] < 10^6
 * source.length == target.length == 2
 * 0 <= source[i][j], target[i][j] < 10^6
 * source != target
 * 
 * 
 */

// @lc code=start
class Solution {

    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int len = 1_000_000;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<String> blockSet = new HashSet<>();
        for(int[] block : blocked) {
            blockSet.add(block[0] + "," + block[1]);
        }

        return check(blockSet, source, target) && check(blockSet, target, source);
    }

    private boolean check(Set<String> blockSet, int[] source, int[] target) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        String sourceStr = source[0] + "," + source[1];
        queue.offer(sourceStr);
        visited.add(sourceStr);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            if (size > blockSet.size()) {
                return true;
            }
            
            for(int i = 0; i < size; i++) {
                String[] arr = queue.poll().split(",");
                int x = Integer.valueOf(arr[0]), y = Integer.valueOf(arr[1]);
                for(int[] d : directions) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= len || ny < 0 || ny >= len) {
                        continue;   
                    }
                    if (nx == target[0] && ny == target[1]) {
                        return true;
                    }
                    
                    String nKey = nx + "," + ny;
                    if (visited.contains(nKey) || blockSet.contains(nKey)) {
                        continue;
                    }
                    
                    visited.add(nKey);
                    queue.offer(nKey);
                }
            }
        }

        return false;
    }
}
// @lc code=end

