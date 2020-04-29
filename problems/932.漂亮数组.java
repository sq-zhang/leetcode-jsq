/*
 * @lc app=leetcode.cn id=932 lang=java
 *
 * [932] 漂亮数组
 *
 * https://leetcode-cn.com/problems/beautiful-array/description/
 *
 * algorithms
 * Medium (56.37%)
 * Likes:    63
 * Dislikes: 0
 * Total Accepted:    3.8K
 * Total Submissions: 6.5K
 * Testcase Example:  '4'
 *
 * 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 * 
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 * 
 * 那么数组 A 是漂亮数组。
 * 
 * 
 * 
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：4
 * 输出：[2,1,4,3]
 * 
 * 
 * 示例 2：
 * 
 * 输入：5
 * 输出：[3,1,2,5,4]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= N <= 1000
 * 
 * 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] beautifulArray(int N) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        while(arr.size() < N) {
            List<Integer> next = new ArrayList<>();
            for(int num : arr) {
                next.add(2 * num - 1);
            }
            for(int num : arr) {
                next.add(2 * num);
            }
            arr = next;
        }
        int[] res = new int[N];
        for(int i = 0, j = 0;i < arr.size();i++) {
            if (arr.get(i) <= N) {
                res[j++] = arr.get(i);
            }
        }
        return res;
    }
}
// @lc code=end

