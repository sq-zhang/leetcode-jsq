/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 *
 * https://leetcode-cn.com/problems/reverse-pairs/description/
 *
 * algorithms
 * Hard (21.11%)
 * Likes:    61
 * Dislikes: 0
 * Total Accepted:    2.7K
 * Total Submissions: 12.2K
 * Testcase Example:  '[1,3,2,3,1]'
 *
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 
 * 你需要返回给定数组中的重要翻转对的数量。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 
 * 
 * 注意:
 * 
 * 
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSortHelper(nums, 0, nums.length - 1);
    }

    int mergeSortHelper(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2, count = 0;
        count += mergeSortHelper(nums, left, mid);
        count += mergeSortHelper(nums, mid + 1, right);
        
        int l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            if ((long)nums[l] > (2 * (long)nums[r])) {
                count += mid - l + 1 ;
                r++;
            } else {
                l++;
            } 
        }
        mergeSortMerge(nums, left, mid, right);
        return count;
    }

    void mergeSortMerge(int[] nums, int left, int mid, int right) {
        int[] arr = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while(i <= mid || j <= right) {
            if (i > mid) {
                arr[k++] = nums[j++];
            } else if (j > right) {
                arr[k++] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                arr[k++] = nums[i++];
            } else {
                arr[k++] = nums[j++];
            }
        }
        for(int p = 0;p < arr.length;p++) {
            nums[left + p] = arr[p];
        }
    }
}
// @lc code=end

