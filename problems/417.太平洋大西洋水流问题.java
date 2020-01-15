/*
 * @lc app=leetcode.cn id=417 lang=java
 *
 * [417] 太平洋大西洋水流问题
 *
 * https://leetcode-cn.com/problems/pacific-atlantic-water-flow/description/
 *
 * algorithms
 * Medium (39.54%)
 * Likes:    65
 * Dislikes: 0
 * Total Accepted:    4.1K
 * Total Submissions: 10.4K
 * Testcase Example:  '[[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]'
 *
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 * 
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * 
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 
 * 给定下面的 5x5 矩阵:
 * 
 * ⁠ 太平洋 ~   ~   ~   ~   ~ 
 * ⁠      ~  1   2   2   3  (5) *
 * ⁠      ~  3   2   3  (4) (4) *
 * ⁠      ~  2   4  (5)  3   1  *
 * ⁠      ~ (6) (7)  1   4   5  *
 * ⁠      ~ (5)  1   1   2   4  *
 * ⁠         *   *   *   *   * 大西洋
 * 
 * 返回:
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visit1 = new boolean[m][n], visit2 = new boolean[m][n];
        for(int i = 0;i < m;i++) {
            visit1[i][0] = true;
            dfs(matrix, visit1, i, 0, m, n);
        }
        for(int j = 0;j < n;j++) {
            visit1[0][j] = true;
            dfs(matrix, visit1, 0, j, m, n);
        }
        for(int i = 0;i < m;i++) {
            visit2[i][n - 1] = true;
            dfs(matrix, visit2, i, n - 1, m, n);
        }
        for(int j = 0;j < n;j++) {
            visit2[m - 1][j] = true;
            dfs(matrix, visit2, m - 1, j, m, n);
        }
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if (visit1[i][j] && visit2[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] matrix, boolean[][] visit, int i, int j, int m, int n) {
        if(i > 0 && !visit[i - 1][j] && matrix[i - 1][j] >= matrix[i][j]){
            visit[i - 1][j] = true;
            dfs(matrix, visit, i - 1, j, m, n);
        }
        if(j > 0 && !visit[i][j - 1] && matrix[i][j - 1] >= matrix[i][j]){
            visit[i][j - 1] = true;
            dfs(matrix, visit, i, j - 1, m, n);
        }
        if(i < m - 1 && !visit[i + 1][j] && matrix[i + 1][j] >= matrix[i][j]){
            visit[i + 1][j] = true;
            dfs(matrix, visit, i + 1, j, m, n);
        }
        if(j < n - 1 && !visit[i][j + 1] && matrix[i][j + 1] >= matrix[i][j]){
            visit[i][j + 1] = true;
            dfs(matrix, visit, i, j + 1, m, n);
        }
    }
}
// @lc code=end

