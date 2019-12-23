/*
 * @lc app=leetcode.cn id=149 lang=java
 *
 * [149] 直线上最多的点数
 *
 * https://leetcode-cn.com/problems/max-points-on-a-line/description/
 *
 * algorithms
 * Hard (19.41%)
 * Likes:    95
 * Dislikes: 0
 * Total Accepted:    6.7K
 * Total Submissions: 34.2K
 * Testcase Example:  '[[1,1],[2,2],[3,3]]'
 *
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 
 * 示例 1:
 * 
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 
 */

// @lc code=start
class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int res = 0;
        for(int i = 0;i < points.length;i++) {
            int max = 0, duplicate = 0;
            Map<String, Integer> map = new HashMap<>();
            for(int j = i + 1;j < points.length;j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    duplicate++;
                    continue;
                }
                int gcd = gcd(x, y);
                x = x / gcd;
                y = y / gcd;
                String key = x + " " + y;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            res = Math.max(res, max + duplicate + 1);
        }

        return res;
    }

    private int gcd(int x, int y) {
        while(y != 0) {
            int t = x % y;
            x = y;
            y = t;
        }

        return x;
    }
}
// @lc code=end

