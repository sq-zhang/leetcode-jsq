/*
 * @lc app=leetcode.cn id=319 lang=java
 *
 * [319] 灯泡开关
 *
 * https://leetcode-cn.com/problems/bulb-switcher/description/
 *
 * algorithms
 * Medium (43.63%)
 * Likes:    77
 * Dislikes: 0
 * Total Accepted:    6.9K
 * Total Submissions: 15.8K
 * Testcase Example:  '3'
 *
 * 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。 第 3
 * 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。
 * 找出 n 轮后有多少个亮着的灯泡。
 * 
 * 示例:
 * 
 * 输入: 3
 * 输出: 1 
 * 解释: 
 * 初始时, 灯泡状态 [关闭, 关闭, 关闭].
 * 第一轮后, 灯泡状态 [开启, 开启, 开启].
 * 第二轮后, 灯泡状态 [开启, 关闭, 开启].
 * 第三轮后, 灯泡状态 [开启, 关闭, 关闭]. 
 * 
 * 你应该返回 1，因为只有一个灯泡还亮着。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int bulbSwitch(int n) {
        // int[] nums = new int[n + 1];
        // for(int i = 1;i <= n;i++) {
        //     for(int j = i; j <= n; j += i) {
        //         nums[j]++;
        //     }
        // }
        // int res = 0;
        // for(int i = 1;i <= n;i++) {
        //     if (nums[i] % 2 == 1) {
        //         res++;
        //     }
        // }
        // return res;
        return (int)Math.sqrt(n);
    }
}
// @lc code=end

