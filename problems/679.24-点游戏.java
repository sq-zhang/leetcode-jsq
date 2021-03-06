/*
 * @lc app=leetcode.cn id=679 lang=java
 *
 * [679] 24 点游戏
 *
 * https://leetcode-cn.com/problems/24-game/description/
 *
 * algorithms
 * Hard (40.16%)
 * Likes:    54
 * Dislikes: 0
 * Total Accepted:    2.1K
 * Total Submissions: 5.2K
 * Testcase Example:  '[4,1,8,7]'
 *
 * 你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
 * 
 * 示例 1:
 * 
 * 输入: [4, 1, 8, 7]
 * 输出: True
 * 解释: (8-4) * (7-1) = 24
 * 
 * 
 * 示例 2:
 * 
 * 输入: [1, 2, 1, 2]
 * 输出: False
 * 
 * 
 * 注意:
 * 
 * 
 * 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
 * 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1
 * 是不允许的。
 * 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> numsDouble = new ArrayList<>();
        for(int n : nums) {
            numsDouble.add((double) n);
        }

        return dfs(numsDouble);
    }

    private boolean dfs(List<Double> nums) {
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - 24) < 1e-6;
        }

        for(int i = 0;i < nums.size();i++) {
            for(int j = 0;j < nums.size();j++) {
                if (i == j) {
                    continue;
                }
                List<Double> newNums = new ArrayList<>();
                for(int k = 0;k < nums.size();k++) {
                    if (k != i && k != j) {
                        newNums.add(nums.get(k));
                    }
                }
                for(int m = 0;m < 4;m++) {
                    if (m < 2 && j > i) {
                        continue;
                    }
                    if(m == 0) {
                        newNums.add(nums.get(i) + nums.get(j));
                    } else if (m == 1) {
                        newNums.add(nums.get(i) * nums.get(j));
                    } else if (m == 2) {
                        newNums.add(nums.get(i) - nums.get(j));
                    } else {
                        if (nums.get(j) != 0) {
                            newNums.add(nums.get(i) / nums.get(j));
                        } else {
                            continue;
                        }
                    }
                    if(dfs(newNums)) {
                        return true;
                    }
                    newNums.remove(newNums.size() - 1);
                }

            }
        }
        return false;
    }
}
// @lc code=end

