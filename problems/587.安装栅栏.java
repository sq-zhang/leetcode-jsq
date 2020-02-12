/*
 * @lc app=leetcode.cn id=587 lang=java
 *
 * [587] 安装栅栏
 *
 * https://leetcode-cn.com/problems/erect-the-fence/description/
 *
 * algorithms
 * Hard (30.45%)
 * Likes:    28
 * Dislikes: 0
 * Total Accepted:    447
 * Total Submissions: 1.5K
 * Testcase Example:  '[[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]'
 *
 * 在一个二维的花园中，有一些用 (x, y)
 * 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能围好栅栏。你需要找到正好位于栅栏边界上的树的坐标。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
 * 输出: [[1,1],[2,0],[4,2],[3,3],[2,4]]
 * 解释:
 * 
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,2],[2,2],[4,2]]
 * 输出: [[1,2],[2,2],[4,2]]
 * 解释:
 * 
 * 即使树都在一条直线上，你也需要先用绳子包围它们。
 * 
 * 
 * 
 * 
 * 注意:
 * 
 * 
 * 所有的树应当被围在一起。你不能剪断绳子来包围树或者把树分成一组以上。
 * 输入的整数在 0 到 100 之间。
 * 花园至少有一棵树。
 * 所有树的坐标都是不同的。
 * 输入的点没有顺序。输出顺序也没有要求。
 * 
 */

// @lc code=start
class Solution {

    public int orientation(int[] p, int[] q, int[] r) {
        return (q[1] - p[1]) * (r[0] - q[0]) - (q[0] - p[0]) * (r[1] - q[1]);
    }

    public int[][] outerTrees(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : b[0] - a[0];
            }
        });
        Stack<int[]> s = new Stack<>();
        for(int i = 0;i < points.length;i++) {
            while(s.size() >= 2 && orientation(s.get(s.size() - 2), s.get(s.size() - 1), points[i]) > 0) {
                s.pop();
            }
            s.push(points[i]);
        }
        s.pop();
        for(int i = points.length - 1;i >= 0;i--) {
            while(s.size() >= 2 && orientation(s.get(s.size() - 2), s.get(s.size() - 1), points[i]) > 0) {
                s.pop();
            }
            s.push(points[i]);
        }
        
        List<int[]> res = new ArrayList<>(new HashSet<>(s));
        return res.toArray(new int[res.size()][2]);
    }
}
// @lc code=end

