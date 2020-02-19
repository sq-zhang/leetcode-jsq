/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (39.41%)
 * Likes:    287
 * Dislikes: 0
 * Total Accepted:    53.2K
 * Total Submissions: 132K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        
        LinkedList<int[]> res = new LinkedList<>();
        for(int i = 0;i < intervals.length;i++) {
            int[] now = intervals[i];
            if (res.size() == 0 || res.getLast()[1] < now[0]) {
                res.add(now);
            } else {
                int[] last = res.pollLast();
                res.add(new int[]{last[0], Math.max(last[1], now[1])});
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
// @lc code=end

