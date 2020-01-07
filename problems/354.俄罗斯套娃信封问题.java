/*
 * @lc app=leetcode.cn id=354 lang=java
 *
 * [354] 俄罗斯套娃信封问题
 *
 * https://leetcode-cn.com/problems/russian-doll-envelopes/description/
 *
 * algorithms
 * Hard (33.02%)
 * Likes:    86
 * Dislikes: 0
 * Total Accepted:    5.5K
 * Total Submissions: 16.6K
 * Testcase Example:  '[[5,4],[6,4],[6,7],[2,3]]'
 *
 * 给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h)
 * 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 
 * 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 
 * 说明:
 * 不允许旋转信封。
 * 
 * 示例:
 * 
 * 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出: 3 
 * 解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        int[] height = new int[n];
        for(int i = 0;i < n;i++) {
            height[i] = envelopes[i][1];
        }
        int res = 0;
        int[] top = new int[n];
        for(int i = 0;i < n;i++) {
            int num = height[i];
            int l = 0, r = res;
            while(l < r) {
                int mid = (l + r) / 2;
                if (top[mid] >= num) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (l == res) {
                res++;
            }
            top[l] = num;
        }
        return res;
    }
}
// @lc code=end

