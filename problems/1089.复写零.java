/*
 * @lc app=leetcode.cn id=1089 lang=java
 *
 * [1089] 复写零
 *
 * https://leetcode-cn.com/problems/duplicate-zeros/description/
 *
 * algorithms
 * Easy (57.54%)
 * Likes:    17
 * Dislikes: 0
 * Total Accepted:    5.2K
 * Total Submissions: 9.1K
 * Testcase Example:  '[1,0,2,3,0,4,5,0]'
 *
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 
 * 
 * 示例 2：
 * 
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * 
 * 
 */

// @lc code=start
class Solution {
    public void duplicateZeros(int[] arr) {
        int[] offsets = new int[arr.length];
        int[] arrcopy = new int[arr.length];
        int i = 0;
        for(int j = 0;j < arr.length;j++) {
            arrcopy[j] = arr[j];
            offsets[j] = i;
            if (arr[j] == 0) {
                i++;
            }
        }
        
        if (i == 0) {
            return;
        }
        for(int j = 0;j < arr.length;j++) {
            arr[j] = 0;
        }
        for(int j = 0;j + offsets[j] < arr.length;j++) {
            arr[j + offsets[j]] = arrcopy[j];
        }
    }
}
// @lc code=end

