/*
 * @lc app=leetcode.cn id=475 lang=java
 *
 * [475] 供暖器
 *
 * https://leetcode-cn.com/problems/heaters/description/
 *
 * algorithms
 * Easy (28.58%)
 * Likes:    80
 * Dislikes: 0
 * Total Accepted:    6.1K
 * Total Submissions: 21.1K
 * Testcase Example:  '[1,2,3]\n[2]'
 *
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * 
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 * 
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 * 
 * 说明:
 * 
 * 
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = Integer.MIN_VALUE;
        for(int h : houses) {
            int l = 0, r = heaters.length - 1;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (h > heaters[mid]) {
                    l = mid + 1;

                } else {
                    r = mid;
                }
            }
            int t = 0;
            if (heaters[l] == h) {
                t = 0;
            } else if (l != 0) {
                t = Math.min(Math.abs(heaters[l] - h), Math.abs(heaters[l - 1] - h));
            } else {
                t = Math.abs(heaters[l] - h);
            }
            res = Math.max(res, t);
        }
        return res;
    }
}
// @lc code=end

