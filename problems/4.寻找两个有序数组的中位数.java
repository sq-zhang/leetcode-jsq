/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 *
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (36.35%)
 * Likes:    2178
 * Dislikes: 0
 * Total Accepted:    143.7K
 * Total Submissions: 390.2K
 * Testcase Example:  '[1,3]\n[2]'
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * 则中位数是 2.0
 * 
 * 
 * 示例 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int mid = (m + n + 1) / 2;
        if ((m + n) % 2 == 0) {
            return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, mid) + 
                getKth(nums1, 0, m - 1, nums2, 0, n - 1, mid + 1)) / 2.0;
        } else {
            return (double) getKth(nums1, 0, m - 1, nums2, 0, n - 1, mid);
        }
    }

    private int getKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        int l1 = e1 - s1 + 1, l2 = e2 - s2 + 1;
        if (l1 == 0) {
            return nums2[s2 + k - 1];
        } else if (l2 == 0) {
            return nums1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[s1], nums2[s2]);
        }
        int i = s1 + Math.min(k / 2, l1) - 1;
        int j = s2 + Math.min(k / 2, l2) - 1;
        if (nums1[i] < nums2[j]) {
            return getKth(nums1, i + 1, e1, nums2, s2, e2, k - (i - s1 + 1));
        } else {
            return getKth(nums1, s1, e1, nums2, j + 1, e2, k - (j - s2 + 1));
        }
    }
}
// @lc code=end

