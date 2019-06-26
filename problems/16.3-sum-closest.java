/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0;i < nums.length - 2;i++) {
            int l = i + 1, h = nums.length - 1;
            while(l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum - target == 0) {
                    return sum;
                } else if (sum - target > 0) {
                    h--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
}

