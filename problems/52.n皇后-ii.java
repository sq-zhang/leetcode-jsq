/*
 * @lc app=leetcode.cn id=52 lang=java
 *
 * [52] N皇后 II
 *
 * https://leetcode-cn.com/problems/n-queens-ii/description/
 *
 * algorithms
 * Hard (76.35%)
 * Likes:    115
 * Dislikes: 0
 * Total Accepted:    21.9K
 * Total Submissions: 28K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * 
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步，可进可退。（引用自
 * 百度百科 - 皇后 ）
 * 
 * 
 */

// @lc code=start
class Solution {
    private int res = 0;
    public int totalNQueens(int n) {
        backtrace(0, new int[n], n);
        return res;
    }

    private void backtrace(int k,int [] array,int n){
        if(k == n){
            res++;
            return;
        }
        for(int i = 0;i < n;i++){
            array[k] = i;
            if(!check(array, n, k)){
                backtrace(k + 1, array, n);
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

