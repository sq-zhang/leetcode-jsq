/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 *
 * https://leetcode-cn.com/problems/sort-array-by-parity/description/
 *
 * algorithms
 * Easy (67.82%)
 * Likes:    112
 * Dislikes: 0
 * Total Accepted:    26.4K
 * Total Submissions: 38.9K
 * Testcase Example:  '[3,1,2,4]'
 *
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 
 * 你可以返回满足此条件的任何数组作为答案。
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while(i < j) {
            if(A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            if(A[i] % 2 == 0) {
                i++;
            }
            if(A[j] % 2 == 1) {
                j--;
            }
        }
        return A;
    }
}
// @lc code=end

