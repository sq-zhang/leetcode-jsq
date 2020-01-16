/*
 * @lc app=leetcode.cn id=399 lang=java
 *
 * [399] 除法求值
 *
 * https://leetcode-cn.com/problems/evaluate-division/description/
 *
 * algorithms
 * Medium (52.53%)
 * Likes:    88
 * Dislikes: 0
 * Total Accepted:    4.1K
 * Total Submissions: 7.7K
 * Testcase Example:  '[["a","b"],["b","c"]]\n[2.0,3.0]\n[["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]'
 *
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k
 * 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 * 
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题:  a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 * 
 * 输入为:  vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size()
 * == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。
 * 返回vector<double>类型。
 * 
 * 基于上述例子，输入如下：
 * 
 * 
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x",
 * "x"] ]. 
 * 
 * 
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 * 
 */

// @lc code=start
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (equations.size() == 0 || equations.size() != values.length) {
            return new double[0];
        }

        Map<String, Map<String, Double>> maps = new HashMap<>();
        for(int i = 0;i < equations.size();i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            if (!maps.containsKey(a)) {
                maps.put(a, new HashMap<String, Double>());
            }
            maps.get(a).put(b, values[i]);
            if (!maps.containsKey(b)) {
                maps.put(b, new HashMap<String, Double>());
            }
            maps.get(b).put(a, 1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for(int i = 0;i < queries.size();i++) {
            res[i] = dfs(maps, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> maps, String a, String b, Set<String> visited) {
        if (!maps.containsKey(a)) {
            return -1.0;
        }
        if (maps.get(a).containsKey(b)) {
            return maps.get(a).get(b);
        }
        visited.add(a);
        for(String key : maps.get(a).keySet()) {
            if (visited.contains(key)) {
                continue;
            }
            double v = dfs(maps, key, b, visited);
            if (v != -1.0) {
                return v * maps.get(a).get(key);
            }
        }
        return -1.0;
    }
}
// @lc code=end

