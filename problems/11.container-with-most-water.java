/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */
class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        } 

        int l = 0, h = height.length - 1, max = 0;
        while (l < h) {
            int currentL = height[l], currentH = height[h];
            int area = (h - l) * Math.min(currentL, currentH);
            max = Math.max(max, area);
            if (currentL <= currentH) {
                while(l < height.length && height[l] <= currentL) {
                    l++;
                }
            } else {
                while(h > 0 && height[h] <= currentH) {
                    h--;
                }
            }
        }

        return max;
    }
}

