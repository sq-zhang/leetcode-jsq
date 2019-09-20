/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */
class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dps = new int[nums.length];
        dps[nums.length - 1] = 0;
        for(int i = nums.length - 2;i >= 0;i--) {
            int min = Integer.MAX_VALUE - 1;
            for(int j = 1; j <= nums[i] && i + j <= dps.length - 1;j++) {
                min = (min < dps[i + j]) ? min : dps[i + j];
            }
            dps[i] = min + 1;
        }
        
        return dps[0];
    }
}

