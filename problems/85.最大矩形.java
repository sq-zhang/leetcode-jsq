/*
 * @lc app=leetcode.cn id=85 lang=java
 *
 * [85] 最大矩形
 *
 * https://leetcode-cn.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (43.29%)
 * Likes:    264
 * Dislikes: 0
 * Total Accepted:    14.1K
 * Total Submissions: 32.4K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 示例:
 * 
 * 输入:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * 
 */

// @lc code=start
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] dp = new int[matrix[0].length];
        int res = 0;
        for(int i = 0;i < matrix.length;i++) {
            for(int j = 0;j < matrix[0].length;j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            res = Math.max(res, largestRectangleArea(dp));
        }

        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0;i < heights.length;i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        
        while(stack.peek() != -1) {
            res = Math.max(res, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }

        return res;
    }
}
// @lc code=end

