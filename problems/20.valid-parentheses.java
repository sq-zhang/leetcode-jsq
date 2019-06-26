import java.util.Stack;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c =='{') {
                stack.push(c);
            } else if (stack.isEmpty() || stack.pop() != getPair(c)) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private char getPair(char c) {
        switch(c) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
            default: return ' ';
        }
    }
}

