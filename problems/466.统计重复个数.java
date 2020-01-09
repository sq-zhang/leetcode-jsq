/*
 * @lc app=leetcode.cn id=466 lang=java
 *
 * [466] 统计重复个数
 *
 * https://leetcode-cn.com/problems/count-the-repetitions/description/
 *
 * algorithms
 * Hard (29.11%)
 * Likes:    24
 * Dislikes: 0
 * Total Accepted:    746
 * Total Submissions: 2.5K
 * Testcase Example:  '"acb"\n4\n"ab"\n2'
 *
 * 定义由 n 个连接的字符串 s 组成字符串 S，即 S = [s,n]。例如，["abc", 3]=“abcabcabc”。
 * 
 * 另一方面，如果我们可以从 s2 中删除某些字符使其变为 s1，我们称字符串 s1 可以从字符串 s2 获得。例如，“abc” 可以根据我们的定义从
 * “abdbec” 获得，但不能从 “acbbe” 获得。
 * 
 * 现在给出两个非空字符串 S1 和 S2（每个最多 100 个字符长）和两个整数 0 ≤ N1 ≤ 10^6 和 1 ≤ N2 ≤
 * 10^6。现在考虑字符串 S1 和 S2，其中S1=[s1,n1]和S2=[s2,n2]。找出可以使[S2,M]从 S1 获得的最大整数 M。
 * 
 * 示例：
 * 
 * 输入：
 * s1 ="acb",n1 = 4
 * s2 ="ab",n2 = 2 
 * 
 * 返回：
 * 2
 * 
 * 
 */

// @lc code=start
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int index = 0 , num1 = 0, num2 = 0;
        while(num1 < n1){
            for(int i = 0 ; i < c1.length ; i++){
                if(c1[i] == c2[index]){
                    if(index == c2.length - 1) {
                        index = 0;
                        num2++;
                    } else {
                        index++;
                    }      
                }
            }
            num1++;
        }

        return num2 / n2;
    }
}
// @lc code=end

