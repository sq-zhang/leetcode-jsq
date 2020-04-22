/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 *
 * https://leetcode-cn.com/problems/maximum-swap/description/
 *
 * algorithms
 * Medium (37.41%)
 * Likes:    70
 * Dislikes: 0
 * Total Accepted:    5.2K
 * Total Submissions: 13.1K
 * Testcase Example:  '2736'
 *
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 
 * 示例 1 :
 * 
 * 
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 
 * 
 * 示例 2 :
 * 
 * 
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 
 * 
 * 注意:
 * 
 * 
 * 给定数字的范围是 [0, 10^8]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        int n = num;
        List<Integer> numsList = new ArrayList<>();
        while(n > 0) {
            numsList.add(n % 10);
            n /= 10;
        }
        int[] nums = new int[numsList.size()];
        for(int i = 0;i < numsList.size();i++) {
            nums[i] = numsList.get(i);
        }
        
        int[] maxNum = new int[nums.length];
        maxNum[0] = nums[0];
        for(int i = 1;i < nums.length;i++) {
            maxNum[i] = Math.max(maxNum[i - 1], nums[i]);
        }
        int maxIndex = -1, minIndex = -1;
        for(int i = nums.length - 1;i >= 0;i--) {
            if (nums[i] < maxNum[i]) {
                maxIndex = i;
                break;
            }
        }
        if (maxIndex == -1) {
            return num;
        }
        for(int i = 0;i < nums.length;i++) {
            if (nums[i] == maxNum[maxIndex]) {
                minIndex = i;
                break;
            }
        }
        int t = nums[maxIndex];
        nums[maxIndex] = nums[minIndex];
        nums[minIndex] = t;

        int res = 0;
        for(int i = nums.length - 1;i >= 0;i--) {
            res = res * 10 + nums[i];
        }
        return res;
    }
}
// @lc code=end

