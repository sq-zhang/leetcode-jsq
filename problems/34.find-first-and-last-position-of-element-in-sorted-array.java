/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearch(nums, target);
        if (left == nums.length || nums[left] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left, binarySearch(nums, target + 1) - 1};
    }

    public int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int mid = (l + h) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l;
    }
}

