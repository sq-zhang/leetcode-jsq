/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 *
 * https://leetcode-cn.com/problems/number-of-boomerangs/description/
 *
 * algorithms
 * Easy (55.54%)
 * Likes:    63
 * Dislikes: 0
 * Total Accepted:    7.3K
 * Total Submissions: 13.2K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k
 * 之间的距离相等（需要考虑元组的顺序）。
 * 
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * 
 * 示例:
 * 
 * 
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * 
 * 输出:
 * 2
 * 
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for(int i = 0;i < points.length;i++) {
            distanceMap.clear();
            for(int j = 0;j < points.length;j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                int mapDis = distanceMap.getOrDefault(distance, 0);
                res += mapDis * 2;
                distanceMap.put(distance, mapDis + 1);
            }
        }

        return res;
    }

    private int getDistance(int point1X, int point1Y, int point2X, int point2Y) {
        int disX = point1X - point2X;
        int disY = point1Y - point2Y;
        return  disX * disX + disY * disY;
    }
}
// @lc code=end

