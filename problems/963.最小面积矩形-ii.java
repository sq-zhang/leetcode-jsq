/*
 * @lc app=leetcode.cn id=963 lang=java
 *
 * [963] 最小面积矩形 II
 *
 * https://leetcode-cn.com/problems/minimum-area-rectangle-ii/description/
 *
 * algorithms
 * Medium (48.68%)
 * Likes:    17
 * Dislikes: 0
 * Total Accepted:    864
 * Total Submissions: 1.8K
 * Testcase Example:  '[[1,2],[2,1],[1,0],[0,1]]'
 *
 * 给定在 xy 平面上的一组点，确定由这些点组成的任何矩形的最小面积，其中矩形的边不一定平行于 x 轴和 y 轴。
 * 
 * 如果没有任何矩形，就返回 0。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 输入：[[1,2],[2,1],[1,0],[0,1]]
 * 输出：2.00000
 * 解释：最小面积的矩形出现在 [1,2],[2,1],[1,0],[0,1] 处，面积为 2。
 * 
 * 示例 2：
 * 
 * 
 * 
 * 输入：[[0,1],[2,1],[1,1],[1,0],[2,0]]
 * 输出：1.00000
 * 解释：最小面积的矩形出现在 [1,0],[1,1],[2,1],[2,0] 处，面积为 1。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 
 * 输入：[[0,3],[1,2],[3,1],[1,3],[2,1]]
 * 输出：0
 * 解释：没法从这些点中组成任何矩形。
 * 
 * 
 * 示例 4：
 * 
 * 
 * 
 * 输入：[[3,1],[1,1],[0,1],[2,1],[3,3],[3,2],[0,2],[2,3]]
 * 输出：2.00000
 * 解释：最小面积的矩形出现在 [2,1],[2,3],[3,3],[3,1] 处，面积为 2。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= points.length <= 50
 * 0 <= points[i][0] <= 40000
 * 0 <= points[i][1] <= 40000
 * 所有的点都是不同的。
 * 与真实值误差不超过 10^-5 的答案将视为正确结果。
 * 
 * 
 */

// @lc code=start
class Solution {
    public double minAreaFreeRect(int[][] points) {
        Map<String,String> state = new HashMap<>();
        double res = Double.MAX_VALUE;
        for(int i = 0;i < points.length; i++) {
            for(int j = i + 1;j < points.length;j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int x = x1 - x2;
                int y = y1 - y2;
                double l = Math.pow(x * x + y * y, 0.5);
                double midx = (x1 + x2) / 2.0;
                double midy = (y1 + y2) / 2.0;
                String st = l + "," + midx + "," + midy;
                if(state.containsKey(st)) {
                    String temp = state.get(st);
                    double s = check(temp, x1, x2, y1, y2);
                    state.put(st, temp + x1 + "," + y1 + ";");
                    if(s < res) {
                        res = s;
                    }
                } else {
                    state.put(st, x1 + "," + y1 + ";");
                }
            }
        }

        return res == Double.MAX_VALUE ? 0 : res;
            
    }
	
    public double check(String s,int x1,int x2,int y1,int y2) {
        String[] strList = s.split(";");
        double min = Double.MAX_VALUE;
        for(String str : strList) {
            String[] strr = str.split(",");
            int sx = Integer.valueOf(strr[0]);
            int sy = Integer.valueOf(strr[1]);
            double c = Math.pow((x1 - sx) * (x1 - sx) + (y1 - sy) * (y1 - sy), 0.5);
            double k = Math.pow((x2 - sx) * (x2 - sx) + (y2-  sy) * (y2 - sy), 0.5);
            min = Math.min(min, c * k);
        }

        return min;
    }
}
// @lc code=end

