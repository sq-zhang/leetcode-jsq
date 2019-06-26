/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, last = 0, current = 0;
        while(i + j <= (nums1.length + nums2.length) / 2) {
            last = current;
            if(i == nums1.length) {
                current = nums2[j++];
            } else if (j == nums2.length) {
                current = nums1[i++];
            } else if (nums1[i] <= nums2[j]) {
                current = nums1[i++];
            } else {
                current = nums2[j++];
            }
        }
        if((nums1.length + nums2.length) % 2 == 0) {
            return (last + current) / 2.0;
        } else {
            return current;
        }
    }
}

