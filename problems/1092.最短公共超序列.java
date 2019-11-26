/*
 * @lc app=leetcode.cn id=1092 lang=java
 *
 * [1092] 最短公共超序列
 *
 * https://leetcode-cn.com/problems/shortest-common-supersequence/description/
 *
 * algorithms
 * Hard (36.32%)
 * Likes:    13
 * Dislikes: 0
 * Total Accepted:    552
 * Total Submissions: 1.5K
 * Testcase Example:  '"abac"\n"cab"'
 *
 * 给出两个字符串 str1 和 str2，返回同时以 str1 和 str2
 * 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
 * 
 * （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T
 * 的子序列）
 * 
 * 
 * 
 * 示例：
 * 
 * 输入：str1 = "abac", str2 = "cab"
 * 输出："cabac"
 * 解释：
 * str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。 
 * str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
 * 最终我们给出的答案是满足上述属性的最短字符串。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= str1.length, str2.length <= 1000
 * str1 和 str2 都由小写英文字母组成。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        
        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
            }
        }
        
        String lcdStr = "";
        
        int lcdLength = dp[str1.length()][str2.length()];
        
        int i = str1.length();
        int j = str2.length();
        
        while(lcdLength > 0){
            if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                lcdStr = lcdStr + String.valueOf(str1.charAt(i-1));
                lcdLength--;
                i--;
                j--;
            }else{
                if(dp[i - 1][j] == lcdLength){
                    i--;
                }else{
                    j--;
                }
            }
        }
        lcdStr = new StringBuilder(lcdStr).reverse().toString();
        
        String result = "";
        
        int p1 = 0, p2 = 0;
        
        for(int k = 0; k < lcdStr.length(); k++){
            for(i = p1; i < str1.length(); i++){
                if(str1.charAt(i) == lcdStr.charAt(k)){
                    break;
                }
            }
            for(j = p2; j < str2.length(); j++){
                if(str2.charAt(j) == lcdStr.charAt(k)){
                    break;
                }
            }
            
            result = result + str1.substring(p1, i) + str2.substring(p2, j + 1);
            p1 = i+1;
            p2 = j+1;
        }
        result = result + str1.substring(p1,str1.length()) + str2.substring(p2,str2.length());
        
        return result;
    }
}
// @lc code=end

