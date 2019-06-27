/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 */
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0, h = nums.length - 1;
        while(l < h) {
            if (nums[l] >= target){
                return l;
            }
            if (nums[h] < target) {
                return h + 1;
            }
            int mid = (l + h) / 2;
            if (nums[mid] > target) {
                h = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return nums[l] >= target ? l : l + 1;
    }
}

