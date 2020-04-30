/*
 * @lc app=leetcode.cn id=954 lang=java
 *
 * [954] 二倍数对数组
 *
 * https://leetcode-cn.com/problems/array-of-doubled-pairs/description/
 *
 * algorithms
 * Medium (25.16%)
 * Likes:    22
 * Dislikes: 0
 * Total Accepted:    2.8K
 * Total Submissions: 10.4K
 * Testcase Example:  '[3,1,3,6]'
 *
 * 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] =
 * 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[3,1,3,6]
 * 输出：false
 * 
 * 
 * 示例 2：
 * 
 * 输入：[2,1,2,6]
 * 输出：false
 * 
 * 
 * 示例 3：
 * 
 * 输入：[4,-2,2,-4]
 * 输出：true
 * 解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * 
 * 示例 4：
 * 
 * 输入：[1,2,4,16,8,4]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= A.length <= 30000
 * A.length 为偶数
 * -100000 <= A[i] <= 100000
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> maps = new HashMap<>();
        for(int num : A) {
            maps.put(num, maps.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(maps.keySet());
        Collections.sort(keys);
        for(Integer num : keys) {
            int x = maps.get(num);
            if (x == 0) {
                continue;
            }
            if (num < 0 && num % 2 == 1)  {
                return false;
            }
            int num2 = num > 0 ? 2 * num : num / 2;
            int y = maps.getOrDefault(num2, 0);
            if (y < x) {
                return false;
            }
            maps.put(num2, y - x);
        }
        return true;
    }
}
// @lc code=end

