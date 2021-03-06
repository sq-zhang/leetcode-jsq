/*
 * @lc app=leetcode.cn id=984 lang=java
 *
 * [984] 不含 AAA 或 BBB 的字符串
 *
 * https://leetcode-cn.com/problems/string-without-aaa-or-bbb/description/
 *
 * algorithms
 * Medium (34.00%)
 * Likes:    29
 * Dislikes: 0
 * Total Accepted:    2.8K
 * Total Submissions: 8K
 * Testcase Example:  '1\n2'
 *
 * 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
 * 
 * 
 * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 * 子串 'aaa' 没有出现在 S 中；
 * 子串 'bbb' 没有出现在 S 中。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：A = 1, B = 2
 * 输出："abb"
 * 解释："abb", "bab" 和 "bba" 都是正确答案。
 * 
 * 
 * 示例 2：
 * 
 * 输入：A = 4, B = 1
 * 输出："aabaa"
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= A <= 100
 * 0 <= B <= 100
 * 对于给定的 A 和 B，保证存在满足要求的 S。
 * 
 * 
 */

// @lc code=start
class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder res = new StringBuilder();
        while(A > 0 && B > 0){
            if(A > B){
                res.append("aab");
                A -= 2;
                B -= 1;
            }else if(B > A){
                res.append("bba");
                A -= 1;
                B -= 2;
            } else {
                res.append("ab");
                A--;
                B--;
            }
        }
        for(int i = 0;i < A;i++){
            res.append("a");
        }
        for(int i=0;i < B;i++){
            res.append("b");
        }
        return res.toString();
    }
}
// @lc code=end

