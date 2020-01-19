/*
 * @lc app=leetcode.cn id=368 lang=java
 *
 * [368] 最大整除子集
 *
 * https://leetcode-cn.com/problems/largest-divisible-subset/description/
 *
 * algorithms
 * Medium (35.99%)
 * Likes:    58
 * Dislikes: 0
 * Total Accepted:    4.1K
 * Total Submissions: 11.5K
 * Testcase Example:  '[1,2,3]'
 *
 * 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si =
 * 0。
 * 
 * 如果有多个目标子集，返回其中任何一个均可。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2] (当然, [1,3] 也正确)
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1,2,4,8]
 * 输出: [1,2,4,8]
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        int n = nums.length, max = 0, end = -1;
        List<Integer> res = new ArrayList<>();
        int[] dp = new int[n], last = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(last, -1);
        for(int i = 0;i < n;i++){
            for(int j = 0;j < i;j++){
                if(nums[i] % nums[j] == 0 && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                    last[i] = j;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                end = i;
            }
        }
        for(int i = end; i != -1;i = last[i]) {
            res.add(nums[i]);
        }
        Collections.reverse(res);
        return res;
    }
}
// @lc code=end

