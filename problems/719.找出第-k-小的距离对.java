/*
 * @lc app=leetcode.cn id=719 lang=java
 *
 * [719] 找出第 k 小的距离对
 *
 * https://leetcode-cn.com/problems/find-k-th-smallest-pair-distance/description/
 *
 * algorithms
 * Hard (29.88%)
 * Likes:    71
 * Dislikes: 0
 * Total Accepted:    3.3K
 * Total Submissions: 10.4K
 * Testcase Example:  '[1,3,1]\n1'
 *
 * 给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。
 * 
 * 示例 1:
 * 
 * 
 * 输入：
 * nums = [1,3,1]
 * k = 1
 * 输出：0 
 * 解释：
 * 所有数对如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
 * 
 * 
 * 提示:
 * 
 * 
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums[nums.length - 1] - nums[0];
        while(left < right) {
            int mid = (left + right) / 2;
            if (countPair(nums, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countPair(int[] nums, int target) {
        int ans = 0, end = 0;
        for(int i = 0;i < nums.length;i++) {
            while(end + 1 < nums.length && nums[end + 1] - nums[i] <= target) {
                end++;
            }
            ans += end - i;
        }
        return ans;
    }

}
// @lc code=end

