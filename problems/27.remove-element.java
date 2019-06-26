/*
 * @lc app=leetcode id=27 lang=java
 *
 * [27] Remove Element
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int n : nums) {
            if (n != val) {
                nums[i++] = n;
            }
        }
        return i;
    }
}

