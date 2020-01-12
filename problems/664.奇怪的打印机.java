/*
 * @lc app=leetcode.cn id=664 lang=java
 *
 * [664] 奇怪的打印机
 *
 * https://leetcode-cn.com/problems/strange-printer/description/
 *
 * algorithms
 * Hard (40.23%)
 * Likes:    34
 * Dislikes: 0
 * Total Accepted:    960
 * Total Submissions: 2.4K
 * Testcase Example:  '"aaabbb"'
 *
 * 有台奇怪的打印机有以下两个特殊要求：
 * 
 * 
 * 打印机每次只能打印同一个字符序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 
 * 
 * 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
 * 
 * 示例 1:
 * 
 * 
 * 输入: "aaabbb"
 * 输出: 2
 * 解释: 首先打印 "aaa" 然后打印 "bbb"。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: "aba"
 * 输出: 2
 * 解释: 首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
 * 
 * 提示: 输入字符串的长度不会超过 100。
 * 
 */

// 其实就是一个dp
// l,r 从l到r 的需要的步数
// dp[l][r] = dp[l+1][r] +1 ; 很好理解
// dp[l][r] = min{dp[l+1][k] + dp[k+1][r]}; 左边相等 右边不等
// dp[l][r] = min{dp[l+1][k]}; aaa -> aaaa
// @lc code=start
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        
        int dp[][] = new int[n][n];
        for(int j = 0;j < n;j++) {
            for(int i = 0;i + j < n;i++) {
                dp[i][i + j] = 1 + j;
                for(int k = i; k < i + j;k++) {
                    int sum = dp[i][k] + dp[k + 1][i + j];
                    if(s.charAt(k) == s.charAt(i + j)) {
                        sum--;
                    }
                    dp[i][i + j] = Math.min(dp[i][i + j], sum);
                }
            }
        }
        return dp[0][n - 1];
	}
}

// class Solution {
//     public int strangePrinter(String s) {
//         List<String> queue = new ArrayList<>();
//         queue.add(s);
//         int step = 0;
//         while(!queue.isEmpty()) {
//             List<String> newQueue = new ArrayList<>();
//             for(String str : queue) {
//                 int last = 0, nextCount = 0;
//                 for(int i = 0;i < str.length();i++) {
//                     if (i == str.length() - 1 || (str.charAt(i + 1) != str.charAt(last) 
//                         && str.charAt(i + 1) != '.')) {
//                         StringBuilder sb = new StringBuilder();
//                         sb.append(str.substring(0, last));
//                         for(int j = last;j <= i;j++) {
//                             sb.append(".");
//                         }
//                         sb.append(str.substring(i + 1));
//                         newQueue.add(sb.toString());
//                         last = i + 1;
//                         nextCount++;
//                     }
//                 }
//                 if (nextCount == 1) {
//                     return step + 1;
//                 }
//             }
//             queue = newQueue;
//             step++;
//         }

//         return 0;
//     }
// }
// @lc code=end

