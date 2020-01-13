/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 *
 * https://leetcode-cn.com/problems/basic-calculator/description/
 *
 * algorithms
 * Hard (36.14%)
 * Likes:    130
 * Dislikes: 0
 * Total Accepted:    8.5K
 * Total Submissions: 23.2K
 * Testcase Example:  '"1 + 1"'
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 * 
 * 示例 1:
 * 
 * 输入: "1 + 1"
 * 输出: 2
 * 
 * 
 * 示例 2:
 * 
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 
 * 示例 3:
 * 
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 * 
 * 说明：
 * 
 * 
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') continue;
            if (ch == ')') {
                int sum = 0;
                while (stack.size() > 0 && stack.peek() != -11111111) {
                    int num = stack.pop();
                    if (stack.size() > 0 && stack.peek() == -33333333) {
                        sum -= num;
                    } else {
                        sum += num;
                    }
                    if (stack.peek() != -11111111) {
                        stack.pop();
                    }
                }
                if (stack.size() > 0 && stack.peek() == -11111111) {
                    stack.pop();
                }
                stack.push(sum);
            } else {
                if (Character.isDigit(ch)) {
                    if (stack.size() > 0 && stack.peek() >= 0) {
                        stack.push(stack.pop() * 10 + (int)(ch - '0'));
                    } else {
                        stack.push((int)(ch - '0'));
                    }
                } else if (ch == '+') {
                    stack.push(-22222222);
                } else if (ch == '-'){
                    stack.push(-33333333);
                } else {
                    stack.push(-11111111);
                }
            }
        }
        if (stack.size() == 1) {
            return stack.peek();
        }

        int res = 0;
        while (stack.size() > 0) {
            int num = stack.pop();
            if (stack.size() > 0 && stack.peek() == -33333333) {
                res -= num;
            } else {
                res += num;
            }
            if (stack.size() > 0) {
                stack.pop();
            }
        }
        return res;
    }
}
// @lc code=end

