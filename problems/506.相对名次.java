/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 *
 * https://leetcode-cn.com/problems/relative-ranks/description/
 *
 * algorithms
 * Easy (52.24%)
 * Likes:    37
 * Dislikes: 0
 * Total Accepted:    7K
 * Total Submissions: 13.2K
 * Testcase Example:  '[5,4,3,2,1]'
 *
 * 给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold
 * Medal", "Silver Medal", "Bronze Medal"）。
 * 
 * (注：分数越高的选手，排名越靠前。)
 * 
 * 示例 1:
 * 
 * 
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal"
 * and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 
 * 提示:
 * 
 * 
 * N 是一个正整数并且不会超过 10000。
 * 所有运动员的成绩都不相同。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        String[] res = new String[n];
        if (n == 0) {
            return res;
        }
        int[][] indexs = new int[nums.length][2];
        for(int i = 0;i < n;i++) {
            indexs[i][0] = i;
            indexs[i][1] = nums[i];
        }
        Arrays.sort(indexs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });
        for(int i = 0;i < n;i++) {
            int index = indexs[i][0];
            if (i == 0) {
                res[index] = "Gold Medal";
            } else if (i == 1) {
                res[index] = "Silver Medal";
            } else if (i == 2) {
                res[index] = "Bronze Medal";
            } else {
                res[index] = (i + 1) + "";
            }
        }
        return res;
    }
}
// @lc code=end

