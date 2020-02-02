/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (66.90%)
 * Likes:    313
 * Dislikes: 0
 * Total Accepted:    23.4K
 * Total Submissions: 34.6K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 */

// @lc code=start
class Solution {
    private List<List<String>> res=new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        dfs(0, new int[n], n);
        return res;
    }

    private void dfs(int k,int [] array,int n){
        if(k == n){
            List<String> list = new ArrayList<>();
            for(int i = 0;i < n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j < n;j++){
                    if(array[i] == j){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for(int i = 0;i < n;i++){
            array[k] = i;
            if(!check(array, n, k)){
                dfs(k + 1, array, n);
            }
        }
    }

    private boolean check(int[] array,int n,int k){
        for(int i = 0;i < k;i++){
            if(Math.abs(k - i) == Math.abs(array[k] - array[i]) 
                || array[k] == array[i]){
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

